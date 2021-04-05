package live.whiteseason.whitebot.util;

import lombok.extern.slf4j.Slf4j;
import reactor.util.annotation.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.Timer;
import java.util.TimerTask;

@Slf4j
public abstract class RetryCallback<T> implements Callback<T> {
    private static final String TAG = RetryCallback.class.getSimpleName();

    private int mRetryCount;
    private long mRetryInterval;

    private int mCurrentRetryCount;

    private boolean isExecuting;

    private Call<T> mCall;

    private Timer timer = new Timer();

    public RetryCallback(Call<T> call, int retryCount, long retryInterval) {
        isExecuting = true;
        mCall = call;
        mRetryCount = retryCount;
        mRetryInterval = retryInterval;
    }

    @Override
    public final void onResponse(Call<T> call,Response<T> response) {
        log.info(TAG+"onResponse");
        isExecuting = false;
        if (!response.isSuccessful() && mCurrentRetryCount < mRetryCount) {
            mCurrentRetryCount++;
            retryRequest(call);
        } else {
            onRequestResponse(call, response);
        }
    }

    @Override
    public final void onFailure(Call<T> call,Throwable t) {
        log.info(TAG+"onFailure");
        isExecuting = false;
        if (mCurrentRetryCount < mRetryCount) {
            mCurrentRetryCount++;
            retryRequest(call);
        } else {
            onRequestFail(call, t);
        }
    }

    private void retryRequest(final Call<T> call) {
        log.info(TAG+"retryRequest");
        onStartRetry();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                synchronized (RetryCallback.this){
                    mCall = call.clone();
                    mCall.enqueue(RetryCallback.this);
                    isExecuting = true;
                }
            }
        };
        timer.schedule(timerTask, mRetryInterval);

    }

    public void cancelCall(){
        synchronized (this){
            if (!isExecuting){
                timer.cancel();
            }else {
                mCall.cancel();
            }
        }
    }

    public abstract void onRequestResponse(Call<T> call, Response<T> response);

    public abstract void onRequestFail(Call<T> call, Throwable t);

    public abstract void onStartRetry();
}

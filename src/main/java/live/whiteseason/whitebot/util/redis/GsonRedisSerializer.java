package live.whiteseason.whitebot.util.redis;

import com.google.gson.Gson;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.UnsupportedEncodingException;

/**
 * Redis序列化器的Gson实现
 * @param <T>
 */
public class GsonRedisSerializer<T> implements RedisSerializer<T> {


    private Class<T> type;

    public GsonRedisSerializer(Class<T> type) {
        this.type = type;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }

        //JSONObject.toJSONString(t, SerializerFeature.WriteClassName).getBytes(IOUtils.UTF8)
        Gson gson = new Gson();
        String str =gson.toJson(t);
        byte[] bytes = new byte[0];
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return  bytes;
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        String str = null;
        try {
            str = new String(bytes,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //JSONObject.parseObject(str, type, defaultRedisConfig)
        Gson gson = new Gson();
        return  gson.fromJson(str, type);
    }
}
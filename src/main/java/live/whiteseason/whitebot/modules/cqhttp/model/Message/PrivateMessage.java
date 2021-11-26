package live.whiteseason.whitebot.modules.cqhttp.model.Message;

import live.whiteseason.whitebot.modules.cqhttp.model.Event;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PrivateMessage extends Event {
    String messageType;
    String subType;
    int messageId;

}

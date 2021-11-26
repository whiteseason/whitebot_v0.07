package live.whiteseason.whitebot.modules.cqhttp.model;


import lombok.Data;

/**
 * 消息总字段，所有消息字段均继承该字段
 */
@Data
public abstract class Event {
    Long time;
    Long self_id;
    String post_type;
}

package info.nightscout.client.data;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class NSTreatment {
    private JSONObject data;
    private String action = null; // "update", "remove" or null (add)

    public NSTreatment(JSONObject obj) {
        this.data = obj;
        this.action = getStringOrNull("action");
        this.data.remove("action");
    }

    private String getStringOrNull(String key) {
        String ret = null;
        if (data.has(key)) {
            try {
                ret = data.getString(key);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ret;
    };

    private Double getDoubleOrNull(String key) {
        Double ret = null;
        if (data.has(key)) {
            try {
                ret = data.getDouble(key);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ret;
    };

    private Integer getIntegerOrNull(String key) {
        Integer ret = null;
        if (data.has(key)) {
            try {
                ret = data.getInt(key);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ret;
    };

    private Long getLongOrNull(String key) {
        Long ret = null;
        if (data.has(key)) {
            try {
                ret = data.getLong(key);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ret;
    };

    private Date getDateOrNull(String key) {
        Date ret = null;
        if (data.has(key)) {
            try {
                ret = new Date(data.getString(key));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ret;
    };

    public String getAction() { return action; }
    public JSONObject getData() { return data; }
    public String get_id() { return getStringOrNull("_id"); }
    public String getEnteredBy() { return getStringOrNull("enteredBy"); }
    public String getEventType() { return getStringOrNull("eventType"); }
    public Integer getHapp_id() { return getIntegerOrNull("happ_id"); }
    public Integer getDuration() { return getIntegerOrNull("duration"); }
    public Integer getMgdl() { return getIntegerOrNull("mgdl"); }
    public Double getAbsolute() { return getDoubleOrNull("absolute"); }
    public Long getMills() { return getLongOrNull("mills"); }
    public Date getCreated_at() { return getDateOrNull("created_at"); }
}

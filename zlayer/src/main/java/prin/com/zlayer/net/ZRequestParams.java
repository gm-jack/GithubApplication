package prin.com.zlayer.net;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

import prin.com.zlayer.utils.ZJsonUtils;


/**
 * Created by prin on 2016/8/24.
 * 请求参数
 */
public class ZRequestParams {
    public ConcurrentHashMap<String, Object> mUrlParams = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, Object> mFileParams = new ConcurrentHashMap<>();

    public void put(String key, Object value) {
        if (key != null && value != null) {
            mUrlParams.put(key, value);
        }
    }

    public void putFile(String attr, File file, String mimeType) {
        if (attr != null && file != null) {
        mFileParams.put(attr,file.getName());
        }
    }

    public String getParamsJsonString() {
        return mUrlParams == null ? null : ZJsonUtils.instance().objToJson(mUrlParams);
    }
}

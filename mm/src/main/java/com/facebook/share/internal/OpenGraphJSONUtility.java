package com.facebook.share.internal;

import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class OpenGraphJSONUtility {

    public interface PhotoJSONProcessor {
        JSONObject toJSONObject(SharePhoto sharePhoto);
    }

    public static JSONObject toJSONObject(ShareOpenGraphAction shareOpenGraphAction, PhotoJSONProcessor photoJSONProcessor) {
        AppMethodBeat.i(8186);
        JSONObject jSONObject = new JSONObject();
        for (String str : shareOpenGraphAction.keySet()) {
            jSONObject.put(str, toJSONValue(shareOpenGraphAction.get(str), photoJSONProcessor));
        }
        AppMethodBeat.o(8186);
        return jSONObject;
    }

    private static JSONObject toJSONObject(ShareOpenGraphObject shareOpenGraphObject, PhotoJSONProcessor photoJSONProcessor) {
        AppMethodBeat.i(8187);
        JSONObject jSONObject = new JSONObject();
        for (String str : shareOpenGraphObject.keySet()) {
            jSONObject.put(str, toJSONValue(shareOpenGraphObject.get(str), photoJSONProcessor));
        }
        AppMethodBeat.o(8187);
        return jSONObject;
    }

    private static JSONArray toJSONArray(List list, PhotoJSONProcessor photoJSONProcessor) {
        AppMethodBeat.i(8188);
        JSONArray jSONArray = new JSONArray();
        for (Object obj : list) {
            jSONArray.put(toJSONValue(obj, photoJSONProcessor));
        }
        AppMethodBeat.o(8188);
        return jSONArray;
    }

    public static Object toJSONValue(Object obj, PhotoJSONProcessor photoJSONProcessor) {
        AppMethodBeat.i(8189);
        if (obj == null) {
            Object obj2 = JSONObject.NULL;
            AppMethodBeat.o(8189);
            return obj2;
        } else if ((obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long)) {
            AppMethodBeat.o(8189);
            return obj;
        } else if (obj instanceof SharePhoto) {
            if (photoJSONProcessor != null) {
                JSONObject jSONObject = photoJSONProcessor.toJSONObject((SharePhoto) obj);
                AppMethodBeat.o(8189);
                return jSONObject;
            }
            AppMethodBeat.o(8189);
            return null;
        } else if (obj instanceof ShareOpenGraphObject) {
            JSONObject jSONObject2 = toJSONObject((ShareOpenGraphObject) obj, photoJSONProcessor);
            AppMethodBeat.o(8189);
            return jSONObject2;
        } else if (obj instanceof List) {
            JSONArray jSONArray = toJSONArray((List) obj, photoJSONProcessor);
            AppMethodBeat.o(8189);
            return jSONArray;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid object found for JSON serialization: " + obj.toString());
            AppMethodBeat.o(8189);
            throw illegalArgumentException;
        }
    }

    private OpenGraphJSONUtility() {
    }
}

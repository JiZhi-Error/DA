package com.facebook;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.share.internal.OpenGraphJSONUtility;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareGraphRequest {
    public static GraphRequest createOpenGraphObject(ShareOpenGraphObject shareOpenGraphObject) {
        String str;
        AppMethodBeat.i(7620);
        String string = shareOpenGraphObject.getString("type");
        if (string == null) {
            str = shareOpenGraphObject.getString("og:type");
        } else {
            str = string;
        }
        if (str == null) {
            FacebookException facebookException = new FacebookException("Open graph object type cannot be null");
            AppMethodBeat.o(7620);
            throw facebookException;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("object", ((JSONObject) OpenGraphJSONUtility.toJSONValue(shareOpenGraphObject, new OpenGraphJSONUtility.PhotoJSONProcessor() {
                /* class com.facebook.ShareGraphRequest.AnonymousClass1 */

                @Override // com.facebook.share.internal.OpenGraphJSONUtility.PhotoJSONProcessor
                public final JSONObject toJSONObject(SharePhoto sharePhoto) {
                    AppMethodBeat.i(7619);
                    Uri imageUrl = sharePhoto.getImageUrl();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("url", imageUrl.toString());
                        AppMethodBeat.o(7619);
                        return jSONObject;
                    } catch (Exception e2) {
                        FacebookException facebookException = new FacebookException("Unable to attach images", e2);
                        AppMethodBeat.o(7619);
                        throw facebookException;
                    }
                }
            })).toString());
            GraphRequest graphRequest = new GraphRequest(AccessToken.getCurrentAccessToken(), String.format(Locale.ROOT, "%s/%s", "me", "objects/".concat(String.valueOf(str))), bundle, HttpMethod.POST);
            AppMethodBeat.o(7620);
            return graphRequest;
        } catch (JSONException e2) {
            FacebookException facebookException2 = new FacebookException(e2.getMessage());
            AppMethodBeat.o(7620);
            throw facebookException2;
        }
    }
}

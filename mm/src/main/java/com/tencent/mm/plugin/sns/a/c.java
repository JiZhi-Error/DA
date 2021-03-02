package com.tencent.mm.plugin.sns.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.z;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import org.json.JSONObject;

public final class c {
    public static void k(final String str, final ImageView imageView) {
        AppMethodBeat.i(202557);
        if (TextUtils.isEmpty(str) || imageView == null) {
            AppMethodBeat.o(202557);
            return;
        }
        Log.d("HalfScreenSubscribeUtils", "loadImage, hash=" + imageView.hashCode() + ", url=" + str);
        h.a(str, false, (f.a) new f.a() {
            /* class com.tencent.mm.plugin.sns.a.c.AnonymousClass1 */
            final /* synthetic */ int DCK = R.id.hwe;

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
            public final void eWN() {
            }

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
            public final void eWO() {
                AppMethodBeat.i(202555);
                imageView.setTag(this.DCK, "");
                Log.e("HalfScreenSubscribeUtils", "onDownloadError, hash=" + imageView.hashCode() + ", url=" + str);
                AppMethodBeat.o(202555);
            }

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
            public final void aNH(String str) {
                AppMethodBeat.i(202556);
                try {
                    if (!Util.isNullOrNil(str)) {
                        Bitmap decodeFile = BitmapUtil.decodeFile(str, null);
                        if (decodeFile != null) {
                            imageView.setImageBitmap(decodeFile);
                            imageView.setTag(this.DCK, str);
                            Log.d("HalfScreenSubscribeUtils", "onDownloaded succ, hash=" + imageView.hashCode());
                            AppMethodBeat.o(202556);
                            return;
                        }
                        Log.e("HalfScreenSubscribeUtils", "onDownloaded, bitmap==null");
                        AppMethodBeat.o(202556);
                        return;
                    }
                    Log.d("HalfScreenSubscribeUtils", "onDownloaded, url changed");
                    AppMethodBeat.o(202556);
                } catch (Throwable th) {
                    Log.e("HalfScreenSubscribeUtils", "onDownloaded, exp=" + th.toString());
                    AppMethodBeat.o(202556);
                }
            }
        });
        AppMethodBeat.o(202557);
    }

    public static void a(SnsInfo snsInfo, int i2, z zVar) {
        AppMethodBeat.i(202558);
        if (snsInfo == null) {
            Log.e("HalfScreenSubscribeUtils", "reportSubscribe snsInfo==null or reportInfo==null, scene = ".concat(String.valueOf(i2)));
            AppMethodBeat.o(202558);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("tempId", zVar.tempId);
            jSONObject2.put("weausername", zVar.EmV);
            jSONObject2.put("clickSubmitBtn", zVar.EmW);
            jSONObject2.put("subscribeResult", zVar.EmX);
            int i3 = i2 == 0 ? 1 : 2;
            String nullAsNil = Util.nullAsNil(snsInfo.getUxinfo());
            jSONObject.put(IssueStorage.COLUMN_EXT_INFO, jSONObject2);
            jSONObject.put("uxinfo", nullAsNil);
            jSONObject.put("snsid", snsInfo.field_snsId);
            jSONObject.put("scene", i3);
            String jSONObject3 = jSONObject.toString();
            k.jY("timeline_subscription_message", jSONObject3);
            Log.i("HalfScreenSubscribeUtils", "reportSubscribe timeline_subscription_message, content=".concat(String.valueOf(jSONObject3)));
            AppMethodBeat.o(202558);
        } catch (Exception e2) {
            Log.e("HalfScreenSubscribeUtils", "reportSubscribe exp:" + e2.toString());
            AppMethodBeat.o(202558);
        }
    }
}

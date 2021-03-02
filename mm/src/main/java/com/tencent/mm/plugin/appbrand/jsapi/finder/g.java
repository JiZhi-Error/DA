package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.finder.ui.FinderAlbumUI;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.protocal.protobuf.FinderJsApiMediaObj;
import com.tencent.mm.protocal.protobuf.FinderJsApiMediaThumbInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g extends d {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "openFinderPostPicker";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(163961);
        if (!(fVar.getContext() instanceof Activity)) {
            fVar.i(i2, "fail");
            AppMethodBeat.o(163961);
            return;
        }
        Intent intent = new Intent(fVar.getContext(), FinderAlbumUI.class);
        intent.addFlags(67108864);
        intent.putExtra("key_can_select_video_and_pic", true);
        intent.putExtra("is_hide_album_footer", true);
        intent.putExtra("show_header_view", false);
        intent.putExtra("max_select_count", 9);
        intent.putExtra("query_source_type", 25);
        intent.putExtra("query_media_type", 3);
        intent.putExtra("fromAppBrand", true);
        com.tencent.luggage.h.f.aK(fVar.getContext()).a(intent, new f.b() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.finder.g.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.b
            public final void a(int i2, Intent intent) {
                AppMethodBeat.i(163960);
                JSONArray jSONArray = new JSONArray();
                if (i2 == -1) {
                    int intExtra = intent.getIntExtra("postType", 0);
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("postMediaList");
                    ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("postThumbList");
                    Log.i("MicroMsg.Finder.JsApiOpenFinderPostPicker", "receive mediaType: %s", Integer.valueOf(intExtra));
                    Log.i("MicroMsg.Finder.JsApiOpenFinderPostPicker", "receive mediaPath: %s", stringArrayListExtra);
                    Log.i("MicroMsg.Finder.JsApiOpenFinderPostPicker", "receive thumbPath: %s", stringArrayListExtra2);
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < stringArrayListExtra.size(); i3++) {
                        i<String> iVar = new i<>();
                        FinderJsApiMediaObj finderJsApiMediaObj = new FinderJsApiMediaObj();
                        m a2 = fVar.getFileSystem().a(new o(stringArrayListExtra.get(i3)), (String) null, false, iVar);
                        if (a2 == m.OK) {
                            finderJsApiMediaObj.mediaPath = iVar.value;
                            if (finderJsApiMediaObj.mediaType == 2) {
                                finderJsApiMediaObj.thumbInfo = new FinderJsApiMediaThumbInfo();
                                String str = stringArrayListExtra2.get(i3);
                                m a3 = fVar.getFileSystem().a(new o(str), (String) null, false, iVar);
                                if (a3 == m.OK) {
                                    finderJsApiMediaObj.thumbInfo.thumbPath = iVar.value;
                                    y yVar = y.vXH;
                                    Point awm = y.awm(str);
                                    finderJsApiMediaObj.thumbInfo.thumbWidth = awm.x;
                                    finderJsApiMediaObj.thumbInfo.thumbHeight = awm.y;
                                    arrayList.add(finderJsApiMediaObj);
                                } else {
                                    Log.i("MicroMsg.Finder.JsApiOpenFinderPostPicker", "create thumb media file error %s %s %b %d", a3.name(), str, Boolean.valueOf(s.YS(str)), Long.valueOf(s.boW(str)));
                                }
                            } else if (finderJsApiMediaObj.mediaType == 4) {
                                finderJsApiMediaObj.thumbInfo = new FinderJsApiMediaThumbInfo();
                                String str2 = stringArrayListExtra2.get(i3);
                                m a4 = fVar.getFileSystem().a(new o(str2), (String) null, false, iVar);
                                if (a4 == m.OK) {
                                    finderJsApiMediaObj.thumbInfo.thumbPath = iVar.value;
                                    y yVar2 = y.vXH;
                                    a awl = y.awl(str2);
                                    if (awl != null) {
                                        finderJsApiMediaObj.thumbInfo.thumbWidth = awl.width;
                                        finderJsApiMediaObj.thumbInfo.thumbHeight = awl.height;
                                    }
                                    arrayList.add(finderJsApiMediaObj);
                                } else {
                                    Log.i("MicroMsg.Finder.JsApiOpenFinderPostPicker", "create thumb media file error %s %s %b %d", a4.name(), str2, Boolean.valueOf(s.YS(str2)), Long.valueOf(s.boW(str2)));
                                }
                            }
                        } else {
                            Log.i("MicroMsg.Finder.JsApiOpenFinderPostPicker", "create media file error %s %s", a2.name(), stringArrayListExtra.get(i3));
                        }
                    }
                    if (arrayList.size() > 0) {
                        try {
                            a.b(arrayList, jSONArray);
                            String a5 = a.a("", 0, jSONArray);
                            Log.i("MicroMsg.Finder.JsApiOpenFinderPostPicker", "returnRetMsg %s", a5);
                            fVar.i(i2, a5);
                            AppMethodBeat.o(163960);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.Finder.JsApiOpenFinderPostPicker", e2, "JsApiOpenFinderImagePickerController", new Object[0]);
                            fVar.i(i2, a.a(e2.getMessage(), -1, jSONArray));
                            AppMethodBeat.o(163960);
                        }
                    } else {
                        fVar.i(i2, a.a("not select media", -1, jSONArray));
                        AppMethodBeat.o(163960);
                    }
                } else {
                    fVar.i(i2, a.a("cancel select media", -1, jSONArray));
                    AppMethodBeat.o(163960);
                }
            }
        });
        AppMethodBeat.o(163961);
    }
}

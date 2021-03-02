package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.upload.i;
import com.tencent.mm.plugin.finder.upload.p;
import com.tencent.mm.plugin.finder.upload.q;
import com.tencent.mm.protocal.protobuf.FinderJsApiMediaObj;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiPostFinderDataItem extends d<s> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "postFinderDataItem";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(163974);
        s sVar2 = sVar;
        Log.i("MicroMsg.Finder.JsApiPostFinderDataItem", "JsApiPostFinderDataItem");
        if (jSONObject == null) {
            sVar2.i(i2, h("fail:data is null or nil", null));
            AppMethodBeat.o(163974);
            return;
        }
        int optInt = jSONObject.optInt("mediaType", 0);
        JSONArray optJSONArray = jSONObject.optJSONArray("mediaObjArray");
        String optString = jSONObject.optString("content", "");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            sVar2.i(i2, h("fail:mediaPathArray is null or nil", null));
            AppMethodBeat.o(163974);
            return;
        }
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                jSONObject2.put("mediaPath", sVar2.getCurrentPageView().getFileSystem().VY(jSONObject2.getString("mediaPath")).hes());
                JSONObject jSONObject3 = jSONObject2.getJSONObject("thumbInfo");
                jSONObject3.put("thumbPath", sVar2.getCurrentPageView().getFileSystem().VY(jSONObject3.getString("thumbPath")).hes());
            } catch (Exception e2) {
            }
        }
        PostFinderTask postFinderTask = new PostFinderTask(sVar2, i2, optInt, optJSONArray.toString(), optString);
        postFinderTask.bDJ();
        AppBrandMainProcessService.a(postFinderTask);
        AppMethodBeat.o(163974);
    }

    static class PostFinderTask extends MainProcessTask implements q {
        public static final Parcelable.Creator<PostFinderTask> CREATOR = new Parcelable.Creator<PostFinderTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiPostFinderDataItem.PostFinderTask.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ PostFinderTask[] newArray(int i2) {
                return new PostFinderTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PostFinderTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(163964);
                PostFinderTask postFinderTask = new PostFinderTask(parcel, (byte) 0);
                AppMethodBeat.o(163964);
                return postFinderTask;
            }
        };
        private String content;
        private String event;
        private s lVM;
        private String lVP;
        private String lVV;
        private long lVW;
        private int lqe;
        private int mediaType;

        /* synthetic */ PostFinderTask(Parcel parcel, byte b2) {
            this(parcel);
        }

        static /* synthetic */ boolean d(PostFinderTask postFinderTask) {
            AppMethodBeat.i(163972);
            boolean bDU = postFinderTask.bDU();
            AppMethodBeat.o(163972);
            return bDU;
        }

        public PostFinderTask(s sVar, int i2, int i3, String str, String str2) {
            this.lVM = sVar;
            this.lqe = i2;
            this.mediaType = i3;
            this.lVV = str;
            this.content = str2;
        }

        private PostFinderTask(Parcel parcel) {
            AppMethodBeat.i(163965);
            f(parcel);
            AppMethodBeat.o(163965);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(163966);
            this.mediaType = parcel.readInt();
            this.lVV = parcel.readString();
            this.content = parcel.readString();
            this.lVP = parcel.readString();
            this.event = parcel.readString();
            AppMethodBeat.o(163966);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(163967);
            parcel.writeInt(this.mediaType);
            parcel.writeString(this.lVV);
            parcel.writeString(this.content);
            parcel.writeString(this.lVP);
            parcel.writeString(this.event);
            AppMethodBeat.o(163967);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(163968);
            Log.i("MicroMsg.Finder.JsApiPostFinderDataItem", "runInClientProcess callback, appId[%s], msg[%s], callbackId[%d], isRunning[%b]", this.lVM.getAppId(), this.lVP, Integer.valueOf(this.lqe), Boolean.valueOf(this.lVM.isRunning()));
            if (Util.isNullOrNil(this.event) || !this.event.equals("onPostEnd")) {
                this.lVM.i(this.lqe, this.lVP);
                AppMethodBeat.o(163968);
                return;
            }
            new a((byte) 0).g(this.lVM).Zg(this.lVP).bEo();
            bDK();
            AppMethodBeat.o(163968);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(163969);
            try {
                JSONArray jSONArray = new JSONArray(this.lVV);
                final ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    arrayList.add((FinderJsApiMediaObj) a.a(jSONArray.optJSONObject(i2), FinderJsApiMediaObj.class));
                }
                h.RTc.b(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiPostFinderDataItem.PostFinderTask.AnonymousClass1 */

                    public final void run() {
                        cjl ha;
                        AppMethodBeat.i(163963);
                        cjk cjk = new cjk();
                        for (FinderJsApiMediaObj finderJsApiMediaObj : arrayList) {
                            if (finderJsApiMediaObj.mediaType == 4) {
                                i iVar = i.vSX;
                                ha = i.a(finderJsApiMediaObj.mediaPath, finderJsApiMediaObj.thumbInfo.thumbPath, null, "");
                            } else {
                                i iVar2 = i.vSX;
                                ha = i.ha(finderJsApiMediaObj.mediaPath, finderJsApiMediaObj.thumbInfo.thumbPath);
                            }
                            cjk.mediaList.add(ha);
                        }
                        PostFinderTask postFinderTask = PostFinderTask.this;
                        g.a aVar = g.vSJ;
                        postFinderTask.lVW = g.vSH.a(new p(PostFinderTask.this.mediaType, PostFinderTask.this.content, cjk, null, null, 0, null, false, "", null, false, false, null, "", "", 0, null));
                        if (PostFinderTask.this.lVW != -1) {
                            g.a aVar2 = g.vSJ;
                            g.vSH.a(PostFinderTask.this);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("feedLocalId", PostFinderTask.this.lVW);
                            } catch (Exception e2) {
                            }
                            PostFinderTask.this.lVP = a.a("", 0, jSONObject);
                        } else {
                            PostFinderTask.this.lVP = a.a("not found contact", -1, new JSONObject());
                        }
                        PostFinderTask.d(PostFinderTask.this);
                        AppMethodBeat.o(163963);
                    }
                }, "JsApiPostFinderDataItem");
                AppMethodBeat.o(163969);
            } catch (Exception e2) {
                AppMethodBeat.o(163969);
            }
        }

        static {
            AppMethodBeat.i(163973);
            AppMethodBeat.o(163973);
        }

        @Override // com.tencent.mm.plugin.finder.upload.q
        public void onPostStart(long j2) {
        }

        @Override // com.tencent.mm.plugin.finder.upload.q
        public void onPostEnd(long j2, boolean z) {
            AppMethodBeat.i(163970);
            if (j2 == this.lVW) {
                g.a aVar = g.vSJ;
                g.vSH.b(this);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("feedLocalId", String.valueOf(j2));
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Finder.JsApiPostFinderDataItem", e2, "PostFinderTask onPostEnd", new Object[0]);
                }
                this.event = "onPostEnd";
                if (z) {
                    this.lVP = a.a("", 0, jSONObject);
                } else {
                    this.lVP = a.a("post fail", -1, jSONObject);
                }
                bDU();
            }
            AppMethodBeat.o(163970);
        }

        @Override // com.tencent.mm.plugin.finder.upload.q
        public void onPostOk(long j2, long j3) {
            AppMethodBeat.i(163971);
            if (j2 == this.lVW) {
                g.a aVar = g.vSJ;
                g.vSH.b(this);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("feedLocalId", String.valueOf(j2));
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Finder.JsApiPostFinderDataItem", e2, "PostFinderTask onPostEnd", new Object[0]);
                }
                this.event = "onPostEnd";
                this.lVP = a.a("", 0, jSONObject);
                bDU();
            }
            AppMethodBeat.o(163971);
        }

        @Override // com.tencent.mm.plugin.finder.upload.q
        public void onPostNotify(long j2, boolean z) {
        }

        static final class a extends com.tencent.mm.plugin.appbrand.jsapi.s {
            private static final int CTRL_INDEX = -2;
            private static final String NAME = "onFeedPostCallback";

            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }
    }
}

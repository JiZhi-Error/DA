package com.tencent.mm.plugin.sns.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.e;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vfs.s;

public final class af implements b {
    private h.a DJU = new h.a() {
        /* class com.tencent.mm.plugin.sns.model.af.AnonymousClass1 */

        @Override // com.tencent.mm.i.h.a
        public final void Ds(String str) {
        }

        @Override // com.tencent.mm.i.h.a
        public final void a(final String str, final long j2, final long j3, final String str2) {
            AppMethodBeat.i(202731);
            if (af.this.qWn != null && af.this.xCU.equals(str)) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.model.af.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(95708);
                        af.this.qWn.AI(j2);
                        AppMethodBeat.o(95708);
                    }
                });
            }
            AppMethodBeat.o(202731);
        }

        @Override // com.tencent.mm.i.h.a
        public final void onDataAvailable(final String str, final long j2, final long j3) {
            AppMethodBeat.i(95713);
            if (af.this.qWn != null && af.this.xCU.equals(str)) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.model.af.AnonymousClass1.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(95709);
                        af.this.qWn.onDataAvailable(str, j2, j3);
                        AppMethodBeat.o(95709);
                    }
                });
            }
            AppMethodBeat.o(95713);
        }

        @Override // com.tencent.mm.i.h.a
        public final void i(final String str, final long j2, final long j3) {
            AppMethodBeat.i(95714);
            if (af.this.qWn != null && af.this.xCU.equals(str)) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.model.af.AnonymousClass1.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(95710);
                        af.this.qWn.i(str, j2, j3);
                        AppMethodBeat.o(95710);
                    }
                });
            }
            AppMethodBeat.o(95714);
        }

        @Override // com.tencent.mm.i.h.a
        public final void a(final String str, final int i2, d dVar) {
            AppMethodBeat.i(95715);
            if (af.this.qWn != null && af.this.xCU.equals(str)) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.model.af.AnonymousClass1.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(95711);
                        MMApplicationContext.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0).edit().putBoolean(str, true).commit();
                        af.this.qWn.ax(str, i2);
                        aj.faJ().aOM(str);
                        AppMethodBeat.o(95711);
                    }
                });
            }
            AppMethodBeat.o(95715);
        }
    };
    b.a qWn;
    String xCU = "";

    public af() {
        AppMethodBeat.i(95716);
        AppMethodBeat.o(95716);
    }

    @Override // com.tencent.mm.modelvideo.b
    public final void p(String str, String str2, String str3) {
        AppMethodBeat.i(95717);
        this.xCU = str;
        Log.i("MicroMsg.SnsAdStreamVideoProxy", "%s start http stream[%s, %s, %s]", Integer.valueOf(hashCode()), str, str3, str2);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("sns_ad_download_resource_preferences", 0);
        boolean z = sharedPreferences.getBoolean(str, false);
        if (s.YS(str2)) {
            Log.i("MicroMsg.SnsAdStreamVideoProxy", "is already download %s", Boolean.valueOf(z));
            if (z) {
                this.DJU.a(str, 0, null);
                AppMethodBeat.o(95717);
                return;
            }
        } else if (z) {
            Log.i("MicroMsg.SnsAdStreamVideoProxy", "last download file was deleted");
            sharedPreferences.edit().putBoolean(str, false).commit();
        }
        if (aj.faJ().aOP(str)) {
            Log.i("%s is already in downloading", str3);
            AppMethodBeat.o(95717);
            return;
        }
        aj.faJ().a(str, str3, str2, this.DJU);
        AppMethodBeat.o(95717);
    }

    @Override // com.tencent.mm.modelvideo.b
    public final void he(String str) {
        AppMethodBeat.i(95718);
        Log.i("MicroMsg.SnsAdStreamVideoProxy", "%s, stop stream[%s]", Integer.valueOf(hashCode()), str);
        if (this.xCU.equals(str)) {
            aj.faJ().aOM(str);
        }
        AppMethodBeat.o(95718);
    }

    @Override // com.tencent.mm.modelvideo.b
    public final void requestVideoData(String str, int i2, int i3) {
        AppMethodBeat.i(95719);
        Log.d("MicroMsg.SnsAdStreamVideoProxy", "%s, request video data[%s, %s, %s]", Integer.valueOf(hashCode()), str, Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.xCU.equals(str)) {
            o.bhk();
            e.r(str, i2, i3);
        }
        AppMethodBeat.o(95719);
    }

    @Override // com.tencent.mm.modelvideo.b
    public final boolean isVideoDataAvailable(String str, int i2, int i3) {
        boolean z = false;
        AppMethodBeat.i(95720);
        Log.d("MicroMsg.SnsAdStreamVideoProxy", "%s, check video data available[%s, %s, %s]", Integer.valueOf(hashCode()), str, Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.xCU.equals(str)) {
            z = o.bhk().isVideoDataAvailable(str, i2, i3);
        }
        AppMethodBeat.o(95720);
        return z;
    }

    @Override // com.tencent.mm.modelvideo.b
    public final void a(b.a aVar) {
        this.qWn = aVar;
    }
}

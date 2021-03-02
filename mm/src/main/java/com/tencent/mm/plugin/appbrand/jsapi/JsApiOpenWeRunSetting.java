package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.ui.AppBrandOpenWeRunSettingUI;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.sport.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class JsApiOpenWeRunSetting extends d {
    public static final int CTRL_INDEX = 228;
    public static final String NAME = "openWeRunSetting";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        boolean z = true;
        AppMethodBeat.i(45601);
        if (jSONObject != null) {
            z = jSONObject.optBoolean("checkSupport", true);
        }
        OpenWeRunSetting openWeRunSetting = new OpenWeRunSetting(this, fVar, i2, z);
        openWeRunSetting.bDJ();
        AppBrandMainProcessService.a(openWeRunSetting);
        AppMethodBeat.o(45601);
    }

    static class OpenWeRunSetting extends MainProcessTask {
        public static final Parcelable.Creator<OpenWeRunSetting> CREATOR = new Parcelable.Creator<OpenWeRunSetting>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting.OpenWeRunSetting.AnonymousClass4 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ OpenWeRunSetting[] newArray(int i2) {
                return new OpenWeRunSetting[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ OpenWeRunSetting createFromParcel(Parcel parcel) {
                AppMethodBeat.i(174771);
                OpenWeRunSetting openWeRunSetting = new OpenWeRunSetting(parcel);
                AppMethodBeat.o(174771);
                return openWeRunSetting;
            }
        };
        private boolean eeO = false;
        private p lAw;
        private f lAx;
        private boolean lBm = false;
        private boolean lBn;
        private int lqe;

        public OpenWeRunSetting(p pVar, f fVar, int i2, boolean z) {
            AppMethodBeat.i(45592);
            Log.i("MicroMsg.JsApiOpenWeRunSetting", "OpenWeRunSetting");
            this.lAw = pVar;
            this.lAx = fVar;
            this.lqe = i2;
            this.lBn = z;
            AppMethodBeat.o(45592);
        }

        public OpenWeRunSetting(Parcel parcel) {
            AppMethodBeat.i(45593);
            f(parcel);
            AppMethodBeat.o(45593);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(45594);
            final AnonymousClass1 r0 = new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting.OpenWeRunSetting.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(174768);
                    OpenWeRunSetting.this.lBm = ((b) g.af(b.class)).hg(MMApplicationContext.getContext());
                    if (!OpenWeRunSetting.this.lBn || OpenWeRunSetting.this.lBm) {
                        OpenWeRunSetting.c(OpenWeRunSetting.this);
                        AppMethodBeat.o(174768);
                        return;
                    }
                    ((com.tencent.mm.plugin.exdevice.a.b) g.af(com.tencent.mm.plugin.exdevice.a.b.class)).a(new b.a() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting.OpenWeRunSetting.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.exdevice.a.b.a
                        public final void w(boolean z, boolean z2) {
                            boolean z3;
                            AppMethodBeat.i(174767);
                            OpenWeRunSetting openWeRunSetting = OpenWeRunSetting.this;
                            if (!z || !z2) {
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            openWeRunSetting.lBm = z3;
                            Log.i("MicroMsg.JsApiOpenWeRunSetting", "After getUserState requestOk %b, hasStep %b", Boolean.valueOf(z), Boolean.valueOf(z2));
                            OpenWeRunSetting.c(OpenWeRunSetting.this);
                            AppMethodBeat.o(174767);
                        }
                    });
                    AppMethodBeat.o(174768);
                }
            };
            if (g.aAi().hrh.hrB) {
                r0.run();
                AppMethodBeat.o(45594);
                return;
            }
            g.aAi().a(new com.tencent.mm.kernel.api.g() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting.OpenWeRunSetting.AnonymousClass2 */

                @Override // com.tencent.mm.kernel.api.g
                public final void WY() {
                    AppMethodBeat.i(174769);
                    r0.run();
                    AppMethodBeat.o(174769);
                }

                @Override // com.tencent.mm.kernel.api.g
                public final void cQ(boolean z) {
                }
            });
            AppMethodBeat.o(45594);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(45596);
            if (this.lBn && !this.lBm) {
                this.lAx.i(this.lqe, this.lAw.h("fail device not support", null));
                bDK();
                AppMethodBeat.o(45596);
            } else if (this.eeO) {
                this.lAx.i(this.lqe, this.lAw.h("ok", null));
                bDK();
                AppMethodBeat.o(45596);
            } else {
                Context context = this.lAx.getContext();
                if (context == null) {
                    this.lAx.i(this.lqe, this.lAw.h("fail:internal error invalid android context", null));
                    bDK();
                    AppMethodBeat.o(45596);
                    return;
                }
                l lVar = (l) this.lAx.av(l.class);
                if (lVar == null || Util.isNullOrNil(lVar.brandName)) {
                    this.lAx.i(this.lqe, this.lAw.h("fail", null));
                    bDK();
                    AppMethodBeat.o(45596);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("OpenWeRunSettingName", lVar.brandName);
                intent.setClass(context, AppBrandOpenWeRunSettingUI.class);
                f.aK(context).a(intent, new f.b() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting.OpenWeRunSetting.AnonymousClass3 */

                    @Override // com.tencent.luggage.h.f.b
                    public final void a(int i2, Intent intent) {
                        AppMethodBeat.i(174770);
                        if (i2 == -1) {
                            OpenWeRunSetting.this.lAx.i(OpenWeRunSetting.this.lqe, OpenWeRunSetting.this.lAw.h("ok", null));
                            OpenWeRunSetting.this.bDK();
                            AppMethodBeat.o(174770);
                        } else if (i2 == 0) {
                            OpenWeRunSetting.this.lAx.i(OpenWeRunSetting.this.lqe, OpenWeRunSetting.this.lAw.h("cancel", null));
                            OpenWeRunSetting.this.bDK();
                            AppMethodBeat.o(174770);
                        } else {
                            OpenWeRunSetting.this.lAx.i(OpenWeRunSetting.this.lqe, OpenWeRunSetting.this.lAw.h("fail", null));
                            OpenWeRunSetting.this.bDK();
                            AppMethodBeat.o(174770);
                        }
                    }
                });
                bDK();
                AppMethodBeat.o(45596);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3 = true;
            AppMethodBeat.i(45597);
            if (parcel.readByte() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.lBm = z;
            if (parcel.readByte() != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.eeO = z2;
            if (parcel.readByte() == 0) {
                z3 = false;
            }
            this.lBn = z3;
            AppMethodBeat.o(45597);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            byte b2;
            byte b3;
            byte b4 = 1;
            AppMethodBeat.i(45598);
            if (this.lBm) {
                b2 = 1;
            } else {
                b2 = 0;
            }
            parcel.writeByte(b2);
            if (this.eeO) {
                b3 = 1;
            } else {
                b3 = 0;
            }
            parcel.writeByte(b3);
            if (!this.lBn) {
                b4 = 0;
            }
            parcel.writeByte(b4);
            AppMethodBeat.o(45598);
        }

        static {
            AppMethodBeat.i(45600);
            AppMethodBeat.o(45600);
        }

        static /* synthetic */ void c(OpenWeRunSetting openWeRunSetting) {
            AppMethodBeat.i(174772);
            if (!openWeRunSetting.lBn || openWeRunSetting.lBm) {
                openWeRunSetting.eeO = ((com.tencent.mm.plugin.sport.a.b) g.af(com.tencent.mm.plugin.sport.a.b.class)).fmg();
                if (openWeRunSetting.lBn && openWeRunSetting.eeO) {
                    ((com.tencent.mm.plugin.sport.a.b) g.af(com.tencent.mm.plugin.sport.a.b.class)).fmf();
                }
            }
            openWeRunSetting.bDU();
            AppMethodBeat.o(174772);
        }
    }
}

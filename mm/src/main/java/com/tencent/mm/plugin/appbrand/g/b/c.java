package com.tencent.mm.plugin.appbrand.g.b;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.iid.InstanceID;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.a.f;
import com.tencent.mm.plugin.appbrand.g.a.g;
import com.tencent.mm.plugin.appbrand.g.a.i;
import com.tencent.mm.plugin.appbrand.g.a.j;
import com.tencent.mm.plugin.appbrand.g.a.k;
import com.tencent.mm.plugin.appbrand.g.a.l;
import com.tencent.mm.plugin.appbrand.g.a.m;
import com.tencent.mm.plugin.appbrand.g.a.n;
import com.tencent.mm.plugin.appbrand.g.b.e;
import com.tencent.mm.plugin.appbrand.g.c.a.a;
import com.tencent.mm.plugin.appbrand.g.c.a.b;
import com.tencent.mm.plugin.appbrand.g.c.b.d;
import com.tencent.mm.plugin.appbrand.g.c.c;
import com.tencent.mm.plugin.appbrand.g.c.h;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public final class c implements b {
    protected b ljV;
    protected h ljW = h.bBB();
    protected f ljX;
    protected f ljY;
    protected f ljZ;
    protected e lka = new e();
    protected com.tencent.mm.plugin.appbrand.g.c.b.c lkb;
    protected com.tencent.mm.plugin.appbrand.g.c.b.c lkc;
    protected d lkd;
    protected boolean lke = false;
    protected boolean lkf = false;
    protected boolean mIsMute = false;

    public final b bBo() {
        return this.ljV;
    }

    public final e.a bBp() {
        return this.lka.lkh;
    }

    public final void a(e.a aVar) {
        this.lka.lkh = aVar;
    }

    public static c a(b bVar) {
        boolean z;
        AppMethodBeat.i(158922);
        c cVar = new c(bVar);
        if (cVar.ljX == null || cVar.ljY == null) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            AppMethodBeat.o(158922);
            return cVar;
        }
        AppMethodBeat.o(158922);
        return null;
    }

    public c(b bVar) {
        AppMethodBeat.i(158923);
        this.ljV = bVar;
        init();
        AppMethodBeat.o(158923);
    }

    private void init() {
        AppMethodBeat.i(158924);
        if (this.ljV == null) {
            AppMethodBeat.o(158924);
        } else if (this.ljV.ljT.size() == 0) {
            AppMethodBeat.o(158924);
        } else {
            Iterator<f> it = this.ljV.ljT.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (!TextUtils.isEmpty(next.iBb)) {
                    if (next.iBb.startsWith("urn:schemas-upnp-org:service:AVTransport")) {
                        this.ljX = next;
                    } else if (next.iBb.startsWith("urn:schemas-upnp-org:service:RenderingControl")) {
                        this.ljY = next;
                    } else if (next.iBb.startsWith("urn:schemas-upnp-org:service:ConnectionManager")) {
                        this.ljZ = next;
                    }
                }
            }
            AppMethodBeat.o(158924);
        }
    }

    public final void a(String str, a aVar) {
        AppMethodBeat.i(158925);
        if (this.ljX != null) {
            this.ljW.a(new j(a(this.ljX), this.ljX.iBb, str), aVar);
        }
        AppMethodBeat.o(158925);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(158926);
        if (this.ljX != null) {
            this.ljW.a(new g(a(this.ljX), this.ljX.iBb), aVar);
        }
        AppMethodBeat.o(158926);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(158927);
        if (this.ljX != null) {
            this.ljW.a(new f(a(this.ljX), this.ljX.iBb), aVar);
        }
        AppMethodBeat.o(158927);
    }

    public final void c(a aVar) {
        AppMethodBeat.i(158928);
        if (this.ljX != null) {
            this.ljW.a(new l(a(this.ljX), this.ljX.iBb), aVar);
        }
        AppMethodBeat.o(158928);
    }

    public final void a(int i2, a aVar) {
        AppMethodBeat.i(158929);
        if (this.ljY != null) {
            this.ljW.a(new k(a(this.ljY), this.ljY.iBb, i2), aVar);
        }
        AppMethodBeat.o(158929);
    }

    public final void d(a aVar) {
        AppMethodBeat.i(158930);
        if (this.ljY != null) {
            this.ljW.a(new com.tencent.mm.plugin.appbrand.g.a.c(a(this.ljY), this.ljY.iBb), aVar);
        }
        AppMethodBeat.o(158930);
    }

    public final void b(String str, a aVar) {
        AppMethodBeat.i(158931);
        if (this.ljX != null) {
            this.ljW.a(new i(a(this.ljX), this.ljX.iBb, str), aVar);
        }
        AppMethodBeat.o(158931);
    }

    public final void e(a aVar) {
        AppMethodBeat.i(158932);
        if (this.ljX != null) {
            this.ljW.a(new com.tencent.mm.plugin.appbrand.g.a.b(a(this.ljX), this.ljX.iBb), aVar);
        }
        AppMethodBeat.o(158932);
    }

    public final void f(a aVar) {
        AppMethodBeat.i(158933);
        if (this.ljX != null) {
            this.ljW.a(new com.tencent.mm.plugin.appbrand.g.a.a(a(this.ljX), this.ljX.iBb), aVar);
        }
        AppMethodBeat.o(158933);
    }

    public final void bBq() {
        AppMethodBeat.i(158934);
        if (this.lke) {
            AppMethodBeat.o(158934);
            return;
        }
        com.tencent.mm.plugin.appbrand.g.c.c bBx = c.b.bBx();
        AnonymousClass1 r1 = new com.tencent.mm.plugin.appbrand.g.c.a.c() {
            /* class com.tencent.mm.plugin.appbrand.g.b.c.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.g.c.a.c
            public final void a(com.tencent.mm.plugin.appbrand.g.c.b.c cVar) {
                AppMethodBeat.i(158914);
                c.this.lke = true;
                c.this.lkb = cVar;
                if (c.this.ljV != null) {
                    new StringBuilder().append(c.this.ljV.ljP).append(" subscribeAVTransportEvent success");
                }
                AppMethodBeat.o(158914);
            }

            @Override // com.tencent.mm.plugin.appbrand.g.c.a.c
            public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                AppMethodBeat.i(158915);
                if (!(eVar == null || c.this.ljV == null)) {
                    new StringBuilder().append(c.this.ljV.ljP).append(" subscribeAVTransportEvent fail response code : ").append(eVar.responseCode);
                }
                AppMethodBeat.o(158915);
            }
        };
        f fVar = this.ljX;
        if (fVar != null) {
            h.bBB().a(new m(com.tencent.mm.plugin.appbrand.g.c.g.u(this.ljV.host, this.ljV.port, fVar.lkr), bBx.Yc("/upnp/cb/AVTransport")), new a(this, r1) {
                /* class com.tencent.mm.plugin.appbrand.g.c.c.AnonymousClass1 */
                final /* synthetic */ com.tencent.mm.plugin.appbrand.g.b.c lkH;
                final /* synthetic */ com.tencent.mm.plugin.appbrand.g.c.a.c lkI;

                {
                    this.lkH = r2;
                    this.lkI = r3;
                }

                @Override // com.tencent.mm.plugin.appbrand.g.c.a.a
                public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                    AppMethodBeat.i(158955);
                    String str = eVar.llp.get("SID");
                    com.tencent.mm.plugin.appbrand.g.c.b.c cVar = new com.tencent.mm.plugin.appbrand.g.c.b.c();
                    com.tencent.mm.plugin.appbrand.g.c.b.b bVar = eVar.llp;
                    cVar.llm = bVar.get("SID");
                    cVar.timeout = bVar.get(InstanceID.ERROR_TIMEOUT);
                    cVar.lln = this.lkH;
                    c.this.lkE.put(str, cVar);
                    if (this.lkI != null) {
                        this.lkI.a(cVar);
                    }
                    AppMethodBeat.o(158955);
                }

                @Override // com.tencent.mm.plugin.appbrand.g.c.a.a
                public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                    AppMethodBeat.i(158956);
                    if (this.lkI != null) {
                        this.lkI.a(eVar);
                    }
                    AppMethodBeat.o(158956);
                }
            });
            AppMethodBeat.o(158934);
            return;
        }
        r1.a((com.tencent.mm.plugin.appbrand.g.c.b.e) null);
        AppMethodBeat.o(158934);
    }

    public final void bBr() {
        AppMethodBeat.i(158935);
        if (this.lkf) {
            AppMethodBeat.o(158935);
            return;
        }
        com.tencent.mm.plugin.appbrand.g.c.c bBx = c.b.bBx();
        AnonymousClass2 r1 = new com.tencent.mm.plugin.appbrand.g.c.a.c() {
            /* class com.tencent.mm.plugin.appbrand.g.b.c.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.g.c.a.c
            public final void a(com.tencent.mm.plugin.appbrand.g.c.b.c cVar) {
                AppMethodBeat.i(158916);
                c.this.lkf = true;
                c.this.lkc = cVar;
                if (c.this.ljV != null) {
                    new StringBuilder().append(c.this.ljV.ljP).append(" subscribeRenderingControlEvent success");
                }
                AppMethodBeat.o(158916);
            }

            @Override // com.tencent.mm.plugin.appbrand.g.c.a.c
            public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                AppMethodBeat.i(158917);
                if (!(eVar == null || c.this.ljV == null)) {
                    new StringBuilder().append(c.this.ljV.ljP).append(" subscribeRenderingControlEvent fail response code : ").append(eVar.responseCode);
                }
                AppMethodBeat.o(158917);
            }
        };
        f fVar = this.ljY;
        if (fVar != null) {
            h.bBB().a(new m(com.tencent.mm.plugin.appbrand.g.c.g.u(this.ljV.host, this.ljV.port, fVar.lkr), bBx.Yc("/upnp/cb/RenderControl")), new a(this, r1) {
                /* class com.tencent.mm.plugin.appbrand.g.c.c.AnonymousClass2 */
                final /* synthetic */ com.tencent.mm.plugin.appbrand.g.b.c lkH;
                final /* synthetic */ com.tencent.mm.plugin.appbrand.g.c.a.c lkI;

                {
                    this.lkH = r2;
                    this.lkI = r3;
                }

                @Override // com.tencent.mm.plugin.appbrand.g.c.a.a
                public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                    AppMethodBeat.i(158957);
                    String str = eVar.llp.get("SID");
                    com.tencent.mm.plugin.appbrand.g.c.b.c cVar = new com.tencent.mm.plugin.appbrand.g.c.b.c();
                    com.tencent.mm.plugin.appbrand.g.c.b.b bVar = eVar.llp;
                    cVar.llm = bVar.get("SID");
                    cVar.timeout = bVar.get(InstanceID.ERROR_TIMEOUT);
                    cVar.lln = this.lkH;
                    c.this.lkF.put(str, cVar);
                    if (this.lkI != null) {
                        this.lkI.a(cVar);
                    }
                    AppMethodBeat.o(158957);
                }

                @Override // com.tencent.mm.plugin.appbrand.g.c.a.a
                public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                    AppMethodBeat.i(158958);
                    if (this.lkI != null) {
                        this.lkI.a(eVar);
                    }
                    AppMethodBeat.o(158958);
                }
            });
            AppMethodBeat.o(158935);
            return;
        }
        r1.a((com.tencent.mm.plugin.appbrand.g.c.b.e) null);
        AppMethodBeat.o(158935);
    }

    public final void bBs() {
        AppMethodBeat.i(158936);
        if (!this.lke) {
            AppMethodBeat.o(158936);
            return;
        }
        com.tencent.mm.plugin.appbrand.g.c.c bBx = c.b.bBx();
        AnonymousClass3 r1 = new a() {
            /* class com.tencent.mm.plugin.appbrand.g.b.c.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.appbrand.g.c.a.a
            public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                AppMethodBeat.i(158918);
                c.this.lke = false;
                c.this.lkb = null;
                if (c.this.ljV != null) {
                    new StringBuilder().append(c.this.ljV.ljP).append(" unSubscribeAVTransportEvent success");
                }
                AppMethodBeat.o(158918);
            }

            @Override // com.tencent.mm.plugin.appbrand.g.c.a.a
            public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                AppMethodBeat.i(158919);
                if (!(eVar == null || c.this.ljV == null)) {
                    new StringBuilder().append(c.this.ljV.ljP).append(" unSubscribeAVTransportEvent fail response code : ").append(eVar.responseCode);
                }
                AppMethodBeat.o(158919);
            }
        };
        f fVar = this.ljX;
        com.tencent.mm.plugin.appbrand.g.c.b.c cVar = this.lkb;
        if (fVar == null || cVar == null || cVar.llm == null) {
            r1.a(null);
            AppMethodBeat.o(158936);
            return;
        }
        h.bBB().a(new n(com.tencent.mm.plugin.appbrand.g.c.g.u(this.ljV.host, this.ljV.port, fVar.lkr), cVar.llm), new a(cVar, r1) {
            /* class com.tencent.mm.plugin.appbrand.g.c.c.AnonymousClass3 */
            final /* synthetic */ com.tencent.mm.plugin.appbrand.g.c.b.c lkK;
            final /* synthetic */ com.tencent.mm.plugin.appbrand.g.c.a.a lkL;

            {
                this.lkK = r2;
                this.lkL = r3;
            }

            @Override // com.tencent.mm.plugin.appbrand.g.c.a.a
            public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                AppMethodBeat.i(158959);
                c.this.lkE.remove(this.lkK.llm);
                if (this.lkL != null) {
                    this.lkL.b(eVar);
                }
                AppMethodBeat.o(158959);
            }

            @Override // com.tencent.mm.plugin.appbrand.g.c.a.a
            public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                AppMethodBeat.i(158960);
                if (this.lkL != null) {
                    this.lkL.a(eVar);
                }
                AppMethodBeat.o(158960);
            }
        });
        AppMethodBeat.o(158936);
    }

    public final void bBt() {
        AppMethodBeat.i(158937);
        if (!this.lkf) {
            AppMethodBeat.o(158937);
            return;
        }
        com.tencent.mm.plugin.appbrand.g.c.c bBx = c.b.bBx();
        AnonymousClass4 r1 = new a() {
            /* class com.tencent.mm.plugin.appbrand.g.b.c.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.appbrand.g.c.a.a
            public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                AppMethodBeat.i(158920);
                c.this.lkf = false;
                c.this.lkc = null;
                if (c.this.ljV != null) {
                    new StringBuilder().append(c.this.ljV.ljP).append(" unSubscribeRenderingControlEvent success");
                }
                AppMethodBeat.o(158920);
            }

            @Override // com.tencent.mm.plugin.appbrand.g.c.a.a
            public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                AppMethodBeat.i(158921);
                if (!(eVar == null || c.this.ljV == null)) {
                    new StringBuilder().append(c.this.ljV.ljP).append(" unSubscribeRenderingControlEvent fail response code : ").append(eVar.responseCode);
                }
                AppMethodBeat.o(158921);
            }
        };
        f fVar = this.ljY;
        com.tencent.mm.plugin.appbrand.g.c.b.c cVar = this.lkc;
        if (fVar == null || cVar == null || cVar.llm == null) {
            r1.a(null);
            AppMethodBeat.o(158937);
            return;
        }
        h.bBB().a(new n(com.tencent.mm.plugin.appbrand.g.c.g.u(this.ljV.host, this.ljV.port, fVar.lkr), cVar.llm), new a(cVar, r1) {
            /* class com.tencent.mm.plugin.appbrand.g.c.c.AnonymousClass4 */
            final /* synthetic */ com.tencent.mm.plugin.appbrand.g.c.b.c lkK;
            final /* synthetic */ com.tencent.mm.plugin.appbrand.g.c.a.a lkL;

            {
                this.lkK = r2;
                this.lkL = r3;
            }

            @Override // com.tencent.mm.plugin.appbrand.g.c.a.a
            public final void b(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                AppMethodBeat.i(158961);
                c.this.lkF.remove(this.lkK.llm);
                if (this.lkL != null) {
                    this.lkL.b(eVar);
                }
                AppMethodBeat.o(158961);
            }

            @Override // com.tencent.mm.plugin.appbrand.g.c.a.a
            public final void a(com.tencent.mm.plugin.appbrand.g.c.b.e eVar) {
                AppMethodBeat.i(158962);
                if (this.lkL != null) {
                    this.lkL.a(eVar);
                }
                AppMethodBeat.o(158962);
            }
        });
        AppMethodBeat.o(158937);
    }

    private String a(f fVar) {
        AppMethodBeat.i(158938);
        if (this.ljV != null) {
            String u = com.tencent.mm.plugin.appbrand.g.c.g.u(this.ljV.host, this.ljV.port, fVar.lkq);
            AppMethodBeat.o(158938);
            return u;
        }
        AppMethodBeat.o(158938);
        return "";
    }

    public final void a(d dVar) {
        this.lkd = dVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.g.c.a.b
    public final boolean a(d dVar) {
        String str;
        boolean z;
        HashMap<String, com.tencent.mm.plugin.appbrand.g.c.b.a> hashMap = null;
        AppMethodBeat.i(158939);
        if (this.lkd == null) {
            AppMethodBeat.o(158939);
            return true;
        } else if (dVar.llq == null || dVar.llq.containsKey("LastChange")) {
            if (dVar.llq != null) {
                str = ((com.tencent.mm.plugin.appbrand.g.c.b.a) Objects.requireNonNull(dVar.llq.get("LastChange"))).value;
            } else {
                str = null;
            }
            if (str != null) {
                hashMap = com.tencent.mm.plugin.appbrand.g.c.j.bBE().Yf(str);
            }
            if (hashMap == null) {
                AppMethodBeat.o(158939);
                return false;
            }
            if ("avtEvent".equals(dVar.llo)) {
                com.tencent.mm.plugin.appbrand.g.c.b.a aVar = hashMap.get("TransportState");
                if (aVar != null) {
                    String Yh = aVar.Yh("val");
                    if ("PLAYING".equalsIgnoreCase(Yh)) {
                        this.lkd.d(this);
                    } else if ("PAUSED_PLAYBACK".equalsIgnoreCase(Yh)) {
                        this.lkd.e(this);
                    } else if ("STOPPED".equalsIgnoreCase(Yh)) {
                        this.lkd.f(this);
                    }
                }
                com.tencent.mm.plugin.appbrand.g.c.b.a aVar2 = hashMap.get("CurrentTrackDuration");
                if (aVar2 != null) {
                    String[] split = aVar2.Yh("val").split(":");
                    if (split.length == 3) {
                        this.lkd.b(this, Integer.parseInt(split[2]) + (Integer.parseInt(split[0]) * LocalCache.TIME_HOUR) + (Integer.parseInt(split[1]) * 60));
                    }
                }
            } else if ("rdcEvent".equals(dVar.llo)) {
                com.tencent.mm.plugin.appbrand.g.c.b.a aVar3 = hashMap.get("Volume");
                if (aVar3 != null) {
                    this.lkd.a(this, Integer.parseInt(aVar3.Yh("val")));
                }
                com.tencent.mm.plugin.appbrand.g.c.b.a aVar4 = hashMap.get("Mute");
                if (aVar4 != null) {
                    if (!AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(aVar4.Yh("val"))) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.lkd.a(this, z);
                }
            }
            AppMethodBeat.o(158939);
            return true;
        } else {
            AppMethodBeat.o(158939);
            return false;
        }
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(158940);
        if (this.ljV == null && obj == null) {
            AppMethodBeat.o(158940);
            return true;
        } else if (this.ljV == null) {
            AppMethodBeat.o(158940);
            return false;
        } else if (obj == this) {
            AppMethodBeat.o(158940);
            return true;
        } else if (obj instanceof c) {
            boolean equals = this.ljV.equals(((c) obj).ljV);
            AppMethodBeat.o(158940);
            return equals;
        } else {
            AppMethodBeat.o(158940);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.i(158941);
        String str = "MRDevice{mDevice=" + this.ljV + '}';
        AppMethodBeat.o(158941);
        return str;
    }
}

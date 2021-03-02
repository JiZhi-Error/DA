package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bb.h;
import com.tencent.mm.ce.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.eggspring.a.a;
import com.tencent.mm.plugin.eggspring.c;
import com.tencent.mm.plugin.eggspring.d;
import com.tencent.mm.plugin.eggspring.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.bu;

public final class aa implements i {
    ChattingAnimFrame PjB = null;
    private d PjC;
    private long PjD = 0;
    private long PjE = 0;
    private e VlA;
    private boolean dZl;
    private String name;
    private long qVk = 0;

    public aa() {
        AppMethodBeat.i(34793);
        AppMethodBeat.o(34793);
    }

    public final void P(boolean z, String str) {
        this.dZl = z;
        this.name = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0163, code lost:
        if (r6 != false) goto L_0x0165;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0154  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long a(final android.app.Activity r21, java.util.List<com.tencent.mm.storage.ca> r22) {
        /*
        // Method dump skipped, instructions count: 874
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.aa.a(android.app.Activity, java.util.List):long");
    }

    public final void gOi() {
        AppMethodBeat.i(232907);
        if (this.PjB != null) {
            this.PjB.stop();
        }
        if (this.PjC != null) {
            d dVar = this.PjC;
            StringBuilder sb = new StringBuilder("dispose: job is running: ");
            bu buVar = dVar.qUS;
            Log.i("MicroMsg.SpringLuckyEggHelper", sb.append(buVar != null ? Boolean.valueOf(buVar.isActive()) : null).toString());
            bu buVar2 = dVar.qUS;
            if (buVar2 != null) {
                buVar2.a((CancellationException) null);
            }
            dVar.qUS = null;
        }
        if (this.VlA != null) {
            e eVar = this.VlA;
            String str = eVar.TAG;
            StringBuilder sb2 = new StringBuilder("dispose: ");
            bu buVar3 = eVar.qUS;
            Log.i(str, sb2.append(buVar3 != null ? Boolean.valueOf(buVar3.isActive()) : null).toString());
            bu buVar4 = eVar.qUS;
            if (buVar4 != null) {
                buVar4.a((CancellationException) null);
            }
            eVar.qUS = null;
            eVar.gWp = null;
        }
        Log.i("MicroMsg.EggMgr", "egg has been stop, %s", this.PjB);
        AppMethodBeat.o(232907);
    }

    public final void onResume() {
        AppMethodBeat.i(232908);
        g.azz().a(2757, this);
        AppMethodBeat.o(232908);
    }

    public final void onPause() {
        AppMethodBeat.i(232909);
        g.azz().b(2757, this);
        AppMethodBeat.o(232909);
    }

    public static void onDestroy() {
        AppMethodBeat.i(258934);
        ((a) g.ah(a.class)).cleanPrefetch();
        AppMethodBeat.o(258934);
    }

    private static boolean bmz(String str) {
        boolean z = true;
        AppMethodBeat.i(34797);
        if (!Util.isNullOrNil(str)) {
            String[] split = str.split(",");
            int length = split.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    if (split[i2].equals(LocaleUtil.getApplicationLanguage())) {
                        break;
                    }
                    i2++;
                } else {
                    z = false;
                    break;
                }
            }
        }
        AppMethodBeat.o(34797);
        return z;
    }

    private static int bt(String str, String str2, String str3) {
        boolean z;
        char charAt;
        String str4;
        AppMethodBeat.i(34798);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || MMApplicationContext.getContext() == null) {
            AppMethodBeat.o(34798);
            return -1;
        }
        String lowerCase = str.toLowerCase();
        int lastIndexOf = lowerCase.lastIndexOf(str2.toLowerCase());
        if (lastIndexOf == -1) {
            AppMethodBeat.o(34798);
            return -1;
        }
        do {
            try {
                if (lastIndexOf >= lowerCase.length() - 1 || Util.isNullOrNil(str3)) {
                    z = true;
                } else {
                    if (lastIndexOf > 0 && lowerCase.charAt(lastIndexOf - 1) >= 'a' && lowerCase.charAt(lastIndexOf - 1) <= 'z') {
                        Log.v("MicroMsg.EggMgr", "letter in the prefix");
                        String substring = str.substring(0, lastIndexOf);
                        int lastIndexOf2 = substring.lastIndexOf(47);
                        if (lastIndexOf2 != -1) {
                            String sb = new StringBuilder().append((Object) substring.subSequence(lastIndexOf2, substring.length())).toString();
                            com.tencent.mm.ce.g.gxZ();
                            MMApplicationContext.getContext();
                            f.a big = f.gxT().big(sb);
                            if (big != null) {
                                str4 = big.text;
                            } else {
                                str4 = null;
                            }
                            if (!Util.isNullOrNil(str4) && str4.length() + lastIndexOf2 == lastIndexOf) {
                                Log.v("MicroMsg.EggMgr", "letter in the prefix is smiley");
                                lastIndexOf2 = -2;
                            }
                        }
                        if (lastIndexOf2 != -2) {
                            z = false;
                            if (z && str2.length() + lastIndexOf < lowerCase.length() && (charAt = lowerCase.charAt(str2.length() + lastIndexOf)) >= 'a' && charAt <= 'z') {
                                Log.v("MicroMsg.EggMgr", "letter in the suffix");
                                z = false;
                            }
                        }
                    }
                    z = true;
                    Log.v("MicroMsg.EggMgr", "letter in the suffix");
                    z = false;
                }
                if (z) {
                    Log.v("MicroMsg.EggMgr", "full match, matchPos = %s, TextLength = %s, keyLength = %s", Integer.valueOf(lastIndexOf), Integer.valueOf(lowerCase.length()), Integer.valueOf(str2.length()));
                    AppMethodBeat.o(34798);
                    return lastIndexOf;
                }
                lastIndexOf = lowerCase.lastIndexOf(str2.toLowerCase(), lastIndexOf - 1);
            } catch (Exception e2) {
                Log.v("MicroMsg.EggMgr", "Exception in isKeywordMatch, %s", e2.getMessage());
                Log.printErrStackTrace("MicroMsg.EggMgr", e2, "", new Object[0]);
            }
        } while (lastIndexOf != -1);
        AppMethodBeat.o(34798);
        return -1;
    }

    private static void bG(int i2, boolean z) {
        com.tencent.mm.bb.i iVar;
        boolean z2;
        AppMethodBeat.i(34800);
        try {
            StringBuilder sb = new StringBuilder();
            bg.aVF();
            byte[] aW = s.aW(sb.append(c.azM()).append("eggresult.rep").toString(), 0, -1);
            if (aW != null) {
                Log.d("MicroMsg.EggMgr", "data not null, parse it");
                iVar = (com.tencent.mm.bb.i) new com.tencent.mm.bb.i().parseFrom(aW);
            } else {
                Log.d("MicroMsg.EggMgr", "data is null, new one");
                iVar = new com.tencent.mm.bb.i();
            }
            Iterator<h> it = iVar.jgW.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                h next = it.next();
                if (next.dYn == i2) {
                    if (z) {
                        next.jgU++;
                    } else {
                        next.jgV++;
                    }
                    z2 = true;
                }
            }
            if (!z2) {
                h hVar = new h();
                hVar.dYn = i2;
                if (z) {
                    hVar.jgU = 1;
                } else {
                    hVar.jgV = 1;
                }
                iVar.jgW.add(hVar);
            }
            byte[] byteArray = iVar.toByteArray();
            Log.d("MicroMsg.EggMgr", "report list is %s, then save it", iVar.toString());
            StringBuilder sb2 = new StringBuilder();
            bg.aVF();
            s.f(sb2.append(c.azM()).append("eggresult.rep").toString(), byteArray, byteArray.length);
            AppMethodBeat.o(34800);
        } catch (Exception e2) {
            Log.w("MicroMsg.EggMgr", "statistics crash : %s", e2.getLocalizedMessage());
            Log.printErrStackTrace("MicroMsg.EggMgr", e2, "", new Object[0]);
            AppMethodBeat.o(34800);
        }
    }

    private void a(final com.tencent.mm.bb.e eVar, String str) {
        boolean z = true;
        AppMethodBeat.i(34801);
        if (eVar == null || Util.isNullOrNil(str)) {
            Object[] objArr = new Object[1];
            if (eVar == null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            Log.e("MicroMsg.EggMgr", "egg info or keyWord err!!! info != null:[%s].", objArr);
            AppMethodBeat.o(34801);
            return;
        }
        if (b(eVar)) {
            c.a aVar = com.tencent.mm.plugin.eggspring.c.qUO;
            com.tencent.mm.plugin.eggspring.c.qUN.FE(2);
            if (eVar.type == 3) {
                if (this.PjC == null) {
                    this.PjC = new d();
                }
                this.PjC.qUT = new b<com.tencent.mm.plugin.eggspring.c.c, x>() {
                    /* class com.tencent.mm.ui.chatting.aa.AnonymousClass3 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.g.a.b
                    public final /* synthetic */ x invoke(com.tencent.mm.plugin.eggspring.c.c cVar) {
                        AppMethodBeat.i(232904);
                        com.tencent.mm.plugin.eggspring.c.c cVar2 = cVar;
                        if (aa.this.PjB == null || aa.this.PjB.gNt()) {
                            Log.w("MicroMsg.EggMgr", "lucky anim is not playing, ignore");
                        } else if (aa.this.PjB != null) {
                            aa.this.PjB.gNr();
                            if (!(aa.this.PjB == null || eVar.gXT.jhm == null)) {
                                aa.this.PjB.a(cVar2);
                            }
                        }
                        AppMethodBeat.o(232904);
                        return null;
                    }
                };
                this.PjC.fM(eVar.gXT.appId, str);
                AppMethodBeat.o(34801);
                return;
            } else if (eVar.type == 2) {
                Log.i("MicroMsg.EggMgr", "initLuckyBagOrNot: game lucky egg %s", eVar.gWY.appId);
                if (this.PjB != null) {
                    this.PjB.post(new Runnable() {
                        /* class com.tencent.mm.ui.chatting.aa.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(232905);
                            aa.this.PjB.gNr();
                            aa aaVar = aa.this;
                            com.tencent.mm.bb.e eVar = eVar;
                            if (!(aaVar.PjB == null || eVar.gWY == null)) {
                                aaVar.PjB.a((com.tencent.mm.plugin.eggspring.c.c) null);
                            }
                            AppMethodBeat.o(232905);
                        }
                    });
                    com.tencent.mm.cr.d.bpI("com.tencent.mm.intent.ACTION_START_MPTOOLS_PROCESS");
                    AppMethodBeat.o(34801);
                    return;
                }
            } else if (eVar.type == 4) {
                if (this.VlA == null) {
                    this.VlA = new e();
                }
                this.VlA.gWp = new m<Boolean, String, x>() {
                    /* class com.tencent.mm.ui.chatting.aa.AnonymousClass5 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // kotlin.g.a.m
                    public final /* synthetic */ x invoke(Boolean bool, String str) {
                        AppMethodBeat.i(258933);
                        Boolean bool2 = bool;
                        String str2 = str;
                        Log.i("MicroMsg.EggMgr", "show %s, %s", bool2, str2);
                        if (!bool2.booleanValue() || Util.isNullOrNil(str2)) {
                            AppMethodBeat.o(258933);
                        } else {
                            com.tencent.mm.cr.d.bpI("com.tencent.mm.intent.ACTION_START_MPTOOLS_PROCESS");
                            if (aa.this.PjB == null || aa.this.PjB.gNt()) {
                                Log.w("MicroMsg.EggMgr", "lucky anim is not playing, ignore");
                            } else if (aa.this.PjB != null) {
                                aa.this.PjB.gNr();
                                if (!(aa.this.PjB == null || eVar.uBT.jgJ == null)) {
                                    com.tencent.mm.plugin.eggspring.c.c cVar = new com.tencent.mm.plugin.eggspring.c.c();
                                    cVar.url = str2;
                                    aa.this.PjB.a(cVar);
                                }
                            }
                            AppMethodBeat.o(258933);
                        }
                        return null;
                    }
                };
                this.VlA.dhS();
            }
        }
        AppMethodBeat.o(34801);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        com.tencent.mm.plugin.eggspring.c.c cVar;
        AppMethodBeat.i(34803);
        Log.i("MicroMsg.EggMgr", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s.", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            if (2757 == qVar.getType()) {
                com.tencent.mm.plugin.eggspring.d.b bVar = (com.tencent.mm.plugin.eggspring.d.b) qVar;
                if (bVar.qVk == this.qVk && (cVar = bVar.qVj) != null) {
                    Log.i("MicroMsg.EggMgr", "luckyBagInfo, %s.", cVar.toString());
                    this.PjE = (long) (cVar.gTn * 1000);
                }
            }
            AppMethodBeat.o(34803);
            return;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1263, 4);
        AppMethodBeat.o(34803);
    }

    public static boolean amp(int i2) {
        AppMethodBeat.i(232910);
        if (i2 == 3001) {
            c.a aVar = com.tencent.mm.plugin.eggspring.c.qUO;
            com.tencent.mm.plugin.eggspring.c.qUN.FF(16);
            AppMethodBeat.o(232910);
            return true;
        }
        AppMethodBeat.o(232910);
        return false;
    }

    static boolean b(com.tencent.mm.bb.e eVar) {
        if (eVar != null) {
            return eVar.type == 1 || eVar.type == 2 || eVar.type == 3 || eVar.type == 4;
        }
        return false;
    }
}

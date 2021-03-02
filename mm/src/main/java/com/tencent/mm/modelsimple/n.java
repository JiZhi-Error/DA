package com.tencent.mm.modelsimple;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.a;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.model.bg;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.account.ui.DisasterUI;
import com.tencent.mm.protocal.protobuf.bmj;
import com.tencent.mm.protocal.protobuf.bmk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class n extends q implements m {
    private static Map<String, Long> jjs = new HashMap();
    private static Map<String, String> jjt;
    private i callback;
    private boolean dOp = false;
    private final d iFd;
    private IListener<a> jju;

    static {
        AppMethodBeat.i(20632);
        AppMethodBeat.o(20632);
    }

    public n(int i2, boolean z) {
        AppMethodBeat.i(20626);
        d.a aVar = new d.a();
        aVar.iLN = new bmj();
        aVar.iLO = new bmk();
        aVar.uri = "/cgi-bin/micromsg-bin/getdisasterinfo";
        aVar.funcId = 775;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.iFd = aVar.aXF();
        this.iFd.option = 1;
        ((bmj) this.iFd.iLK.iLR).dOo = i2;
        this.dOp = z;
        bfb();
        Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo noticeid[%d], manualauthSucc[%b], stack[%s]", Integer.valueOf(i2), Boolean.valueOf(this.dOp), Util.getStack());
        AppMethodBeat.o(20626);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 775;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(20627);
        bmj bmj = (bmj) this.iFd.iLK.iLR;
        long nullAs = Util.nullAs(jjs.get(new StringBuilder().append(bmj.dOo).toString()), 0);
        Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene noticeid[%d], tick[%d], noticeidTickMap[%s]", Integer.valueOf(bmj.dOo), Long.valueOf(nullAs), jjs);
        if (nullAs == 0 || Util.ticksToNow(nullAs) >= 1800000) {
            String nullAs2 = Util.nullAs(jjt.get(new StringBuilder().append(bmj.dOo).toString()), "");
            if (!Util.isNullOrNil(nullAs2)) {
                Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene found cache[%d, %s]", Integer.valueOf(bmj.dOo), nullAs2);
                U(nullAs2, false);
                AppMethodBeat.o(20627);
                return -1;
            }
            this.callback = iVar;
            int dispatch = dispatch(gVar, this.iFd, this);
            AppMethodBeat.o(20627);
            return dispatch;
        }
        Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene disasterTick within half an hour, drop it [%s]", Integer.valueOf(bmj.dOo));
        AppMethodBeat.o(20627);
        return -1;
    }

    private void U(final String str, final boolean z) {
        AppMethodBeat.i(20628);
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.modelsimple.n.AnonymousClass1 */

            public final void run() {
                int length;
                AppMethodBeat.i(20625);
                Object[] objArr = new Object[2];
                if (str == null) {
                    length = -1;
                } else {
                    length = str.length();
                }
                objArr[0] = Integer.valueOf(length);
                objArr[1] = Boolean.valueOf(z);
                Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo broadcastEvent content len[%d], cache[%b]", objArr);
                ar arVar = new ar();
                arVar.dDD.type = 5;
                arVar.dDD.event = str;
                EventCenter.instance.publish(arVar);
                String str = arVar.dDE.dDJ;
                int i2 = arVar.dDE.position;
                int i3 = arVar.dDE.dDH;
                Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd event.result.Actionp[%d] noticeId[%s], position[%d], manualauthSucc[%b], noticeidTickMap[%s]", Integer.valueOf(i3), str, Integer.valueOf(i2), Boolean.valueOf(n.this.dOp), n.jjs);
                if (i2 == 1 && i3 == 6) {
                    if (z) {
                        n.by(str, str);
                    }
                    if (n.this.dOp) {
                        final String str2 = arVar.dDE.desc;
                        final String str3 = arVar.dDE.url;
                        Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony after init[%b]", Boolean.valueOf(MMApplicationContext.isAppHasInit()));
                        if (n.this.jju == null) {
                            n.this.jju = new IListener<a>() {
                                /* class com.tencent.mm.modelsimple.n.AnonymousClass1.AnonymousClass1 */

                                {
                                    AppMethodBeat.i(161280);
                                    this.__eventId = a.class.getName().hashCode();
                                    AppMethodBeat.o(161280);
                                }

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                                @Override // com.tencent.mm.sdk.event.IListener
                                public final /* synthetic */ boolean callback(a aVar) {
                                    AppMethodBeat.i(20624);
                                    EventCenter.instance.removeListener(n.this.jju);
                                    n.this.jju = null;
                                    Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony after 5s[%b]", Boolean.valueOf(MMApplicationContext.isAppHasInit()));
                                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                        /* class com.tencent.mm.modelsimple.n.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(20623);
                                            Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony[%b]", Boolean.valueOf(MMApplicationContext.isAppHasInit()));
                                            Intent intent = new Intent();
                                            intent.putExtra("key_disaster_content", str2);
                                            intent.putExtra("key_disaster_url", str3);
                                            intent.setClass(MMApplicationContext.getContext(), DisasterUI.class).addFlags(268435456);
                                            Context context = MMApplicationContext.getContext();
                                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/modelsimple/NetSceneGetDisasterInfo$1$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                            context.startActivity((Intent) bl.pG(0));
                                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/modelsimple/NetSceneGetDisasterInfo$1$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                            AppMethodBeat.o(20623);
                                        }
                                    }, 5000);
                                    AppMethodBeat.o(20624);
                                    return true;
                                }
                            };
                        }
                        EventCenter.instance.addListener(n.this.jju);
                    } else {
                        lz lzVar = new lz();
                        lzVar.dRz.content = arVar.dDE.desc;
                        lzVar.dRz.url = arVar.dDE.url;
                        EventCenter.instance.publish(lzVar);
                    }
                    n.jjs.put(str, Long.valueOf(Util.currentTicks()));
                    AppMethodBeat.o(20625);
                    return;
                }
                if (i3 == 2) {
                    if (z) {
                        n.by(str, str);
                    }
                    n.jjs.put(str, Long.valueOf(Util.currentTicks()));
                }
                AppMethodBeat.o(20625);
            }
        });
        AppMethodBeat.o(20628);
    }

    private synchronized void bfb() {
        String[] split;
        AppMethodBeat.i(20629);
        if (jjt == null) {
            Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap");
            jjt = new HashMap();
            SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("disaster_pref", com.tencent.mm.compatible.util.g.aps());
            String string = sharedPreferences.getString("disaster_new_noticeid_list_key", "");
            if (!Util.isNullOrNil(string) && (split = string.split(";")) != null && split.length > 0) {
                String str = "";
                SharedPreferences.Editor edit = sharedPreferences.edit();
                for (String str2 : split) {
                    String[] split2 = str2.split(",");
                    try {
                        if (Util.getLong(split2[0], 0) > 0) {
                            if (Util.secondsToNow(Util.getLong(split2[1], 0)) < 86400) {
                                String string2 = sharedPreferences.getString(split2[0], "");
                                if (!Util.isNullOrNil(string2)) {
                                    str = str + split2[0] + "," + split2[1] + ";";
                                    jjt.put(split2[0], string2);
                                }
                            } else {
                                edit.remove(split2[0]).commit();
                            }
                        }
                    } catch (Exception e2) {
                        Log.e("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap error:%s", e2.getMessage());
                    }
                }
                edit.putString("disaster_new_noticeid_list_key", str).commit();
                Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap newNoticeIdList[%s], noticeidTickMap[%s]", str, jjs);
            }
            Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap done noticeContentMap[%s]", jjt);
        }
        AppMethodBeat.o(20629);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(20630);
        Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            U(((bmk) this.iFd.iLL.iLR).content, true);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(20630);
    }

    static /* synthetic */ void by(String str, String str2) {
        AppMethodBeat.i(20631);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("disaster_pref", com.tencent.mm.compatible.util.g.aps());
        String string = sharedPreferences.getString("disaster_new_noticeid_list_key", "");
        if (!Util.isNullOrNil(string)) {
            string = string + ";";
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(str, str2);
        edit.putString("disaster_new_noticeid_list_key", string + str + "," + Util.nowSecond());
        edit.commit();
        jjt.put(str, str2);
        Log.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz saveDisasterNotice newNoticeIdList[%s], noticeId[%s], content[%s]", sharedPreferences.getString("disaster_new_noticeid_list_key", ""), str, sharedPreferences.getString(str, ""));
        AppMethodBeat.o(20631);
    }
}

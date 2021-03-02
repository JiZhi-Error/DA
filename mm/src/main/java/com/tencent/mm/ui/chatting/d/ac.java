package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.e;
import com.tencent.mm.chatroom.ui.GroupToolsManagereUI;
import com.tencent.mm.g.a.nu;
import com.tencent.mm.g.b.a.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.chatting.d.b.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(gRF = z.class)
public class ac extends a implements z {
    public static final Long PqN = 604800000L;
    private View GEr;
    private View PqO;
    private LinearLayout PqP;
    private NestedScrollView PqQ;
    private LinearLayout PqR;
    private LinearLayout PqS;
    private RelativeLayout PqT;
    private com.tencent.mm.ui.chatting.view.b PqU;
    private GridLayoutManager PqV;
    private d PqW;
    private GridLayoutManager PqX;
    private d PqY;
    protected Thread PqZ;
    private ArrayList<GroupToolItem> Pra = new ArrayList<>();
    private boolean Prb = false;
    private a Prc = new a() {
        /* class com.tencent.mm.ui.chatting.d.ac.AnonymousClass1 */

        @Override // com.tencent.mm.ui.chatting.d.ac.a
        public final void onClick(View view) {
            AppMethodBeat.i(179854);
            Log.i("MicroMsg.roomtools.GroupToolsComponet", "iStickToolsCallback click");
            Object tag = view.getTag();
            if (tag instanceof GroupToolItem) {
                GroupToolItem groupToolItem = (GroupToolItem) tag;
                if (groupToolItem.amm()) {
                    ac.a(ac.this);
                } else if (groupToolItem.amn()) {
                    ac.b(ac.this);
                } else {
                    ac.a(ac.this, groupToolItem, "1", true);
                }
                ac.a(ac.this, groupToolItem, true);
            }
            if (ac.this.PqU != null) {
                ac.this.PqU.bMo();
            }
            AppMethodBeat.o(179854);
        }
    };
    private a Prd = new a() {
        /* class com.tencent.mm.ui.chatting.d.ac.AnonymousClass9 */

        @Override // com.tencent.mm.ui.chatting.d.ac.a
        public final void onClick(View view) {
            AppMethodBeat.i(179864);
            Log.i("MicroMsg.roomtools.GroupToolsComponet", "iRecentUseToolsCallback click");
            Object tag = view.getTag();
            if (tag instanceof GroupToolItem) {
                GroupToolItem groupToolItem = (GroupToolItem) tag;
                if (groupToolItem.amm()) {
                    ac.a(ac.this);
                } else if (groupToolItem.amn()) {
                    ac.b(ac.this);
                } else {
                    ac.a(ac.this, groupToolItem, "2", false);
                }
                ac.a(ac.this, groupToolItem, false);
            }
            if (ac.this.PqU != null) {
                ac.this.PqU.bMo();
            }
            AppMethodBeat.o(179864);
        }
    };
    private IListener<nu> Pre = new IListener<nu>() {
        /* class com.tencent.mm.ui.chatting.d.ac.AnonymousClass10 */

        {
            AppMethodBeat.i(179865);
            this.__eventId = nu.class.getName().hashCode();
            AppMethodBeat.o(179865);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(nu nuVar) {
            AppMethodBeat.i(179866);
            nu nuVar2 = nuVar;
            if (nuVar2 != null) {
                Log.i("MicroMsg.roomtools.GroupToolsComponet", "NotifyGroupToolsEvent %s", Util.nullAs(nuVar2.dTV.dOe, ""));
                if (Util.isEqual(ac.this.dom.getTalkerUserName(), nuVar2.dTV.dOe)) {
                    if (ac.this.PqU != null) {
                        ac.this.PqU.bMo();
                    }
                    ac.d(ac.this);
                }
            }
            AppMethodBeat.o(179866);
            return true;
        }
    };
    private View.OnClickListener Prf = new View.OnClickListener() {
        /* class com.tencent.mm.ui.chatting.d.ac.AnonymousClass11 */

        public final void onClick(View view) {
            AppMethodBeat.i(179867);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupToolsComponet$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.roomtools.GroupToolsComponet", "stickManagerLl click");
            Intent intent = new Intent(ac.this.dom.Pwc.getContext(), GroupToolsManagereUI.class);
            intent.putExtra("key_chatroomname", ac.this.dom.getTalkerUserName());
            intent.putParcelableArrayListExtra("key_recent_use_tools", ac.this.Pra);
            Activity context = ac.this.dom.Pwc.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/component/GroupToolsComponet$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/component/GroupToolsComponet$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ac.this.Pre.alive();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupToolsComponet$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(179867);
        }
    };
    private Runnable Prg = new Runnable() {
        /* class com.tencent.mm.ui.chatting.d.ac.AnonymousClass5 */
        private ArrayList<GroupToolItem> Pri = new ArrayList<>();

        {
            AppMethodBeat.i(185883);
            AppMethodBeat.o(185883);
        }

        public final void run() {
            long j2;
            e eVar;
            Exception e2;
            boolean z;
            e eVar2;
            boolean a2;
            boolean z2;
            GroupToolItem g2;
            AppMethodBeat.i(185884);
            long aWz = cl.aWz();
            if (System.currentTimeMillis() > aWz) {
                j2 = System.currentTimeMillis();
            } else {
                j2 = aWz;
            }
            long aWz2 = cl.aWz();
            e DE = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().DE(ac.this.dom.getTalkerUserName());
            try {
                this.Pri.clear();
                boolean z3 = false;
                int i2 = 0;
                while (!Thread.interrupted() && !gQj() && !z3 && i2 < 26) {
                    List<ca> J = ((l) g.af(l.class)).eiy().J(ac.this.dom.getTalkerUserName(), j2 - (((long) (i2 + 1)) * ac.PqN.longValue()), j2 - (((long) i2) * ac.PqN.longValue()));
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(i2);
                    objArr[1] = Integer.valueOf(J != null ? J.size() : 0);
                    Log.i("MicroMsg.roomtools.GroupToolsComponet", "getRecentUseToolTask i:%s size:%s", objArr);
                    if (J == null || J.size() == 0) {
                        z2 = true;
                    } else {
                        Iterator<ca> it = J.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z2 = z3;
                                break;
                            }
                            ca next = it.next();
                            if (!((next.fqJ & 4) == 4 || next.getType() == 10000)) {
                                k.b HD = k.b.HD(next.field_content);
                                if (HD == null) {
                                    Log.d("MicroMsg.roomtools.GroupToolsComponet", "content is null");
                                } else {
                                    if ((com.tencent.mm.modelappbrand.a.b(HD) || com.tencent.mm.modelappbrand.a.c(HD)) && (g2 = aa.g(next)) != null) {
                                        Log.d("MicroMsg.roomtools.GroupToolsComponet", "getRecentUseToolTask add:%s", g2.toString());
                                        if (b(g2) && gQj()) {
                                            z2 = true;
                                            break;
                                        }
                                    }
                                    if (aa.h(next)) {
                                        Log.d("MicroMsg.roomtools.GroupToolsComponet", "getRecentUseToolTask add:AAPay");
                                        if (b(new GroupToolItem("roomaa@app.origin", "", next.field_createTime)) && gQj()) {
                                            z2 = true;
                                            break;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                        }
                        if (gQj()) {
                            z2 = true;
                        }
                    }
                    i2++;
                    z3 = z2;
                }
                Log.d("MicroMsg.roomtools.GroupToolsComponet", "getRecentUseToolTask recentItemList:%s %s", Integer.valueOf(this.Pri.size()), ac.jr(this.Pri));
                if (DE == null) {
                    z = false;
                    eVar = new e();
                    try {
                        eVar.field_chatroomname = ac.this.dom.getTalkerUserName();
                        eVar2 = eVar;
                    } catch (Exception e3) {
                        e2 = e3;
                        Log.e("MicroMsg.roomtools.GroupToolsComponet", "getRecentUseToolTask Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
                        Log.i("MicroMsg.roomtools.GroupToolsComponet", "getRecentUseToolTask roomname:%s interTime:%s", ac.this.dom.getTalkerUserName(), Long.valueOf(cl.aWz() - aWz2));
                        ac.this.Pra.clear();
                        ac.this.Pra.addAll(eVar.gtx);
                        Collections.sort(ac.this.Pra, new Comparator<GroupToolItem>() {
                            /* class com.tencent.mm.ui.chatting.d.ac.AnonymousClass5.AnonymousClass1 */

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                            @Override // java.util.Comparator
                            public final /* bridge */ /* synthetic */ int compare(GroupToolItem groupToolItem, GroupToolItem groupToolItem2) {
                                AppMethodBeat.i(185881);
                                int compare = Long.compare(groupToolItem2.crj, groupToolItem.crj);
                                AppMethodBeat.o(185881);
                                return compare;
                            }
                        });
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.ui.chatting.d.ac.AnonymousClass5.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(185882);
                                if (ac.this.tipDialog != null) {
                                    ac.this.tipDialog.dismiss();
                                }
                                ac.k(ac.this);
                                AppMethodBeat.o(185882);
                            }
                        });
                        AppMethodBeat.o(185884);
                    }
                } else {
                    z = true;
                    eVar2 = DE;
                }
                try {
                    eVar2.field_queryState = 1;
                    int size = eVar2.gtx.size();
                    eVar2.gtx.clear();
                    eVar2.gtx.addAll(this.Pri);
                    eVar2.field_recentUseToolList = e.W(this.Pri);
                    if (z) {
                        a2 = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().a(eVar2, new String[0]);
                    } else {
                        a2 = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().a(eVar2);
                    }
                    Log.i("MicroMsg.roomtools.GroupToolsComponet", "getRecentUseToolTask oldRecent:%s newRecent:%s exist:%s queryEnd:%s result:%s", Integer.valueOf(size), Integer.valueOf(this.Pri.size()), Boolean.valueOf(z), Boolean.valueOf(z3), Boolean.valueOf(a2));
                    eVar = eVar2;
                } catch (Exception e4) {
                    e2 = e4;
                    eVar = eVar2;
                    Log.e("MicroMsg.roomtools.GroupToolsComponet", "getRecentUseToolTask Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
                    Log.i("MicroMsg.roomtools.GroupToolsComponet", "getRecentUseToolTask roomname:%s interTime:%s", ac.this.dom.getTalkerUserName(), Long.valueOf(cl.aWz() - aWz2));
                    ac.this.Pra.clear();
                    ac.this.Pra.addAll(eVar.gtx);
                    Collections.sort(ac.this.Pra, new Comparator<GroupToolItem>() {
                        /* class com.tencent.mm.ui.chatting.d.ac.AnonymousClass5.AnonymousClass1 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                        @Override // java.util.Comparator
                        public final /* bridge */ /* synthetic */ int compare(GroupToolItem groupToolItem, GroupToolItem groupToolItem2) {
                            AppMethodBeat.i(185881);
                            int compare = Long.compare(groupToolItem2.crj, groupToolItem.crj);
                            AppMethodBeat.o(185881);
                            return compare;
                        }
                    });
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.ui.chatting.d.ac.AnonymousClass5.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(185882);
                            if (ac.this.tipDialog != null) {
                                ac.this.tipDialog.dismiss();
                            }
                            ac.k(ac.this);
                            AppMethodBeat.o(185882);
                        }
                    });
                    AppMethodBeat.o(185884);
                }
            } catch (Exception e5) {
                e2 = e5;
                eVar = DE;
                Log.e("MicroMsg.roomtools.GroupToolsComponet", "getRecentUseToolTask Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
                Log.i("MicroMsg.roomtools.GroupToolsComponet", "getRecentUseToolTask roomname:%s interTime:%s", ac.this.dom.getTalkerUserName(), Long.valueOf(cl.aWz() - aWz2));
                ac.this.Pra.clear();
                ac.this.Pra.addAll(eVar.gtx);
                Collections.sort(ac.this.Pra, new Comparator<GroupToolItem>() {
                    /* class com.tencent.mm.ui.chatting.d.ac.AnonymousClass5.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // java.util.Comparator
                    public final /* bridge */ /* synthetic */ int compare(GroupToolItem groupToolItem, GroupToolItem groupToolItem2) {
                        AppMethodBeat.i(185881);
                        int compare = Long.compare(groupToolItem2.crj, groupToolItem.crj);
                        AppMethodBeat.o(185881);
                        return compare;
                    }
                });
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.d.ac.AnonymousClass5.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(185882);
                        if (ac.this.tipDialog != null) {
                            ac.this.tipDialog.dismiss();
                        }
                        ac.k(ac.this);
                        AppMethodBeat.o(185882);
                    }
                });
                AppMethodBeat.o(185884);
            }
            Log.i("MicroMsg.roomtools.GroupToolsComponet", "getRecentUseToolTask roomname:%s interTime:%s", ac.this.dom.getTalkerUserName(), Long.valueOf(cl.aWz() - aWz2));
            ac.this.Pra.clear();
            ac.this.Pra.addAll(eVar.gtx);
            Collections.sort(ac.this.Pra, new Comparator<GroupToolItem>() {
                /* class com.tencent.mm.ui.chatting.d.ac.AnonymousClass5.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* bridge */ /* synthetic */ int compare(GroupToolItem groupToolItem, GroupToolItem groupToolItem2) {
                    AppMethodBeat.i(185881);
                    int compare = Long.compare(groupToolItem2.crj, groupToolItem.crj);
                    AppMethodBeat.o(185881);
                    return compare;
                }
            });
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.ui.chatting.d.ac.AnonymousClass5.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(185882);
                    if (ac.this.tipDialog != null) {
                        ac.this.tipDialog.dismiss();
                    }
                    ac.k(ac.this);
                    AppMethodBeat.o(185882);
                }
            });
            AppMethodBeat.o(185884);
        }

        private boolean b(GroupToolItem groupToolItem) {
            AppMethodBeat.i(185885);
            if (groupToolItem == null) {
                AppMethodBeat.o(185885);
                return false;
            } else if (this.Pri.contains(groupToolItem)) {
                AppMethodBeat.o(185885);
                return false;
            } else {
                this.Pri.add(groupToolItem);
                AppMethodBeat.o(185885);
                return true;
            }
        }

        private boolean gQj() {
            AppMethodBeat.i(185886);
            if (this.Pri.size() >= 20) {
                AppMethodBeat.o(185886);
                return true;
            }
            AppMethodBeat.o(185886);
            return false;
        }
    };
    private boolean dEF = false;
    private LinearLayout gvA;
    private RecyclerView gvB;
    private e gvI = null;
    private LinearLayout gvy;
    private RecyclerView gvz;
    private long nJh = 0;
    private ImageView qoh;
    private q tipDialog = null;

    public interface a {
        void onClick(View view);
    }

    public ac() {
        AppMethodBeat.i(179883);
        AppMethodBeat.o(179883);
    }

    static /* synthetic */ void d(ac acVar) {
        AppMethodBeat.i(233123);
        acVar.gQi();
        AppMethodBeat.o(233123);
    }

    static /* synthetic */ void k(ac acVar) {
        AppMethodBeat.i(233126);
        acVar.gQh();
        AppMethodBeat.o(233126);
    }

    static {
        AppMethodBeat.i(179908);
        AppMethodBeat.o(179908);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIl() {
        AppMethodBeat.i(179884);
        super.gIl();
        Log.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingEnterAnimStart: user %s hashCode:%s", this.dom.getTalkerUserName(), Integer.valueOf(hashCode()));
        AppMethodBeat.o(179884);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(179885);
        super.gIm();
        String talkerUserName = this.dom.getTalkerUserName();
        if (Util.isNullOrNil(talkerUserName) || !ab.Ix(talkerUserName) || !ab.JN(talkerUserName)) {
            this.Prb = false;
            AppMethodBeat.o(179885);
            return;
        }
        this.Prb = true;
        AppMethodBeat.o(179885);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(179886);
        super.gIn();
        Log.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingExitAnimStart");
        this.Pre.dead();
        AppMethodBeat.o(179886);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(179887);
        super.gOK();
        this.dEF = false;
        if (this.PqO != null) {
            this.PqO.setVisibility(8);
        }
        AppMethodBeat.o(179887);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.z
    public final void gQg() {
        AppMethodBeat.i(179888);
        if (!aa.ame()) {
            AppMethodBeat.o(179888);
            return;
        }
        gQi();
        AppMethodBeat.o(179888);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFx() {
        AppMethodBeat.i(179889);
        super.cFx();
        Log.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingResume");
        this.Pre.dead();
        AppMethodBeat.o(179889);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
        AppMethodBeat.i(179890);
        super.cFy();
        Log.i("MicroMsg.roomtools.GroupToolsComponet", "onChattingPause");
        AppMethodBeat.o(179890);
    }

    private void gQi() {
        AppMethodBeat.i(233119);
        this.gvI = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().DE(this.dom.getTalkerUserName());
        if (this.gvI == null) {
            e eVar = new e();
            eVar.field_chatroomname = this.dom.getTalkerUserName();
            boolean a2 = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().a(eVar);
            if (a2) {
                this.gvI = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupToolsStorage().DE(this.dom.getTalkerUserName());
            }
            Log.i("MicroMsg.roomtools.GroupToolsComponet", "getGroupTools insert GroupTools: result(%s)", Boolean.valueOf(a2));
        }
        Log.i("MicroMsg.roomtools.GroupToolsComponet", "getGroupTools start:%s queryRecentUse:%s state:%s", this.dom.getTalkerUserName(), Boolean.TRUE, Integer.valueOf(this.gvI.field_queryState));
        if (this.gvI.field_queryState == 1) {
            this.Pra.clear();
            this.Pra.addAll(this.gvI.gtx);
            Collections.sort(this.Pra, new Comparator<GroupToolItem>() {
                /* class com.tencent.mm.ui.chatting.d.ac.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* bridge */ /* synthetic */ int compare(GroupToolItem groupToolItem, GroupToolItem groupToolItem2) {
                    AppMethodBeat.i(185880);
                    int compare = Long.compare(groupToolItem2.crj, groupToolItem.crj);
                    AppMethodBeat.o(185880);
                    return compare;
                }
            });
            gQh();
            AppMethodBeat.o(233119);
            return;
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.ui.chatting.d.ac.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(179856);
                Object[] objArr = new Object[1];
                objArr[0] = ac.this.PqZ != null ? Boolean.valueOf(ac.this.PqZ.isAlive()) : BuildConfig.COMMAND;
                Log.i("MicroMsg.roomtools.GroupToolsComponet", "getRecentToolsThread interrupt() %s", objArr);
                if (ac.this.PqZ != null && ac.this.PqZ.isAlive()) {
                    ac.this.PqZ.interrupt();
                }
                AppMethodBeat.o(179856);
            }
        }, 5000);
        this.PqZ = new Thread(this.Prg);
        this.PqZ.start();
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.ui.chatting.d.ac.AnonymousClass4 */

            {
                AppMethodBeat.i(179859);
                AppMethodBeat.o(179859);
            }

            public final void run() {
                AppMethodBeat.i(179860);
                if (ac.this.PqZ != null && ac.this.PqZ.isAlive()) {
                    ac.i(ac.this);
                }
                AppMethodBeat.o(179860);
            }
        }, 200);
        AppMethodBeat.o(233119);
    }

    public static class d extends RecyclerView.a {
        private a Prl;
        private Context context;
        private List<GroupToolItem> gwb;

        static /* synthetic */ void b(b bVar, WxaAttributes wxaAttributes) {
            AppMethodBeat.i(233118);
            a(bVar, wxaAttributes);
            AppMethodBeat.o(233118);
        }

        public d(Context context2, List<GroupToolItem> list, a aVar) {
            this.context = context2;
            this.gwb = list;
            this.Prl = aVar;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(179878);
            b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.qg, viewGroup, false));
            AppMethodBeat.o(179878);
            return bVar;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2) {
            AppMethodBeat.i(179879);
            if (this.gwb != null && i2 >= 0 && i2 < this.gwb.size()) {
                final b bVar = (b) vVar;
                GroupToolItem groupToolItem = this.gwb.get(i2);
                bVar.gvQ.setVisibility(0);
                if (groupToolItem.amm()) {
                    bVar.gBZ.setImageResource(R.drawable.bg2);
                    bVar.PqE.setText(R.string.dwp);
                } else if (groupToolItem.amn()) {
                    bVar.gBZ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, R.drawable.bg3));
                    bVar.PqE.setText(R.string.uj);
                } else {
                    WxaAttributes Xk = ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(groupToolItem.username);
                    if (Xk == null) {
                        ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).a(groupToolItem.username, new q.a() {
                            /* class com.tencent.mm.ui.chatting.d.ac.d.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.appbrand.service.q.a
                            public final void b(final WxaAttributes wxaAttributes) {
                                AppMethodBeat.i(179876);
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.ui.chatting.d.ac.d.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(179875);
                                        d.b(bVar, wxaAttributes);
                                        AppMethodBeat.o(179875);
                                    }
                                });
                                AppMethodBeat.o(179876);
                            }
                        });
                    } else {
                        a(bVar, Xk);
                    }
                }
                bVar.gvQ.setTag(groupToolItem);
                bVar.gvQ.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.d.ac.d.AnonymousClass2 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(179877);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/component/GroupToolsComponet$ToolAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (d.this.Prl != null) {
                            d.this.Prl.onClick(view);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/component/GroupToolsComponet$ToolAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(179877);
                    }
                });
            }
            AppMethodBeat.o(179879);
        }

        private static void a(b bVar, WxaAttributes wxaAttributes) {
            AppMethodBeat.i(179880);
            com.tencent.mm.av.q.bcV().a(wxaAttributes != null ? wxaAttributes.field_smallHeadURL : "", bVar.gBZ, b.gvY);
            bVar.PqE.setText(wxaAttributes != null ? wxaAttributes.field_nickname : "");
            AppMethodBeat.o(179880);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            return 0;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(179881);
            int size = this.gwb.size();
            AppMethodBeat.o(179881);
            return size;
        }
    }

    public static class b extends RecyclerView.v {
        static final com.tencent.mm.av.a.a.c gvY;
        TextView PqE;
        LinearLayout Prk;
        ImageView gBZ;
        View gvQ;

        static {
            AppMethodBeat.i(179874);
            c.a aVar = new c.a();
            aVar.jbq = R.raw.app_brand_app_default_icon_for_tail;
            c.a dr = aVar.dr(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20));
            dr.iaT = true;
            dr.jbf = true;
            dr.jbd = true;
            gvY = aVar.bdv();
            AppMethodBeat.o(179874);
        }

        public b(View view) {
            super(view);
            AppMethodBeat.i(179873);
            this.gvQ = view;
            this.Prk = (LinearLayout) view.findViewById(R.id.is0);
            this.gBZ = (ImageView) view.findViewById(R.id.is4);
            this.PqE = (TextView) view.findViewById(R.id.is6);
            AppMethodBeat.o(179873);
        }
    }

    /* access modifiers changed from: package-private */
    public static class c extends RecyclerView.h {
        private final int column = 4;
        private final int tCv;

        public c(int i2) {
            this.tCv = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(233117);
            rect.left = (RecyclerView.bw(view) % this.column) * this.tCv;
            AppMethodBeat.o(233117);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x02e4  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0301 A[LOOP:0: B:55:0x02fb->B:57:0x0301, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0334  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x033c  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0350  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x03a2 A[LOOP:1: B:69:0x039c->B:71:0x03a2, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x03bf  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x03d4  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0403  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x040c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void gQh() {
        /*
        // Method dump skipped, instructions count: 1044
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.d.ac.gQh():void");
    }

    static /* synthetic */ void a(ac acVar) {
        AppMethodBeat.i(179897);
        if (as.bjq(acVar.dom.getTalkerUserName())) {
            h.a((Context) acVar.dom.Pwc.getContext(), acVar.dom.Pwc.getContext().getString(R.string.dwo), "", acVar.dom.Pwc.getContext().getString(R.string.j34), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.d.ac.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(185887);
                    Log.i("MicroMsg.roomtools.GroupToolsComponet", "gotoAAPay onDialogClick() ");
                    AppMethodBeat.o(185887);
                }
            });
            AppMethodBeat.o(179897);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(acVar.dom.Pwc.getContext(), "com.tencent.mm.plugin.aa.ui.LaunchAAUI");
        intent.putExtra("enter_scene", 7);
        intent.putExtra("chatroom_name", acVar.dom.getTalkerUserName());
        Activity context = acVar.dom.Pwc.getContext();
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/component/GroupToolsComponet", "gotoAAPay", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/component/GroupToolsComponet", "gotoAAPay", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(179897);
    }

    static /* synthetic */ void b(ac acVar) {
        AppMethodBeat.i(233120);
        if (((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt()) {
            Log.i("MicroMsg.roomtools.GroupToolsComponet", "exit in teen mode");
            ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(acVar.dom.Pwc.getContext());
            AppMethodBeat.o(233120);
            return;
        }
        Log.i("MicroMsg.roomtools.GroupToolsComponet", "gotoRoomLiveEntrance");
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(acVar.dom.Pwc.getContext(), "android.permission.CAMERA", 25, "", "");
        Log.i("MicroMsg.roomtools.GroupToolsComponet", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), acVar.dom.Pwc.getContext());
        if (a2) {
            boolean a3 = com.tencent.mm.pluginsdk.permission.b.a(acVar.dom.Pwc.getContext(), "android.permission.RECORD_AUDIO", 25, "", "");
            Log.i("MicroMsg.roomtools.GroupToolsComponet", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(a3), Util.getStack(), acVar.dom.Pwc.getContext());
            if (a3 && !com.tencent.mm.q.a.o(acVar.dom.Pwc.getContext(), true) && !com.tencent.mm.q.a.cC(acVar.dom.Pwc.getContext()) && !com.tencent.mm.q.a.cA(acVar.dom.Pwc.getContext()) && !com.tencent.mm.q.a.cE(acVar.dom.Pwc.getContext())) {
                if (g.aAh().azQ().getInt(ar.a.USERINFO_LIVE_MODE_INT_SYNC, 0) == 1) {
                    final Activity context = acVar.dom.Pwc.getContext();
                    com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(context);
                    lVar.HLX = new o.f() {
                        /* class com.tencent.mm.ui.chatting.d.ac.AnonymousClass7 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(m mVar) {
                            AppMethodBeat.i(233115);
                            mVar.d(0, context.getString(R.string.efr));
                            mVar.d(1, context.getString(R.string.efq));
                            AppMethodBeat.o(233115);
                        }
                    };
                    lVar.HLY = new o.g() {
                        /* class com.tencent.mm.ui.chatting.d.ac.AnonymousClass8 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(233116);
                            if (i2 == 0) {
                                ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).liveEntranceJumper().a(ac.this.dom.Pwc.getContext(), LiveConfig.V(ac.this.dom.getTalkerUserName(), LiveConfig.hvS));
                                AppMethodBeat.o(233116);
                                return;
                            }
                            ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).liveEntranceJumper().c(ac.this.dom.Pwc.getContext(), LiveConfig.V(ac.this.dom.getTalkerUserName(), LiveConfig.hvS));
                            AppMethodBeat.o(233116);
                        }
                    };
                    lVar.gXI();
                    AppMethodBeat.o(233120);
                    return;
                }
                ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).liveEntranceJumper().c(acVar.dom.Pwc.getContext(), LiveConfig.V(acVar.dom.getTalkerUserName(), LiveConfig.hvS));
            }
        }
        AppMethodBeat.o(233120);
    }

    static /* synthetic */ void a(ac acVar, GroupToolItem groupToolItem, String str, boolean z) {
        AppMethodBeat.i(233121);
        com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
        gVar.username = groupToolItem.username;
        if (z) {
            gVar.kHw = groupToolItem.path;
        } else {
            gVar.kHw = "";
        }
        gVar.scene = 1158;
        gVar.kHG = acVar.dom.getTalkerUserName();
        gVar.dCw = str;
        ((r) g.af(r.class)).a(acVar.dom.Pwc.getContext(), gVar);
        AppMethodBeat.o(233121);
    }

    static /* synthetic */ void a(ac acVar, GroupToolItem groupToolItem, boolean z) {
        String str;
        int i2;
        int i3 = 0;
        AppMethodBeat.i(233122);
        if (groupToolItem.amm()) {
            str = MMApplicationContext.getContext().getString(R.string.dwp);
        } else if (groupToolItem.amn()) {
            str = MMApplicationContext.getContext().getString(R.string.uj);
        } else {
            WxaAttributes Xk = ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(groupToolItem.username);
            str = Xk == null ? "" : Xk.field_nickname;
        }
        String talkerUserName = acVar.dom.getTalkerUserName();
        String str2 = groupToolItem.username;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (ab.JO(talkerUserName)) {
            i3 = 2;
        } else if (ab.JN(talkerUserName)) {
            i3 = 1;
        }
        af afVar = new af();
        afVar.ik(talkerUserName);
        afVar.ejW = 2;
        afVar.enM = (long) i3;
        afVar.enR = afVar.x("appid", str2, true);
        afVar.enS = afVar.x("appname", str, true);
        afVar.enT = (long) i2;
        afVar.bfK();
        AppMethodBeat.o(233122);
    }

    static /* synthetic */ void i(ac acVar) {
        AppMethodBeat.i(233124);
        if (acVar.tipDialog == null) {
            Activity context = acVar.dom.Pwc.getContext();
            acVar.dom.Pwc.getContext().getString(R.string.zb);
            acVar.tipDialog = h.a((Context) context, acVar.dom.Pwc.getContext().getString(R.string.wc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.ui.chatting.d.ac.AnonymousClass16 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(179872);
                    Log.i("MicroMsg.roomtools.GroupToolsComponet", "dialog onCancel");
                    if (ac.this.PqZ != null && ac.this.PqZ.isAlive()) {
                        ac.this.PqZ.interrupt();
                    }
                    AppMethodBeat.o(179872);
                }
            });
            AppMethodBeat.o(233124);
            return;
        }
        if (!acVar.tipDialog.isShowing()) {
            acVar.tipDialog.show();
        }
        AppMethodBeat.o(233124);
    }

    static /* synthetic */ String jr(List list) {
        AppMethodBeat.i(233125);
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            sb.append((GroupToolItem) it.next()).append(",");
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(233125);
        return sb2;
    }
}

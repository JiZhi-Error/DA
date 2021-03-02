package com.tencent.mm.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.c.c;
import com.tencent.mm.live.d.f;
import com.tencent.mm.model.aa;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class q {
    private static HashSet<a> OFt = new HashSet<>();
    private LiveTalkRoomTipsBar OFq;
    private LinkedList<com.tencent.mm.live.b.c.b> OFr;
    public b OFs = new b();
    c.a hLf = new c.a() {
        /* class com.tencent.mm.ui.q.AnonymousClass1 */

        @Override // com.tencent.mm.live.b.c.c.a
        public final void Ha(String str) {
            AppMethodBeat.i(232617);
            if (q.this.hwa != null && q.this.hwa.equals(str)) {
                Log.i("MicroMsg.LiveTalkRoomTipsBarController", "liveTipsBarStorage notify, hostRoomId:%s", q.this.hwa);
                q.this.gIH();
                q.Pn(str);
            }
            AppMethodBeat.o(232617);
        }
    };
    String hwa;

    public interface a {
        void blQ(String str);
    }

    public final boolean blN(String str) {
        AppMethodBeat.i(232627);
        if (this.hwa == null || !this.hwa.equals(str)) {
            AppMethodBeat.o(232627);
            return false;
        }
        AppMethodBeat.o(232627);
        return true;
    }

    public q(LiveTalkRoomTipsBar liveTalkRoomTipsBar) {
        AppMethodBeat.i(232628);
        this.OFq = liveTalkRoomTipsBar;
        gIH();
        AppMethodBeat.o(232628);
    }

    public static void gIG() {
        AppMethodBeat.i(232629);
        ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().hLf = null;
        AppMethodBeat.o(232629);
    }

    public final LinkedList<com.tencent.mm.live.b.c.b> gIH() {
        AppMethodBeat.i(232630);
        this.OFr = ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().GX(this.hwa);
        LinkedList<com.tencent.mm.live.b.c.b> linkedList = this.OFr;
        AppMethodBeat.o(232630);
        return linkedList;
    }

    public static void blO(String str) {
        AppMethodBeat.i(232631);
        com.tencent.mm.live.b.c.c liveTipsBarStorage = ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).getLiveTipsBarStorage();
        if (com.tencent.mm.live.b.c.c.hLd == null || !((String) com.tencent.mm.live.b.c.c.hLd.first).equals(str)) {
            int delete = liveTipsBarStorage.db.delete("LiveTipsBar", "hostRoomId= ? ", new String[]{str});
            if (delete < 0) {
                Log.e("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId failed, hostRoomId:%s, result%d", str, Integer.valueOf(delete));
            } else {
                Log.i("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId, hostRoomId:%s, result%d", str, Integer.valueOf(delete));
            }
        } else {
            long longValue = ((Long) com.tencent.mm.live.b.c.c.hLd.second).longValue();
            boolean execSQL = liveTipsBarStorage.db.execSQL("LiveTipsBar", String.format("DELETE FROM %s WHERE %s = '%s' AND %s != '%s'", "LiveTipsBar", "hostRoomId", str, "liveId", com.tencent.mm.live.b.c.c.hLd.second));
            if (!execSQL) {
                Log.e("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId failed, hostRoomId:%s, result%b, visitingLive:%d", str, Boolean.valueOf(execSQL), Long.valueOf(longValue));
            } else {
                Log.i("MicroMsg.LiveTipsBarStorage", "deleteByHostRoomId, hostRoomId:%s, result%b, visitingLive:%d", str, Boolean.valueOf(execSQL), Long.valueOf(longValue));
            }
        }
        if (liveTipsBarStorage.hLf != null) {
            liveTipsBarStorage.hLf.Ha(str);
        }
        AppMethodBeat.o(232631);
    }

    static {
        AppMethodBeat.i(232636);
        AppMethodBeat.o(232636);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(232632);
        if (OFt != null) {
            OFt.add(aVar);
        }
        AppMethodBeat.o(232632);
    }

    public static void b(a aVar) {
        AppMethodBeat.i(232633);
        if (OFt != null) {
            OFt.remove(aVar);
        }
        AppMethodBeat.o(232633);
    }

    /* access modifiers changed from: package-private */
    public class b extends BaseAdapter {
        b() {
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(232626);
            com.tencent.mm.live.b.c.b akV = akV(i2);
            AppMethodBeat.o(232626);
            return akV;
        }

        public final int getCount() {
            AppMethodBeat.i(232623);
            if (q.this.OFr != null) {
                int size = q.this.OFr.size();
                AppMethodBeat.o(232623);
                return size;
            }
            AppMethodBeat.o(232623);
            return 0;
        }

        private com.tencent.mm.live.b.c.b akV(int i2) {
            AppMethodBeat.i(232624);
            if (q.this.OFr == null) {
                AppMethodBeat.o(232624);
                return null;
            }
            com.tencent.mm.live.b.c.b bVar = (com.tencent.mm.live.b.c.b) q.this.OFr.get(i2);
            AppMethodBeat.o(232624);
            return bVar;
        }

        public final long getItemId(int i2) {
            return -1;
        }

        public final View getView(final int i2, View view, ViewGroup viewGroup) {
            c cVar;
            String Is;
            AppMethodBeat.i(232625);
            if (view == null) {
                view = LayoutInflater.from(q.this.OFq.context).inflate(R.layout.b1n, viewGroup, false);
                cVar = new c();
                cVar.OFA = (LinearLayout) view.findViewById(R.id.em5);
                cVar.OFB = (WeImageView) view.findViewById(R.id.em4);
                cVar.OFe = (RelativeLayout) view.findViewById(R.id.em6);
                cVar.OFC = (TextView) view.findViewById(R.id.emb);
                cVar.OFD = (TextView) view.findViewById(R.id.em3);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            final com.tencent.mm.live.b.c.b akV = akV(i2);
            if (akV != null) {
                a.b.c(cVar.OFB, akV.field_anchorUsername);
                cVar.OFC.setText(l.c(q.this.OFq.context, akV.field_liveName));
                TextView textView = cVar.OFD;
                StringBuilder sb = new StringBuilder("主播：");
                Context context = q.this.OFq.context;
                String str = akV.field_anchorUsername;
                String str2 = q.this.hwa;
                if (str == null) {
                    Is = "";
                } else {
                    Is = aa.Is(str);
                    if (Util.isNullOrNil(Is)) {
                        ah Kd = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(str2);
                        if (Kd == null) {
                            Is = aa.getDisplayName(str);
                        } else {
                            Is = Kd.getDisplayName(str);
                            if (Util.isNullOrNil(Is)) {
                                Is = aa.getDisplayName(str);
                            }
                        }
                    }
                }
                textView.setText(sb.append((Object) l.b(context, Is, cVar.OFD.getTextSize())).toString());
            }
            cVar.OFA.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.q.b.AnonymousClass1 */

                public final void onClick(View view) {
                    int i2;
                    AppMethodBeat.i(232620);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LiveTalkRoomTipsBarController$LiveTalkRoomTipsBarAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (akV != null) {
                        LiveTalkRoomTipsBar liveTalkRoomTipsBar = q.this.OFq;
                        com.tencent.mm.live.b.c.b bVar2 = akV;
                        LiveConfig.a aVar = new LiveConfig.a();
                        if (((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).isAnchorLiving() || ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).isVisitorLiving() || (!com.tencent.mm.q.a.o(liveTalkRoomTipsBar.context, true) && !com.tencent.mm.q.a.cC(liveTalkRoomTipsBar.context) && !com.tencent.mm.q.a.cA(liveTalkRoomTipsBar.context) && !com.tencent.mm.q.a.cE(liveTalkRoomTipsBar.context))) {
                            if (bVar2.field_isSender) {
                                i2 = LiveConfig.hvT;
                            } else {
                                i2 = LiveConfig.hvU;
                            }
                            aVar.hvZ = i2;
                            aVar.thumbUrl = bVar2.field_thumbUrl;
                            aVar.hwa = bVar2.field_hostRoomId;
                            aVar.liveId = bVar2.field_liveId;
                            aVar.hwb = bVar2.field_liveName;
                            aVar.fromScene = LiveConfig.hvW;
                            aVar.hwd = bVar2.field_anchorUsername;
                            LiveConfig aBR = aVar.aBR();
                            if (bVar2.field_isSender) {
                                ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).liveEntranceJumper().c(liveTalkRoomTipsBar.context, aBR);
                            } else {
                                f.aIM();
                                ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).liveEntranceJumper().b(liveTalkRoomTipsBar.context, aBR);
                            }
                        }
                    }
                    if (q.this.OFq != null) {
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.ui.q.b.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(232619);
                                if (q.this.OFq != null) {
                                    q.this.OFq.bc(true, false);
                                }
                                AppMethodBeat.o(232619);
                            }
                        });
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBarController$LiveTalkRoomTipsBarAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(232620);
                }
            });
            cVar.OFe.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.q.b.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(232622);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/LiveTalkRoomTipsBarController$LiveTalkRoomTipsBarAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().zF(((com.tencent.mm.live.b.c.b) q.this.OFr.get(i2)).field_liveId);
                    q.this.gIH();
                    if (q.this.OFq != null) {
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.ui.q.b.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(232621);
                                if (q.this.OFq != null) {
                                    q.this.OFq.gIE();
                                }
                                AppMethodBeat.o(232621);
                            }
                        });
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LiveTalkRoomTipsBarController$LiveTalkRoomTipsBarAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(232622);
                }
            });
            AppMethodBeat.o(232625);
            return view;
        }
    }

    class c {
        LinearLayout OFA;
        WeImageView OFB;
        TextView OFC;
        TextView OFD;
        RelativeLayout OFe;

        c() {
        }
    }

    public static LinkedList<com.tencent.mm.live.b.c.b> blP(String str) {
        AppMethodBeat.i(232634);
        LinkedList<com.tencent.mm.live.b.c.b> GX = ((com.tencent.mm.live.a) g.ah(com.tencent.mm.live.a.class)).getLiveTipsBarStorage().GX(str);
        AppMethodBeat.o(232634);
        return GX;
    }

    static /* synthetic */ void Pn(final String str) {
        AppMethodBeat.i(232635);
        if (OFt != null) {
            Iterator<a> it = OFt.iterator();
            while (it.hasNext()) {
                final a next = it.next();
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.q.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(232618);
                        next.blQ(str);
                        AppMethodBeat.o(232618);
                    }
                });
            }
        }
        AppMethodBeat.o(232635);
    }
}

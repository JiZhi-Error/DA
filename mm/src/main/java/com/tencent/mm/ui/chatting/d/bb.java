package com.tencent.mm.ui.chatting.d;

import android.util.SparseArray;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.jd;
import com.tencent.mm.g.b.a.jg;
import com.tencent.mm.g.b.a.jo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.l;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.h.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.m;
import com.tencent.mm.ui.chatting.view.AvatarImageView;
import com.tencent.mm.ui.chatting.viewitems.bq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@a(gRF = ai.class)
public class bb extends a implements l.a, ai {
    private boolean BdH = false;
    private boolean FpT = false;
    private List<String> Fue = Collections.synchronizedList(new ArrayList());
    private MenuItem.OnMenuItemClickListener ORI = new MenuItem.OnMenuItemClickListener() {
        /* class com.tencent.mm.ui.chatting.d.bb.AnonymousClass1 */

        public final boolean onMenuItemClick(MenuItem menuItem) {
            long j2;
            long j3 = 1;
            AppMethodBeat.i(35622);
            if (System.currentTimeMillis() - bb.this.nJh <= bb.this.Puo) {
                Log.i("MicroMsg.StoryStateComponent", "onclick pass $clickTime now: %s", Long.valueOf(System.currentTimeMillis()));
                AppMethodBeat.o(35622);
                return true;
            }
            bb.this.nJh = System.currentTimeMillis();
            Log.i("MicroMsg.StoryStateComponent", "menuItemClickListener clickTime %s storyUserList size %s", Long.valueOf(bb.this.nJh), Integer.valueOf(bb.this.Pum.size()));
            if (bb.this.Pum.size() > 0) {
                String str = (String) bb.this.Pum.get(0);
                Log.i("MicroMsg.StoryStateComponent", "menuItemClickListener click go %s", str);
                ((e) g.ah(e.class)).checkReportFromChatting(1, str);
                ((e) g.ah(e.class)).enterGallery(bb.this.Fue);
                ((e) g.ah(e.class)).preLoadVideoViewMgr(str);
                h hVar = h.FuH;
                h.fqi().wU(bb.this.sessionId);
                if (bb.this.tcb) {
                    h hVar2 = h.FuH;
                    h.fqi().eQv = 4;
                    o.a(bb.this.dom.Pwc.getContext(), bb.this.Pum, bb.this.dom.getTalkerUserName(), bb.this.sessionId);
                } else {
                    h hVar3 = h.FuH;
                    h.fqi().eQv = 5;
                    o.bB(bb.this.dom.Pwc.getContext(), (String) bb.this.Pum.get(0));
                }
                h hVar4 = h.FuH;
                jo fqi = h.fqi();
                if (bb.this.FpT) {
                    j2 = 1;
                } else {
                    j2 = 0;
                }
                fqi.eQw = j2;
                AppMethodBeat.o(35622);
                return true;
            } else if (!bb.this.BdH || !bb.this.tcb) {
                AppMethodBeat.o(35622);
                return false;
            } else {
                h hVar5 = h.FuH;
                jo fqi2 = h.fqi();
                if (!bb.this.FpT) {
                    j3 = 0;
                }
                fqi2.eQw = j3;
                o.a(bb.this.dom.Pwc.getContext(), bb.this.Pum, bb.this.dom.getTalkerUserName(), bb.this.sessionId);
                h hVar6 = h.FuH;
                h.fqi().eQv = 4;
                AppMethodBeat.o(35622);
                return true;
            }
        }
    };
    private l Pul;
    private List<String> Pum = Collections.synchronizedList(new ArrayList());
    private boolean Pun = false;
    private long Puo = 500;
    private boolean Pup = false;
    private SparseArray<WeakReference<AvatarImageView>> Puq = new SparseArray<>();
    private long nJh = 0;
    private String sessionId = null;
    private boolean tcb = true;
    private boolean thE = false;

    public bb() {
        AppMethodBeat.i(35625);
        AppMethodBeat.o(35625);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0067  */
    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void gIl() {
        /*
        // Method dump skipped, instructions count: 332
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.d.bb.gIl():void");
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(35627);
        super.gIm();
        Log.i("MicroMsg.StoryStateComponent", "onChattingEnterAnimEnd: hashCode:%s", Integer.valueOf(hashCode()));
        AppMethodBeat.o(35627);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFx() {
        long j2;
        long aSq;
        long j3 = 2;
        AppMethodBeat.i(35628);
        super.cFx();
        Log.i("MicroMsg.StoryStateComponent", "onChattingResume: hashCode:%s", Integer.valueOf(hashCode()));
        this.thE = true;
        gRg();
        if (this.Pul != null) {
            this.Pul.resume();
            h hVar = h.FuH;
            jo fqi = h.fqi();
            if (this.tcb) {
                j2 = 10;
            } else {
                j2 = 11;
            }
            fqi.eQv = j2;
            h hVar2 = h.FuH;
            h.fqi().wS(this.dom.getTalkerUserName());
            h hVar3 = h.FuH;
            jo fqi2 = h.fqi();
            if (this.tcb) {
                aSq = 2;
            } else {
                i.a aVar = i.FuI;
                aSq = (long) i.a.aSq(this.dom.getTalkerUserName());
            }
            fqi2.eQZ = aSq;
        }
        h hVar4 = h.FuH;
        h.fqq().wJ(this.dom.getTalkerUserName());
        h hVar5 = h.FuH;
        jg fqq = h.fqq();
        if (!this.tcb) {
            i.a aVar2 = i.FuI;
            j3 = (long) i.a.aSq(this.dom.getTalkerUserName());
        }
        fqq.eQZ = j3;
        AppMethodBeat.o(35628);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
        AppMethodBeat.i(35629);
        super.cFy();
        this.thE = false;
        Log.i("MicroMsg.StoryStateComponent", "onChattingPause: hashCode:%s", Integer.valueOf(hashCode()));
        if (this.Pul != null) {
            this.Pul.pause();
        }
        AppMethodBeat.o(35629);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35630);
        super.gIn();
        Log.i("MicroMsg.StoryStateComponent", "onChattingExitAnimStart: hashCode:%s", Integer.valueOf(hashCode()));
        gRf();
        h hVar = h.FuH;
        h.fqi().wS("");
        h hVar2 = h.FuH;
        h.fqi().eRK = 0;
        h hVar3 = h.FuH;
        h.fqi().eQZ = 0;
        h hVar4 = h.FuH;
        h.fqq().wJ("");
        h hVar5 = h.FuH;
        h.fqq().eQZ = 0;
        AppMethodBeat.o(35630);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(35631);
        super.gOK();
        Log.i("MicroMsg.StoryStateComponent", "onComponentUnInstall: hashCode:%s", Integer.valueOf(hashCode()));
        gRf();
        AppMethodBeat.o(35631);
    }

    private void gRf() {
        AppMethodBeat.i(35632);
        if (this.Pul != null) {
            this.Pul.destroy();
            this.Pul.a(null);
            this.Pul = null;
        }
        this.BdH = false;
        this.FpT = false;
        this.Pum.clear();
        this.Puq.clear();
        AppMethodBeat.o(35632);
    }

    @Override // com.tencent.mm.ui.chatting.d.ai
    public final void gQG() {
        AppMethodBeat.i(35634);
        int i2 = com.tencent.mm.n.h.aqJ().getInt("StoryShouldShowEntraceInChatRoom", 1);
        if (!this.BdH || i2 == 0) {
            Log.i("MicroMsg.StoryStateComponent", "updateMenuItem enable %s", Integer.valueOf(i2));
            this.dom.Pwc.removeOptionMenu(3);
            AppMethodBeat.o(35634);
            return;
        }
        if (this.Pun && o.isShowStoryCheck()) {
            Log.i("MicroMsg.StoryStateComponent", "updateMenuItem: hasUnread %s hashCode:%s", Boolean.valueOf(this.FpT), Integer.valueOf(hashCode()));
            if (this.FpT) {
                this.dom.Pwc.removeOptionMenu(3);
                a(R.raw.icons_outlined_one_day_blue_video, this.ORI, this.dom.Pwc.getContext().getResources().getColor(R.color.Blue));
                AppMethodBeat.o(35634);
                return;
            }
            a(R.raw.icons_outlined_one_day_video, this.ORI, 0);
        }
        AppMethodBeat.o(35634);
    }

    private void a(int i2, MenuItem.OnMenuItemClickListener onMenuItemClickListener, int i3) {
        AppMethodBeat.i(35635);
        if (this.dom.Pwc.findMenuInfo(3) == null) {
            this.dom.Pwc.addIconOptionMenu(3, i2, onMenuItemClickListener, i3);
            AppMethodBeat.o(35635);
            return;
        }
        this.dom.Pwc.updateOptionMenu(3, i2, onMenuItemClickListener, i3);
        AppMethodBeat.o(35635);
    }

    @Override // com.tencent.mm.plugin.story.api.l.a
    public final void a(List<String> list, ArrayList<String> arrayList) {
        AppMethodBeat.i(35637);
        Log.i("MicroMsg.StoryStateComponent", "updateGalleryUserList: size is %s %s hashCode:%s", this.dom.GUe, Integer.valueOf(list.size()), Integer.valueOf(hashCode()));
        this.Pum.clear();
        this.Pum.addAll(list);
        this.Fue.clear();
        this.Fue.addAll(arrayList);
        AppMethodBeat.o(35637);
    }

    @Override // com.tencent.mm.plugin.story.api.l.a
    public final void as(boolean z, boolean z2) {
        AppMethodBeat.i(35638);
        ((m) this.dom.bh(m.class)).amA(z2 ? 1 : z ? 2 : 0);
        if (this.BdH == z && this.FpT == z2) {
            AppMethodBeat.o(35638);
            return;
        }
        Log.i("MicroMsg.StoryStateComponent", "updateChatRoomState: hasStory %s, hasUnread %s", Boolean.valueOf(z), Boolean.valueOf(z2));
        this.BdH = z;
        this.FpT = z2;
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ui.chatting.d.bb.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(35623);
                ((aa) bb.this.dom.bh(aa.class)).gQp();
                AppMethodBeat.o(35623);
            }
        });
        gRg();
        AppMethodBeat.o(35638);
    }

    @Override // com.tencent.mm.plugin.story.api.l.a
    public final void cs(final String str, final boolean z) {
        AppMethodBeat.i(35639);
        Log.i("MicroMsg.StoryStateComponent", "notifyAvatar: ");
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ui.chatting.d.bb.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(35624);
                for (int i2 = 0; i2 < bb.this.Puq.size(); i2++) {
                    AvatarImageView avatarImageView = (AvatarImageView) ((WeakReference) bb.this.Puq.valueAt(i2)).get();
                    if (avatarImageView != null) {
                        Object tag = avatarImageView.getTag();
                        if ((tag instanceof bq) && str.equals(((bq) tag).userName)) {
                            avatarImageView.fL(((bq) tag).userName, 5);
                            avatarImageView.setShowStoryHint(z);
                        }
                    }
                }
                AppMethodBeat.o(35624);
            }
        });
        AppMethodBeat.o(35639);
    }

    private void gRg() {
        long j2;
        AppMethodBeat.i(35640);
        if (this.BdH && this.thE) {
            this.thE = false;
            h hVar = h.FuH;
            jd fqo = h.fqo();
            if (this.FpT) {
                j2 = 1;
            } else {
                j2 = 0;
            }
            fqo.eQw = j2;
            h hVar2 = h.FuH;
            h.fqp();
        }
        AppMethodBeat.o(35640);
    }
}

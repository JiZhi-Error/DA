package com.tencent.mm.plugin.sns.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.js;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.widget.StoryAvatarDotsView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SnsStoryHeaderView extends FrameLayout implements l.b {
    private String DTT;
    private int FdB;
    public boolean FdC;
    private TextView FdD;
    private StoryAvatarDotsView FdE;
    private TextView FdF;
    private TextView FdG;
    private int FdH;
    private int FdI;
    private int FdJ;
    private int FdK;
    private a FdL;
    public boolean aMn;
    public boolean dLD;
    private boolean eco;
    private List<String> iPH;
    private String lem;
    private View pxo;
    private String sessionId;
    private int xnH;

    public interface a {
        void fjo();
    }

    static /* synthetic */ void c(SnsStoryHeaderView snsStoryHeaderView) {
        AppMethodBeat.i(100442);
        snsStoryHeaderView.fkW();
        AppMethodBeat.o(100442);
    }

    public void setStoryAction(a aVar) {
        this.FdL = aVar;
    }

    public SnsStoryHeaderView(Context context) {
        this(context, null);
    }

    public SnsStoryHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SnsStoryHeaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(100432);
        this.xnH = 10000;
        this.iPH = new LinkedList();
        this.sessionId = null;
        this.DTT = null;
        this.dLD = false;
        this.FdC = false;
        this.FdH = 0;
        this.FdI = 0;
        this.FdJ = 0;
        this.lem = "";
        this.FdK = 0;
        this.eco = true;
        this.aMn = false;
        int i3 = g.aAh().azQ().getInt(ar.a.USERINFO_STORY_SNS_HEADER_TYPE_INT, 0);
        if (i3 > 0) {
            this.xnH = i3;
        } else {
            this.xnH = ((b) g.af(b.class)).a(b.a.clicfg_story_sns_story_open, 10000);
        }
        if (((e) g.ah(e.class)).getStoryUserInfo().NeF == 1) {
            this.xnH = 10001;
        }
        Log.i("MicroMsg.SnsStoryHeaderView", "init: headerType %s configType %s", Integer.valueOf(this.xnH), Integer.valueOf(i3));
        inflate(getContext(), R.layout.bxa, this);
        this.pxo = findViewById(R.id.i0e);
        this.FdD = (TextView) findViewById(R.id.i0q);
        this.FdE = (StoryAvatarDotsView) findViewById(R.id.i0c);
        this.FdF = (TextView) findViewById(R.id.i0f);
        this.FdG = (TextView) findViewById(R.id.i0g);
        this.pxo.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(100430);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/view/SnsStoryHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (SnsStoryHeaderView.this.FdL != null) {
                    SnsStoryHeaderView.this.FdL.fjo();
                }
                h.INSTANCE.n(1015, 5, 1);
                SnsStoryHeaderView.b(SnsStoryHeaderView.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/view/SnsStoryHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100430);
            }
        });
        AppMethodBeat.o(100432);
    }

    public void setTopLineVisibility(int i2) {
        AppMethodBeat.i(203984);
        findViewById(R.id.i0r).setVisibility(i2);
        AppMethodBeat.o(203984);
    }

    public void setSnsType(int i2) {
        AppMethodBeat.i(100433);
        this.FdB = i2;
        is(true);
        if (this.iPH.size() > 0) {
            ((e) g.ah(e.class)).preloadForSnsUser(this.iPH.get(0), true);
        }
        AppMethodBeat.o(100433);
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setEnterObjectId(String str) {
        this.DTT = str;
    }

    private void is(boolean z) {
        AppMethodBeat.i(100434);
        Log.i("MicroMsg.SnsStoryHeaderView", "updateView: %s, %s", Boolean.valueOf(z), Boolean.valueOf(this.aMn));
        if (this.aMn) {
            AppMethodBeat.o(100434);
            return;
        }
        this.iPH.clear();
        this.FdJ = ((e) g.ah(e.class)).getContactFetcher().fnm();
        if (this.FdB != 1 || this.xnH == 10000 || this.xnH == 10001) {
            this.pxo.setVisibility(8);
            this.FdC = false;
        } else if (this.xnH == 2) {
            fkV();
            ((e) g.ah(e.class)).getContactFetcher().a(this);
        } else {
            h.INSTANCE.n(1006, 0, 1);
            h.INSTANCE.n(1015, 0, 1);
            fkU();
            ((e) g.ah(e.class)).getContactFetcher().a(this);
        }
        if (this.iPH.size() == 0) {
            this.pxo.setVisibility(8);
            this.FdC = false;
        } else {
            this.pxo.setVisibility(0);
            if (!this.dLD) {
                fkW();
            }
        }
        if (((e) g.ah(e.class)).getContactFetcher().fnl().isEmpty()) {
            this.FdG.setVisibility(8);
            AppMethodBeat.o(100434);
            return;
        }
        this.FdG.setVisibility(0);
        this.FdG.setText(String.valueOf(this.FdJ));
        AppMethodBeat.o(100434);
    }

    private void fkU() {
        int i2;
        AppMethodBeat.i(100435);
        List<String> fnj = ((e) g.ah(e.class)).getContactFetcher().fnj();
        List<String> fnk = ((e) g.ah(e.class)).getContactFetcher().fnk();
        if (fnj.size() > 0) {
            i2 = fnj.size();
        } else {
            i2 = 0;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(((e) g.ah(e.class)).getContactFetcher().fnl().keySet());
        this.FdI = i2;
        this.iPH.addAll(fnj);
        this.iPH.addAll(fnk);
        this.iPH.addAll(arrayList);
        this.FdD.setText(getResources().getString(R.string.h_z));
        hn(fnj);
        this.FdF.setTextColor(getContext().getResources().getColor(R.color.BW_0_Alpha_0_3));
        int i3 = com.tencent.mm.n.h.aqJ().getInt("StoryEntranceShouldShowInTimelineOfUnreadCount", 3);
        Log.i("MicroMsg.SnsStoryHeaderView", "initTypeNew %s", Integer.valueOf(i3));
        if (fnj.size() > 0) {
            h.INSTANCE.n(1015, 1, 1);
        } else {
            h.INSTANCE.n(1015, 2, 1);
        }
        if (this.iPH.size() == 0) {
            h.INSTANCE.n(1015, 3, 1);
        }
        if (i2 > i3) {
            int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 4.0f);
            this.FdF.setPadding(fromDPToPix, 0, fromDPToPix, 0);
            this.FdF.setText(String.format("%s", Integer.valueOf(i2)));
            AppMethodBeat.o(100435);
            return;
        }
        this.FdF.setPadding(0, 0, 0, 0);
        this.FdF.setText("");
        AppMethodBeat.o(100435);
    }

    private void fkV() {
        AppMethodBeat.i(100436);
        List<String> fnj = ((e) g.ah(e.class)).getContactFetcher().fnj();
        List<String> fnn = ((e) g.ah(e.class)).getContactFetcher().fnn();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(((e) g.ah(e.class)).getContactFetcher().fnl().keySet());
        this.iPH.addAll(fnj);
        this.iPH.addAll(fnn);
        this.iPH.addAll(arrayList);
        this.FdD.setText(getResources().getString(R.string.h_w));
        hn(fnj);
        AppMethodBeat.o(100436);
    }

    private void hn(List<String> list) {
        AppMethodBeat.i(100437);
        this.FdE.setIconSize(com.tencent.mm.cb.a.fromDPToPix(getContext(), 26));
        this.FdE.setIconGap(com.tencent.mm.cb.a.fromDPToPix(getContext(), 16));
        this.FdH = 0;
        if (list.size() > 0) {
            this.FdE.setVisibility(0);
            this.FdE.setIconLayerCount(Math.min(list.size(), 3));
            this.FdH = this.FdE.getChildCount();
            for (int i2 = 0; i2 < this.FdE.getChildCount(); i2++) {
                a.b.a(this.FdE.zK(i2), list.get(i2), 0.5f, false);
                this.FdE.zK(i2).setBackground(getResources().getDrawable(R.drawable.avy));
                this.FdE.zK(i2).setPadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 1), com.tencent.mm.cb.a.fromDPToPix(getContext(), 1), com.tencent.mm.cb.a.fromDPToPix(getContext(), 1), com.tencent.mm.cb.a.fromDPToPix(getContext(), 1));
            }
            AppMethodBeat.o(100437);
            return;
        }
        this.FdE.setVisibility(8);
        AppMethodBeat.o(100437);
    }

    public final void fkW() {
        AppMethodBeat.i(100438);
        if (!this.eco) {
            this.pxo.setVisibility(8);
            AppMethodBeat.o(100438);
            return;
        }
        if (this.pxo.getVisibility() == 0) {
            int[] iArr = new int[2];
            this.pxo.getLocationOnScreen(iArr);
            if (iArr[1] <= 0) {
                this.FdC = false;
            } else if (!this.FdC) {
                this.FdC = true;
                cnl();
            }
            Log.i("MicroMsg.SnsStoryHeaderView", "checkExpose: %s", Boolean.valueOf(this.FdC));
        }
        AppMethodBeat.o(100438);
    }

    private void cnl() {
        AppMethodBeat.i(100439);
        Log.i("MicroMsg.SnsStoryHeaderView", "reportExpose: ");
        if (this.iPH.size() <= 0) {
            AppMethodBeat.o(100439);
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (this.FdH > 0) {
            sb.append(this.iPH.get(0));
        }
        for (int i2 = 1; i2 < this.FdH; i2++) {
            sb.append("|").append(this.iPH.get(i2));
        }
        js jsVar = new js();
        jsVar.wZ(this.DTT);
        this.lem = "99_" + System.currentTimeMillis();
        jsVar.xa(this.lem);
        jsVar.eSm = (long) this.FdH;
        jsVar.xb(sb.toString());
        jsVar.eSo = (long) this.FdI;
        jsVar.eRo = (long) this.FdJ;
        jsVar.bfK();
        this.FdK++;
        AppMethodBeat.o(100439);
    }

    @Override // com.tencent.mm.plugin.story.api.l.b
    public final void fkX() {
        AppMethodBeat.i(100440);
        is(false);
        if (this.iPH.size() > 0) {
            ((e) g.ah(e.class)).preloadForSnsUser(this.iPH.get(0), false);
        }
        AppMethodBeat.o(100440);
    }

    static /* synthetic */ void b(SnsStoryHeaderView snsStoryHeaderView) {
        AppMethodBeat.i(100441);
        Log.i("MicroMsg.SnsStoryHeaderView", "goToStoryGallery: %s", Integer.valueOf(snsStoryHeaderView.iPH.size()));
        if (snsStoryHeaderView.iPH.size() > 0) {
            ((e) g.ah(e.class)).showStoryEntranceDialog(snsStoryHeaderView.getContext(), snsStoryHeaderView.lem, snsStoryHeaderView.FdK);
        }
        AppMethodBeat.o(100441);
    }
}

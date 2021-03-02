package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.ui.SnsCommentFooter;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SnsStrangerCommentDetailUI extends MMActivity implements c.b {
    private static int EJR = 4;
    private SnsInfo DsC;
    private int EBc = -1;
    private MStorage.IOnStorageChange EGa = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.AnonymousClass7 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(99146);
            aj.dRd().post(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.AnonymousClass7.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(99145);
                    Log.v("MicroMsg.SnsStrangerCommentDetailUI", "comment notify");
                    SnsStrangerCommentDetailUI.this.EJN.onNotifyChange(null, null);
                    if (SnsStrangerCommentDetailUI.this.EJP) {
                        SnsStrangerCommentDetailUI.this.EJP = false;
                        aj.dRd().postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.AnonymousClass8 */

                            public final void run() {
                                AppMethodBeat.i(99147);
                                SnsStrangerCommentDetailUI.this.EJJ.setSelection(SnsStrangerCommentDetailUI.this.EJN.getCount() - 1);
                                AppMethodBeat.o(99147);
                            }
                        }, 10);
                    }
                    AppMethodBeat.o(99145);
                }
            });
            AppMethodBeat.o(99146);
        }
    };
    private ListView EJJ;
    private SnsCommentFooter EJK;
    private LinearLayout EJL;
    private List<View> EJM;
    private a EJN;
    private boolean EJO = false;
    private boolean EJP = false;
    private as EJQ;
    private bb EoL;
    private long ece;
    private ImageView keC;
    private TextView qbF;
    private int source;
    private String talker;
    private View vbj;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsStrangerCommentDetailUI() {
        AppMethodBeat.i(99157);
        AppMethodBeat.o(99157);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(99158);
        super.onCreate(bundle);
        setMMTitle(R.string.h5i);
        this.ece = getIntent().getLongExtra("INTENT_SNSID", 0);
        this.talker = getIntent().getStringExtra("INTENT_TALKER");
        this.DsC = aj.faO().JJ(this.ece);
        this.source = getIntent().getIntExtra("INTENT_SOURCE", -1);
        g.aAi();
        this.EJQ = ((l) g.af(l.class)).aSN().Kn(this.talker);
        if (this.DsC == null || this.talker == null) {
            finish();
            AppMethodBeat.o(99158);
            return;
        }
        this.EoL = new bb(this);
        aj.faT().add(this.EGa);
        initView();
        AppMethodBeat.o(99158);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(99159);
        aj.faJ().a(this);
        super.onResume();
        AppMethodBeat.o(99159);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(99160);
        aj.faJ().b(this);
        super.onPause();
        AppMethodBeat.o(99160);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(99161);
        aj.faT().remove(this.EGa);
        aj.faL().aI(this);
        if (this.EJN != null) {
            this.EJN.ebf();
        }
        super.onDestroy();
        AppMethodBeat.o(99161);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(99162);
        this.EJJ = (ListView) findViewById(R.id.jh);
        this.EJK = (SnsCommentFooter) findViewById(R.id.b8y);
        this.vbj = View.inflate(this, R.layout.bxb, null);
        this.EJL = (LinearLayout) this.vbj.findViewById(R.id.kd);
        this.keC = (ImageView) this.vbj.findViewById(R.id.iu);
        this.qbF = (TextView) this.vbj.findViewById(R.id.kj);
        a.b.A(this.keC, this.DsC.getUserName());
        this.qbF.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, ((b) g.af(b.class)).getDisplayName(this.DsC.getUserName()), this.qbF.getTextSize()));
        fiK();
        for (int i2 = 0; i2 < this.EJM.size(); i2++) {
            bc bcVar = new bc();
            bcVar.dJX = this.DsC.getLocalid();
            bcVar.index = i2;
            bcVar.EDW = this.EJM;
            this.EJM.get(i2).setTag(bcVar);
            this.EJM.get(i2).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.AnonymousClass9 */

                public final void onClick(View view) {
                    AppMethodBeat.i(99148);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (view.getTag() instanceof bc) {
                        SnsStrangerCommentDetailUI.this.EoL.v(view, 2, 1);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99148);
                }
            });
        }
        this.EJJ.addHeaderView(this.vbj);
        this.EJN = new a(this);
        this.EJJ.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(99149);
                SnsStrangerCommentDetailUI.this.EBc = SnsStrangerCommentDetailUI.this.EJJ.getBottom();
                Log.d("MicroMsg.SnsStrangerCommentDetailUI", "listOriginalBottom: " + SnsStrangerCommentDetailUI.this.EBc);
                AppMethodBeat.o(99149);
            }
        });
        this.EJJ.setAdapter((ListAdapter) this.EJN);
        this.EJJ.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.AnonymousClass11 */

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            }

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
            }
        });
        this.EJK.setAfterEditAction(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.AnonymousClass2 */
            int ECI = -1;
            int ECJ = 10;

            public final void run() {
                AppMethodBeat.i(99140);
                if (!SnsStrangerCommentDetailUI.this.EJO) {
                    this.ECJ = 10;
                }
                SnsStrangerCommentDetailUI.this.EJO = true;
                Log.e("MicroMsg.SnsStrangerCommentDetailUI", "list.bottom:" + SnsStrangerCommentDetailUI.this.EJJ.getBottom() + " footer.top" + SnsStrangerCommentDetailUI.this.EJJ.getTop());
                int top = SnsStrangerCommentDetailUI.this.EJK.getTop();
                int i2 = this.ECJ;
                this.ECJ = i2 - 1;
                if (i2 > 0 && (this.ECI != top || SnsStrangerCommentDetailUI.this.EJJ.getBottom() == SnsStrangerCommentDetailUI.this.EBc)) {
                    new MMHandler().postDelayed(this, 30);
                }
                this.ECI = top;
                BackwardSupportUtil.SmoothScrollFactory.scrollTo(SnsStrangerCommentDetailUI.this.EJJ, SnsStrangerCommentDetailUI.this.EJJ.getCount() - 1);
                AppMethodBeat.o(99140);
            }
        });
        this.EJK.fhX();
        this.EJK.setOnCommentSendImp(new SnsCommentFooter.b() {
            /* class com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.sns.ui.SnsCommentFooter.b
            public final void kP(String str, String str2) {
                AppMethodBeat.i(99141);
                Log.v("MicroMsg.SnsStrangerCommentDetailUI", "comment send requested");
                SnsStrangerCommentDetailUI.this.EJP = true;
                SnsStrangerCommentDetailUI.a(SnsStrangerCommentDetailUI.this, SnsStrangerCommentDetailUI.this.DsC, str);
                AppMethodBeat.o(99141);
            }
        });
        this.EJK.setCommentHint(getString(R.string.h9y) + this.talker + getString(R.string.h4y));
        setToTop(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(99139);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(SnsStrangerCommentDetailUI.this.EJJ);
                Object obj = new Object();
                com.tencent.mm.hellhoundlib.a.a.a(obj, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI$1", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI$1", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99139);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(99142);
                SnsStrangerCommentDetailUI.this.finish();
                AppMethodBeat.o(99142);
                return true;
            }
        });
        addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(99143);
                SnsStrangerCommentDetailUI.b(SnsStrangerCommentDetailUI.this);
                AppMethodBeat.o(99143);
                return true;
            }
        });
        AppMethodBeat.o(99162);
    }

    private void fiK() {
        AppMethodBeat.i(99163);
        this.EJL.removeAllViews();
        int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, (float) EJR);
        LinkedList<cnb> linkedList = this.DsC.getTimeLine().ContentObj.LoV;
        this.EJM = new ArrayList();
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            MMImageView mMImageView = new MMImageView(this);
            mMImageView.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
            this.EJL.addView(mMImageView, new ViewGroup.LayoutParams(-2, -2));
            Bitmap aSa = aj.faL().a(linkedList.get(i2), (ImageView) mMImageView, hashCode(), bp.Oqt).aSa();
            if (aSa == null) {
                b(this.DsC.field_type, mMImageView);
            } else {
                mMImageView.setImageBitmap(aSa);
            }
            this.EJM.add(mMImageView);
        }
        AppMethodBeat.o(99163);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bvi;
    }

    private static void b(int i2, MMImageView mMImageView) {
        int i3 = R.raw.app_attach_file_icon_webpage;
        AppMethodBeat.i(99164);
        switch (i2) {
            case 1:
                i3 = R.drawable.bxc;
                break;
            case 2:
                mMImageView.setImageDrawable(null);
                i3 = 0;
                break;
            case 4:
            case 42:
                i3 = R.raw.app_attach_file_icon_music;
                break;
            case 5:
                i3 = R.raw.app_attach_file_icon_video;
                break;
            case 6:
                i3 = R.raw.app_attach_file_icon_location;
                break;
            case 7:
                i3 = R.drawable.bxc;
                break;
            case 8:
                mMImageView.setImageDrawable(null);
                i3 = 0;
                break;
        }
        if (i3 != 0) {
            mMImageView.setImageResource(i3);
        }
        AppMethodBeat.o(99164);
    }

    /* access modifiers changed from: package-private */
    public class a extends s<h> {
        private Activity dKq;
        private View.OnClickListener pri = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.a.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(99150);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI$CommentListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String str = (String) view.getTag();
                Log.d("MicroMsg.SnsStrangerCommentDetailUI", "onCommentClick:".concat(String.valueOf(str)));
                Intent intent = new Intent();
                intent.putExtra("Contact_User", str);
                com.tencent.mm.plugin.sns.c.a.jRt.c(intent, a.this.dKq);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI$CommentListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99150);
            }
        };

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
        @Override // com.tencent.mm.ui.s
        public final /* synthetic */ h a(h hVar, Cursor cursor) {
            AppMethodBeat.i(99156);
            h hVar2 = hVar;
            if (hVar2 == null) {
                hVar2 = new h();
            }
            hVar2.convertFrom(cursor);
            AppMethodBeat.o(99156);
            return hVar2;
        }

        public a(Activity activity) {
            super(activity, new h());
            AppMethodBeat.i(99152);
            this.dKq = activity;
            AppMethodBeat.o(99152);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1732a aVar;
            String str;
            AppMethodBeat.i(99153);
            if (view == null) {
                C1732a aVar2 = new C1732a();
                view = View.inflate(this.dKq, R.layout.bxc, null);
                aVar2.gvv = (ImageView) view.findViewById(R.id.hx8);
                aVar2.hXC = (TextView) view.findViewById(R.id.hxb);
                aVar2.kib = (TextView) view.findViewById(R.id.hxf);
                aVar2.xYx = (TextView) view.findViewById(R.id.hxg);
                aVar2.timeTv = (TextView) view.findViewById(R.id.hxh);
                aVar2.EJV = (ImageView) view.findViewById(R.id.hxc);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C1732a) view.getTag();
            }
            h hVar = (h) getItem(i2);
            try {
                dzi dzi = (dzi) new dzi().parseFrom(hVar.field_curActionBuf);
                a.b.A(aVar.gvv, dzi.MKC);
                aVar.gvv.setTag(dzi.MKC);
                aVar.gvv.setOnClickListener(this.pri);
                if (dzi.MYQ != null) {
                    str = dzi.MYQ;
                } else {
                    str = ((h) this.OFE).field_talker;
                }
                aVar.kib.setTag(dzi.MKC);
                SpannableString b2 = com.tencent.mm.pluginsdk.ui.span.l.b(this.dKq, str, aVar.kib.getTextSize());
                b2.setSpan(new q(dzi.MKC) {
                    /* class com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.a.AnonymousClass2 */

                    @Override // com.tencent.mm.pluginsdk.ui.span.p, com.tencent.mm.pluginsdk.ui.span.q
                    public final void onClick(View view) {
                        AppMethodBeat.i(99151);
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", view.getTag().toString());
                        com.tencent.mm.plugin.sns.c.a.jRt.c(intent, a.this.dKq);
                        AppMethodBeat.o(99151);
                    }
                }, 0, str.length(), 33);
                aVar.kib.setText(b2, TextView.BufferType.SPANNABLE);
                aVar.kib.setOnTouchListener(new af());
                if (hVar.field_type == 3) {
                    aVar.hXC.setVisibility(0);
                    aVar.EJV.setVisibility(8);
                    Log.v("MicroMsg.SnsStrangerCommentDetailUI", "source:" + dzi.xub + "  time:" + dzi.CreateTime + " timeFormatted:" + bm.q(this.dKq, ((long) dzi.CreateTime) * 1000));
                    aVar.hXC.setText(dzi.iAc + " ");
                    com.tencent.mm.pluginsdk.ui.span.l.p(aVar.hXC, 2);
                    aVar.hXC.setVisibility(0);
                } else {
                    aVar.hXC.setVisibility(8);
                    aVar.EJV.setVisibility(0);
                }
                if (!z.aTY().equals(dzi.MKC)) {
                    aVar.xYx.setVisibility(0);
                    TextView textView = aVar.xYx;
                    switch (dzi.xub) {
                        case 18:
                            textView.setText(SnsStrangerCommentDetailUI.this.getString(R.string.h6h));
                            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.tencent.mm.cb.a.l(this.dKq, R.drawable.bki), (Drawable) null);
                            break;
                        case 19:
                        case 20:
                        case 21:
                        default:
                            textView.setText(SnsStrangerCommentDetailUI.this.getString(R.string.h6k));
                            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.tencent.mm.cb.a.l(this.dKq, R.drawable.bkj), (Drawable) null);
                            break;
                        case 22:
                        case 23:
                        case 24:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                            textView.setText(SnsStrangerCommentDetailUI.this.getString(R.string.h6j));
                            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.tencent.mm.cb.a.l(this.dKq, R.drawable.bkk), (Drawable) null);
                            break;
                        case 25:
                            textView.setText(SnsStrangerCommentDetailUI.this.getString(R.string.h6g));
                            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.tencent.mm.cb.a.l(this.dKq, R.drawable.bkg), (Drawable) null);
                            break;
                        case 30:
                            textView.setText(SnsStrangerCommentDetailUI.this.getString(R.string.h6i));
                            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.tencent.mm.cb.a.l(this.dKq, R.drawable.bkh), (Drawable) null);
                            break;
                    }
                } else {
                    aVar.xYx.setVisibility(8);
                }
                aVar.timeTv.setText(bm.q(this.dKq, ((long) dzi.CreateTime) * 1000));
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.SnsStrangerCommentDetailUI", e2, "", new Object[0]);
            }
            AppMethodBeat.o(99153);
            return view;
        }

        @Override // com.tencent.mm.ui.s
        public final void anp() {
            AppMethodBeat.i(99154);
            i faT = aj.faT();
            String str = SnsStrangerCommentDetailUI.this.talker;
            String str2 = i.feF() + " where talker = " + com.tencent.mm.storagebase.h.Fl(str) + " and  snsID = " + SnsStrangerCommentDetailUI.this.ece + " and ( type = 3 or type = 5 )";
            Log.v("MicroMsg.SnsCommentStorage", "comment sql:".concat(String.valueOf(str2)));
            setCursor(faT.iFy.rawQuery(str2, null));
            AppMethodBeat.o(99154);
        }

        @Override // com.tencent.mm.ui.s
        public final void anq() {
            AppMethodBeat.i(99155);
            anp();
            AppMethodBeat.o(99155);
        }

        /* renamed from: com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI$a$a  reason: collision with other inner class name */
        class C1732a {
            ImageView EJV;
            ImageView gvv;
            TextView hXC;
            TextView kib;
            TextView timeTv;
            TextView xYx;

            C1732a() {
            }
        }
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void aOG(String str) {
        AppMethodBeat.i(99165);
        fiK();
        AppMethodBeat.o(99165);
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void ci(String str, boolean z) {
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void eZJ() {
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(99166);
        Log.i("MicroMsg.SnsStrangerCommentDetailUI", "onAcvityResult requestCode:".concat(String.valueOf(i2)));
        if (i3 != -1) {
            AppMethodBeat.o(99166);
            return;
        }
        switch (i2) {
            case 1:
                if (i3 == -1) {
                    Cursor managedQuery = managedQuery(intent.getData(), null, null, null, null);
                    if (managedQuery.moveToFirst()) {
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/".concat(String.valueOf(managedQuery.getString(managedQuery.getColumnIndexOrThrow("_id")))))));
                        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        break;
                    }
                }
                break;
        }
        AppMethodBeat.o(99166);
    }

    @Override // com.tencent.mm.plugin.sns.model.c.b
    public final void cj(String str, boolean z) {
    }

    static /* synthetic */ void b(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI) {
        AppMethodBeat.i(99167);
        String[] strArr = new String[1];
        if (snsStrangerCommentDetailUI.EJQ == null) {
            snsStrangerCommentDetailUI.EJQ = new as();
            AppMethodBeat.o(99167);
            return;
        }
        if (!com.tencent.mm.contact.c.oR(snsStrangerCommentDetailUI.EJQ.field_type)) {
            ab.q(snsStrangerCommentDetailUI.EJQ);
        }
        if (snsStrangerCommentDetailUI.EJQ.ary()) {
            strArr[0] = snsStrangerCommentDetailUI.getString(R.string.bda);
        } else {
            strArr[0] = snsStrangerCommentDetailUI.getString(R.string.bd6);
        }
        com.tencent.mm.ui.base.h.b(snsStrangerCommentDetailUI, "", strArr, "", new h.d() {
            /* class com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.AnonymousClass6 */

            @Override // com.tencent.mm.ui.base.h.d
            public final void oj(int i2) {
                AppMethodBeat.i(99144);
                switch (i2) {
                    case 0:
                        if (!SnsStrangerCommentDetailUI.this.EJQ.ary()) {
                            ab.t(SnsStrangerCommentDetailUI.this.EJQ);
                            SnsStrangerCommentDetailUI.this.EJQ.aqS();
                            com.tencent.mm.plugin.sns.c.a.jRu.WZ();
                            break;
                        } else {
                            ab.u(SnsStrangerCommentDetailUI.this.EJQ);
                            SnsStrangerCommentDetailUI.this.EJQ.aqT();
                            com.tencent.mm.plugin.sns.c.a.jRu.WZ();
                            AppMethodBeat.o(99144);
                            return;
                        }
                }
                AppMethodBeat.o(99144);
            }
        });
        AppMethodBeat.o(99167);
    }

    static /* synthetic */ void a(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI, SnsInfo snsInfo, String str) {
        AppMethodBeat.i(99168);
        if (str == null || str.trim().equals("")) {
            AppMethodBeat.o(99168);
            return;
        }
        aq.a.a(snsStrangerCommentDetailUI.talker, 3, str, snsInfo, snsStrangerCommentDetailUI.source);
        AppMethodBeat.o(99168);
    }
}

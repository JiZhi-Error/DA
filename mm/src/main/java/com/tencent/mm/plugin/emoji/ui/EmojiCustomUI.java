package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.c.e;
import com.tencent.mm.av.a.c.n;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.emoji.sync.f;
import com.tencent.mm.g.a.rj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.HeaderGridView;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.b.b;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import kotlin.g.b.p;

public class EmojiCustomUI extends MMActivity implements AdapterView.OnItemClickListener, i {
    private static n jbT = new n() {
        /* class com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.AnonymousClass17 */

        @Override // com.tencent.mm.av.a.c.n
        public final Bitmap aq(byte[] bArr) {
            AppMethodBeat.i(108876);
            Bitmap bF = com.tencent.mm.plugin.gif.i.bF(bArr);
            AppMethodBeat.o(108876);
            return bF;
        }

        @Override // com.tencent.mm.av.a.c.n
        public final Bitmap Pb(String str) {
            AppMethodBeat.i(108877);
            Bitmap bF = com.tencent.mm.plugin.gif.i.bF(s.aW(str, 0, -1));
            AppMethodBeat.o(108877);
            return bF;
        }
    };
    private static e rfY = new e() {
        /* class com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.AnonymousClass16 */

        @Override // com.tencent.mm.av.a.c.e
        public final byte[] i(Object... objArr) {
            Object obj;
            AppMethodBeat.i(108875);
            if (objArr == null || objArr.length <= 0 || (obj = objArr[0]) == null || !(obj instanceof EmojiInfo)) {
                AppMethodBeat.o(108875);
                return null;
            }
            byte[] a2 = com.tencent.mm.emoji.decode.a.aum().a((EmojiInfo) obj);
            AppMethodBeat.o(108875);
            return a2;
        }
    };
    private ProgressDialog jZH;
    private MMHandler mHandler = new MMHandler() {
        /* class com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.AnonymousClass18 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(108878);
            switch (message.what) {
                case 1001:
                    EmojiCustomUI.h(EmojiCustomUI.this);
                    AppMethodBeat.o(108878);
                    return;
                case 1002:
                    if (!NetStatusUtil.isWifi(EmojiCustomUI.this)) {
                        if (EmojiCustomUI.this.rfS.hcS == EmojiSyncManager.b.Syncing) {
                            EmojiCustomUI.a(EmojiCustomUI.this, true);
                            AppMethodBeat.o(108878);
                            return;
                        }
                        EmojiCustomUI.a(EmojiCustomUI.this, false);
                        AppMethodBeat.o(108878);
                        return;
                    }
                    break;
                case 1003:
                    EmojiCustomUI.this.rfJ.setVisibility(8);
                    EmojiCustomUI.this.rfD.notifyDataSetChanged();
                    AppMethodBeat.o(108878);
                    return;
                case 1004:
                    if (EmojiCustomUI.this.rfD != null) {
                        EmojiCustomUI.this.rfD.cHq();
                        EmojiCustomUI.this.rfD.notifyDataSetChanged();
                    }
                    EmojiCustomUI.cHo();
                    AppMethodBeat.o(108878);
                    return;
                default:
                    Log.e("MicroMsg.emoji.EmojiCustomUI", "unknow Msg");
                    break;
            }
            AppMethodBeat.o(108878);
        }
    };
    private c rfC = c.NORMAL;
    private b rfD;
    private HeaderGridView rfE;
    private View rfF;
    private Button rfG;
    private Button rfH;
    private EmojiSyncManager.b rfI = EmojiSyncManager.b.Init;
    private View rfJ;
    private TextView rfK;
    private Button rfL;
    private boolean rfM = false;
    private boolean rfN = false;
    private boolean rfO = false;
    private a rfP = a.EMPTY;
    private ArrayList<String> rfQ = new ArrayList<>();
    private int rfR = 0;
    private EmojiSyncManager rfS;
    private View.OnClickListener rfT = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(108859);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiCustomUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            switch (AnonymousClass11.rgd[EmojiCustomUI.this.rfP.ordinal()]) {
                case 2:
                    EmojiCustomUI.b(EmojiCustomUI.this);
                    break;
                case 3:
                    EmojiCustomUI.this.rfS.stop();
                    break;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiCustomUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(108859);
        }
    };
    private View.OnClickListener rfU = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.AnonymousClass12 */

        public final void onClick(View view) {
            AppMethodBeat.i(108870);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiCustomUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            EmojiCustomUI.d(EmojiCustomUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiCustomUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(108870);
        }
    };
    private View.OnClickListener rfV = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.AnonymousClass13 */

        public final void onClick(View view) {
            AppMethodBeat.i(108871);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiCustomUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            EmojiCustomUI.e(EmojiCustomUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiCustomUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(108871);
        }
    };
    private final MStorage.IOnStorageChange rfW = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.AnonymousClass14 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(108872);
            if (!Util.isNullOrNil(str) && ((str.length() == 32 || str.equals("event_update_emoji")) && EmojiCustomUI.this.rfD != null)) {
                EmojiCustomUI.this.rfD.cHq();
                EmojiCustomUI.this.rfD.notifyDataSetChanged();
            }
            AppMethodBeat.o(108872);
        }
    };
    private final f rfX = new f() {
        /* class com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.AnonymousClass15 */

        @Override // com.tencent.mm.emoji.sync.f
        public final void awp() {
            AppMethodBeat.i(108873);
            if (EmojiCustomUI.this.mHandler != null) {
                EmojiCustomUI.this.mHandler.sendEmptyMessage(1002);
            }
            AppMethodBeat.o(108873);
        }

        @Override // com.tencent.mm.emoji.sync.f
        public final void a(EmojiSyncManager.b bVar) {
            AppMethodBeat.i(108874);
            EmojiCustomUI.this.rfI = bVar;
            if (EmojiCustomUI.this.mHandler != null) {
                EmojiCustomUI.this.mHandler.sendEmptyMessage(1001);
            }
            AppMethodBeat.o(108874);
        }
    };
    private EmojiInfo rfZ;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiCustomUI() {
        AppMethodBeat.i(108895);
        AppMethodBeat.o(108895);
    }

    static /* synthetic */ void a(EmojiCustomUI emojiCustomUI, c cVar) {
        AppMethodBeat.i(108924);
        emojiCustomUI.a(cVar);
        AppMethodBeat.o(108924);
    }

    static /* synthetic */ void a(EmojiCustomUI emojiCustomUI, boolean z) {
        AppMethodBeat.i(108922);
        emojiCustomUI.ls(z);
        AppMethodBeat.o(108922);
    }

    /* access modifiers changed from: package-private */
    public enum c {
        NORMAL,
        EDIT,
        SYNCING,
        WITH_OUT_ADD;

        public static c valueOf(String str) {
            AppMethodBeat.i(108892);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(108892);
            return cVar;
        }

        static {
            AppMethodBeat.i(108893);
            AppMethodBeat.o(108893);
        }
    }

    /* access modifiers changed from: package-private */
    public enum a {
        START,
        PAUSE,
        EMPTY;

        public static a valueOf(String str) {
            AppMethodBeat.i(108880);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(108880);
            return aVar;
        }

        static {
            AppMethodBeat.i(108881);
            AppMethodBeat.o(108881);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void a(a aVar) {
        AppMethodBeat.i(108896);
        Log.i("MicroMsg.emoji.EmojiCustomUI", "dz[updateButtonType,button type:%s]", aVar.toString());
        this.rfP = aVar;
        switch (aVar) {
            case EMPTY:
                this.rfL.setVisibility(4);
                AppMethodBeat.o(108896);
                return;
            case START:
                this.rfL.setVisibility(0);
                this.rfL.setText(R.string.bwa);
                AppMethodBeat.o(108896);
                return;
            case PAUSE:
                this.rfL.setVisibility(0);
                this.rfL.setText(R.string.bwb);
                break;
        }
        AppMethodBeat.o(108896);
    }

    static {
        AppMethodBeat.i(108926);
        AppMethodBeat.o(108926);
    }

    private void ls(boolean z) {
        int i2;
        AppMethodBeat.i(108897);
        int size = this.rfS.hcT.size();
        int i3 = this.rfS.cnR;
        if (size != i3 || z) {
            if (i3 == 0) {
                i2 = size;
            } else {
                i2 = 0;
            }
            int i4 = i3 + i2;
            this.rfK.setText(String.format(getString(z ? R.string.bwf : R.string.bw9), Integer.valueOf(i4 - size), Integer.valueOf(i4)));
            AppMethodBeat.o(108897);
            return;
        }
        this.rfK.setText(R.string.bwd);
        AppMethodBeat.o(108897);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean booleanValue;
        AppMethodBeat.i(108898);
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        this.rfR = getIntent().getIntExtra("key_emoji_panel_type", this.rfR);
        if (this.rfR == 1) {
            EmojiSyncManager.a aVar = EmojiSyncManager.hda;
            this.rfS = EmojiSyncManager.a.awo();
        } else {
            EmojiSyncManager.a aVar2 = EmojiSyncManager.hda;
            this.rfS = EmojiSyncManager.a.awn();
        }
        this.rfD = new b(this.rfR);
        this.rfD.cHq();
        initView();
        a(c.NORMAL);
        if (this.rfR == 1) {
            booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_EMOJI_SYNC_CAPTURE_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE)).booleanValue();
        } else {
            booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE)).booleanValue();
        }
        Log.i("MicroMsg.emoji.EmojiCustomUI", "[cpan] touch batch emoji download from EmojiCustomUI needDownload:%b", Boolean.valueOf(booleanValue));
        if (booleanValue) {
            g.aAg().hqi.a(new com.tencent.mm.plugin.emoji.f.e(this.rfR), 0);
        }
        k.getEmojiStorageMgr().OpN.add(this.rfW);
        h.INSTANCE.idkeyStat(406, 9, 1, false);
        h.INSTANCE.idkeyStat(406, 11, System.currentTimeMillis() - currentTimeMillis, false);
        h.INSTANCE.a(12740, 4, "", "", "", 28, 28);
        EmojiSyncManager emojiSyncManager = this.rfS;
        f fVar = this.rfX;
        p.h(fVar, "callback");
        com.tencent.mm.ac.d.h(new EmojiSyncManager.e(emojiSyncManager, fVar));
        this.rfS.eg(true);
        com.tencent.mm.emoji.b.k kVar = com.tencent.mm.emoji.b.k.gXr;
        com.tencent.mm.emoji.b.k.auS();
        this.rfI = this.rfS.hcS;
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(1001);
        }
        AppMethodBeat.o(108898);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(108899);
        super.onResume();
        cHl();
        g.aAg().hqi.a(698, this);
        AppMethodBeat.o(108899);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(108900);
        super.onPause();
        g.aAg().hqi.b(698, this);
        AppMethodBeat.o(108900);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(108901);
        super.onDestroy();
        k.getEmojiStorageMgr().OpN.remove(this.rfW);
        k.cGg().rds.mIsForeground = false;
        BKGLoaderManager bKGLoaderManager = k.cGg().rds;
        if (bKGLoaderManager.rdD) {
            bKGLoaderManager.rdD = false;
        }
        EmojiSyncManager emojiSyncManager = this.rfS;
        f fVar = this.rfX;
        p.h(fVar, "callback");
        com.tencent.mm.ac.d.h(new EmojiSyncManager.h(emojiSyncManager, fVar));
        this.mHandler.removeCallbacksAndMessages(null);
        AppMethodBeat.o(108901);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a1p;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(108902);
        this.rfJ = getLayoutInflater().inflate(R.layout.a1r, (ViewGroup) null);
        this.rfK = (TextView) this.rfJ.findViewById(R.id.ifo);
        this.rfL = (Button) this.rfJ.findViewById(R.id.ifn);
        this.rfL.setOnClickListener(this.rfT);
        this.rfE = (HeaderGridView) findViewById(R.id.hmf);
        HeaderGridView headerGridView = this.rfE;
        View view = this.rfJ;
        ListAdapter adapter = headerGridView.getAdapter();
        if (adapter == null || (adapter instanceof HeaderGridView.c)) {
            HeaderGridView.a aVar = new HeaderGridView.a((byte) 0);
            HeaderGridView.b bVar = new HeaderGridView.b(headerGridView.getContext());
            bVar.addView(view);
            aVar.view = view;
            aVar.OOn = bVar;
            aVar.data = null;
            aVar.isSelectable = false;
            headerGridView.OOm.add(aVar);
            if (adapter != null) {
                ((HeaderGridView.c) adapter).mDataSetObservable.notifyChanged();
            }
            this.rfE.setAdapter$159aa965(this.rfD);
            this.rfE.setOnItemClickListener(this);
            this.rfE.setFocusableInTouchMode(false);
            this.rfF = findViewById(R.id.hme);
            this.rfG = (Button) findViewById(R.id.hmg);
            this.rfG.setOnClickListener(this.rfU);
            this.rfH = (Button) findViewById(R.id.hmh);
            this.rfH.setOnClickListener(this.rfV);
            AppMethodBeat.o(108902);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
        AppMethodBeat.o(108902);
        throw illegalStateException;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(108903);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiCustomUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        if (this.rfD != null) {
            int headerViewCount = i2 - (this.rfE.getHeaderViewCount() * 5);
            if (this.rfC == c.NORMAL && headerViewCount == 0) {
                if (1 == this.rfR) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiCustomUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(108903);
                    return;
                } else if (!g.aAh().isSDCardAvailable()) {
                    u.g(this, null);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiCustomUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(108903);
                    return;
                } else {
                    if (this.rfD.getRealCount() >= com.tencent.mm.emoji.b.n.auY()) {
                        com.tencent.mm.ui.base.h.d(this, getString(R.string.bwq), "", new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.AnonymousClass19 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                    } else {
                        com.tencent.mm.pluginsdk.ui.tools.s.aZ(this);
                    }
                    h.INSTANCE.a(11596, 0);
                }
            }
            if (this.rfC == c.EDIT && headerViewCount < this.rfD.getRealCount()) {
                EmojiInfo FY = this.rfD.FY(headerViewCount);
                d dVar = null;
                if (view != null) {
                    dVar = (d) view.getTag();
                }
                if (FY.field_catalog == EmojiGroupInfo.VkO) {
                    com.tencent.mm.ui.base.h.n(getContext(), R.string.axy, R.string.axy).show();
                } else if (!this.rfQ.contains(FY.getMd5())) {
                    String md5 = FY.getMd5();
                    if (this.rfQ != null) {
                        this.rfQ.add(md5);
                    }
                    if (dVar != null) {
                        dVar.rgq.setChecked(true);
                    }
                    Log.i("MicroMsg.emoji.EmojiCustomUI", "selected md5:%s", FY.getMd5());
                } else {
                    String md52 = FY.getMd5();
                    if (this.rfQ != null) {
                        this.rfQ.remove(md52);
                    }
                    if (dVar != null) {
                        dVar.rgq.setChecked(false);
                        this.rfD.notifyDataSetChanged();
                    }
                    Log.i("MicroMsg.emoji.EmojiCustomUI", "unselected md5:%s", FY.getMd5());
                }
                cHj();
                if (dVar == null) {
                    this.rfD.notifyDataSetChanged();
                }
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiCustomUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(108903);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(108904);
        Log.d("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: requestCode[%d],resultCode:[%d]", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 == -1) {
            switch (i2) {
                case 205:
                    if (intent == null) {
                        AppMethodBeat.o(108904);
                        return;
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 3);
                    com.tencent.mm.emoji.e.a aVar = com.tencent.mm.emoji.e.a.hdT;
                    intent2.putExtra("CropImage_OutputPath", com.tencent.mm.emoji.e.a.awt());
                    com.tencent.mm.plugin.emoji.c.jRt.a(intent2, 206, this, intent);
                    AppMethodBeat.o(108904);
                    return;
                case 206:
                    if (intent == null) {
                        Log.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult MAT_IMAGE_IN_CROP_ACTIVITY return null.");
                        AppMethodBeat.o(108904);
                        return;
                    }
                    String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    final int intExtra = intent.getIntExtra("emoji_type", 0);
                    if (stringExtra == null || stringExtra.length() <= 0) {
                        AppMethodBeat.o(108904);
                        return;
                    }
                    final String substring = stringExtra.substring(stringExtra.lastIndexOf(47) + 1);
                    StringBuilder sb = new StringBuilder();
                    com.tencent.mm.emoji.e.a aVar2 = com.tencent.mm.emoji.e.a.hdT;
                    String sb2 = sb.append(com.tencent.mm.emoji.e.a.awt()).append(substring).toString();
                    this.rfZ = k.getEmojiStorageMgr().OpN.blk(substring);
                    com.tencent.mm.ui.tools.b.b bnW = com.tencent.mm.ui.tools.b.b.bnW(sb2);
                    bnW.mSize = com.tencent.mm.n.c.aqn();
                    bnW.aop(com.tencent.mm.n.c.aqo()).a(new b.a() {
                        /* class com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.tools.b.b.a
                        public final void a(com.tencent.mm.ui.tools.b.b bVar) {
                            AppMethodBeat.i(108860);
                            if (EmojiCustomUI.this.rfZ == null) {
                                if (intExtra == 0) {
                                    EmojiCustomUI.this.rfZ = k.getEmojiStorageMgr().OpN.d(substring, "", EmojiGroupInfo.VkQ, EmojiInfo.VkX, bVar.QxG, "");
                                } else {
                                    EmojiCustomUI.this.rfZ = k.getEmojiStorageMgr().OpN.d(substring, "", EmojiGroupInfo.VkQ, EmojiInfo.VkY, bVar.QxG, "");
                                }
                            }
                            k.cGf().a(EmojiCustomUI.this.getContext(), EmojiCustomUI.this.rfZ, 1, z.aTY());
                            if (EmojiCustomUI.this.rfD != null) {
                                EmojiCustomUI.this.rfD.cHq();
                                EmojiCustomUI.this.rfD.notifyDataSetChanged();
                            }
                            AppMethodBeat.o(108860);
                        }

                        @Override // com.tencent.mm.ui.tools.b.b.a
                        public final void cHf() {
                            AppMethodBeat.i(108861);
                            com.tencent.mm.ui.base.h.a((Context) EmojiCustomUI.this.getContext(), EmojiCustomUI.this.getContext().getString(R.string.bs2), "", EmojiCustomUI.this.getContext().getString(R.string.e2u), false, (DialogInterface.OnClickListener) null);
                            AppMethodBeat.o(108861);
                        }
                    });
                    AppMethodBeat.o(108904);
                    return;
                case 214:
                    if (this.rfD != null) {
                        this.rfD.cHq();
                        this.rfD.notifyDataSetChanged();
                        AppMethodBeat.o(108904);
                        return;
                    }
                    break;
                default:
                    Log.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: not found this requestCode");
                    AppMethodBeat.o(108904);
                    return;
            }
        }
        AppMethodBeat.o(108904);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(108905);
        if (this.rfC == c.EDIT) {
            a(c.NORMAL);
            AppMethodBeat.o(108905);
            return;
        }
        super.onBackPressed();
        AppMethodBeat.o(108905);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void a(c cVar) {
        AppMethodBeat.i(108906);
        long currentTimeMillis = System.currentTimeMillis();
        this.rfC = cVar;
        switch (cVar) {
            case NORMAL:
                setBackBtn(new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.AnonymousClass3 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(108862);
                        EmojiCustomUI.this.finish();
                        AppMethodBeat.o(108862);
                        return true;
                    }
                });
                enableBackMenu(true);
                addTextOptionMenu(0, getString(R.string.bu3), new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.AnonymousClass4 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(108863);
                        EmojiCustomUI.a(EmojiCustomUI.this, c.EDIT);
                        h.INSTANCE.a(11596, 1);
                        AppMethodBeat.o(108863);
                        return true;
                    }
                });
                this.rfF.setVisibility(8);
                cHl();
                cHh();
                cHi();
                break;
            case EDIT:
                setBackBtn(new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.AnonymousClass5 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(108864);
                        EmojiCustomUI.a(EmojiCustomUI.this, c.NORMAL);
                        AppMethodBeat.o(108864);
                        return true;
                    }
                });
                addTextOptionMenu(0, getString(R.string.vl), new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.AnonymousClass6 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(108865);
                        EmojiCustomUI.a(EmojiCustomUI.this, c.NORMAL);
                        AppMethodBeat.o(108865);
                        return true;
                    }
                });
                this.rfF.setVisibility(0);
                cHk();
                cHj();
                cHi();
                break;
            case SYNCING:
                cHi();
                break;
            case WITH_OUT_ADD:
                cHi();
                break;
        }
        if (this.rfD != null) {
            this.rfD.cHq();
            this.rfD.notifyDataSetChanged();
        }
        Log.d("MicroMsg.emoji.EmojiCustomUI", "updateMode use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(108906);
    }

    private void cHh() {
        AppMethodBeat.i(108907);
        if (this.rfQ != null) {
            this.rfQ.clear();
        }
        Log.i("MicroMsg.emoji.EmojiCustomUI", "clear md5 list. updateMode NORMAL");
        AppMethodBeat.o(108907);
    }

    private void cHi() {
        AppMethodBeat.i(108908);
        this.rfF.setVisibility(this.rfC == c.EDIT ? 0 : 8);
        AppMethodBeat.o(108908);
    }

    private void cHj() {
        AppMethodBeat.i(108909);
        if (this.rfC == c.EDIT) {
            int size = this.rfQ == null ? 0 : this.rfQ.size();
            if (size > 0) {
                this.rfG.setText(getResources().getString(R.string.tf));
                this.rfG.setEnabled(true);
                this.rfH.setEnabled(true);
            } else {
                this.rfG.setText(getResources().getString(R.string.tf));
                this.rfG.setEnabled(false);
                this.rfH.setEnabled(false);
            }
            setMMTitle(getResources().getString(R.string.bti, Integer.valueOf(size)));
        }
        AppMethodBeat.o(108909);
    }

    private boolean amX(String str) {
        AppMethodBeat.i(108910);
        com.tencent.mm.ui.base.h.c(getContext(), str, "", "", getString(R.string.e2u), null, null);
        AppMethodBeat.o(108910);
        return true;
    }

    private void cHk() {
        AppMethodBeat.i(108911);
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(1003, 0);
        }
        AppMethodBeat.o(108911);
    }

    private void cHl() {
        AppMethodBeat.i(108912);
        if (!NetStatusUtil.isConnected(this)) {
            cHk();
            AppMethodBeat.o(108912);
        } else if (cHm()) {
            AppMethodBeat.o(108912);
        } else {
            this.rfN = false;
            AppMethodBeat.o(108912);
        }
    }

    private boolean cHm() {
        AppMethodBeat.i(108913);
        if (this.rfD == null || this.rfD.getRealCount() <= com.tencent.mm.emoji.b.n.auY()) {
            AppMethodBeat.o(108913);
            return false;
        }
        this.rfM = true;
        this.rfJ.setVisibility(0);
        cHn();
        this.rfL.setVisibility(8);
        this.rfD.notifyDataSetChanged();
        enableOptionMenu(0, true);
        this.rfN = true;
        AppMethodBeat.o(108913);
        return true;
    }

    private void cHn() {
        AppMethodBeat.i(108914);
        this.rfK.setTextColor(getResources().getColor(R.color.a5c));
        this.rfK.setText(getString(R.string.bw7, new Object[]{Integer.valueOf(com.tencent.mm.emoji.b.n.auY())}));
        AppMethodBeat.o(108914);
    }

    /* access modifiers changed from: package-private */
    public class b extends BaseAdapter {
        private int hcW;
        private ArrayList<EmojiInfo> rcx;
        private Animation rgk;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(108890);
            EmojiInfo FY = FY(i2);
            AppMethodBeat.o(108890);
            return FY;
        }

        public b(int i2) {
            AppMethodBeat.i(108882);
            this.hcW = i2;
            this.rgk = AnimationUtils.loadAnimation(EmojiCustomUI.this, R.anim.e3);
            this.rgk.setInterpolator(new LinearInterpolator());
            AppMethodBeat.o(108882);
        }

        public final int getCount() {
            AppMethodBeat.i(108883);
            int realCount = getRealCount() + cHp();
            AppMethodBeat.o(108883);
            return realCount;
        }

        private int cHp() {
            AppMethodBeat.i(108884);
            if (getRealCount() <= 0 || (getRealCount() + 1) % 5 != 0) {
                AppMethodBeat.o(108884);
                return 2;
            }
            AppMethodBeat.o(108884);
            return 1;
        }

        public final int getRealCount() {
            AppMethodBeat.i(108885);
            if (this.rcx == null) {
                AppMethodBeat.o(108885);
                return 0;
            }
            int size = this.rcx.size();
            AppMethodBeat.o(108885);
            return size;
        }

        public final EmojiInfo FY(int i2) {
            AppMethodBeat.i(108886);
            if (i2 >= getRealCount()) {
                AppMethodBeat.o(108886);
                return null;
            } else if (this.rcx == null) {
                AppMethodBeat.o(108886);
                return null;
            } else {
                EmojiInfo emojiInfo = this.rcx.get(i2);
                AppMethodBeat.o(108886);
                return emojiInfo;
            }
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            d dVar;
            int i3;
            AppMethodBeat.i(108887);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(EmojiCustomUI.this.getContext()).inflate(R.layout.a1q, (ViewGroup) null);
                view.setVisibility(0);
                d dVar2 = new d(view);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                view.setVisibility(0);
                dVar = (d) view.getTag();
            }
            if (EmojiCustomUI.this.rfC == c.WITH_OUT_ADD || EmojiCustomUI.this.rfC == c.EDIT) {
                i3 = cHp();
            } else if (1 == this.hcW) {
                i3 = cHp();
            } else {
                i3 = cHp() - 1;
            }
            if (i2 < getCount() - i3) {
                if (i2 % 5 == 0) {
                    dVar.lJI.setBackgroundResource(R.drawable.emoji_grid_item_bottom);
                } else {
                    dVar.lJI.setBackgroundResource(R.drawable.emoji_grid_item_middle);
                }
            } else if (i2 == getCount() - i3) {
                dVar.lJI.setBackgroundResource(R.drawable.emoji_grid_item_left);
            } else {
                dVar.lJI.setBackgroundColor(0);
            }
            dVar.image.clearAnimation();
            dVar.image.setScaleType(ImageView.ScaleType.FIT_CENTER);
            switch (EmojiCustomUI.this.rfC) {
                case NORMAL:
                    if (i2 == (getCount() - cHp()) + 1) {
                        com.tencent.mm.emoji.loader.e eVar = com.tencent.mm.emoji.loader.e.gVM;
                        com.tencent.mm.emoji.loader.e.cl(dVar.image);
                        dVar.image.setImageBitmap(null);
                    } else if (i2 == 0) {
                        if (this.hcW == 0) {
                            com.tencent.mm.emoji.loader.e eVar2 = com.tencent.mm.emoji.loader.e.gVM;
                            com.tencent.mm.emoji.loader.e.cl(dVar.image);
                            dVar.image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                            dVar.image.setImageResource(R.raw.emoji_add);
                        } else if (i2 != getRealCount()) {
                            a(dVar.image, this.rcx.get(i2));
                        }
                    } else if (this.hcW == 0) {
                        a(dVar.image, this.rcx.get(i2 - 1));
                    } else if (i2 != getRealCount()) {
                        a(dVar.image, this.rcx.get(i2));
                    } else {
                        com.tencent.mm.emoji.loader.e eVar3 = com.tencent.mm.emoji.loader.e.gVM;
                        com.tencent.mm.emoji.loader.e.cl(dVar.image);
                        dVar.image.setImageBitmap(null);
                    }
                    dVar.rgq.setVisibility(8);
                    break;
                case EDIT:
                    if (i2 != (getCount() - cHp()) + 1) {
                        if (i2 != getRealCount()) {
                            EmojiInfo emojiInfo = this.rcx.get(i2);
                            a(dVar.image, emojiInfo);
                            if (emojiInfo.field_catalog != EmojiGroupInfo.VkO) {
                                dVar.rgq.setVisibility(0);
                                dVar.rgq.setChecked(EmojiCustomUI.this.rfQ.contains(emojiInfo.getMd5()));
                                break;
                            }
                        } else {
                            com.tencent.mm.emoji.loader.e eVar4 = com.tencent.mm.emoji.loader.e.gVM;
                            com.tencent.mm.emoji.loader.e.cl(dVar.image);
                            dVar.image.setImageBitmap(null);
                        }
                    } else {
                        com.tencent.mm.emoji.loader.e eVar5 = com.tencent.mm.emoji.loader.e.gVM;
                        com.tencent.mm.emoji.loader.e.cl(dVar.image);
                        dVar.image.setImageBitmap(null);
                    }
                    dVar.rgq.setVisibility(8);
                    break;
                case SYNCING:
                    if (i2 == (getCount() - cHp()) + 1) {
                        com.tencent.mm.emoji.loader.e eVar6 = com.tencent.mm.emoji.loader.e.gVM;
                        com.tencent.mm.emoji.loader.e.cl(dVar.image);
                        dVar.image.setImageBitmap(null);
                    } else if (i2 == getRealCount()) {
                        com.tencent.mm.emoji.loader.e eVar7 = com.tencent.mm.emoji.loader.e.gVM;
                        com.tencent.mm.emoji.loader.e.cl(dVar.image);
                        dVar.image.setImageResource(R.drawable.ap_);
                        dVar.image.startAnimation(this.rgk);
                    } else {
                        a(dVar.image, this.rcx.get(i2));
                    }
                    dVar.rgq.setVisibility(8);
                    break;
                case WITH_OUT_ADD:
                    if (i2 == (getCount() - cHp()) + 1) {
                        com.tencent.mm.emoji.loader.e eVar8 = com.tencent.mm.emoji.loader.e.gVM;
                        com.tencent.mm.emoji.loader.e.cl(dVar.image);
                        dVar.image.setImageBitmap(null);
                    } else if (i2 == getRealCount()) {
                        com.tencent.mm.emoji.loader.e eVar9 = com.tencent.mm.emoji.loader.e.gVM;
                        com.tencent.mm.emoji.loader.e.cl(dVar.image);
                        dVar.image.setImageBitmap(null);
                    } else {
                        a(dVar.image, this.rcx.get(i2));
                    }
                    dVar.rgq.setVisibility(8);
                    break;
            }
            AppMethodBeat.o(108887);
            return view;
        }

        public final boolean cHq() {
            AppMethodBeat.i(108888);
            if (!g.aAh().isSDCardAvailable()) {
                this.rcx = new ArrayList<>();
            } else if (this.hcW == 0) {
                this.rcx = j.auL().auO();
            } else {
                this.rcx = j.auL().dU(false);
            }
            if (EmojiCustomUI.this.rfC == c.EDIT) {
                EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(R.string.bti, new Object[]{Integer.valueOf(EmojiCustomUI.this.rfQ == null ? 0 : EmojiCustomUI.this.rfQ.size())}));
            } else if (this.hcW == 0) {
                EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(R.string.bs4, new Object[]{Integer.valueOf(this.rcx.size())}));
            } else {
                EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(R.string.brk, new Object[]{Integer.valueOf(this.rcx.size())}));
            }
            AppMethodBeat.o(108888);
            return true;
        }

        private static void a(ImageView imageView, EmojiInfo emojiInfo) {
            AppMethodBeat.i(108889);
            com.tencent.mm.emoji.loader.e eVar = com.tencent.mm.emoji.loader.e.gVM;
            com.tencent.mm.emoji.loader.e.a(emojiInfo, imageView);
            AppMethodBeat.o(108889);
        }
    }

    static class d {
        ImageView image;
        View lJI;
        CheckBox rgq;

        public d(View view) {
            AppMethodBeat.i(108894);
            this.lJI = view.findViewById(R.id.e1v);
            this.image = (ImageView) view.findViewById(R.id.dup);
            this.rgq = (CheckBox) view.findViewById(R.id.b0v);
            AppMethodBeat.o(108894);
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(108915);
        Log.i("MicroMsg.emoji.EmojiCustomUI", "errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (qVar instanceof com.tencent.mm.plugin.emoji.f.c) {
            switch (((com.tencent.mm.plugin.emoji.f.c) qVar).kfa) {
                case 2:
                    cGW();
                    if (i2 == 0 && i3 == 0) {
                        final ArrayList arrayList = new ArrayList(this.rfQ);
                        g.aAk().postToWorker(new Runnable() {
                            /* class com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.AnonymousClass9 */

                            public final void run() {
                                AppMethodBeat.i(108868);
                                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                    Log.i("MicroMsg.emoji.EmojiCustomUI", "delete md5List md5:%s", arrayList.get(i2));
                                    EmojiInfo blk = k.getEmojiStorageMgr().OpN.blk((String) arrayList.get(i2));
                                    h.INSTANCE.a(10613, arrayList.get(i2), blk.field_groupId, blk.field_designerID, blk.field_activityid);
                                }
                                AppMethodBeat.o(108868);
                            }
                        });
                        if (this.rfR == 0) {
                            j.auL().dW(true);
                            j.auL().dV(true);
                            com.tencent.mm.emoji.b.k kVar = com.tencent.mm.emoji.b.k.gXr;
                            com.tencent.mm.emoji.b.k.dZ(false);
                        } else {
                            j.auL().dY(true);
                            com.tencent.mm.emoji.b.k kVar2 = com.tencent.mm.emoji.b.k.gXr;
                            com.tencent.mm.emoji.b.k.ea(false);
                        }
                        k.getEmojiStorageMgr().OpN.I(this.rfQ, this.rfR);
                        cHh();
                        cHj();
                        this.mHandler.sendEmptyMessageDelayed(1004, 100);
                        AppMethodBeat.o(108915);
                        return;
                    }
                    Log.i("MicroMsg.emoji.EmojiCustomUI", "delete failed");
                    amX(getString(R.string.bwm));
                    AppMethodBeat.o(108915);
                    return;
                case 3:
                    cGW();
                    if (i2 != 0 || i3 != 0) {
                        amX(getString(R.string.bwm));
                        break;
                    } else {
                        if (this.rfR == 0) {
                            j.auL().dW(true);
                            j.auL().dV(true);
                        } else {
                            j.auL().dY(true);
                        }
                        k.getEmojiStorageMgr().OpN.x(this.rfR, this.rfQ);
                        cHh();
                        cHj();
                        this.mHandler.sendEmptyMessageDelayed(1004, 100);
                        AppMethodBeat.o(108915);
                        return;
                    }
            }
            AppMethodBeat.o(108915);
            return;
        }
        Log.w("MicroMsg.emoji.EmojiCustomUI", "no emoji operate");
        AppMethodBeat.o(108915);
    }

    private void amY(String str) {
        AppMethodBeat.i(108916);
        getString(R.string.zb);
        this.jZH = com.tencent.mm.ui.base.h.a((Context) this, str, true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.AnonymousClass10 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        AppMethodBeat.o(108916);
    }

    private void cGW() {
        AppMethodBeat.i(108917);
        if (this.jZH != null && this.jZH.isShowing()) {
            this.jZH.dismiss();
        }
        AppMethodBeat.o(108917);
    }

    static /* synthetic */ void b(EmojiCustomUI emojiCustomUI) {
        AppMethodBeat.i(108918);
        com.tencent.mm.ui.base.h.c(emojiCustomUI.getContext(), emojiCustomUI.getResources().getString(R.string.bwc), "", emojiCustomUI.getResources().getString(R.string.bwa), emojiCustomUI.getResources().getString(R.string.sz), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.AnonymousClass8 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(108867);
                EmojiCustomUI.this.rfS.start(true);
                h.INSTANCE.a(11595, 1, Integer.valueOf(EmojiCustomUI.this.rfR));
                AppMethodBeat.o(108867);
            }
        }, null);
        AppMethodBeat.o(108918);
    }

    static /* synthetic */ boolean d(EmojiCustomUI emojiCustomUI) {
        AppMethodBeat.i(108919);
        com.tencent.mm.ui.base.h.a(emojiCustomUI.getContext(), emojiCustomUI.getResources().getString(R.string.bs5), "", emojiCustomUI.getResources().getString(R.string.tf), emojiCustomUI.getResources().getString(R.string.sz), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.AnonymousClass7 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(108866);
                EmojiCustomUI.k(EmojiCustomUI.this);
                AppMethodBeat.o(108866);
            }
        }, (DialogInterface.OnClickListener) null, (int) R.color.a5f);
        AppMethodBeat.o(108919);
        return true;
    }

    static /* synthetic */ void e(EmojiCustomUI emojiCustomUI) {
        int size;
        AppMethodBeat.i(108920);
        Object[] objArr = new Object[1];
        if (emojiCustomUI.rfQ == null) {
            size = 0;
        } else {
            size = emojiCustomUI.rfQ.size();
        }
        objArr[0] = Integer.valueOf(size);
        Log.i("MicroMsg.emoji.EmojiCustomUI", "topCustom mSelectedList size:%d", objArr);
        if (emojiCustomUI.rfQ == null || emojiCustomUI.rfQ.size() <= 0) {
            Log.w("MicroMsg.emoji.EmojiCustomUI", "empty seleted list");
            AppMethodBeat.o(108920);
            return;
        }
        emojiCustomUI.amY(emojiCustomUI.getString(R.string.bwn));
        ArrayList<String> arrayList = emojiCustomUI.rfQ;
        Object[] objArr2 = new Object[1];
        objArr2[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
        Log.i("MicroMsg.emoji.EmojiCustomUI", "topSyncEmoji list size:%d", objArr2);
        if (arrayList == null || arrayList.size() <= 0) {
            Log.i("MicroMsg.emoji.EmojiCustomUI", "empty size.");
            AppMethodBeat.o(108920);
            return;
        }
        g.aAg().hqi.a(new com.tencent.mm.plugin.emoji.f.c(emojiCustomUI.rfR, 3, emojiCustomUI.rfQ), 0);
        AppMethodBeat.o(108920);
    }

    static /* synthetic */ void h(EmojiCustomUI emojiCustomUI) {
        AppMethodBeat.i(108921);
        Log.i("MicroMsg.emoji.EmojiCustomUI", "dz[updateSyncView status:%s]", emojiCustomUI.rfI.toString());
        if (emojiCustomUI.rfC == c.EDIT || emojiCustomUI.rfN) {
            AppMethodBeat.o(108921);
            return;
        }
        switch (emojiCustomUI.rfI) {
            case Init:
                emojiCustomUI.rfO = false;
                emojiCustomUI.enableOptionMenu(0, true);
                emojiCustomUI.cHk();
                emojiCustomUI.a(c.NORMAL);
                AppMethodBeat.o(108921);
                return;
            case Syncing:
                emojiCustomUI.enableOptionMenu(0, false);
                if (!NetStatusUtil.isWifi(emojiCustomUI)) {
                    emojiCustomUI.rfO = false;
                    emojiCustomUI.rfJ.setVisibility(0);
                    emojiCustomUI.a(a.PAUSE);
                    emojiCustomUI.ls(true);
                } else if (NetStatusUtil.isWifi(emojiCustomUI) && !emojiCustomUI.rfO) {
                    emojiCustomUI.rfO = true;
                    emojiCustomUI.cHk();
                    emojiCustomUI.a(a.EMPTY);
                }
                if (emojiCustomUI.rfC != c.SYNCING) {
                    emojiCustomUI.a(c.SYNCING);
                    AppMethodBeat.o(108921);
                    return;
                }
                break;
            case Wait:
                emojiCustomUI.rfO = false;
                emojiCustomUI.enableOptionMenu(0, false);
                if (emojiCustomUI.mHandler != null) {
                    emojiCustomUI.mHandler.removeMessages(1003);
                }
                emojiCustomUI.rfJ.setVisibility(0);
                emojiCustomUI.ls(false);
                emojiCustomUI.a(a.START);
                emojiCustomUI.a(c.WITH_OUT_ADD);
                AppMethodBeat.o(108921);
                return;
            case End:
                emojiCustomUI.rfO = false;
                emojiCustomUI.enableOptionMenu(0, true);
                emojiCustomUI.cHk();
                emojiCustomUI.a(c.NORMAL);
                break;
        }
        AppMethodBeat.o(108921);
    }

    static /* synthetic */ void cHo() {
        AppMethodBeat.i(108923);
        EventCenter.instance.publish(new rj());
        AppMethodBeat.o(108923);
    }

    static /* synthetic */ void k(EmojiCustomUI emojiCustomUI) {
        int size;
        AppMethodBeat.i(108925);
        Object[] objArr = new Object[1];
        if (emojiCustomUI.rfQ == null) {
            size = 0;
        } else {
            size = emojiCustomUI.rfQ.size();
        }
        objArr[0] = Integer.valueOf(size);
        Log.i("MicroMsg.emoji.EmojiCustomUI", "deleteEmoji mSelectedList size:%d", objArr);
        if (emojiCustomUI.rfQ == null || emojiCustomUI.rfQ.size() <= 0) {
            Log.w("MicroMsg.emoji.EmojiCustomUI", "empty seleted list");
            AppMethodBeat.o(108925);
            return;
        }
        emojiCustomUI.amY(emojiCustomUI.getString(R.string.bs8));
        ArrayList<String> arrayList = emojiCustomUI.rfQ;
        Object[] objArr2 = new Object[1];
        objArr2[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
        Log.i("MicroMsg.emoji.EmojiCustomUI", "deleteSyncEmoji list size:%d", objArr2);
        if (arrayList == null || arrayList.size() <= 0) {
            Log.i("MicroMsg.emoji.EmojiCustomUI", "empty size.");
        } else {
            g.aAg().hqi.a(new com.tencent.mm.plugin.emoji.f.c(emojiCustomUI.rfR, 2, emojiCustomUI.rfQ), 0);
        }
        Log.i("MicroMsg.emoji.EmojiCustomUI", "touchBatchEmojiBackup over emoji size. need touch :%b", Boolean.valueOf(emojiCustomUI.rfM));
        if (emojiCustomUI.rfM) {
            emojiCustomUI.rfM = false;
            g.aAh().azQ().set(348162, Boolean.TRUE);
            com.tencent.mm.plugin.emoji.c.a.cFr();
        }
        emojiCustomUI.cHl();
        AppMethodBeat.o(108925);
    }
}

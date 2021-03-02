package com.tencent.mm.plugin.editor;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.as;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.editor.adapter.CollectEditorLinearLayoutManager;
import com.tencent.mm.plugin.editor.model.a.i;
import com.tencent.mm.plugin.editor.model.a.l;
import com.tencent.mm.plugin.editor.model.a.m;
import com.tencent.mm.plugin.editor.model.nativenote.c.e;
import com.tencent.mm.plugin.editor.model.nativenote.c.f;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.editor.model.nativenote.manager.d;
import com.tencent.mm.plugin.editor.model.nativenote.manager.e;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;
import com.tencent.mm.plugin.editor.model.nativenote.spans.u;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.imageview.WeImageButton;
import com.tencent.mm.vfs.o;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class EditorUI extends MMActivity implements com.tencent.mm.plugin.editor.model.nativenote.a, com.tencent.mm.plugin.editor.model.nativenote.b.a, d.a {
    private g.a iZc = new g.a() {
        /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass19 */

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, c cVar, com.tencent.mm.i.d dVar, boolean z) {
            AppMethodBeat.i(181537);
            if (i2 != 0) {
                Log.e("MicroMsg.EditorUI", "transfer err! startRet: %s.", Integer.valueOf(i2));
                AppMethodBeat.o(181537);
                return 0;
            }
            com.tencent.mm.plugin.fav.a.c cVar2 = (com.tencent.mm.plugin.fav.a.c) EditorUI.this.qNV.get(str);
            if (cVar2 == null) {
                Log.e("MicroMsg.EditorUI", "cdn info is null!!!");
                AppMethodBeat.o(181537);
                return 0;
            }
            aml aml = (aml) EditorUI.this.qNW.get(str);
            if (aml == null) {
                Log.e("MicroMsg.EditorUI", "data item is null!!!");
                AppMethodBeat.o(181537);
                return 0;
            }
            if (dVar != null && dVar.field_retCode >= 0) {
                if (1 == cVar2.field_type) {
                    String str2 = cVar2.field_path + ".temp";
                    String str3 = cVar2.field_path;
                    int i3 = cVar2.field_dataType;
                    if (!(str2 == null || str3 == null)) {
                        if (i3 != -2 || EditorUI.alH(str2) || !EditorUI.fI(str2, str3)) {
                            o oVar = new o(str2);
                            o oVar2 = new o(str3);
                            if (oVar.exists()) {
                                Log.i("MicroMsg.EditorUI", "rename file suc:%b, old:%s, new:%s", Boolean.valueOf(oVar.am(oVar2)), str2, oVar2);
                            }
                        } else {
                            Log.i("MicroMsg.EditorUI", "renameAndCopyFile write amr head ok!");
                        }
                    }
                } else {
                    cVar2.field_cdnKey = dVar.field_aesKey;
                    cVar2.field_cdnUrl = dVar.field_fileId;
                }
                if (str.endsWith("_t")) {
                    aml.bgi(cVar2.field_cdnKey);
                    aml.bgh(cVar2.field_cdnUrl);
                } else {
                    aml.bgk(cVar2.field_cdnKey);
                    aml.bgj(cVar2.field_cdnUrl);
                    if (cVar2.field_type == 0 && cVar2.cUr()) {
                        Log.i("MicroMsg.EditorUI", "video stream, id:%s", dVar.field_videoFileId);
                        aml.bgy(dVar.field_videoFileId);
                    }
                }
                EditorUI.this.qNV.remove(cVar2.field_dataId);
                Log.i("MicroMsg.EditorUI", "transfer done, mediaId=%s completeResult.mediaId=%s aesKey=%s completeInfo=%s", str, dVar.mediaId, dVar.field_aesKey, dVar.toString());
                if (1 == cVar2.field_type) {
                    EditorUI.u(EditorUI.this);
                } else {
                    EditorUI.v(EditorUI.this);
                }
            }
            AppMethodBeat.o(181537);
            return 0;
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            return null;
        }
    };
    private MMHandler kAn;
    private float liD;
    private float liE;
    ProgressDialog pqa;
    private a qNA;
    private LinearLayout qNB;
    com.tencent.mm.plugin.editor.widget.a qNC;
    private LinearLayout qND;
    private RelativeLayout qNE;
    private d qNF;
    private j qNG;
    private boolean qNH = true;
    private int qNI;
    private RecyclerView.l qNJ;
    private boolean qNK;
    private boolean qNL;
    private boolean qNM;
    private String qNN;
    private boolean qNO;
    private int qNP = -1;
    private boolean qNQ;
    private aml qNR;
    View.OnTouchListener qNS = new View.OnTouchListener() {
        /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass14 */

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(181531);
            if (motionEvent.getAction() == 0) {
                EditorUI.this.liD = motionEvent.getX();
                EditorUI.this.liE = motionEvent.getY();
            }
            if (motionEvent.getAction() == 1 && EditorUI.this.qNx.o(motionEvent.getX(), motionEvent.getY()) == null) {
                float abs = Math.abs(EditorUI.this.liD - motionEvent.getX());
                float abs2 = Math.abs(EditorUI.this.liE - motionEvent.getY());
                if (abs < 30.0f && abs2 < 30.0f) {
                    if (EditorUI.this.qNE.getVisibility() != 8) {
                        if (EditorUI.this.qNF != null) {
                            EditorUI.this.qNF.qQv.dismiss();
                        }
                        EditorUI.this.qNE.setVisibility(8);
                    } else {
                        int size = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().size();
                        com.tencent.mm.plugin.editor.model.a.a Fw = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().Fw(size - 1);
                        if (Fw != null) {
                            boolean z = Fw.qPA;
                            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDr();
                            Fw.qPA = true;
                            Fw.qPG = false;
                            Fw.qPC = -1;
                            EditorUI.this.qNy.ci(size - 1);
                            EditorUI.this.e(true, 50);
                            EditorUI.this.Q(1, 0);
                            if (EditorUI.this.qNH && z) {
                                EditorUI.this.kAn.postDelayed(new Runnable() {
                                    /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass14.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(181530);
                                        e.cDT().ln(true);
                                        e.cDT().lm(true);
                                        AppMethodBeat.o(181530);
                                    }
                                }, 100);
                            }
                        }
                    }
                }
            } else if (motionEvent.getAction() == 2) {
                float abs3 = Math.abs(EditorUI.this.liD - motionEvent.getX());
                float abs4 = Math.abs(EditorUI.this.liE - motionEvent.getY());
                if (abs3 > 120.0f || abs4 > 120.0f) {
                    if (EditorUI.this.qNH) {
                        if (e.cDT().getSelectType() == 1) {
                            EditorUI.this.cCD();
                            e.cDT().cDY();
                        }
                    } else if (!EditorUI.this.qNK) {
                        EditorUI.this.cCD();
                    }
                }
            }
            AppMethodBeat.o(181531);
            return false;
        }
    };
    com.tencent.mm.plugin.fav.a.g qNT;
    LinkedList<aml> qNU = new LinkedList<>();
    private ConcurrentHashMap<String, com.tencent.mm.plugin.fav.a.c> qNV = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, aml> qNW = new ConcurrentHashMap<>();
    private boolean qNw = false;
    private RecyclerView qNx;
    private com.tencent.mm.plugin.editor.adapter.b qNy;
    private CollectEditorLinearLayoutManager qNz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EditorUI() {
        AppMethodBeat.i(181554);
        AppMethodBeat.o(181554);
    }

    static /* synthetic */ void u(EditorUI editorUI) {
        AppMethodBeat.i(181613);
        editorUI.cCR();
        AppMethodBeat.o(181613);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a11;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(181555);
        customfixStatusbar(true);
        com.tencent.mm.plugin.editor.model.nativenote.manager.c cDo = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo();
        cDo.mDataList = new ArrayList<>();
        cDo.qQp = this;
        cDo.qQq = new aml();
        cDo.qQr = 0;
        cDo.qQs = 0;
        cDo.qQt = 0;
        super.onCreate(bundle);
        this.qNM = getIntent().getBooleanExtra("KEY_EDITABLE", false);
        this.qNN = getIntent().getStringExtra("KEY_CONTENT_XML");
        if (Util.isNullOrNil(this.qNN)) {
            this.qNN = "";
            this.qNw = false;
        }
        Log.i("MicroMsg.EditorUI", "mCollectEditable: %s, mCollectContentXml: %s", Boolean.valueOf(this.qNM), this.qNN);
        this.kAn = new MMHandler();
        initView();
        this.qNI = com.tencent.mm.cb.a.fromDPToPix((Context) this, 48);
        if (this.qNH) {
            Log.i("MicroMsg.EditorUI", "use multiselect");
            int color = getResources().getColor(R.color.mk);
            e cDT = e.cDT();
            boolean z = this.qNM;
            Log.i("EditorSelectManager", "onInit start");
            cDT.qSq = z;
            cDT.qSt = 14;
            cDT.qSu = 32;
            cDT.qSv = com.tencent.mm.cb.a.fromDPToPix((Context) this, 21) - cDT.qSu;
            cDT.qSw = com.tencent.mm.cb.a.fromDPToPix((Context) this, 40) + (cDT.qSu * 2);
            cDT.qSx = com.tencent.mm.cb.a.fromDPToPix((Context) this, 240) + (cDT.qSu * 2);
            cDT.qSr = com.tencent.mm.cb.a.fromDPToPix((Context) this, 22);
            cDT.qSs = com.tencent.mm.cb.a.fromDPToPix((Context) this, 1);
            cDT.mScreenHeight = getResources().getDisplayMetrics().heightPixels;
            cDT.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
            cDT.qSB = new int[]{-1, -1};
            cDT.qSC = new int[]{-1, -1};
            cDT.qSD = new int[]{-1, -1};
            cDT.qSE = new int[]{-1, -1};
            com.tencent.mm.plugin.editor.model.nativenote.c.a aVar = new com.tencent.mm.plugin.editor.model.nativenote.c.a(this, 2, cDT.qSr, cDT.qSs, color, cDT);
            cDT.qSF = new PopupWindow((View) aVar, aVar.getViewWidth(), aVar.getViewHeight(), false);
            cDT.qSF.setClippingEnabled(false);
            cDT.qSF.setAnimationStyle(R.style.a5n);
            cDT.qSz = aVar.getOffsetForCursorMid();
            cDT.qSA = com.tencent.mm.cb.a.fromDPToPix((Context) this, 6);
            com.tencent.mm.plugin.editor.model.nativenote.c.a aVar2 = new com.tencent.mm.plugin.editor.model.nativenote.c.a(this, 3, cDT.qSr, cDT.qSs, color, cDT);
            cDT.qSG = new PopupWindow((View) aVar2, aVar2.getViewWidth(), aVar.getViewHeight(), false);
            cDT.qSG.setClippingEnabled(false);
            cDT.qSG.setAnimationStyle(R.style.a5m);
            com.tencent.mm.plugin.editor.model.nativenote.c.a aVar3 = new com.tencent.mm.plugin.editor.model.nativenote.c.a(this, 4, cDT.qSr, cDT.qSs, color, cDT);
            cDT.qSH = new PopupWindow((View) aVar3, aVar3.getViewWidth(), aVar.getViewHeight(), false);
            cDT.qSH.setClippingEnabled(false);
            cDT.qSH.setAnimationStyle(R.style.a5o);
            View inflate = LayoutInflater.from(this).inflate(R.layout.a0z, (ViewGroup) null);
            inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            cDT.qSI = new PopupWindow(inflate, -2, -2, false);
            cDT.qSI.setBackgroundDrawable(getResources().getDrawable(R.drawable.coj));
            cDT.qSI.setClippingEnabled(false);
            cDT.qSI.setAnimationStyle(R.style.a5q);
            cDT.qSO = (TextView) inflate.findViewById(R.id.g13);
            cDT.qSP = (TextView) inflate.findViewById(R.id.g1v);
            cDT.qSQ = (TextView) inflate.findViewById(R.id.g1s);
            cDT.qSR = (TextView) inflate.findViewById(R.id.g1r);
            cDT.qSS = (TextView) inflate.findViewById(R.id.g1c);
            cDT.qST = (TextView) inflate.findViewById(R.id.g1b);
            cDT.qSU = (TextView) inflate.findViewById(R.id.g1a);
            cDT.qSV = (TextView) inflate.findViewById(R.id.g1n);
            e.i(cDT.qSO, cDT.qSt);
            e.i(cDT.qSP, cDT.qSt);
            e.i(cDT.qSQ, cDT.qSt);
            e.i(cDT.qSR, cDT.qSt);
            e.i(cDT.qSS, cDT.qSt);
            e.i(cDT.qST, cDT.qSt);
            e.i(cDT.qSU, cDT.qSt);
            e.i(cDT.qSV, cDT.qSt);
            cDT.qSO.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.editor.model.nativenote.c.e.AnonymousClass10 */

                public final void onClick(View view) {
                    AppMethodBeat.i(181861);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("EditorSelectManager", "bold");
                    e.this.cEa();
                    a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(181861);
                }
            });
            cDT.qSP.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.editor.model.nativenote.c.e.AnonymousClass11 */

                public final void onClick(View view) {
                    AppMethodBeat.i(181862);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("EditorSelectManager", "unbold");
                    e.this.cEa();
                    a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(181862);
                }
            });
            cDT.qSQ.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.editor.model.nativenote.c.e.AnonymousClass12 */

                public final void onClick(View view) {
                    com.tencent.mm.plugin.editor.model.a.a aVar = null;
                    AppMethodBeat.i(181863);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("EditorSelectManager", "select");
                    e.this.cEa();
                    if (!e.mHasInit) {
                        Log.e("EditorSelectManager", "select: not init");
                        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(181863);
                    } else if (e.this.getSelectType() != 1) {
                        Log.e("EditorSelectManager", "select: not insert");
                        e.h(e.this);
                        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(181863);
                    } else if (com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().Fw(e.this.qSK.bNu) == null) {
                        Log.e("EditorSelectManager", "select: item is null");
                        e.h(e.this);
                        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(181863);
                    } else {
                        RecyclerView a2 = e.a(e.this);
                        if (a2 == null) {
                            Log.e("EditorSelectManager", "select: recyclerView is null");
                            e.h(e.this);
                            a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(181863);
                            return;
                        }
                        c dG = f.dG(f.d(a2, e.this.qSK.bNu));
                        if (dG == null) {
                            Log.e("EditorSelectManager", "select: rteInfo is null");
                            e.h(e.this);
                            a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(181863);
                            return;
                        }
                        if (dG.qSl != null) {
                            Editable text = dG.qSl.getText();
                            if (text == null) {
                                Log.e("EditorSelectManager", "select: text is null");
                                e.h(e.this);
                                a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(181863);
                                return;
                            } else if (text.length() > 0) {
                                dG.qSl.ah(e.this.qSK.startOffset, true);
                            } else {
                                com.tencent.mm.plugin.editor.model.a.a Fw = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().Fw(e.this.qSK.bNu - 1);
                                if (Fw != null && Fw.getType() == -3) {
                                    Fw = null;
                                }
                                com.tencent.mm.plugin.editor.model.a.a Fw2 = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().Fw(e.this.qSK.bNu + 1);
                                if (Fw2 == null || Fw2.getType() != -2) {
                                    aVar = Fw2;
                                }
                                if (Fw != null) {
                                    if (Fw.getType() == 1) {
                                        Spanned alS = com.tencent.mm.plugin.editor.model.nativenote.a.a.alS(((com.tencent.mm.plugin.editor.model.a.j) Fw).content);
                                        if (alS == null) {
                                            Log.e("EditorSelectManager", "select: spanned is null");
                                            e.h(e.this);
                                            a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                            AppMethodBeat.o(181863);
                                            return;
                                        }
                                        e.this.B(e.this.qSK.bNu - 1, alS.length(), e.this.qSK.bNu, 0);
                                    } else {
                                        e.this.B(e.this.qSK.bNu - 1, 0, e.this.qSK.bNu, 0);
                                    }
                                } else if (aVar == null) {
                                    Log.e("EditorSelectManager", "select: no neighbor");
                                    e.h(e.this);
                                    a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(181863);
                                    return;
                                } else if (aVar.getType() == 1) {
                                    e.this.B(e.this.qSK.bNu, 0, e.this.qSK.bNu + 1, 0);
                                } else {
                                    e.this.B(e.this.qSK.bNu, 0, e.this.qSK.bNu + 1, 1);
                                }
                                e.e(e.this);
                                e.this.I(true, true);
                            }
                        } else if (dG.qSm == null || dG.qSn == null) {
                            Log.e("EditorSelectManager", "select: rteInfo invalid");
                            e.h(e.this);
                        } else {
                            e.e(e.this);
                            e.this.B(e.this.qSK.bNu, 0, e.this.qSK.bNu, 1);
                            e.this.I(true, true);
                        }
                        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(181863);
                    }
                }
            });
            cDT.qSR.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.editor.model.nativenote.c.e.AnonymousClass13 */

                public final void onClick(View view) {
                    int i2;
                    AppMethodBeat.i(181864);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("EditorSelectManager", "select all");
                    e.this.cEa();
                    if (!e.mHasInit) {
                        Log.e("EditorSelectManager", "select all: not init");
                        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(181864);
                        return;
                    }
                    int cDz = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDz();
                    int cDA = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDA();
                    com.tencent.mm.plugin.editor.model.a.a Fw = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().Fw(cDz);
                    com.tencent.mm.plugin.editor.model.a.a Fw2 = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().Fw(cDA);
                    if (Fw == null || Fw2 == null) {
                        Log.e("EditorSelectManager", "select all: item is null");
                        e.h(e.this);
                        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(181864);
                        return;
                    }
                    if (Fw2.getType() == 1) {
                        Spanned alS = com.tencent.mm.plugin.editor.model.nativenote.a.a.alS(((com.tencent.mm.plugin.editor.model.a.j) Fw2).content);
                        if (alS == null) {
                            Log.e("EditorSelectManager", "select all: spanned is null");
                            e.h(e.this);
                            a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(181864);
                            return;
                        }
                        i2 = alS.length();
                    } else {
                        i2 = 1;
                    }
                    e.e(e.this);
                    e.this.B(cDz, 0, cDA, i2);
                    e.this.cEc();
                    e.this.cEa();
                    e.j(e.this);
                    e.this.ln(false);
                    e.this.ll(false);
                    a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(181864);
                }
            });
            cDT.qSS.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.editor.model.nativenote.c.e.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(181853);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("EditorSelectManager", "delete");
                    if (!e.mHasInit || !e.this.qSq) {
                        Log.e("EditorSelectManager", "delete: not init or not editable");
                        e.this.cEa();
                        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(181853);
                    } else if (e.l(e.this)) {
                        if (e.this.qSJ != null) {
                            e.this.qSJ.cCz();
                        }
                        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(181853);
                    } else {
                        if (e.this.qSJ != null) {
                            e.this.qSJ.cCB();
                        } else {
                            e.this.cEi();
                        }
                        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(181853);
                    }
                }
            });
            cDT.qST.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.editor.model.nativenote.c.e.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(181854);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("EditorSelectManager", "cut");
                    if (!e.mHasInit || !e.this.qSq) {
                        Log.e("EditorSelectManager", "cut: not init or not editable");
                        e.this.cEa();
                        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(181854);
                    } else if (e.l(e.this)) {
                        if (e.this.qSJ != null) {
                            e.this.qSJ.cCz();
                        }
                        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(181854);
                    } else {
                        e.this.cEa();
                        int selectType = e.this.getSelectType();
                        if (selectType == 2) {
                            SpannableStringBuilder a2 = e.a(e.this, true, (ArrayList) null, "");
                            if (Util.isNullOrNil(a2)) {
                                Log.e("EditorSelectManager", "cut: selectedSpan is null or empty");
                                e.h(e.this);
                                a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(181854);
                                return;
                            }
                            com.tencent.mm.plugin.editor.model.a.j jVar = new com.tencent.mm.plugin.editor.model.a.j();
                            jVar.content = com.tencent.mm.plugin.editor.model.nativenote.a.b.a(a2);
                            jVar.qPC = -1;
                            jVar.qPA = false;
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(jVar);
                            com.tencent.mm.plugin.editor.model.nativenote.manager.b.c(MMApplicationContext.getContext(), arrayList);
                        } else if (selectType == 3) {
                            ArrayList b2 = e.b(e.this, true, null, "");
                            if (b2 == null || b2.size() <= 0) {
                                Log.e("EditorSelectManager", "cut: dataList is null or empty");
                                e.h(e.this);
                            } else {
                                com.tencent.mm.plugin.editor.model.nativenote.manager.b.c(MMApplicationContext.getContext(), b2);
                            }
                        } else {
                            Log.e("EditorSelectManager", "cut: not in select");
                            e.h(e.this);
                        }
                        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(181854);
                    }
                }
            });
            cDT.qSU.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.editor.model.nativenote.c.e.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(181855);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("EditorSelectManager", "copy");
                    if (!e.mHasInit) {
                        Log.e("EditorSelectManager", "copy: not init");
                        e.this.cEa();
                        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(181855);
                    } else if (e.l(e.this)) {
                        if (e.this.qSJ != null) {
                            e.this.qSJ.cCz();
                        }
                        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(181855);
                    } else {
                        e.this.cEa();
                        int selectType = e.this.getSelectType();
                        if (selectType == 2) {
                            SpannableStringBuilder a2 = e.a(e.this, false, (ArrayList) null, "");
                            if (Util.isNullOrNil(a2)) {
                                Log.e("EditorSelectManager", "copy: selectedSpan is null or empty");
                                e.h(e.this);
                                a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(181855);
                                return;
                            }
                            com.tencent.mm.plugin.editor.model.a.j jVar = new com.tencent.mm.plugin.editor.model.a.j();
                            jVar.content = com.tencent.mm.plugin.editor.model.nativenote.a.b.a(a2);
                            jVar.qPC = -1;
                            jVar.qPA = false;
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(jVar);
                            com.tencent.mm.plugin.editor.model.nativenote.manager.b.c(MMApplicationContext.getContext(), arrayList);
                        } else if (selectType == 3) {
                            ArrayList b2 = e.b(e.this, false, null, "");
                            if (b2 == null || b2.size() <= 0) {
                                Log.e("EditorSelectManager", "copy: dataList is null or empty");
                                e.h(e.this);
                            } else {
                                com.tencent.mm.plugin.editor.model.nativenote.manager.b.c(MMApplicationContext.getContext(), b2);
                            }
                        } else {
                            Log.e("EditorSelectManager", "copy: not in select");
                            e.h(e.this);
                        }
                        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(181855);
                    }
                }
            });
            cDT.qSV.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.editor.model.nativenote.c.e.AnonymousClass5 */

                public final void onClick(View view) {
                    ArrayList<com.tencent.mm.plugin.editor.model.a.a> arrayList;
                    String sb;
                    AppMethodBeat.i(181856);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("EditorSelectManager", "paste");
                    if (!e.mHasInit || !e.this.qSq) {
                        Log.e("EditorSelectManager", "paste: not init or not editable");
                        e.this.cEa();
                        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(181856);
                    } else if (e.l(e.this)) {
                        if (e.this.qSJ != null) {
                            e.this.qSJ.cCz();
                        }
                        a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(181856);
                    } else {
                        e.this.cEa();
                        String str = "";
                        MMApplicationContext.getContext();
                        int cDn = com.tencent.mm.plugin.editor.model.nativenote.manager.b.cDn();
                        if (cDn == 2) {
                            if (e.this.qSJ != null) {
                                MMApplicationContext.getContext();
                                if (com.tencent.mm.plugin.editor.model.nativenote.manager.b.cDm()) {
                                    e.this.qSJ.cCx();
                                    a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(181856);
                                    return;
                                }
                            }
                            try {
                                CharSequence text = ClipboardHelper.getText();
                                if (text instanceof Spanned) {
                                    sb = com.tencent.mm.plugin.editor.model.nativenote.a.b.a((Spanned) text);
                                } else {
                                    String charSequence = text.toString();
                                    StringBuilder sb2 = new StringBuilder();
                                    com.tencent.mm.plugin.editor.model.nativenote.a.b.a(charSequence, sb2, 0, charSequence.length());
                                    sb = sb2.toString();
                                }
                                if (Util.isNullOrNil(sb)) {
                                    sb = "";
                                }
                                com.tencent.mm.plugin.editor.model.nativenote.manager.b.clearData();
                                arrayList = null;
                                str = sb;
                            } catch (Exception e2) {
                                Log.e("EditorSelectManager", "get clipboard data error : ", e2);
                                e.h(e.this);
                                a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(181856);
                                return;
                            }
                        } else if (cDn == 3) {
                            ArrayList<com.tencent.mm.plugin.editor.model.a.a> cDk = com.tencent.mm.plugin.editor.model.nativenote.manager.b.cDk();
                            if (cDk.size() <= 0) {
                                Log.e("EditorSelectManager", "paste: tempDataList is null or empty");
                                e.h(e.this);
                                a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(181856);
                                return;
                            } else if (cDk.size() == 1 && cDk.get(0) != null && cDk.get(0).getType() == 1) {
                                arrayList = null;
                                str = ((com.tencent.mm.plugin.editor.model.a.j) cDk.get(0)).content;
                            } else {
                                arrayList = cDk;
                            }
                        } else {
                            Log.e("EditorSelectManager", "paste: no data");
                            e.h(e.this);
                            a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(181856);
                            return;
                        }
                        if (Util.isNullOrNil(str) && (arrayList == null || arrayList.size() == 0)) {
                            Log.e("EditorSelectManager", "paste: no useful data");
                            e.h(e.this);
                            a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(181856);
                        } else if (e.this.qSJ == null || !e.a(e.this, arrayList, str)) {
                            int selectType = e.this.getSelectType();
                            if (selectType == 1 || selectType == 2) {
                                e.a(e.this, true, (ArrayList) arrayList, str);
                            } else if (selectType == 3) {
                                e.b(e.this, true, arrayList, str);
                            } else {
                                Log.e("EditorSelectManager", "paste: invalid selection");
                                e.h(e.this);
                            }
                            a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(181856);
                        } else {
                            e.this.qSJ.cCx();
                            a.a(this, "com/tencent/mm/plugin/editor/model/nativenote/multiselect/EditorSelectManager$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(181856);
                        }
                    }
                }
            });
            cDT.qSy = aVar.getViewPadding();
            cDT.qSJ = this;
            cDT.qSK = new com.tencent.mm.plugin.editor.model.nativenote.c.d();
            cDT.qSL = new com.tencent.mm.plugin.editor.model.nativenote.c.b();
            cDT.mHandler = new MMHandler();
            e.mHasInit = true;
            Log.i("EditorSelectManager", "onInit end");
            this.qNJ = new RecyclerView.l() {
                /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass16 */

                @Override // android.support.v7.widget.RecyclerView.l
                public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                    AppMethodBeat.i(181533);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(recyclerView);
                    bVar.pH(i2);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/EditorUI$24", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                    super.onScrollStateChanged(recyclerView, i2);
                    switch (i2) {
                        case 0:
                            e.cDT().ln(e.cDT().cEb());
                            e.cDT().lm(e.cDT().cDZ());
                            e.cDT().f(false, 50);
                            break;
                        case 1:
                            e.cDT().cEc();
                            e.cDT().cEa();
                            break;
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/EditorUI$24", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                    AppMethodBeat.o(181533);
                }

                @Override // android.support.v7.widget.RecyclerView.l
                public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                    AppMethodBeat.i(181534);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(recyclerView);
                    bVar.pH(i2);
                    bVar.pH(i3);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/EditorUI$24", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                    super.onScrolled(recyclerView, i2, i3);
                    if (i3 > 30) {
                        e.cDT().cEc();
                        e.cDT().cEa();
                    }
                    com.tencent.mm.plugin.editor.model.nativenote.c.d cDV = e.cDT().cDV();
                    if ((EditorUI.this.qNL || (EditorUI.this.qNB != null && EditorUI.this.qNB.getVisibility() == 0)) && cDV.getSelectType() == 2 && f.d(recyclerView, cDV.bNu) == null) {
                        EditorUI.this.cCD();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/EditorUI$24", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                    AppMethodBeat.o(181534);
                }
            };
            this.qNx.a(this.qNJ);
        }
        cCQ();
        AppMethodBeat.o(181555);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(181556);
        super.initView();
        setActionbarColor(getContext().getResources().getColor(R.color.afz));
        setMMTitle("");
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass11 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(181527);
                EditorUI.this.goBack();
                AppMethodBeat.o(181527);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.yl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass21 */

            /* JADX WARNING: Code restructure failed: missing block: B:36:0x012c, code lost:
                r0 = null;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
                r0.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:44:0x013e, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:45:0x013f, code lost:
                r1 = r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
                r3.close();
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x0138 A[SYNTHETIC, Splitter:B:41:0x0138] */
            /* JADX WARNING: Removed duplicated region for block: B:44:0x013e A[ExcHandler: all (r0v16 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:22:0x00d6] */
            /* JADX WARNING: Removed duplicated region for block: B:47:0x0142 A[SYNTHETIC, Splitter:B:47:0x0142] */
            /* JADX WARNING: Removed duplicated region for block: B:61:0x010f A[SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onMenuItemClick(android.view.MenuItem r14) {
                /*
                // Method dump skipped, instructions count: 353
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.editor.EditorUI.AnonymousClass21.onMenuItemClick(android.view.MenuItem):boolean");
            }
        }, null, t.b.GREEN);
        enableOptionMenu(0, this.qNw);
        getContentView().getRootView().setBackgroundColor(getContext().getResources().getColor(R.color.afz));
        this.qNG = new j(this);
        this.qNG.qRR = this.qNM;
        this.qNx = (RecyclerView) findViewById(R.id.b6l);
        this.qNB = (LinearLayout) findViewById(R.id.b6k);
        this.qNC = new com.tencent.mm.plugin.editor.widget.a();
        com.tencent.mm.plugin.editor.widget.a aVar = this.qNC;
        LinearLayout linearLayout = this.qNB;
        aVar.psf = linearLayout;
        j.cDP().qRQ = aVar;
        aVar.qTN = (WeImageButton) linearLayout.findViewById(R.id.dle);
        aVar.qTO = (WeImageButton) linearLayout.findViewById(R.id.dli);
        aVar.qTP = (WeImageButton) linearLayout.findViewById(R.id.dlh);
        aVar.qTQ = (WeImageButton) linearLayout.findViewById(R.id.dlj);
        aVar.qTR = (LinearLayout) linearLayout.findViewById(R.id.dlk);
        aVar.qTS = (LinearLayout) aVar.qTR.findViewById(R.id.jot);
        aVar.qTT = (LinearLayout) aVar.qTR.findViewById(R.id.jor);
        aVar.qTU = (LinearLayout) aVar.qTR.findViewById(R.id.jos);
        aVar.qTV = (LinearLayout) aVar.qTR.findViewById(R.id.fjy);
        aVar.qTW = (LinearLayout) aVar.qTR.findViewById(R.id.jom);
        aVar.qTN.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.editor.widget.a.AnonymousClass1 */
            final /* synthetic */ com.tencent.mm.plugin.editor.model.nativenote.b.a qUe;

            {
                this.qUe = r2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(181971);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/widget/EditorFooterPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                int a2 = a.a(a.this);
                if (a2 == 1) {
                    this.qUe.e(false, 0);
                    this.qUe.Q(3, 100);
                } else if (a2 == 3) {
                    this.qUe.e(true, 50);
                    this.qUe.Q(1, 0);
                } else if (a2 == 2) {
                    this.qUe.Q(3, 0);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/EditorFooterPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(181971);
            }
        });
        aVar.qTO.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.editor.widget.a.AnonymousClass5 */
            final /* synthetic */ Context val$context;

            {
                this.val$context = r2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(181974);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/widget/EditorFooterPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.EditorFooterPanel", "go to GalleryEntryUI");
                com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().af(-1, false);
                Intent intent = new Intent();
                intent.putExtra("max_select_count", 9);
                intent.putExtra("query_source_type", 13);
                intent.putExtra("query_media_type", 3);
                intent.putExtra("show_header_view", false);
                intent.addFlags(67108864);
                intent.putExtra("key_can_select_video_and_pic", true);
                com.tencent.mm.br.c.b(this.val$context, "gallery", ".ui.GalleryEntryUI", intent, 4096);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/EditorFooterPanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(181974);
            }
        });
        aVar.qUd = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_jump_to_record_media, true);
        aVar.qTP.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.editor.widget.a.AnonymousClass6 */
            final /* synthetic */ Context val$context;

            {
                this.val$context = r2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(181975);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/widget/EditorFooterPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                RecordConfigProvider eJM = RecordConfigProvider.eJM();
                UICustomParam.a aVar = new UICustomParam.a();
                aVar.apE();
                aVar.apD();
                aVar.dz(true);
                eJM.BOn = aVar.gLU;
                if (a.this.qUd) {
                    com.tencent.mm.plugin.recordvideo.jumper.a aVar2 = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
                    com.tencent.mm.plugin.recordvideo.jumper.a.a(this.val$context, 4097, eJM);
                } else {
                    Intent intent = new Intent();
                    SightParams sightParams = (SightParams) intent.getParcelableExtra("KEY_SIGHT_PARAMS");
                    if (sightParams == null) {
                        sightParams = new SightParams(4, 0);
                    }
                    String str = "micromsg_" + System.currentTimeMillis();
                    String str2 = com.tencent.mm.loader.j.b.aKV() + str + ".mp4";
                    String str3 = com.tencent.mm.loader.j.b.aKV() + str + ".jpeg";
                    int intExtra = intent.getIntExtra("key_pick_local_media_duration", 60);
                    SightParams sightParams2 = new SightParams(4, 1);
                    sightParams2.zsH = 2;
                    sightParams2.mode = 0;
                    if (sightParams2.irT == null) {
                        sightParams2.irT = new VideoTransPara();
                    }
                    sightParams2.irT.duration = intExtra;
                    sightParams2.v(str, str2, str3, AndroidMediaUtil.getSysCameraDirPath() + String.format("%s%d.%s", "capture", Long.valueOf(System.currentTimeMillis()), "jpg"));
                    intent.putExtra("KEY_SIGHT_PARAMS", sightParams);
                    s.a(this.val$context, 4098, intent, 4, 1);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/EditorFooterPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(181975);
            }
        });
        aVar.qTQ.setOnClickListener(new View.OnClickListener(this, this) {
            /* class com.tencent.mm.plugin.editor.widget.a.AnonymousClass7 */
            final /* synthetic */ com.tencent.mm.plugin.editor.model.nativenote.b.a qUe;
            final /* synthetic */ Context val$context;

            {
                this.qUe = r2;
                this.val$context = r3;
            }

            /* JADX WARNING: Removed duplicated region for block: B:58:0x0241  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onClick(android.view.View r15) {
                /*
                // Method dump skipped, instructions count: 677
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.editor.widget.a.AnonymousClass7.onClick(android.view.View):void");
            }
        });
        aVar.qTS.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.editor.widget.a.AnonymousClass8 */
            final /* synthetic */ com.tencent.mm.plugin.editor.model.nativenote.b.a qUe;

            {
                this.qUe = r2;
            }

            public final void onClick(View view) {
                boolean z = true;
                AppMethodBeat.i(181977);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/widget/EditorFooterPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a.this.qTV.setPressed(false);
                a.this.qTT.setPressed(false);
                if (a.this.qUa || a.this.qUb) {
                    a.this.qTZ = false;
                }
                a.c(u.qTJ, Boolean.valueOf(!a.this.qTZ));
                a aVar = a.this;
                if (a.this.qTZ) {
                    z = false;
                }
                aVar.qTZ = z;
                a.a(a.this, view, a.this.qTZ);
                a.b(this.qUe);
                a.this.qUa = false;
                a.this.qUb = false;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/EditorFooterPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(181977);
            }
        });
        aVar.qTT.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.editor.widget.a.AnonymousClass9 */
            final /* synthetic */ com.tencent.mm.plugin.editor.model.nativenote.b.a qUe;

            {
                this.qUe = r2;
            }

            public final void onClick(View view) {
                boolean z = true;
                AppMethodBeat.i(181978);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/widget/EditorFooterPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a.this.qTS.setPressed(false);
                a.this.qTV.setPressed(false);
                if (a.this.qTZ || a.this.qUb) {
                    a.this.qUa = false;
                }
                a.c(u.qTK, Boolean.valueOf(!a.this.qUa));
                a aVar = a.this;
                if (a.this.qUa) {
                    z = false;
                }
                aVar.qUa = z;
                a.a(a.this, view, a.this.qUa);
                a.b(this.qUe);
                a.this.qTZ = false;
                a.this.qUb = false;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/EditorFooterPanel$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(181978);
            }
        });
        aVar.qTU.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.editor.widget.a.AnonymousClass10 */
            final /* synthetic */ com.tencent.mm.plugin.editor.model.nativenote.b.a qUe;

            {
                this.qUe = r2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(181979);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/widget/EditorFooterPanel$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                i iVar = new i();
                j cDP = j.cDP();
                if (cDP != null) {
                    com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().a((com.tencent.mm.plugin.editor.model.a.a) iVar, cDP.cDQ(), false, false, true);
                } else {
                    com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().a((com.tencent.mm.plugin.editor.model.a.a) iVar, (WXRTEditText) null, false, false, true);
                }
                a.b(this.qUe);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/EditorFooterPanel$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(181979);
            }
        });
        aVar.qTV.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.editor.widget.a.AnonymousClass11 */
            final /* synthetic */ com.tencent.mm.plugin.editor.model.nativenote.b.a qUe;

            {
                this.qUe = r2;
            }

            public final void onClick(View view) {
                boolean z = true;
                AppMethodBeat.i(181980);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/widget/EditorFooterPanel$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a.this.qTS.setPressed(false);
                a.this.qTT.setPressed(false);
                if (a.this.qUa || a.this.qTZ) {
                    a.this.qUb = false;
                }
                a.c(u.qTI, Boolean.valueOf(!a.this.qUb));
                a aVar = a.this;
                if (a.this.qUb) {
                    z = false;
                }
                aVar.qUb = z;
                a.a(a.this, view, a.this.qUb);
                a.b(this.qUe);
                a.this.qUa = false;
                a.this.qTZ = false;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/EditorFooterPanel$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(181980);
            }
        });
        aVar.qTW.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.editor.widget.a.AnonymousClass12 */
            final /* synthetic */ com.tencent.mm.plugin.editor.model.nativenote.b.a qUe;

            {
                this.qUe = r2;
            }

            public final void onClick(View view) {
                boolean z;
                boolean z2 = true;
                AppMethodBeat.i(181981);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/widget/EditorFooterPanel$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.editor.model.nativenote.spans.b bVar2 = u.qTH;
                if (!a.this.qUc) {
                    z = true;
                } else {
                    z = false;
                }
                a.c(bVar2, Boolean.valueOf(z));
                a aVar = a.this;
                if (a.this.qUc) {
                    z2 = false;
                }
                aVar.qUc = z2;
                a.a(a.this, view, a.this.qUc);
                a.b(this.qUe);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/widget/EditorFooterPanel$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(181981);
            }
        });
        this.qND = (LinearLayout) this.qNB.findViewById(R.id.dlk);
        this.qND.setVisibility(8);
        this.qNE = (RelativeLayout) findViewById(R.id.jn3);
        this.qNE.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(181517);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/EditorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (EditorUI.this.qNF != null) {
                    EditorUI.this.qNF.qQv.dismiss();
                }
                EditorUI.this.qNE.setVisibility(8);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/EditorUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(181517);
            }
        });
        this.qNF = new d(this, this.qNE);
        this.qNF.qQw = this;
        this.qNz = new CollectEditorLinearLayoutManager();
        this.qNz.qOi = com.tencent.mm.compatible.util.i.getScreenWH(this)[1];
        this.qNx.setLayoutManager(this.qNz);
        this.qNx.setHasFixedSize(true);
        this.qNA = new a();
        this.qNx.a(this.qNA);
        this.qNy = new com.tencent.mm.plugin.editor.adapter.b(this.qNG);
        this.qNx.setAdapter(this.qNy);
        if (this.qNM) {
            com.tencent.mm.plugin.editor.model.a.j jVar = new com.tencent.mm.plugin.editor.model.a.j();
            jVar.content = "";
            jVar.qPA = true;
            jVar.qPG = false;
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().e(jVar);
            e(true, 300);
            Q(1, 0);
            this.qNx.setOnTouchListener(this.qNS);
        } else {
            this.qNB.setVisibility(8);
        }
        this.qNx.getItemAnimator().atn = 0;
        this.qNx.getItemAnimator().atq = 0;
        this.qNx.getItemAnimator().atp = 0;
        this.qNx.getItemAnimator().ato = 120;
        ((as) this.qNx.getItemAnimator()).awI = false;
        AppMethodBeat.o(181556);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(181557);
        super.onResume();
        if (this.qNM) {
            switch (this.qNP) {
                case -1:
                    if (this.qNQ) {
                        e(true, 100);
                        Q(1, 0);
                        break;
                    }
                    break;
                case 4096:
                case 4097:
                    if (!this.qNO) {
                        e(true, 100);
                        Q(1, 0);
                        break;
                    }
                    break;
            }
        }
        this.qNP = -1;
        this.qNO = false;
        if (isSupportNavigationSwipeBack()) {
            getSwipeBackLayout().setEnableGesture(false);
        }
        AppMethodBeat.o(181557);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(181558);
        super.onPause();
        if (this.qNC != null) {
            this.qNC.a(this);
        }
        if (com.tencent.mm.plugin.editor.widget.voiceview.a.cEC().cEF()) {
            com.tencent.mm.plugin.editor.widget.voiceview.a.cEC().stopPlay();
        }
        this.qNQ = this.qNL;
        e(false, 0);
        AppMethodBeat.o(181558);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(181559);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.EditorUI", "onActivityResult reqCode: %d, retCod: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.qNP = i2;
        if (i3 != -1) {
            this.qNO = false;
            AppMethodBeat.o(181559);
            return;
        }
        this.qNO = true;
        switch (i2) {
            case 4096:
                Log.i("MicroMsg.EditorUI", "onActivityResult back from gallery");
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                    Log.i("MicroMsg.EditorUI", "no pic selected");
                } else {
                    S(stringArrayListExtra);
                }
                ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("key_select_video_list");
                String stringExtra = intent.getStringExtra("K_SEGMENTVIDEOPATH");
                if (!Util.isNullOrNil(stringExtra) && stringArrayListExtra2 == null) {
                    stringArrayListExtra2 = new ArrayList<>();
                    stringArrayListExtra2.add(stringExtra);
                }
                if (stringArrayListExtra2 == null || stringArrayListExtra2.size() <= 0) {
                    Log.i("MicroMsg.EditorUI", "no video selected");
                    AppMethodBeat.o(181559);
                    return;
                } else if (com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().fw(0, stringArrayListExtra2.size())) {
                    cCx();
                    AppMethodBeat.o(181559);
                    return;
                } else {
                    alF(stringArrayListExtra2.get(0));
                    AppMethodBeat.o(181559);
                    return;
                }
            case 4097:
                CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel = (CaptureDataManager.CaptureVideoNormalModel) intent.getParcelableExtra("KSEGMENTMEDIAINFO");
                if (captureVideoNormalModel == null) {
                    Log.e("MicroMsg.EditorUI", "sight capture result is null!");
                    AppMethodBeat.o(181559);
                    return;
                }
                String str = captureVideoNormalModel.videoPath;
                if (!Util.isNullOrNil(str)) {
                    alF(str);
                }
                if (captureVideoNormalModel.BOe.booleanValue() && !Util.isNullOrNil(captureVideoNormalModel.thumbPath)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(captureVideoNormalModel.thumbPath);
                    S(arrayList);
                    AppMethodBeat.o(181559);
                    return;
                }
            case 4098:
                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                if (sightCaptureResult != null) {
                    String str2 = sightCaptureResult.zsA;
                    if (!Util.isNullOrNil(str2)) {
                        alF(str2);
                    }
                    if (sightCaptureResult.zsy && !Util.isNullOrNil(sightCaptureResult.zsG)) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        arrayList2.add(sightCaptureResult.zsG);
                        S(arrayList2);
                        break;
                    }
                } else {
                    Log.e("MicroMsg.EditorUI", "sight capture result is null!");
                    AppMethodBeat.o(181559);
                    return;
                }
        }
        AppMethodBeat.o(181559);
    }

    private void S(final ArrayList<String> arrayList) {
        AppMethodBeat.i(181560);
        if (com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().fw(0, arrayList.size())) {
            cCx();
            AppMethodBeat.o(181560);
            return;
        }
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.pqa = h.a((Context) context, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass22 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(181540);
                if (EditorUI.this.pqa != null) {
                    EditorUI.this.pqa.dismiss();
                    EditorUI.this.pqa = null;
                }
                AppMethodBeat.o(181540);
            }
        });
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass23 */

            public final void run() {
                AppMethodBeat.i(181541);
                ArrayList<com.tencent.mm.plugin.editor.model.a.a> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    com.tencent.mm.plugin.editor.model.a.h hVar = new com.tencent.mm.plugin.editor.model.a.h();
                    hVar.qPO = true;
                    hVar.type = 2;
                    hVar.qPN = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDu();
                    hVar.dLl = com.tencent.mm.plugin.editor.model.b.alR(hVar.toString());
                    EditorUI.this.qNR = new aml();
                    EditorUI.this.qNR.bgs(hVar.dLl);
                    hVar.qPL = b.fJ((String) arrayList.get(i2), com.tencent.mm.plugin.editor.model.b.b(EditorUI.this.qNR));
                    hVar.dUs = b.fK(hVar.qPL, com.tencent.mm.plugin.editor.model.b.a(EditorUI.this.qNR));
                    arrayList.add(hVar);
                }
                if (EditorUI.this.pqa == null || !EditorUI.this.pqa.isShowing()) {
                    Log.i("MicroMsg.EditorUI", "user canceled");
                    AppMethodBeat.o(181541);
                    return;
                }
                com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().a(arrayList, EditorUI.this.qNG.cDQ(), true, false, true, false);
                EditorUI.this.e(true, 100);
                EditorUI.this.Q(1, 0);
                AppMethodBeat.o(181541);
            }
        });
        AppMethodBeat.o(181560);
    }

    private void alF(String str) {
        AppMethodBeat.i(181561);
        com.tencent.mm.plugin.sight.base.a aNx = com.tencent.mm.plugin.sight.base.e.aNx(str);
        if (aNx == null) {
            Log.e("MicroMsg.EditorUI", "mediaInfo is null, videoPath is %s", Util.nullAsNil(str));
            AppMethodBeat.o(181561);
            return;
        }
        int videoDuration = aNx.getVideoDuration();
        l lVar = new l();
        lVar.qPO = true;
        lVar.thumbPath = "";
        lVar.dUs = "";
        lVar.duration = videoDuration;
        lVar.type = 6;
        lVar.qPN = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDu();
        lVar.qPP = com.tencent.mm.vfs.s.akC(str);
        lVar.dLl = com.tencent.mm.plugin.editor.model.b.alR(lVar.toString());
        this.qNR = new aml();
        this.qNR.bgs(lVar.dLl);
        this.qNR.bgp(lVar.qPP);
        a(str, lVar, com.tencent.mm.plugin.editor.model.b.a(this.qNR), com.tencent.mm.plugin.editor.model.b.b(this.qNR));
        AppMethodBeat.o(181561);
    }

    private void a(String str, final l lVar, String str2, String str3) {
        AppMethodBeat.i(181562);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.EditorUI", "video is null");
            AppMethodBeat.o(181562);
            return;
        }
        Log.v("MicroMsg.EditorUI", "compressNoteVideo path: %s", str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        final com.tencent.mm.plugin.editor.model.nativenote.manager.e eVar = new com.tencent.mm.plugin.editor.model.nativenote.manager.e(arrayList, str2, str3, lVar, new e.a() {
            /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass24 */

            @Override // com.tencent.mm.plugin.editor.model.nativenote.manager.e.a
            public final void a(String str, l lVar) {
                AppMethodBeat.i(181542);
                Log.i("MicroMsg.EditorUI", "compressNoteVideo onImportFinish");
                if (!Util.isNullOrNil(str) && com.tencent.mm.vfs.s.YS(str) && lVar != null) {
                    lVar.thumbPath = str;
                }
                AppMethodBeat.o(181542);
            }

            @Override // com.tencent.mm.plugin.editor.model.nativenote.manager.e.a
            public final void b(String str, l lVar) {
                AppMethodBeat.i(181543);
                Log.i("MicroMsg.EditorUI", "compressNoteVideo onExportFinish");
                if (EditorUI.this.pqa != null) {
                    EditorUI.this.pqa.dismiss();
                    EditorUI.this.pqa = null;
                }
                if (Util.isNullOrNil(str) || !com.tencent.mm.vfs.s.YS(str) || lVar == null || lVar.qPW) {
                    Log.i("MicroMsg.EditorUI", "file not exist or user canceled");
                } else if (new o(str).length() < ((long) ((af) com.tencent.mm.kernel.g.ah(af.class)).getFileSizeLimit(false))) {
                    lVar.dUs = str;
                    com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().a((com.tencent.mm.plugin.editor.model.a.a) lVar, EditorUI.this.qNG.cDQ(), false, true, false);
                } else {
                    Toast.makeText(EditorUI.this.getContext(), EditorUI.this.getString(R.string.ccv), 1).show();
                }
                EditorUI.this.e(true, 100);
                EditorUI.this.Q(1, 0);
                AppMethodBeat.o(181543);
            }
        });
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.pqa = h.a((Context) context, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass25 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(181544);
                com.tencent.mm.plugin.editor.model.nativenote.manager.e eVar = eVar;
                eVar.isStop = true;
                eVar.interrupt();
                lVar.qPW = true;
                EditorUI.this.e(true, 100);
                EditorUI.this.Q(1, 0);
                AppMethodBeat.o(181544);
            }
        });
        ThreadPool.post(eVar, "NoteEditor_importVideo");
        AppMethodBeat.o(181562);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final void a(WXRTEditText wXRTEditText, boolean z, int i2) {
        AppMethodBeat.i(181563);
        if (!this.qNM) {
            AppMethodBeat.o(181563);
            return;
        }
        Log.d("MicroMsg.EditorUI", "onFocusChanged, poi: %s, focus: %s, editor: %s.", Integer.valueOf(i2), Boolean.valueOf(z), wXRTEditText);
        CollectEditorLinearLayoutManager collectEditorLinearLayoutManager = (CollectEditorLinearLayoutManager) this.qNx.getLayoutManager();
        if (collectEditorLinearLayoutManager != null) {
            if (this.qNK) {
                collectEditorLinearLayoutManager.qOj = false;
            } else {
                collectEditorLinearLayoutManager.qOj = z;
            }
        }
        if (!z) {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().af(-1, false);
        } else if (wXRTEditText == null || wXRTEditText.getEditTextType() != 1) {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().ag(i2, false);
        } else {
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().ag(i2, true);
        }
        cCT();
        AppMethodBeat.o(181563);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final void Fr(final int i2) {
        AppMethodBeat.i(181564);
        this.kAn.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass26 */

            public final void run() {
                AppMethodBeat.i(181545);
                Log.i("MicroMsg.EditorUI", "huahuastart: onNotifyItemChanged,position is %d", Integer.valueOf(i2));
                EditorUI.this.qNy.ci(i2);
                Log.i("MicroMsg.EditorUI", "huahuaend: onNotifyItemChanged,position is %d", Integer.valueOf(i2));
                AppMethodBeat.o(181545);
            }
        }, 0);
        AppMethodBeat.o(181564);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final void Fs(int i2) {
        AppMethodBeat.i(181565);
        try {
            this.qNy.cj(i2);
            AppMethodBeat.o(181565);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.EditorUI", e2, "", new Object[0]);
            Log.e("MicroMsg.EditorUI", "onNotifyItemInserted error,positionStart:%d", Integer.valueOf(i2));
            AppMethodBeat.o(181565);
        }
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final void ft(int i2, int i3) {
        AppMethodBeat.i(181566);
        try {
            this.qNy.as(i2, i3);
            AppMethodBeat.o(181566);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.EditorUI", e2, "", new Object[0]);
            Log.e("MicroMsg.EditorUI", "onNotifyItemRangeInserted error,positionStart:%d,count:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(181566);
        }
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final void Ft(int i2) {
        AppMethodBeat.i(181567);
        try {
            this.qNy.ck(i2);
            AppMethodBeat.o(181567);
        } catch (Exception e2) {
            Log.e("MicroMsg.EditorUI", "onNotifyItemRemoved error,positionStart:%d", Integer.valueOf(i2));
            AppMethodBeat.o(181567);
        }
    }

    private void cCu() {
        AppMethodBeat.i(181568);
        try {
            this.qNy.atj.notifyChanged();
            AppMethodBeat.o(181568);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.EditorUI", e2, "", new Object[0]);
            Log.i("MicroMsg.EditorUI", "onNotifyDataChanged error");
            AppMethodBeat.o(181568);
        }
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final void fu(int i2, int i3) {
        AppMethodBeat.i(181569);
        try {
            this.qNy.aq(i2, i3);
            AppMethodBeat.o(181569);
        } catch (Exception e2) {
            Log.e("MicroMsg.EditorUI", "onNotifyItemRangeChanged error,positionStart:%d,count:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(181569);
        }
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final void cCv() {
        AppMethodBeat.i(181570);
        if (!this.qNC.qTX) {
            cCD();
            final AppCompatActivity context = getContext();
            this.kAn.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass27 */

                public final void run() {
                    AppMethodBeat.i(181546);
                    int size = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().size();
                    int childCount = EditorUI.this.qNx.getChildCount();
                    if (size == childCount) {
                        int i2 = childCount - 1;
                        float f2 = 0.0f;
                        int i3 = i2;
                        while (i3 >= 0) {
                            View childAt = EditorUI.this.qNx.getChildAt(i3);
                            float ae = android.support.v4.view.u.ae(childAt);
                            i3--;
                            f2 = f2 > ((float) childAt.getBottom()) + ae ? f2 : ((float) childAt.getBottom()) + ae;
                        }
                        if (f2 < ((float) com.tencent.mm.compatible.util.i.getScreenWH(context)[1]) && f2 > 0.0f) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) EditorUI.this.qNE.getLayoutParams();
                            layoutParams.height = (int) f2;
                            EditorUI.this.qNE.setLayoutParams(layoutParams);
                        }
                    }
                    EditorUI.this.qNE.setVisibility(0);
                    if (EditorUI.this.qNF != null) {
                        d dVar = EditorUI.this.qNF;
                        int[] iArr = {0, 0};
                        dVar.mParentView.getLocationOnScreen(iArr);
                        dVar.qQv.showAtLocation(dVar.mParentView, 49, 0, iArr[1] + 50);
                    }
                    AppMethodBeat.o(181546);
                }
            }, 400);
        }
        AppMethodBeat.o(181570);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final void a(WXRTEditText wXRTEditText) {
        boolean z;
        AppMethodBeat.i(181571);
        if (wXRTEditText != null) {
            if (com.tencent.mm.plugin.editor.model.nativenote.manager.b.kgc == null || com.tencent.mm.plugin.editor.model.nativenote.manager.b.kgc.size() <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                ArrayList<com.tencent.mm.plugin.editor.model.a.a> cDk = com.tencent.mm.plugin.editor.model.nativenote.manager.b.cDk();
                if (com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().U(cDk)) {
                    cCx();
                    AppMethodBeat.o(181571);
                    return;
                }
                com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().a(cDk, wXRTEditText, true, true, false, false);
                int recyclerItemPosition = wXRTEditText.getRecyclerItemPosition();
                com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().fx(recyclerItemPosition, cDk.size() + recyclerItemPosition + 1);
                cCD();
                if (this.qNH) {
                    com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().cDY();
                }
                AppMethodBeat.o(181571);
                return;
            }
        }
        AppMethodBeat.o(181571);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final void fv(int i2, int i3) {
        AppMethodBeat.i(181572);
        this.qNK = Math.abs(i3 - i2) > 0;
        AppMethodBeat.o(181572);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final void Fu(final int i2) {
        AppMethodBeat.i(181573);
        if (i2 < 0 || i2 >= com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().size()) {
            AppMethodBeat.o(181573);
            return;
        }
        this.kAn.post(new Runnable() {
            /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(181518);
                RecyclerView recyclerView = EditorUI.this.qNx;
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/editor/EditorUI$11", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/editor/EditorUI$11", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                AppMethodBeat.o(181518);
            }
        });
        AppMethodBeat.o(181573);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final void cCw() {
        AppMethodBeat.i(181574);
        this.kAn.post(new Runnable() {
            /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(181519);
                if (EditorUI.this.pqa != null) {
                    EditorUI.this.pqa.dismiss();
                    EditorUI.this.pqa = null;
                }
                AppMethodBeat.o(181519);
            }
        });
        AppMethodBeat.o(181574);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final void cCx() {
        AppMethodBeat.i(181575);
        cCD();
        if (this.qNH) {
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().cDY();
        }
        this.kAn.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(181520);
                h.c(EditorUI.this.getContext(), EditorUI.this.getString(R.string.hn3), null, true);
                AppMethodBeat.o(181520);
            }
        }, 100);
        AppMethodBeat.o(181575);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final void cCy() {
        AppMethodBeat.i(181576);
        h.a((Context) this, getString(R.string.flb), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(181521);
                dialogInterface.dismiss();
                EditorUI editorUI = EditorUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                com.tencent.mm.hellhoundlib.a.a.a(editorUI, bl.axQ(), "com/tencent/mm/plugin/editor/EditorUI$14", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                editorUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(editorUI, "com/tencent/mm/plugin/editor/EditorUI$14", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(181521);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(181522);
                dialogInterface.dismiss();
                AppMethodBeat.o(181522);
            }
        });
        AppMethodBeat.o(181576);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(181577);
        if (iArr.length <= 0) {
            Log.i("MicroMsg.EditorUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(181577);
            return;
        }
        Log.i("MicroMsg.EditorUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 64:
                if (com.tencent.mm.aw.b.Pi((String) com.tencent.mm.kernel.g.aAh().azQ().get(274436, (Object) null)) && iArr[0] != 0) {
                    h.a((Context) getContext(), getString(R.string.fl_), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass7 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(181523);
                            EditorUI editorUI = EditorUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(editorUI, bl.axQ(), "com/tencent/mm/plugin/editor/EditorUI$16", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            editorUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(editorUI, "com/tencent/mm/plugin/editor/EditorUI$16", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(181523);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    break;
                }
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                if (iArr[0] != 0) {
                    cCy();
                    AppMethodBeat.o(181577);
                    return;
                }
                break;
        }
        AppMethodBeat.o(181577);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final void e(final boolean z, long j2) {
        AppMethodBeat.i(181578);
        if (!this.qNM) {
            AppMethodBeat.o(181578);
            return;
        }
        this.kAn.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(181524);
                if (!z || EditorUI.this.qNL) {
                    if (!z && EditorUI.this.qNL) {
                        EditorUI.this.hideVKB();
                    }
                    AppMethodBeat.o(181524);
                    return;
                }
                EditorUI.this.showVKB();
                AppMethodBeat.o(181524);
            }
        }, j2);
        AppMethodBeat.o(181578);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final void Q(final int i2, long j2) {
        AppMethodBeat.i(181579);
        if (!this.qNM) {
            AppMethodBeat.o(181579);
            return;
        }
        this.kAn.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass9 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            public final void run() {
                AppMethodBeat.i(181525);
                ImageButton imageButton = (ImageButton) EditorUI.this.qNB.findViewById(R.id.dle);
                View findViewById = EditorUI.this.qNB.findViewById(R.id.dlf);
                switch (i2) {
                    case 0:
                        EditorUI.this.qND.setVisibility(8);
                        if (!EditorUI.this.qNC.qTX) {
                            EditorUI.this.qNB.setVisibility(8);
                            AppMethodBeat.o(181525);
                            return;
                        }
                        EditorUI.this.qNB.setVisibility(0);
                        AppMethodBeat.o(181525);
                        return;
                    case 1:
                        imageButton.setImageResource(R.raw.editor_style_unpress);
                        findViewById.setVisibility(8);
                        EditorUI.this.qNB.setVisibility(0);
                        EditorUI.this.qND.setVisibility(8);
                        AppMethodBeat.o(181525);
                        return;
                    case 2:
                        EditorUI.this.qNB.setVisibility(0);
                        EditorUI.this.qND.setVisibility(8);
                        AppMethodBeat.o(181525);
                        return;
                    case 3:
                        imageButton.setImageResource(R.raw.editor_style_press);
                        findViewById.setVisibility(0);
                        EditorUI.this.qNB.setVisibility(0);
                        EditorUI.this.qND.setVisibility(0);
                        break;
                }
                AppMethodBeat.o(181525);
            }
        }, j2);
        AppMethodBeat.o(181579);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final void cCz() {
        AppMethodBeat.i(181580);
        h.c(getContext(), getString(R.string.fvt), null, true);
        AppMethodBeat.o(181580);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final void cCA() {
        AppMethodBeat.i(181581);
        if (this.qNC != null) {
            this.qNC.a((com.tencent.mm.plugin.editor.model.nativenote.b.a) null);
        }
        AppMethodBeat.o(181581);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final void cCB() {
        AppMethodBeat.i(181582);
        h.c(this, getString(R.string.blg), "", getString(R.string.blf), getString(R.string.ble), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass10 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(181526);
                com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().cEi();
                AppMethodBeat.o(181526);
            }
        }, null);
        AppMethodBeat.o(181582);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final void cCC() {
        AppMethodBeat.i(181583);
        Toast.makeText(getContext(), getString(R.string.fjf), 0).show();
        AppMethodBeat.o(181583);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final void cCD() {
        AppMethodBeat.i(181584);
        int cDq = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDq();
        com.tencent.mm.plugin.editor.model.a.a Fw = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().Fw(cDq);
        if (Fw != null) {
            Fw.qPA = false;
            Fw.qPG = false;
            Fr(cDq);
        }
        this.kAn.post(new Runnable() {
            /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(181528);
                WXRTEditText cDO = EditorUI.this.qNG.cDO();
                if (cDO != null) {
                    cDO.clearFocus();
                }
                AppMethodBeat.o(181528);
            }
        });
        e(false, 0);
        Q(0, 0);
        AppMethodBeat.o(181584);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final int cCE() {
        AppMethodBeat.i(181585);
        if (this.qNL) {
            int keyBordHeightPx = com.tencent.mm.compatible.util.i.getKeyBordHeightPx(this);
            AppMethodBeat.o(181585);
            return keyBordHeightPx;
        }
        AppMethodBeat.o(181585);
        return 0;
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final int cCF() {
        AppMethodBeat.i(181586);
        int i2 = 0;
        if (this.qNB != null && this.qNB.getVisibility() == 0) {
            i2 = this.qNI + 0;
        }
        if (this.qND != null && this.qND.getVisibility() == 0) {
            i2 += this.qNI;
        }
        AppMethodBeat.o(181586);
        return i2;
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final boolean cCG() {
        AppMethodBeat.i(181587);
        if (this.qNG == null || this.qNG.cDO() == null) {
            AppMethodBeat.o(181587);
            return false;
        }
        AppMethodBeat.o(181587);
        return true;
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final RecyclerView cCH() {
        return this.qNx;
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.a
    public final RecyclerView cCI() {
        return this.qNx;
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.a
    public final Context cCJ() {
        AppMethodBeat.i(181588);
        AppCompatActivity context = getContext();
        AppMethodBeat.o(181588);
        return context;
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.a
    public final com.tencent.mm.plugin.editor.model.nativenote.b.a cCK() {
        return this;
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.manager.d.a
    public final void cCL() {
        AppMethodBeat.i(181589);
        com.tencent.mm.plugin.editor.model.a.j jVar = new com.tencent.mm.plugin.editor.model.a.j();
        jVar.content = "";
        jVar.qPA = true;
        jVar.qPG = false;
        jVar.qPC = 0;
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDp();
        com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().e(jVar);
        cCu();
        e(true, 50);
        Q(1, 0);
        AppMethodBeat.o(181589);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.manager.d.a
    public final void cCM() {
        AppMethodBeat.i(181590);
        com.tencent.mm.plugin.editor.model.nativenote.manager.b.c(getContext(), com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDx());
        AppMethodBeat.o(181590);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.manager.d.a
    public final void cCN() {
        AppMethodBeat.i(181591);
        com.tencent.mm.plugin.editor.model.nativenote.manager.b.c(getContext(), com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDx());
        cCL();
        AppMethodBeat.o(181591);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.manager.d.a
    public final void cCO() {
        AppMethodBeat.i(181592);
        getContext();
        int cDn = com.tencent.mm.plugin.editor.model.nativenote.manager.b.cDn();
        if (cDn == 2) {
            if (com.tencent.mm.plugin.editor.model.nativenote.manager.b.cDm()) {
                cCx();
                AppMethodBeat.o(181592);
                return;
            }
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDp();
            com.tencent.mm.plugin.editor.model.nativenote.manager.b.clearData();
            com.tencent.mm.plugin.editor.model.a.j jVar = new com.tencent.mm.plugin.editor.model.a.j();
            jVar.content = "";
            jVar.qPA = false;
            jVar.qPG = false;
            jVar.qPC = 0;
            jVar.qPI = true;
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().e(jVar);
            cCu();
            AppMethodBeat.o(181592);
        } else if (cDn == 3) {
            ArrayList<com.tencent.mm.plugin.editor.model.a.a> cDk = com.tencent.mm.plugin.editor.model.nativenote.manager.b.cDk();
            if (com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().U(cDk)) {
                cCx();
                AppMethodBeat.o(181592);
                return;
            }
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDp();
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().a(cDk, null, false, false, false, false);
            cCD();
            AppMethodBeat.o(181592);
        } else {
            Log.d("MicroMsg.EditorUI", "no data.");
            AppMethodBeat.o(181592);
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends com.tencent.mm.plugin.editor.adapter.a {
        a() {
        }

        @Override // com.tencent.mm.plugin.editor.adapter.a
        public final void cCV() {
            AppMethodBeat.i(181547);
            EditorUI.m(EditorUI.this);
            AppMethodBeat.o(181547);
        }

        @Override // com.tencent.mm.plugin.editor.adapter.a
        public final void cCW() {
            AppMethodBeat.i(181548);
            EditorUI.this.showActionbarLine();
            EditorUI.m(EditorUI.this);
            AppMethodBeat.o(181548);
        }

        @Override // com.tencent.mm.plugin.editor.adapter.a
        public final void cCX() {
            AppMethodBeat.i(181549);
            EditorUI.this.hideActionbarLine();
            AppMethodBeat.o(181549);
        }

        @Override // android.support.v7.widget.RecyclerView.l, com.tencent.mm.plugin.editor.adapter.a
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(181550);
            super.onScrollStateChanged(recyclerView, i2);
            AppMethodBeat.o(181550);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void onKeyboardStateChanged() {
        AppMethodBeat.i(181593);
        super.onKeyboardStateChanged();
        this.qNL = keyboardState() == 1;
        if (this.qNL) {
            Q(1, 0);
        }
        if (this.qNH) {
            this.kAn.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass15 */

                public final void run() {
                    AppMethodBeat.i(181532);
                    com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().ln(com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().cEb());
                    com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().lm(com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().cDZ());
                    AppMethodBeat.o(181532);
                }
            }, 200);
        }
        AppMethodBeat.o(181593);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(181594);
        super.onDestroy();
        if (this.qNH) {
            if (this.qNx != null) {
                this.qNx.b(this.qNJ);
            }
            com.tencent.mm.plugin.editor.model.nativenote.c.e cDT = com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT();
            Log.i("EditorSelectManager", "onDestroy");
            com.tencent.mm.plugin.editor.model.nativenote.c.e.mHasInit = false;
            if (cDT.qSM != null) {
                cDT.qSM.stopTimer();
            }
            if (cDT.qSN != null) {
                cDT.qSN.stopTimer();
            }
            if (cDT.qSF != null) {
                cDT.qSF.dismiss();
            }
            if (cDT.qSG != null) {
                cDT.qSG.dismiss();
            }
            if (cDT.qSH != null) {
                cDT.qSH.dismiss();
            }
            if (cDT.qSI != null) {
                cDT.qSI.dismiss();
            }
            com.tencent.mm.plugin.editor.model.nativenote.c.e.qSp = null;
        }
        if (this.qNG != null && j.qRM == this.qNG) {
            j.qRM = null;
        }
        com.tencent.mm.plugin.editor.widget.voiceview.a cEC = com.tencent.mm.plugin.editor.widget.voiceview.a.cEC();
        cEC.stopPlay();
        cEC.qUq = null;
        cEC.qUp = null;
        cEC.callbacks.clear();
        com.tencent.mm.plugin.editor.widget.voiceview.a.qUk = null;
        if (com.tencent.mm.plugin.editor.model.c.cDf() != null) {
            com.tencent.mm.plugin.editor.model.c.cDf();
            com.tencent.mm.plugin.editor.model.c.destroy();
        }
        com.tencent.mm.plugin.editor.model.nativenote.manager.c cDo = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo();
        cDo.qQp = null;
        if (cDo.mDataList != null) {
            Iterator<com.tencent.mm.plugin.editor.model.a.a> it = cDo.mDataList.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.editor.model.a.a next = it.next();
                next.qPF = null;
                next.qPD = null;
                next.qPE = null;
            }
        }
        AppMethodBeat.o(181594);
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
    public void onDrag() {
        AppMethodBeat.i(181595);
        super.onDrag();
        if (this.qNH) {
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().cEc();
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().cEa();
        }
        if (this.qNL) {
            Log.i("MicroMsg.EditorUI", "onSwipeBack close vkb");
            hideVKB();
        }
        AppMethodBeat.o(181595);
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
    public void onCancel() {
        AppMethodBeat.i(181596);
        super.onCancel();
        if (this.qNH) {
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().ln(false);
            com.tencent.mm.plugin.editor.model.nativenote.c.e.cDT().lm(false);
        }
        AppMethodBeat.o(181596);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(181597);
        goBack();
        AppMethodBeat.o(181597);
    }

    private boolean cCP() {
        AppMethodBeat.i(181598);
        if (this.qNC == null || !this.qNC.qTX) {
            AppMethodBeat.o(181598);
            return true;
        }
        cCz();
        AppMethodBeat.o(181598);
        return false;
    }

    public final void goBack() {
        AppMethodBeat.i(181599);
        if (!cCP()) {
            AppMethodBeat.o(181599);
            return;
        }
        h.a((Context) this, getString(R.string.amq), "", getString(R.string.a0_), getString(R.string.x6), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass17 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(181535);
                EditorUI.this.finish();
                AppMethodBeat.o(181535);
            }
        }, (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(181599);
    }

    static boolean alG(String str) {
        AppMethodBeat.i(181600);
        boolean isNullOrNil = Util.isNullOrNil(b.alQ(str));
        AppMethodBeat.o(181600);
        return isNullOrNil;
    }

    /* access modifiers changed from: package-private */
    public enum b {
        TYPE_THUMB,
        TYPE_FILE;

        public static b valueOf(String str) {
            AppMethodBeat.i(181552);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(181552);
            return bVar;
        }

        static {
            AppMethodBeat.i(181553);
            AppMethodBeat.o(181553);
        }
    }

    private void a(com.tencent.mm.plugin.fav.a.c cVar) {
        AppMethodBeat.i(181602);
        if (cVar == null) {
            AppMethodBeat.o(181602);
            return;
        }
        Log.i("MicroMsg.EditorUI", "startTransfer, md5:%s", cVar.field_dataId);
        g gVar = new g();
        gVar.taskName = "task_EditorUI";
        gVar.gqy = this.iZc;
        gVar.field_mediaId = cVar.field_dataId;
        gVar.field_priority = com.tencent.mm.i.a.gpN;
        if (cVar.field_type == 0) {
            gVar.ehd = true;
            gVar.field_needStorage = true;
            gVar.field_totalLen = cVar.field_totalLen;
            gVar.field_aesKey = cVar.field_cdnKey;
            gVar.field_fileId = cVar.field_cdnUrl;
            gVar.field_isStreamMedia = cVar.cUr();
            gVar.field_fullpath = cVar.field_path;
            if (!com.tencent.mm.vfs.s.YS(gVar.field_fullpath)) {
                Log.e("MicroMsg.EditorUI", "upload, but file not exist, filePath = %s", cVar.field_path);
            }
            if (cVar.cUr()) {
                gVar.field_fileType = a(cVar, com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO);
            } else {
                gVar.field_fileType = a(cVar, com.tencent.mm.i.a.MediaType_FAVORITE_FILE);
            }
            gVar.field_force_aeskeycdn = true;
            gVar.field_trysafecdn = false;
            com.tencent.mm.an.f.baQ().f(gVar);
            AppMethodBeat.o(181602);
            return;
        }
        gVar.ehd = false;
        gVar.field_totalLen = cVar.field_totalLen;
        gVar.field_aesKey = cVar.field_cdnKey;
        gVar.field_fileId = cVar.field_cdnUrl;
        gVar.field_fullpath = cVar.field_path + ".temp";
        gVar.field_needStorage = true;
        gVar.field_isStreamMedia = cVar.cUr();
        if (cVar.cUr()) {
            gVar.field_fileType = a(cVar, com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO);
        } else {
            gVar.field_fileType = a(cVar, com.tencent.mm.i.a.MediaType_FAVORITE_FILE);
        }
        com.tencent.mm.an.f.baQ().b(gVar, -1);
        AppMethodBeat.o(181602);
    }

    private com.tencent.mm.plugin.fav.a.c a(aml aml, int i2) {
        com.tencent.mm.plugin.fav.a.c cVar = null;
        AppMethodBeat.i(181603);
        if (1 == i2 && (Util.isNullOrNil(aml.Lvp) || Util.isNullOrNil(aml.KuR))) {
            Log.e("MicroMsg.EditorUI", "getCdnDataInfo, type recv, cdnDataUrl must not be null!");
            AppMethodBeat.o(181603);
        } else if (i2 != 0 || !Util.isNullOrNil(com.tencent.mm.plugin.fav.a.b.d(aml))) {
            cVar = new com.tencent.mm.plugin.fav.a.c();
            cVar.field_dataId = aml.dLl;
            cVar.field_totalLen = (int) aml.LvI;
            cVar.field_type = i2;
            cVar.field_favLocalId = this.qNT.field_localId;
            cVar.field_cdnKey = aml.Lvp;
            cVar.field_cdnUrl = aml.KuR;
            cVar.field_path = com.tencent.mm.plugin.fav.a.b.d(aml);
            if (aml.dataType == 3) {
                cVar.field_dataType = com.tencent.mm.plugin.fav.a.b.arK(aml.LvC);
            } else {
                cVar.field_dataType = aml.dataType;
            }
            cVar.field_modifyTime = Util.nowMilliSecond();
            cVar.field_status = 1;
            AppMethodBeat.o(181603);
        } else {
            Log.e("MicroMsg.EditorUI", "getCdnDataInfo, type send, path must not be null!");
            AppMethodBeat.o(181603);
        }
        return cVar;
    }

    private static int a(com.tencent.mm.plugin.fav.a.c cVar, int i2) {
        AppMethodBeat.i(181604);
        if (cVar.field_totalLen > 26214400) {
            int i3 = com.tencent.mm.i.a.gpR;
            AppMethodBeat.o(181604);
            return i3;
        } else if ((cVar.field_extFlag & 1) == 0) {
            AppMethodBeat.o(181604);
            return i2;
        } else {
            Log.w("MicroMsg.EditorUI", "NEED To Exchange Type, defType %d", Integer.valueOf(i2));
            if (com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO == i2) {
                int i4 = com.tencent.mm.i.a.MediaType_FAVORITE_FILE;
                AppMethodBeat.o(181604);
                return i4;
            }
            int i5 = com.tencent.mm.i.a.MediaType_FAVORITE_VIDEO;
            AppMethodBeat.o(181604);
            return i5;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x007e A[SYNTHETIC, Splitter:B:25:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0096 A[SYNTHETIC, Splitter:B:33:0x0096] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean alH(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 174
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.editor.EditorUI.alH(java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a A[SYNTHETIC, Splitter:B:17:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003f A[SYNTHETIC, Splitter:B:20:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008f A[SYNTHETIC, Splitter:B:43:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0094 A[SYNTHETIC, Splitter:B:46:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean fI(java.lang.String r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 198
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.editor.EditorUI.fI(java.lang.String, java.lang.String):boolean");
    }

    private void cCQ() {
        AppMethodBeat.i(181607);
        if (this.qNN.isEmpty()) {
            Log.i("MicroMsg.EditorUI", "no need update ui by xml!!! xml is empty.");
            AppMethodBeat.o(181607);
            return;
        }
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.pqa = h.a((Context) context, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass20 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(181538);
                if (EditorUI.this.pqa != null) {
                    EditorUI.this.pqa.dismiss();
                    EditorUI.this.pqa = null;
                }
                AppMethodBeat.o(181538);
            }
        });
        this.qNT = com.tencent.mm.plugin.fav.a.b.arO(this.qNN);
        if (this.qNT != null) {
            this.qNU.clear();
            this.qNU.addAll(this.qNT.field_favProto.ppH);
            int size = this.qNU.size();
            if (size == 0) {
                Log.v("MicroMsg.EditorUI", "favItemInfo has no data!!!");
                AppMethodBeat.o(181607);
                return;
            }
            LinkedList<aml> linkedList = this.qNT.field_favProto.ppH;
            this.qNV.clear();
            this.qNW.clear();
            for (int i2 = size - 1; i2 >= 0; i2--) {
                aml aml = linkedList.get(i2);
                if (!Util.isNullOrNil(aml.LvE)) {
                    o oVar = new o(com.tencent.mm.plugin.fav.a.b.d(aml));
                    Log.i("MicroMsg.EditorUI", "dataFile: %s", oVar.getName());
                    if (oVar.exists()) {
                        Log.d("MicroMsg.EditorUI", "file exist, favId:%d, dataIndex:%d", Integer.valueOf(this.qNT.field_id), Integer.valueOf(i2));
                    } else if (Util.isNullOrNil(aml.Lvp) || Util.isNullOrNil(aml.KuR)) {
                        Log.e("MicroMsg.EditorUI", "data key or url null!!!");
                    } else {
                        Log.d("MicroMsg.EditorUI", "local data not exist, gen cdnInfo.");
                        com.tencent.mm.plugin.fav.a.c a2 = a(aml, 1);
                        this.qNV.put(a2.field_dataId, a2);
                        this.qNW.put(a2.field_dataId, aml);
                        a(a2);
                    }
                }
                if (!Util.isNullOrNil(aml.LvP)) {
                    if (new o(com.tencent.mm.plugin.fav.a.b.a(aml)).exists()) {
                        Log.d("MicroMsg.EditorUI", "thumb exist, favId:%d, dataIndex:%d", Integer.valueOf(this.qNT.field_id), Integer.valueOf(i2));
                    } else if (Util.isNullOrNil(aml.Lvk) || Util.isNullOrNil(aml.iwX)) {
                        Log.w("MicroMsg.EditorUI", "thumb key or url null. favId: %d", Integer.valueOf(this.qNT.field_id));
                    } else {
                        Log.d("MicroMsg.EditorUI", "local thumb not exist, insert cdnInfo, favId:%d, dataIndex:%d", Integer.valueOf(this.qNT.field_id), Integer.valueOf(i2));
                        com.tencent.mm.plugin.fav.a.c a3 = a(aml, 1);
                        this.qNV.put(a3.field_dataId, a3);
                        this.qNW.put(a3.field_dataId, aml);
                        a(a3);
                    }
                }
            }
            cCR();
        }
        AppMethodBeat.o(181607);
    }

    private void cCR() {
        AppMethodBeat.i(181608);
        if (this.qNV.isEmpty()) {
            Log.i("MicroMsg.EditorUI", "download finish, notifyUpdateUI.");
            com.tencent.mm.plugin.editor.model.a.g cCS = cCS();
            if (cCS == null) {
                Log.e("MicroMsg.EditorUI", "weNoteWrapData is null!!!");
                AppMethodBeat.o(181608);
                return;
            }
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDp();
            Iterator<com.tencent.mm.plugin.editor.model.a.d> it = cCS.qPU.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.editor.model.a.d next = it.next();
                switch (next.type) {
                    case -1:
                        com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().e((i) next);
                        break;
                    case 1:
                        com.tencent.mm.plugin.editor.model.a.j jVar = (com.tencent.mm.plugin.editor.model.a.j) next;
                        if (Util.isNullOrNil(jVar.content)) {
                            jVar.content = "";
                        }
                        jVar.content = a.alE(jVar.content);
                        if (jVar.content.length() > 100) {
                            com.tencent.mm.plugin.editor.model.nativenote.a.a.alS(jVar.content);
                        } else if (b.alP(jVar.content)) {
                            jVar.content = jVar.content.substring(0, jVar.content.length() - 5);
                        }
                        com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().e(jVar);
                        break;
                    case 2:
                        com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().e((com.tencent.mm.plugin.editor.model.a.h) next);
                        break;
                    case 4:
                        com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().e((m) next);
                        break;
                    case 6:
                        com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().e((l) next);
                        break;
                }
            }
            cCu();
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDu();
            if (this.pqa != null) {
                this.pqa.dismiss();
                this.pqa = null;
            }
        }
        AppMethodBeat.o(181608);
    }

    private com.tencent.mm.plugin.editor.model.a.g cCS() {
        Bitmap asm;
        ArrayList<String> arrayList;
        AppMethodBeat.i(181609);
        com.tencent.mm.plugin.editor.model.a.g gVar = new com.tencent.mm.plugin.editor.model.a.g();
        Iterator<aml> it = this.qNU.iterator();
        ArrayList<String> arrayList2 = null;
        while (it.hasNext()) {
            aml next = it.next();
            com.tencent.mm.plugin.editor.model.a.d dVar = new com.tencent.mm.plugin.editor.model.a.d();
            dVar.qPN = next.Lwp;
            if (next.dataType == 1) {
                dVar.qPN = "-1";
            }
            if (Util.isNullOrNil(dVar.qPN)) {
                Log.e("MicroMsg.EditorUI", "noteItemData.localEditorId is null or nil.");
                AppMethodBeat.o(181609);
                return null;
            } else if (dVar.qPN.equals("WeNoteHtmlFile")) {
                String d2 = com.tencent.mm.plugin.fav.a.b.d(next);
                if (Util.isNullOrNil(d2) || !com.tencent.mm.vfs.s.YS(d2)) {
                    arrayList = arrayList2;
                } else {
                    try {
                        gVar.qPT = com.tencent.mm.vfs.s.boY(d2);
                        arrayList = b.alN(gVar.qPT);
                        try {
                            Log.i("MicroMsg.EditorUI", "local html file exist, dataId: %s", next.dLl);
                        } catch (Exception e2) {
                            e = e2;
                            Log.printErrStackTrace("MicroMsg.EditorUI", e, "", new Object[0]);
                            Log.i("MicroMsg.EditorUI", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", Boolean.valueOf(Util.isNullOrNil(next.KuR)), Boolean.valueOf(Util.isNullOrNil(next.Lvp)));
                            arrayList2 = arrayList;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        arrayList = arrayList2;
                        Log.printErrStackTrace("MicroMsg.EditorUI", e, "", new Object[0]);
                        Log.i("MicroMsg.EditorUI", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", Boolean.valueOf(Util.isNullOrNil(next.KuR)), Boolean.valueOf(Util.isNullOrNil(next.Lvp)));
                        arrayList2 = arrayList;
                    }
                }
                Log.i("MicroMsg.EditorUI", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", Boolean.valueOf(Util.isNullOrNil(next.KuR)), Boolean.valueOf(Util.isNullOrNil(next.Lvp)));
                arrayList2 = arrayList;
            } else {
                dVar.dLl = next.dLl;
                switch (next.dataType) {
                    case 1:
                        if (!Util.isNullOrNil(next.desc)) {
                            if (gVar.qPU.size() > 0 && gVar.qPU.get(gVar.qPU.size() - 1) != null && gVar.qPU.get(gVar.qPU.size() - 1).qPN.equals("-1")) {
                                com.tencent.mm.plugin.editor.model.a.e eVar = (com.tencent.mm.plugin.editor.model.a.e) gVar.qPU.get(gVar.qPU.size() - 1);
                                eVar.content = eVar.content.concat(next.desc);
                                break;
                            } else {
                                com.tencent.mm.plugin.editor.model.a.j jVar = new com.tencent.mm.plugin.editor.model.a.j();
                                ((com.tencent.mm.plugin.editor.model.a.e) jVar).qPN = dVar.qPN;
                                jVar.content = next.desc;
                                gVar.qPU.add(jVar);
                                break;
                            }
                        } else {
                            continue;
                        }
                    case 2:
                        com.tencent.mm.plugin.editor.model.a.h hVar = new com.tencent.mm.plugin.editor.model.a.h();
                        ((com.tencent.mm.plugin.editor.model.a.c) hVar).qPN = dVar.qPN;
                        ((com.tencent.mm.plugin.editor.model.a.c) hVar).type = 2;
                        ((com.tencent.mm.plugin.editor.model.a.c) hVar).dLl = dVar.dLl;
                        ((com.tencent.mm.plugin.editor.model.a.c) hVar).qPM = next;
                        String d3 = com.tencent.mm.plugin.fav.a.b.d(next);
                        if (!Util.isNullOrNil(d3)) {
                            String str = d3 + "_bigthumb";
                            com.tencent.mm.vfs.s.YS(com.tencent.mm.plugin.fav.a.b.a(next));
                            if (com.tencent.mm.vfs.s.YS(d3)) {
                                ((com.tencent.mm.plugin.editor.model.a.c) hVar).qPO = true;
                                b.fK(d3, str);
                            }
                            ((com.tencent.mm.plugin.editor.model.a.c) hVar).dUs = str;
                            hVar.qPL = d3;
                            gVar.qPU.add(hVar);
                            break;
                        } else {
                            continue;
                        }
                    case 3:
                        m mVar = new m();
                        ((com.tencent.mm.plugin.editor.model.a.f) mVar).qPN = dVar.qPN;
                        ((com.tencent.mm.plugin.editor.model.a.f) mVar).type = 4;
                        ((com.tencent.mm.plugin.editor.model.a.f) mVar).dLl = dVar.dLl;
                        ((com.tencent.mm.plugin.editor.model.a.f) mVar).qPM = next;
                        String d4 = com.tencent.mm.plugin.fav.a.b.d(next);
                        if (!Util.isNullOrNil(d4) && com.tencent.mm.vfs.s.YS(d4)) {
                            ((com.tencent.mm.plugin.editor.model.a.f) mVar).qPO = true;
                            mVar.mav = com.tencent.mm.plugin.editor.model.a.qPf;
                            mVar.length = (int) com.tencent.mm.plugin.editor.model.b.AO((long) next.duration);
                        }
                        ((com.tencent.mm.plugin.editor.model.a.f) mVar).dUs = d4;
                        AppCompatActivity context = getContext();
                        hb hbVar = new hb();
                        hbVar.dLm.type = 21;
                        hbVar.dLm.context = context;
                        hbVar.dLm.dLu = (int) com.tencent.mm.plugin.editor.model.b.AO((long) next.duration);
                        EventCenter.instance.publish(hbVar);
                        mVar.qPR = hbVar.dLn.path;
                        mVar.dLu = next.duration;
                        hb hbVar2 = new hb();
                        hbVar2.dLm.type = 17;
                        hbVar2.dLm.dLo = next;
                        EventCenter.instance.publish(hbVar2);
                        mVar.dLt = hbVar2.dLn.ret;
                        mVar.qPP = next.LvC;
                        gVar.qPU.add(mVar);
                        continue;
                    case 4:
                        l lVar = new l();
                        lVar.qPN = dVar.qPN;
                        lVar.type = 6;
                        lVar.dLl = dVar.dLl;
                        lVar.qPM = next;
                        lVar.duration = next.duration;
                        lVar.thumbPath = com.tencent.mm.plugin.fav.a.b.a(next);
                        String d5 = com.tencent.mm.plugin.fav.a.b.d(next);
                        lVar.dUs = d5;
                        if (!Util.isNullOrNil(lVar.thumbPath) && !com.tencent.mm.vfs.s.YS(lVar.thumbPath) && com.tencent.mm.vfs.s.YS(d5) && (asm = com.tencent.mm.plugin.fav.ui.e.asm(d5)) != null) {
                            try {
                                Log.i("MicroMsg.EditorUI", "add fav service: create thumbPath bitmap, saveBitmapToImage ");
                                BitmapUtil.saveBitmapToImage(asm, 60, Bitmap.CompressFormat.JPEG, lVar.thumbPath, true);
                            } catch (Exception e4) {
                                Log.printErrStackTrace("MicroMsg.EditorUI", e4, "", new Object[0]);
                            }
                        }
                        if (!Util.isNullOrNil(d5) && com.tencent.mm.vfs.s.YS(d5)) {
                            lVar.qPO = true;
                        }
                        gVar.qPU.add(lVar);
                        continue;
                }
            }
        }
        if (arrayList2 != null && arrayList2.size() > 0) {
            com.tencent.mm.plugin.editor.model.b.a(gVar.qPU, arrayList2);
        }
        AppMethodBeat.o(181609);
        return gVar;
    }

    private void cCT() {
        AppMethodBeat.i(181610);
        if (Util.isNullOrNil(b.alQ(com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDw()))) {
            if (this.qNw) {
                this.qNw = false;
                enableOptionMenu(0, false);
                AppMethodBeat.o(181610);
                return;
            }
        } else if (!this.qNw) {
            this.qNw = true;
            enableOptionMenu(0, true);
        }
        AppMethodBeat.o(181610);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.a
    public final void cCU() {
        AppMethodBeat.i(181611);
        cCT();
        AppMethodBeat.o(181611);
    }

    /* access modifiers changed from: package-private */
    public final void a(aml aml, b bVar) {
        com.tencent.mm.plugin.fav.a.c cVar = null;
        AppMethodBeat.i(181601);
        if (Util.isNullOrNil(aml.Lvp)) {
            com.tencent.mm.an.f.baR();
            String baG = com.tencent.mm.an.a.baG();
            aml.bgk(baG);
            Log.i("MicroMsg.EditorUI", "local not exist cdn data key, generate %s", baG);
        }
        if (b.TYPE_FILE == bVar) {
            cVar = a(aml, 0);
        } else if (b.TYPE_THUMB == bVar) {
            if (Util.isNullOrNil(com.tencent.mm.plugin.fav.a.b.a(aml))) {
                Log.e("MicroMsg.EditorUI", "insertCdnThumbInfo, type send, path must not be null!");
            } else {
                String arI = com.tencent.mm.plugin.fav.a.b.arI(aml.dLl);
                cVar = new com.tencent.mm.plugin.fav.a.c();
                cVar.field_cdnKey = aml.Lvk;
                cVar.field_cdnUrl = aml.iwX;
                cVar.field_dataId = arI;
                cVar.field_favLocalId = this.qNT.field_localId;
                cVar.field_totalLen = (int) aml.LvT;
                cVar.field_type = 0;
                cVar.field_status = 1;
                cVar.field_path = com.tencent.mm.plugin.fav.a.b.a(aml);
                cVar.field_modifyTime = Util.nowMilliSecond();
                cVar.field_attrFlag |= 1;
            }
        }
        if (cVar != null) {
            this.qNV.put(cVar.field_dataId, cVar);
            this.qNW.put(cVar.field_dataId, aml);
            a(cVar);
        }
        AppMethodBeat.o(181601);
    }

    static /* synthetic */ void m(EditorUI editorUI) {
        AppMethodBeat.i(181612);
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.editor.EditorUI.AnonymousClass13 */

            public final void run() {
                AppMethodBeat.i(181529);
                try {
                    int kv = ((LinearLayoutManager) EditorUI.this.qNx.getLayoutManager()).kv();
                    com.tencent.mm.plugin.editor.model.a.a Fw = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().Fw(kv);
                    if (Fw != null && Fw.getType() == 4 && !((m) Fw).qPO) {
                        EditorUI.this.Fr(kv);
                    }
                    AppMethodBeat.o(181529);
                } catch (NullPointerException e2) {
                    AppMethodBeat.o(181529);
                }
            }
        });
        AppMethodBeat.o(181612);
    }

    static /* synthetic */ void v(EditorUI editorUI) {
        AppMethodBeat.i(181614);
        if (editorUI.qNV.isEmpty()) {
            String t = com.tencent.mm.plugin.fav.a.g.t(editorUI.qNT);
            Log.d("MicroMsg.EditorUI", "xmlStr res: %s.", t);
            Intent intent = new Intent();
            intent.putExtra("KEY_CONTENT_XML", t);
            editorUI.setResult(-1, intent);
            if (editorUI.pqa != null) {
                editorUI.pqa.dismiss();
                editorUI.pqa = null;
            }
            editorUI.finish();
        }
        AppMethodBeat.o(181614);
    }
}

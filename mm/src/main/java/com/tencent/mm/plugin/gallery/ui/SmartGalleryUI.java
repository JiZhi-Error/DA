package com.tencent.mm.plugin.gallery.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.w;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.s;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.q;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class SmartGalleryUI extends MMActivity {
    public static int xrW = 1;
    private int mcq;
    private ProgressDialog pqa;
    Button rlN;
    private String xjc;
    private RecyclerView xrK;
    private EditText xrL;
    private b xrM;
    private f xrN;
    private e xrO;
    private h xrP;
    private int xrQ;
    private boolean xrR = false;
    w xrS;
    private boolean xrT = true;
    c xrU = new c() {
        /* class com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.AnonymousClass7 */

        @Override // com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.c
        public final void a(s.a aVar) {
            String str;
            AppMethodBeat.i(111677);
            Log.i("MicroMsg.SmartGalleryUI", "onAlbumClick, albumId: %s, albumName: %s.", aVar.xjJ, aVar.albumName);
            Intent intent = new Intent(SmartGalleryUI.this, AlbumPreviewUI.class);
            intent.putExtras(SmartGalleryUI.this.getIntent());
            intent.putExtra("send_raw_img", SmartGalleryUI.this.xrV);
            if (!SmartGalleryUI.this.xrR) {
                intent.putExtra("select_type_tag", 2);
            } else if (aVar.xjN == null || !aVar.xjN.xjO) {
                intent.putExtra("select_type_tag", 0);
            } else {
                intent.putExtra("select_type_tag", 1);
            }
            try {
                if (aVar.xjI == null || aVar.xjI.xjU == null) {
                    str = "";
                } else {
                    str = aVar.xjI.xjU;
                }
                String str2 = "";
                if (aVar.albumName != null) {
                    str2 = aVar.albumName;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(18269, URLEncoder.encode(str, ProtocolPackage.ServerEncoding), URLEncoder.encode(str2, ProtocolPackage.ServerEncoding));
            } catch (Exception e2) {
            }
            intent.putExtra("is_from_smart_gallery", true);
            String str3 = aVar.albumName;
            if (Util.isNullOrNil(str3)) {
                str3 = aVar.xjI.xjU;
            }
            intent.putExtra("title_from_smart_gallery", str3);
            intent.putExtra("album_id_from_smart_gallery", aVar.xjJ);
            SmartGalleryUI.this.startActivityForResult(intent, 1);
            AppMethodBeat.o(111677);
        }
    };
    private boolean xrV = false;

    /* access modifiers changed from: package-private */
    public interface c {
        void a(s.a aVar);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SmartGalleryUI() {
        AppMethodBeat.i(111703);
        AppMethodBeat.o(111703);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.btg;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(111704);
        super.onCreate(bundle);
        this.mcq = getIntent().getIntExtra("query_source_type", 3);
        this.xrQ = getIntent().getIntExtra("max_select_count", 9);
        this.xjc = getIntent().getStringExtra("album_business_tag");
        this.xrV = getIntent().getBooleanExtra("send_raw_img", false);
        this.pqa = q.b(this, getString(R.string.a06), true, 0, null);
        this.pqa.show();
        setActionbarColor(getResources().getColor(R.color.s0));
        setNavigationbarColor(getResources().getColor(R.color.s0));
        View inflate = LayoutInflater.from(this).inflate(R.layout.b_, (ViewGroup) new LinearLayout(this), false);
        inflate.findViewById(R.id.ht5).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(111671);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (Util.isNullOrNil(SmartGalleryUI.this.xrL.getText())) {
                    SmartGalleryUI.this.setResult(-2, SmartGalleryUI.this.getIntent().putExtra("send_raw_img", SmartGalleryUI.this.xrV));
                    SmartGalleryUI.this.finish();
                } else {
                    SmartGalleryUI.this.xrL.setText("");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(111671);
            }
        });
        this.xrL = (EditText) inflate.findViewById(R.id.ht7);
        this.xrL.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(111672);
                if (!SmartGalleryUI.this.xrT) {
                    SmartGalleryUI.this.xrT = true;
                }
                AppMethodBeat.o(111672);
                return false;
            }
        });
        this.xrL.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.AnonymousClass3 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(111673);
                if (3 == i2) {
                    String charSequence = textView.getText().toString();
                    if (!Util.isNullOrNil(charSequence)) {
                        SmartGalleryUI.a(SmartGalleryUI.this, charSequence, true);
                        AppMethodBeat.o(111673);
                        return true;
                    }
                }
                AppMethodBeat.o(111673);
                return false;
            }
        });
        this.xrL.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.AnonymousClass4 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(111674);
                String obj = editable.toString();
                Log.d("MicroMsg.SmartGalleryUI", "cur txt: %s.", obj);
                SmartGalleryUI.this.xrP.xsj = obj;
                if (Util.isNullOrNil(obj)) {
                    SmartGalleryUI.this.xrR = false;
                    SmartGalleryUI.this.xrK.setAdapter(SmartGalleryUI.this.xrM);
                    SmartGalleryUI.this.xrK.a(SmartGalleryUI.this.xrS);
                    SmartGalleryUI.this.xrM.atj.notifyChanged();
                    AppMethodBeat.o(111674);
                    return;
                }
                SmartGalleryUI.a(SmartGalleryUI.this, obj, false);
                AppMethodBeat.o(111674);
            }
        });
        this.rlN = (Button) inflate.findViewById(R.id.ht8);
        dSt();
        this.rlN.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(111675);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SmartGalleryUI.this.setResult(SmartGalleryUI.xrW);
                SmartGalleryUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(111675);
            }
        });
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setLogo(new ColorDrawable(getContext().getResources().getColor(17170445)));
            supportActionBar.gt();
            supportActionBar.setDisplayHomeAsUpEnabled(false);
            supportActionBar.gs();
            supportActionBar.gu();
            supportActionBar.setCustomView(inflate);
        } else {
            Log.e("MicroMsg.SmartGalleryUI", "actionbar is null.");
        }
        this.xrS = new w(this, 1);
        this.xrS.setDrawable(getResources().getDrawable(R.drawable.au3));
        this.xrK = (RecyclerView) findViewById(R.id.ht6);
        this.xrK.a(new RecyclerView.l() {
            /* class com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.AnonymousClass6 */

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                AppMethodBeat.i(257760);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                bVar.pH(i3);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                super.onScrolled(recyclerView, i2, i3);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(257760);
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                AppMethodBeat.i(111676);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                Log.d("MicroMsg.SmartGalleryUI", "onScrollStateChanged, newState: %d, mIsNeedReset: %s.", Integer.valueOf(i2), Boolean.valueOf(SmartGalleryUI.this.xrT));
                if (1 == i2 && SmartGalleryUI.this.xrT) {
                    SmartGalleryUI.this.xrT = false;
                    SmartGalleryUI.this.hideVKB();
                    SmartGalleryUI.this.xrL.clearFocus();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$6", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                AppMethodBeat.o(111676);
            }
        });
        this.xrK.a(this.xrS);
        this.xrM = new b(this);
        this.xrM.xrU = this.xrU;
        this.xrN = new f(this);
        this.xrN.xrU = this.xrU;
        this.xrK.setLayoutManager(new LinearLayoutManager());
        this.xrK.setAdapter(this.xrM);
        this.xrP = new h(this.xrK, this.xrN);
        this.xrO = new e(this.xrP);
        com.tencent.mm.plugin.gallery.model.e.dQL().ar(new d(this.xrM, this.pqa, this.xrL));
        AppMethodBeat.o(111704);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(111705);
        super.onResume();
        dSt();
        AppMethodBeat.o(111705);
    }

    private void dSt() {
        AppMethodBeat.i(111706);
        int dRz = s.dRv().dRz();
        if (dRz > 0) {
            this.rlN.setEnabled(true);
        } else {
            this.rlN.setEnabled(false);
        }
        this.rlN.setText(com.tencent.mm.plugin.gallery.a.d.a(this, this.mcq, dRz, this.xrQ, this.xjc, null));
        AppMethodBeat.o(111706);
    }

    static class d implements Runnable {
        WeakReference<b> xsg;
        WeakReference<ProgressDialog> xsh;
        WeakReference<EditText> xsi;

        d(b bVar, ProgressDialog progressDialog, EditText editText) {
            AppMethodBeat.i(111689);
            this.xsg = new WeakReference<>(bVar);
            this.xsh = new WeakReference<>(progressDialog);
            this.xsi = new WeakReference<>(editText);
            AppMethodBeat.o(111689);
        }

        public final void run() {
            AppMethodBeat.i(111690);
            long currentTimeMillis = System.currentTimeMillis();
            Log.i("MicroMsg.SmartGalleryUI", "start query category album.");
            s dRv = s.dRv();
            ArrayList arrayList = new ArrayList();
            Cursor query = dRv.hwt.query(s.BASE_URI.buildUpon().appendEncodedPath("albums").build(), s.dRw(), null, null, null);
            if (query != null) {
                int columnIndex = query.getColumnIndex("categoryID");
                int columnIndex2 = query.getColumnIndex("categoryName");
                int columnIndex3 = query.getColumnIndex("albumID");
                int columnIndex4 = query.getColumnIndex("albumName");
                int columnIndex5 = query.getColumnIndex("albumCapacity");
                int columnIndex6 = query.getColumnIndex("coverID");
                int columnIndex7 = query.getColumnIndex("coverData");
                int columnIndex8 = query.getColumnIndex("albumTag");
                while (query.moveToNext()) {
                    s.a aVar = new s.a();
                    aVar.hD(query.getString(columnIndex), query.getString(columnIndex2));
                    aVar.xjJ = query.getString(columnIndex3);
                    aVar.albumName = query.getString(columnIndex4);
                    aVar.xjK = Util.safeParseInt(query.getString(columnIndex5));
                    aVar.xjL = Util.safeParseLong(query.getString(columnIndex6));
                    aVar.xjM = query.getString(columnIndex7);
                    String string = query.getString(columnIndex8);
                    if (!Util.isNullOrNil(string)) {
                        aVar.xjN = s.hC(string, aVar.xjJ);
                    }
                    arrayList.add(aVar);
                }
                query.close();
            }
            s.c eV = s.eV(arrayList);
            Log.i("MicroMsg.SmartGalleryUI", "finish query category album.");
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(19165, "", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            g gVar = new g(this.xsg, eV);
            gVar.xsh = this.xsh;
            gVar.xsi = this.xsi;
            com.tencent.mm.plugin.gallery.model.e.dQL().postToMainThread(gVar);
            AppMethodBeat.o(111690);
        }
    }

    static class g implements Runnable {
        s.c xse;
        WeakReference<b> xsg;
        WeakReference<ProgressDialog> xsh;
        WeakReference<EditText> xsi;

        g(WeakReference<b> weakReference, s.c cVar) {
            this.xsg = weakReference;
            this.xse = cVar;
        }

        public final void run() {
            EditText editText;
            ProgressDialog progressDialog;
            AppMethodBeat.i(111700);
            if (!(this.xsg == null || this.xse == null)) {
                b bVar = this.xsg.get();
                if (bVar != null) {
                    Log.i("MicroMsg.SmartGalleryUI", "show category.");
                    bVar.xse = this.xse;
                    bVar.atj.notifyChanged();
                }
                if (!(this.xsh == null || (progressDialog = this.xsh.get()) == null)) {
                    Log.i("MicroMsg.SmartGalleryUI", "tipDialog dismiss.");
                    progressDialog.dismiss();
                }
                if (!(this.xsi == null || (editText = this.xsi.get()) == null)) {
                    Log.i("MicroMsg.SmartGalleryUI", "show keyboard.");
                    editText.requestFocus();
                    ((InputMethodManager) editText.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
                }
            }
            AppMethodBeat.o(111700);
        }
    }

    /* access modifiers changed from: package-private */
    public static class h implements Runnable {
        List<s.i> qXp = new ArrayList();
        String xsj;
        WeakReference<RecyclerView> xsm;
        WeakReference<f> xsn;

        h(RecyclerView recyclerView, f fVar) {
            AppMethodBeat.i(111701);
            this.xsm = new WeakReference<>(recyclerView);
            this.xsn = new WeakReference<>(fVar);
            AppMethodBeat.o(111701);
        }

        public final void run() {
            f fVar;
            AppMethodBeat.i(111702);
            if (this.xsm == null || this.xsn == null) {
                Log.e("MicroMsg.SmartGalleryUI", "update search ui, ref is null, return.");
                AppMethodBeat.o(111702);
            } else if (this.qXp != null) {
                RecyclerView recyclerView = this.xsm.get();
                if (!(recyclerView == null || (fVar = this.xsn.get()) == null)) {
                    recyclerView.setAdapter(fVar);
                    fVar.xsj = this.xsj;
                    List<s.i> list = this.qXp;
                    fVar.qXp.clear();
                    fVar.qXp.addAll(list);
                    fVar.atj.notifyChanged();
                }
                AppMethodBeat.o(111702);
            } else {
                Log.e("MicroMsg.SmartGalleryUI", "update search ui, data is null.");
                AppMethodBeat.o(111702);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class e implements Runnable {
        String xsj;
        h xsk;

        e(h hVar) {
            this.xsk = hVar;
        }

        public final void run() {
            AppMethodBeat.i(111691);
            if (Util.isNullOrNil(this.xsj)) {
                Log.e("MicroMsg.SmartGalleryUI", "keyword is invalid.");
                AppMethodBeat.o(111691);
                return;
            }
            Log.i("MicroMsg.SmartGalleryUI", "query search start.");
            s dRv = s.dRv();
            String str = this.xsj;
            ArrayList arrayList = new ArrayList();
            Cursor query = dRv.hwt.query(s.BASE_URI.buildUpon().appendEncodedPath("search").build(), new String[]{"categoryID", "categoryName", "albumID", "albumName", "albumCapacity", "coverID", "coverData", "albumTag"}, "keyword=?", new String[]{str}, null);
            if (query != null) {
                int columnIndex = query.getColumnIndex("categoryID");
                int columnIndex2 = query.getColumnIndex("categoryName");
                int columnIndex3 = query.getColumnIndex("albumID");
                int columnIndex4 = query.getColumnIndex("albumName");
                int columnIndex5 = query.getColumnIndex("albumCapacity");
                int columnIndex6 = query.getColumnIndex("coverID");
                int columnIndex7 = query.getColumnIndex("coverData");
                int columnIndex8 = query.getColumnIndex("albumTag");
                while (query.moveToNext()) {
                    s.a aVar = new s.a();
                    aVar.hD(query.getString(columnIndex), query.getString(columnIndex2));
                    aVar.xjJ = query.getString(columnIndex3);
                    aVar.albumName = query.getString(columnIndex4);
                    aVar.xjK = Util.safeParseInt(query.getString(columnIndex5));
                    aVar.xjL = Util.safeParseLong(query.getString(columnIndex6));
                    aVar.xjM = query.getString(columnIndex7);
                    String string = query.getString(columnIndex8);
                    if (!Util.isNullOrNil(string)) {
                        aVar.xjN = s.hC(string, aVar.xjJ);
                    }
                    arrayList.add(aVar);
                }
                query.close();
            }
            List<s.i> n = s.n(arrayList, str);
            Log.i("MicroMsg.SmartGalleryUI", "query search finish.");
            try {
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr = new Object[2];
                objArr[0] = URLEncoder.encode(this.xsj, ProtocolPackage.ServerEncoding);
                objArr[1] = Integer.valueOf(n.size() == 0 ? 0 : 1);
                hVar.a(18270, objArr);
            } catch (Exception e2) {
            }
            if (Util.isNullOrNil(this.xsk.xsj) || !this.xsk.xsj.equals(this.xsj)) {
                Log.i("MicroMsg.SmartGalleryUI", "mKeyword: %s, cur: %s.", this.xsj, this.xsk.xsj);
                AppMethodBeat.o(111691);
                return;
            }
            h hVar2 = this.xsk;
            hVar2.qXp.clear();
            hVar2.qXp.addAll(n);
            com.tencent.mm.plugin.gallery.model.e.dQL().postToMainThread(this.xsk);
            AppMethodBeat.o(111691);
        }
    }

    /* access modifiers changed from: package-private */
    public static class b extends RecyclerView.a<a> {
        private Context mContext;
        c xrU;
        s.c xse;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(a aVar, int i2) {
            GridLayoutManager gridLayoutManager;
            AppMethodBeat.i(111687);
            a aVar2 = aVar;
            Log.i("MicroMsg.SmartGalleryUI", "CategoryAlbumAdapter onBindViewHolder: %d.", Integer.valueOf(i2));
            if (this.xse != null) {
                s.d dVar = this.xse.xjR.get(i2);
                aVar2.pYi.setText(dVar.xjU);
                Log.i("MicroMsg.SmartGalleryUI", "category id: %s, category name: %s.", dVar.xjT, dVar.xjU);
                List<s.a> list = this.xse.xjS.get(dVar);
                if (Util.isNullOrNil(list)) {
                    Log.e("MicroMsg.SmartGalleryUI", "album info list invalid.");
                    AppMethodBeat.o(111687);
                    return;
                }
                if (list.size() > 4) {
                    gridLayoutManager = new GridLayoutManager(2, 0);
                } else {
                    gridLayoutManager = new GridLayoutManager(1, 0);
                }
                aVar2.xsf.setLayoutManager(gridLayoutManager);
                a aVar3 = new a(this.mContext);
                if (this.xrU != null) {
                    aVar3.xrU = this.xrU;
                }
                aVar2.xsf.setAdapter(aVar3);
                aVar3.xrY.clear();
                aVar3.xrY.addAll(list);
                aVar3.atj.notifyChanged();
            }
            AppMethodBeat.o(111687);
        }

        b(Context context) {
            this.mContext = context;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(111686);
            if (this.xse == null) {
                AppMethodBeat.o(111686);
                return 0;
            }
            int size = this.xse.xjS.size();
            AppMethodBeat.o(111686);
            return size;
        }

        static class a extends RecyclerView.v {
            TextView pYi;
            RecyclerView xsf;

            a(View view) {
                super(view);
                AppMethodBeat.i(111685);
                this.pYi = (TextView) view.findViewById(R.id.aq0);
                ao.a(this.pYi.getPaint(), 0.8f);
                this.xsf = (RecyclerView) view.findViewById(R.id.apz);
                AppMethodBeat.o(111685);
            }
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(111688);
            a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.btf, viewGroup, false));
            AppMethodBeat.o(111688);
            return aVar;
        }
    }

    static class a extends RecyclerView.a<C1389a> {
        View.OnClickListener ko = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.a.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(111678);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$AlbumInfoAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Object tag = view.getTag();
                if ((tag instanceof s.a) && a.this.xrU != null) {
                    a.this.xrU.a((s.a) tag);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$AlbumInfoAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(111678);
            }
        };
        private Context mContext;
        private View.OnLongClickListener xnu = new View.OnLongClickListener() {
            /* class com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.a.AnonymousClass2 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(111679);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$AlbumInfoAdapter$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                Object tag = view.getTag();
                if (tag instanceof s.a) {
                    ClipboardHelper.setText(a.this.mContext, "media info", ((s.a) tag).toString());
                }
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$AlbumInfoAdapter$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(111679);
                return true;
            }
        };
        c xrU;
        List<s.a> xrY;
        private int xrZ;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(C1389a aVar, int i2) {
            int i3;
            Object obj;
            s.e eVar;
            AppMethodBeat.i(111683);
            C1389a aVar2 = aVar;
            s.a aVar3 = this.xrY.get(i2);
            aVar2.aus.setTag(aVar3);
            aVar2.aus.setOnClickListener(this.ko);
            s.b bVar = aVar3.xjN;
            if (bVar != null) {
                i3 = bVar.xjP ? 2 : 1;
            } else {
                i3 = 1;
            }
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = aVar3.xjM;
            objArr[2] = aVar3.albumName;
            if (bVar == null) {
                obj = "";
            } else {
                obj = bVar;
            }
            objArr[3] = obj;
            Log.d("MicroMsg.SmartGalleryUI", "position: %s, filePath: %s, albumName: %s, albumTag: %s.", objArr);
            ImageView imageView = aVar2.xsb;
            String str = aVar3.xjM;
            String str2 = aVar3.xjM;
            long j2 = aVar3.xjL;
            if (aVar3.xjN == null) {
                eVar = null;
            } else {
                eVar = aVar3.xjN.xhZ;
            }
            h.a(imageView, i3, str, str2, j2, eVar);
            aVar2.xsc.setText(aVar3.albumName);
            aVar2.xsd.setText(String.valueOf(aVar3.xjK));
            aVar2.aus.setOnLongClickListener(this.xnu);
            AppMethodBeat.o(111683);
        }

        a(Context context) {
            AppMethodBeat.i(111681);
            this.mContext = context;
            this.xrY = new ArrayList();
            this.xrZ = (((this.mContext.getResources().getDisplayMetrics().widthPixels - at.aH(this.mContext, R.dimen.cb)) - (at.aH(this.mContext, R.dimen.ct) * 4)) / 9) * 2;
            Log.d("MicroMsg.SmartGalleryUI", "mThumbSize: %d.", Integer.valueOf(this.xrZ));
            AppMethodBeat.o(111681);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(111682);
            int size = this.xrY.size();
            AppMethodBeat.o(111682);
            return size;
        }

        /* renamed from: com.tencent.mm.plugin.gallery.ui.SmartGalleryUI$a$a  reason: collision with other inner class name */
        static class C1389a extends RecyclerView.v {
            ImageView xsb;
            TextView xsc;
            TextView xsd;

            C1389a(View view, int i2) {
                super(view);
                AppMethodBeat.i(111680);
                this.xsb = (ImageView) view.findViewById(R.id.jq);
                ViewGroup.LayoutParams layoutParams = this.xsb.getLayoutParams();
                layoutParams.width = i2;
                layoutParams.height = i2;
                this.xsb.setLayoutParams(layoutParams);
                this.xsc = (TextView) view.findViewById(R.id.kh);
                this.xsd = (TextView) view.findViewById(R.id.j3);
                AppMethodBeat.o(111680);
            }
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ C1389a a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(111684);
            C1389a aVar = new C1389a(LayoutInflater.from(this.mContext).inflate(R.layout.bte, viewGroup, false), this.xrZ);
            AppMethodBeat.o(111684);
            return aVar;
        }
    }

    static class f extends RecyclerView.a<RecyclerView.v> {
        private View.OnClickListener ko = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.f.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(111692);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$SearchAlbumAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Object tag = view.getTag();
                if ((tag instanceof s.a) && f.this.xrU != null) {
                    f.this.xrU.a((s.a) tag);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/SmartGalleryUI$SearchAlbumAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(111692);
            }
        };
        private Context mContext;
        List<s.i> qXp;
        c xrU;
        String xsj;

        f(Context context) {
            AppMethodBeat.i(111695);
            this.mContext = context;
            this.qXp = new ArrayList();
            AppMethodBeat.o(111695);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(111696);
            if (i2 == 0) {
                b bVar = new b(LayoutInflater.from(this.mContext).inflate(R.layout.bti, viewGroup, false));
                AppMethodBeat.o(111696);
                return bVar;
            } else if (1 == i2) {
                a aVar = new a(LayoutInflater.from(this.mContext).inflate(R.layout.bth, viewGroup, false));
                AppMethodBeat.o(111696);
                return aVar;
            } else {
                c cVar = new c(LayoutInflater.from(this.mContext).inflate(R.layout.btj, viewGroup, false));
                AppMethodBeat.o(111696);
                return cVar;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2) {
            s.e eVar;
            int i3 = 1;
            AppMethodBeat.i(111697);
            if (vVar instanceof b) {
                ((b) vVar).pYi.setText(((s.d) this.qXp.get(i2)).xjU);
                AppMethodBeat.o(111697);
            } else if (vVar instanceof a) {
                s.a aVar = (s.a) this.qXp.get(i2);
                vVar.aus.setOnClickListener(this.ko);
                vVar.aus.setTag(aVar);
                s.b bVar = aVar.xjN;
                if (bVar != null) {
                    i3 = bVar.xjP ? 2 : 1;
                }
                a aVar2 = (a) vVar;
                ImageView imageView = aVar2.xsb;
                String str = aVar.xjM;
                String str2 = aVar.xjM;
                long j2 = aVar.xjL;
                if (aVar.xjN == null) {
                    eVar = null;
                } else {
                    eVar = aVar.xjN.xhZ;
                }
                h.a(imageView, i3, str, str2, j2, eVar);
                aVar2.xsc.setText(com.tencent.mm.plugin.fts.a.f.b(aVar.albumName, this.xsj));
                aVar2.xsd.setText(String.valueOf(aVar.xjK));
                AppMethodBeat.o(111697);
            } else {
                if (vVar instanceof c) {
                    Log.i("MicroMsg.SmartGalleryUI", "no search result.");
                }
                AppMethodBeat.o(111697);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(111698);
            if (this.qXp.size() == 0) {
                this.qXp.add(new s.f());
            }
            int size = this.qXp.size();
            AppMethodBeat.o(111698);
            return size;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(111699);
            int i3 = this.qXp.get(i2).mType;
            AppMethodBeat.o(111699);
            return i3;
        }

        static class a extends RecyclerView.v {
            private ImageView xsb;
            private TextView xsc;
            private TextView xsd;

            a(View view) {
                super(view);
                AppMethodBeat.i(111693);
                this.xsb = (ImageView) view.findViewById(R.id.jq);
                this.xsc = (TextView) view.findViewById(R.id.kh);
                this.xsd = (TextView) view.findViewById(R.id.j3);
                AppMethodBeat.o(111693);
            }
        }

        static class b extends RecyclerView.v {
            private TextView pYi;

            b(View view) {
                super(view);
                AppMethodBeat.i(111694);
                this.pYi = (TextView) view.findViewById(R.id.aq0);
                ao.a(this.pYi.getPaint(), 0.8f);
                AppMethodBeat.o(111694);
            }
        }

        static class c extends RecyclerView.v {
            c(View view) {
                super(view);
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(111707);
        Log.i("MicroMsg.SmartGalleryUI", "requestCode: %d, resultCode: %d.", Integer.valueOf(i2), Integer.valueOf(i3));
        if (intent != null) {
            this.xrV = intent.getBooleanExtra("send_raw_img", false);
            intent.putExtra("send_raw_img", this.xrV);
            Bundle extras = intent.getExtras();
            if (extras != null) {
                for (String str : extras.keySet()) {
                    Log.i("MicroMsg.SmartGalleryUI", "key: %s, value: %s.", str, extras.get(str));
                }
            }
        }
        if (1 == i2) {
            if (-2 == i3 || i3 == 0) {
                Log.i("MicroMsg.SmartGalleryUI", "just back from AlbumPreviewUI.");
                dSt();
                AppMethodBeat.o(111707);
                return;
            }
            setResult(i3, intent);
            finish();
        }
        AppMethodBeat.o(111707);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(111708);
        if (4 == i2 && keyEvent.getRepeatCount() == 0) {
            if (Util.isNullOrNil(this.xrL.getText())) {
                setResult(-2, getIntent().putExtra("send_raw_img", this.xrV));
                finish();
            } else {
                this.xrL.setText("");
            }
            AppMethodBeat.o(111708);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(111708);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(111709);
        super.onPause();
        this.xrL.clearFocus();
        AppMethodBeat.o(111709);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(111710);
        super.onDestroy();
        s.dRv().dRy();
        AppMethodBeat.o(111710);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    static /* synthetic */ void a(SmartGalleryUI smartGalleryUI, String str, boolean z) {
        AppMethodBeat.i(111711);
        smartGalleryUI.xrR = true;
        if (z) {
            smartGalleryUI.hideVKB();
            smartGalleryUI.xrL.clearFocus();
        }
        smartGalleryUI.xrK.c(smartGalleryUI.xrS);
        smartGalleryUI.xrO.xsj = str;
        com.tencent.mm.plugin.gallery.model.e.dQL().ar(smartGalleryUI.xrO);
        AppMethodBeat.o(111711);
    }
}

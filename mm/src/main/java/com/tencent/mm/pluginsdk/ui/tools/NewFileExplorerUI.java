package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.n.c;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.s;
import com.tencent.mm.vfs.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class NewFileExplorerUI extends MMActivity {
    private TextView Bvi;
    private a Kwh;
    private TextView Kwi;
    private FileSelectorFolderView Kwj;
    private o.a Kwk;
    private FileSelectorFolderView.a Kwl = new FileSelectorFolderView.a() {
        /* class com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.AnonymousClass7 */

        @Override // com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView.a
        public final void aiQ(int i2) {
            AppMethodBeat.i(31985);
            Log.i("MicroMsg.FileExplorerUI", "position: %d", Integer.valueOf(i2));
            if (i2 == 0) {
                NewFileExplorerUI.this.setMMTitle(R.string.cdv);
                NewFileExplorerUI.this.setMMSubTitle((String) null);
                NewFileExplorerUI.this.Kwi = (TextView) NewFileExplorerUI.this.findViewById(R.id.cg3);
                NewFileExplorerUI.this.Kwi.setText(R.string.cdv);
                NewFileExplorerUI.this.Kwh.c(new com.tencent.mm.vfs.o(b.aKM()), true);
                NewFileExplorerUI.this.Kwh.a(new com.tencent.mm.vfs.o(b.aKM()), null);
            } else {
                NewFileExplorerUI.this.Kwh.c(new com.tencent.mm.vfs.o(b.aKE()), false);
                NewFileExplorerUI.this.Kwh.a(new com.tencent.mm.vfs.o(b.aKE()), null);
                NewFileExplorerUI.this.setMMTitle(R.string.cdw);
                NewFileExplorerUI.this.Kwi.setText(R.string.cdw);
            }
            NewFileExplorerUI.this.Kwh.notifyDataSetChanged();
            NewFileExplorerUI.c(NewFileExplorerUI.this);
            AppMethodBeat.o(31985);
        }
    };
    private String dJw;
    private ListView krb;
    private int mode = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public NewFileExplorerUI() {
        AppMethodBeat.i(32013);
        AppMethodBeat.o(32013);
    }

    static /* synthetic */ void c(NewFileExplorerUI newFileExplorerUI) {
        AppMethodBeat.i(32021);
        newFileExplorerUI.gsC();
        AppMethodBeat.o(32021);
    }

    static /* synthetic */ void d(NewFileExplorerUI newFileExplorerUI) {
        AppMethodBeat.i(32022);
        newFileExplorerUI.Aq(true);
        AppMethodBeat.o(32022);
    }

    static /* synthetic */ void h(NewFileExplorerUI newFileExplorerUI) {
        AppMethodBeat.i(32024);
        newFileExplorerUI.dmp();
        AppMethodBeat.o(32024);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bft;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(32014);
        super.onCreate(bundle);
        this.dJw = getIntent().getStringExtra("TO_USER");
        this.krb = (ListView) findViewById(R.id.cg5);
        this.Kwh = new a();
        this.Bvi = (TextView) findViewById(R.id.hiw);
        this.mode = getIntent().getIntExtra("explorer_mode", 0);
        if (this.mode == 1) {
            setMMTitle(R.string.cdy);
            setMMSubTitle((String) null);
            this.Kwh.a(null, getIntent().getStringArrayListExtra("selected_file_lst"));
        } else {
            setMMTitle(R.string.cdv);
            setMMSubTitle((String) null);
            this.Kwi = (TextView) findViewById(R.id.cg3);
            this.Kwi.setText(R.string.cdv);
            this.Kwh.c(new com.tencent.mm.vfs.o(b.aKM()), true);
            this.Kwh.a(new com.tencent.mm.vfs.o(b.aKM()), null);
            if (this.Kwh.getCount() == 0) {
                this.Kwh.c(new com.tencent.mm.vfs.o(b.aKE()), false);
                this.Kwh.a(new com.tencent.mm.vfs.o(b.aKE()), null);
                setMMTitle(R.string.cdw);
                this.Kwi.setText(R.string.cdw);
            }
            findViewById(R.id.cg1).setVisibility(0);
            findViewById(R.id.cg1).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.AnonymousClass1 */

                public final void onClick(View view) {
                    boolean z;
                    AppMethodBeat.i(31979);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (NewFileExplorerUI.this.Kwj != null) {
                        FileSelectorFolderView fileSelectorFolderView = NewFileExplorerUI.this.Kwj;
                        if (!fileSelectorFolderView.jT) {
                            z = true;
                        } else {
                            z = false;
                        }
                        fileSelectorFolderView.pD(z);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(31979);
                }
            });
            this.Kwj = (FileSelectorFolderView) findViewById(R.id.cg2);
            this.Kwj.setListener(this.Kwl);
        }
        this.krb.setAdapter((ListAdapter) this.Kwh);
        this.krb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(31980);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                com.tencent.mm.vfs.o oVar = NewFileExplorerUI.this.Kwh.KtX[i2];
                if (oVar.isDirectory()) {
                    NewFileExplorerUI.this.Kwh.a(oVar, null);
                    NewFileExplorerUI.this.Kwh.notifyDataSetChanged();
                    NewFileExplorerUI.c(NewFileExplorerUI.this);
                } else {
                    a.b(NewFileExplorerUI.this, aa.z(oVar.mUri), s.akC(aa.z(oVar.mUri)), 1);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(31980);
            }
        });
        this.krb.setEmptyView(findViewById(R.id.cg0));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(31981);
                NewFileExplorerUI.d(NewFileExplorerUI.this);
                AppMethodBeat.o(31981);
                return false;
            }
        }, this.mode == 0 ? R.raw.actionbar_quit_webview_icon : 0);
        if (this.mode == 0) {
            addTextOptionMenu(1, getString(R.string.yq), new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.AnonymousClass4 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(31982);
                    NewFileExplorerUI.e(NewFileExplorerUI.this);
                    AppMethodBeat.o(31982);
                    return true;
                }
            }, null, t.b.GREEN);
        }
        dmp();
        AppMethodBeat.o(32014);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(32015);
        super.onDestroy();
        AppMethodBeat.o(32015);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(32016);
        if (i2 == 4) {
            Aq(false);
            AppMethodBeat.o(32016);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(32016);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(32017);
        if (i2 == 0 && i3 == -1) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("selected_file_lst");
            if (!(stringArrayListExtra == null || this.Kwh.Kwn.size() == stringArrayListExtra.size())) {
                this.Kwk.kdo.dismiss();
                this.Kwh.Kwn.clear();
                Iterator<String> it = stringArrayListExtra.iterator();
                while (it.hasNext()) {
                    this.Kwh.Kwn.add(new com.tencent.mm.vfs.o(it.next()));
                }
                this.Kwh.notifyDataSetChanged();
                gsC();
                dmp();
            }
            AppMethodBeat.o(32017);
            return;
        }
        if (i2 == 2) {
            a.a((Activity) this, i2, i3, intent, true, (int) R.string.bny, (int) R.string.bnz, 1);
        }
        AppMethodBeat.o(32017);
    }

    private void Aq(boolean z) {
        AppMethodBeat.i(32018);
        if (this.mode != 0) {
            Intent intent = new Intent();
            intent.putStringArrayListExtra("selected_file_lst", this.Kwh.gsD());
            intent.putStringArrayListExtra("key_select_video_list", this.Kwh.gsF());
            intent.putStringArrayListExtra("CropImage_OutputPath_List", this.Kwh.gsE());
            intent.putExtra("GalleryUI_ToUser", this.dJw);
            setResult(-1, intent);
            finish();
            AppMethodBeat.o(32018);
        } else if (z || this.Kwh.gst() == null) {
            setResult(0);
            finish();
            AppMethodBeat.o(32018);
        } else {
            this.Kwh.a(this.Kwh.gst(), null);
            this.Kwh.notifyDataSetChanged();
            gsC();
            AppMethodBeat.o(32018);
        }
    }

    private void dmp() {
        AppMethodBeat.i(32019);
        int size = this.Kwh.Kwn.size();
        if (size > 0) {
            if (this.mode == 0) {
                updateOptionMenuText(1, getString(R.string.yq) + "(" + size + "/9)");
                enableOptionMenu(1, true);
            }
            this.Bvi.setText(getString(R.string.cdx, new Object[]{Util.getSizeKB((long) this.Kwh.eGR())}));
            this.Bvi.setVisibility(0);
            AppMethodBeat.o(32019);
            return;
        }
        if (this.mode == 0) {
            updateOptionMenuText(1, getString(R.string.yq));
            enableOptionMenu(1, false);
        }
        this.Bvi.setVisibility(8);
        AppMethodBeat.o(32019);
    }

    private void gsC() {
        AppMethodBeat.i(32020);
        if (!(this.Kwh.Kva == null || this.Kwh.KtW == null)) {
            String replace = aa.z(this.Kwh.KtW.mUri).replace(aa.z(this.Kwh.Kva.mUri), "");
            if (replace.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                replace = replace.substring(1);
            }
            if (replace.length() == 0) {
                replace = null;
            }
            setMMSubTitle(replace);
        }
        AppMethodBeat.o(32020);
    }

    public class a extends BaseAdapter {
        private com.tencent.mm.vfs.o KtW;
        com.tencent.mm.vfs.o[] KtX = new com.tencent.mm.vfs.o[0];
        private com.tencent.mm.vfs.o Kva;
        private boolean Kvb = false;
        private ArrayList<com.tencent.mm.vfs.o> Kwn = new ArrayList<>();

        public a() {
            AppMethodBeat.i(31990);
            AppMethodBeat.o(31990);
        }

        public final void c(com.tencent.mm.vfs.o oVar, boolean z) {
            this.Kva = oVar;
            this.Kvb = z;
        }

        public final void a(com.tencent.mm.vfs.o oVar, List<String> list) {
            AppMethodBeat.i(169797);
            this.KtW = oVar;
            if (this.KtW != null && this.KtW.canRead() && this.KtW.isDirectory()) {
                this.KtX = this.KtW.a(new q() {
                    /* class com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.a.AnonymousClass1 */

                    @Override // com.tencent.mm.vfs.q
                    public final boolean accept(com.tencent.mm.vfs.o oVar) {
                        AppMethodBeat.i(169795);
                        if (oVar.isHidden()) {
                            AppMethodBeat.o(169795);
                            return false;
                        } else if (!a.this.Kvb || !oVar.isDirectory()) {
                            AppMethodBeat.o(169795);
                            return true;
                        } else {
                            AppMethodBeat.o(169795);
                            return false;
                        }
                    }
                });
                if (this.KtX == null) {
                    this.KtX = new com.tencent.mm.vfs.o[0];
                }
                if (this.KtX.length > 0) {
                    this.KtX = b(this.KtX);
                    a(this.KtX);
                    AppMethodBeat.o(169797);
                    return;
                }
            } else if (list != null) {
                this.KtX = new com.tencent.mm.vfs.o[list.size()];
                for (int i2 = 0; i2 < list.size(); i2++) {
                    this.KtX[i2] = new com.tencent.mm.vfs.o(list.get(i2));
                    this.Kwn.add(this.KtX[i2]);
                }
            }
            AppMethodBeat.o(169797);
        }

        public final int eGR() {
            AppMethodBeat.i(31992);
            int i2 = 0;
            Iterator<com.tencent.mm.vfs.o> it = this.Kwn.iterator();
            while (it.hasNext()) {
                i2 = (int) (it.next().length() + ((long) i2));
            }
            AppMethodBeat.o(31992);
            return i2;
        }

        public final ArrayList<String> gsD() {
            AppMethodBeat.i(31993);
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<com.tencent.mm.vfs.o> it = this.Kwn.iterator();
            while (it.hasNext()) {
                com.tencent.mm.vfs.o next = it.next();
                if (!bfr(next.getName()) && !by(next.getName())) {
                    arrayList.add(aa.z(next.mUri));
                }
            }
            AppMethodBeat.o(31993);
            return arrayList;
        }

        public final ArrayList<String> gsE() {
            AppMethodBeat.i(31994);
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<com.tencent.mm.vfs.o> it = this.Kwn.iterator();
            while (it.hasNext()) {
                com.tencent.mm.vfs.o next = it.next();
                if (bfr(next.getName())) {
                    arrayList.add(aa.z(next.mUri));
                }
            }
            AppMethodBeat.o(31994);
            return arrayList;
        }

        public final ArrayList<String> gsF() {
            AppMethodBeat.i(31995);
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<com.tencent.mm.vfs.o> it = this.Kwn.iterator();
            while (it.hasNext()) {
                com.tencent.mm.vfs.o next = it.next();
                if (by(next.getName())) {
                    arrayList.add(aa.z(next.mUri));
                }
            }
            AppMethodBeat.o(31995);
            return arrayList;
        }

        public final com.tencent.mm.vfs.o gst() {
            AppMethodBeat.i(169798);
            if (this.KtW.hashCode() == this.Kva.hashCode()) {
                AppMethodBeat.o(169798);
                return null;
            }
            com.tencent.mm.vfs.o heq = this.KtW.heq();
            AppMethodBeat.o(169798);
            return heq;
        }

        private static com.tencent.mm.vfs.o[] b(com.tencent.mm.vfs.o[] oVarArr) {
            AppMethodBeat.i(232368);
            if (oVarArr == null || oVarArr.length == 0) {
                AppMethodBeat.o(232368);
                return oVarArr;
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (com.tencent.mm.vfs.o oVar : oVarArr) {
                if (!oVar.isDirectory()) {
                    arrayList.add(oVar);
                } else if (!hashSet.contains(aa.z(oVar.her()))) {
                    hashSet.add(aa.z(oVar.her()));
                    arrayList.add(oVar);
                }
            }
            com.tencent.mm.vfs.o[] oVarArr2 = (com.tencent.mm.vfs.o[]) arrayList.toArray(new com.tencent.mm.vfs.o[0]);
            AppMethodBeat.o(232368);
            return oVarArr2;
        }

        private void a(com.tencent.mm.vfs.o[] oVarArr) {
            int i2;
            int i3 = 0;
            AppMethodBeat.i(169799);
            if (oVarArr == null || oVarArr.length == 0) {
                AppMethodBeat.o(169799);
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<C2034a> arrayList2 = new ArrayList();
            for (com.tencent.mm.vfs.o oVar : oVarArr) {
                C2034a aVar = new C2034a(this, (byte) 0);
                aVar.file = oVar;
                aVar.time = oVar.lastModified();
                if (oVar.isDirectory()) {
                    aVar.Kvc = f.Sh(oVar.getName()).toUpperCase();
                    arrayList.add(aVar);
                } else {
                    arrayList2.add(aVar);
                }
            }
            Collections.sort(arrayList, new Comparator<C2034a>() {
                /* class com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.a.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(C2034a aVar, C2034a aVar2) {
                    AppMethodBeat.i(31987);
                    int compareTo = aVar.Kvc.compareTo(aVar2.Kvc);
                    AppMethodBeat.o(31987);
                    return compareTo;
                }
            });
            Collections.sort(arrayList2, new Comparator<C2034a>() {
                /* class com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.a.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* bridge */ /* synthetic */ int compare(C2034a aVar, C2034a aVar2) {
                    C2034a aVar3 = aVar;
                    C2034a aVar4 = aVar2;
                    if (aVar3.time == aVar4.time) {
                        return 0;
                    }
                    return aVar3.time > aVar4.time ? -1 : 1;
                }
            });
            Iterator it = arrayList.iterator();
            while (true) {
                i2 = i3;
                if (!it.hasNext()) {
                    break;
                }
                oVarArr[i2] = ((C2034a) it.next()).file;
                i3 = i2 + 1;
            }
            for (C2034a aVar2 : arrayList2) {
                oVarArr[i2] = aVar2.file;
                i2++;
            }
            AppMethodBeat.o(169799);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI$a$a  reason: collision with other inner class name */
        public class C2034a {
            String Kvc;
            com.tencent.mm.vfs.o file;
            long time;

            private C2034a() {
            }

            /* synthetic */ C2034a(a aVar, byte b2) {
                this();
            }
        }

        public final int getCount() {
            return this.KtX.length;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            Bitmap bitmap = null;
            AppMethodBeat.i(31998);
            if (view == null) {
                view = View.inflate(viewGroup.getContext(), R.layout.alv, null);
                b bVar = new b(this, (byte) 0);
                bVar.KuC = (FrameLayout) view.findViewById(R.id.e3p);
                bVar.KuD = (CheckBox) bVar.KuC.findViewById(R.id.e3o);
                bVar.nnL = (ImageView) view.findViewById(R.id.e2f);
                bVar.jVO = (TextView) view.findViewById(R.id.e40);
                bVar.Bvi = (TextView) view.findViewById(R.id.e3t);
                bVar.timeTV = (TextView) view.findViewById(R.id.e3y);
                bVar.KuC.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.a.AnonymousClass4 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(31988);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$FileExplorerAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        com.tencent.mm.vfs.o oVar = a.this.KtX[((Integer) view.getTag()).intValue()];
                        CheckBox checkBox = (CheckBox) view.findViewById(R.id.e3o);
                        if (a.this.Kwn.contains(oVar)) {
                            a.this.Kwn.remove(oVar);
                            checkBox.setChecked(false);
                        } else if (a.this.Kwn.size() >= 9) {
                            u.makeText(NewFileExplorerUI.this.getContext(), NewFileExplorerUI.this.getString(R.string.ceg, new Object[]{9}), 0).show();
                            checkBox.setChecked(false);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$FileExplorerAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(31988);
                            return;
                        } else {
                            long aqr = (long) c.aqr();
                            if (oVar.length() >= aqr) {
                                u.makeText(NewFileExplorerUI.this.getContext(), NewFileExplorerUI.this.getString(R.string.cef, new Object[]{Util.getSizeKB(aqr)}), 0).show();
                                checkBox.setChecked(false);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$FileExplorerAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(31988);
                                return;
                            }
                            if (a.by(oVar.getName())) {
                                com.tencent.mm.plugin.gallery.ui.a.a azf = com.tencent.mm.plugin.gallery.ui.a.a.azf(aa.z(oVar.mUri));
                                azf.mSize = c.aqq();
                                if (azf.dSv() == 1) {
                                    u.makeText(NewFileExplorerUI.this.getContext(), NewFileExplorerUI.this.getString(R.string.hxq, new Object[]{Util.getSizeKB((long) c.aqq())}), 0).show();
                                    checkBox.setChecked(false);
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$FileExplorerAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(31988);
                                    return;
                                }
                            }
                            checkBox.setChecked(true);
                            a.this.Kwn.add(oVar);
                        }
                        NewFileExplorerUI.h(NewFileExplorerUI.this);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$FileExplorerAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(31988);
                    }
                });
                view.setTag(bVar);
            }
            b bVar2 = (b) view.getTag();
            com.tencent.mm.vfs.o oVar = this.KtX[i2];
            bVar2.jVO.setText(oVar.getName());
            if (oVar.isDirectory()) {
                bVar2.nnL.setImageResource(R.raw.app_attach_file_icon_folders);
                bVar2.KuC.setVisibility(4);
                bVar2.Bvi.setVisibility(0);
                bVar2.timeTV.setVisibility(8);
                String[] a2 = oVar.a(new w() {
                    /* class com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.a.AnonymousClass5 */

                    @Override // com.tencent.mm.vfs.w
                    public final boolean accept(com.tencent.mm.vfs.o oVar, String str) {
                        AppMethodBeat.i(232367);
                        if (!str.startsWith(".")) {
                            AppMethodBeat.o(232367);
                            return true;
                        }
                        AppMethodBeat.o(232367);
                        return false;
                    }
                });
                bVar2.Bvi.setText(NewFileExplorerUI.this.getString(R.string.cdt, new Object[]{Integer.valueOf(a2 != null ? a2.length : 0)}));
            } else {
                bVar2.KuC.setVisibility(0);
                bVar2.Bvi.setVisibility(0);
                bVar2.timeTV.setVisibility(0);
                bVar2.Bvi.setText(Util.getSizeKB(oVar.length()));
                bVar2.timeTV.setText(com.tencent.mm.pluginsdk.i.f.c(NewFileExplorerUI.this, oVar.lastModified(), true));
                if (bfr(oVar.getName())) {
                    Cursor query = NewFileExplorerUI.this.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=?", new String[]{aa.z(oVar.mUri)}, null);
                    if (query != null) {
                        if (query.moveToFirst()) {
                            int i3 = query.getInt(query.getColumnIndex("_id"));
                            query.close();
                            bitmap = MediaStore.Images.Thumbnails.getThumbnail(NewFileExplorerUI.this.getContentResolver(), (long) i3, 3, null);
                        } else {
                            query.close();
                        }
                    }
                    if (bitmap != null) {
                        bVar2.nnL.setImageBitmap(bitmap);
                    } else {
                        bVar2.nnL.setImageResource(bfq(oVar.getName()));
                    }
                } else {
                    bVar2.nnL.setImageResource(bfq(oVar.getName()));
                }
            }
            bVar2.KuD.setChecked(this.Kwn.contains(oVar));
            bVar2.KuC.setTag(Integer.valueOf(i2));
            AppMethodBeat.o(31998);
            return view;
        }

        class b {
            public TextView Bvi;
            public FrameLayout KuC;
            public CheckBox KuD;
            public TextView jVO;
            public ImageView nnL;
            public TextView timeTV;

            private b() {
            }

            /* synthetic */ b(a aVar, byte b2) {
                this();
            }
        }

        private static int bfq(String str) {
            AppMethodBeat.i(31999);
            String lowerCase = str.toLowerCase();
            if (bft(lowerCase)) {
                AppMethodBeat.o(31999);
                return R.raw.app_attach_file_icon_word;
            } else if (bfr(lowerCase)) {
                AppMethodBeat.o(31999);
                return R.drawable.bxc;
            } else if (bfy(lowerCase)) {
                AppMethodBeat.o(31999);
                return R.raw.app_attach_file_icon_rar;
            } else if (bfz(lowerCase)) {
                AppMethodBeat.o(31999);
                return R.raw.app_attach_file_icon_txt;
            } else if (bfu(lowerCase)) {
                AppMethodBeat.o(31999);
                return R.raw.app_attach_file_icon_pdf;
            } else if (bfv(lowerCase)) {
                AppMethodBeat.o(31999);
                return R.raw.app_attach_file_icon_ppt;
            } else if (bfw(lowerCase)) {
                AppMethodBeat.o(31999);
                return R.raw.app_attach_file_icon_excel;
            } else if (bx(lowerCase)) {
                AppMethodBeat.o(31999);
                return R.raw.app_attach_file_icon_music;
            } else if (by(lowerCase)) {
                AppMethodBeat.o(31999);
                return R.raw.app_attach_file_icon_video;
            } else if (df(lowerCase)) {
                AppMethodBeat.o(31999);
                return R.raw.app_attach_file_icon_webpage;
            } else if (bfA(lowerCase)) {
                AppMethodBeat.o(31999);
                return R.raw.app_attach_file_icon_keynote;
            } else if (bfB(lowerCase)) {
                AppMethodBeat.o(31999);
                return R.raw.app_attach_file_icon_number;
            } else if (bfC(lowerCase)) {
                AppMethodBeat.o(31999);
                return R.raw.app_attach_file_icon_page;
            } else {
                AppMethodBeat.o(31999);
                return R.raw.app_attach_file_icon_unknow;
            }
        }

        private static boolean bfr(String str) {
            AppMethodBeat.i(32000);
            String lowerCase = Util.nullAsNil(str).toLowerCase();
            if (Build.VERSION.SDK_INT >= 28 && lowerCase.endsWith(".heic")) {
                AppMethodBeat.o(32000);
                return true;
            } else if (lowerCase.endsWith(".bmp") || lowerCase.endsWith(".png") || lowerCase.endsWith(".jpg") || lowerCase.endsWith(".jpeg") || lowerCase.endsWith(".gif")) {
                AppMethodBeat.o(32000);
                return true;
            } else {
                AppMethodBeat.o(32000);
                return false;
            }
        }

        private static boolean bx(String str) {
            AppMethodBeat.i(32001);
            String lowerCase = Util.nullAsNil(str).toLowerCase();
            if (lowerCase.endsWith(".mp3") || lowerCase.endsWith(".wma")) {
                AppMethodBeat.o(32001);
                return true;
            }
            AppMethodBeat.o(32001);
            return false;
        }

        static boolean by(String str) {
            AppMethodBeat.i(32002);
            String lowerCase = Util.nullAsNil(str).toLowerCase();
            if (lowerCase.endsWith(".mp4") || lowerCase.endsWith(".rm")) {
                AppMethodBeat.o(32002);
                return true;
            }
            AppMethodBeat.o(32002);
            return false;
        }

        private static boolean bfy(String str) {
            AppMethodBeat.i(32003);
            String lowerCase = Util.nullAsNil(str).toLowerCase();
            if (lowerCase.endsWith(".rar") || lowerCase.endsWith(".zip") || lowerCase.endsWith(".7z") || lowerCase.endsWith("tar") || lowerCase.endsWith(".iso")) {
                AppMethodBeat.o(32003);
                return true;
            }
            AppMethodBeat.o(32003);
            return false;
        }

        private static boolean bft(String str) {
            AppMethodBeat.i(32004);
            String lowerCase = Util.nullAsNil(str).toLowerCase();
            if (lowerCase.endsWith(".doc") || lowerCase.endsWith(".docx") || lowerCase.endsWith("wps")) {
                AppMethodBeat.o(32004);
                return true;
            }
            AppMethodBeat.o(32004);
            return false;
        }

        private static boolean bfu(String str) {
            AppMethodBeat.i(32005);
            boolean endsWith = Util.nullAsNil(str).toLowerCase().endsWith(".pdf");
            AppMethodBeat.o(32005);
            return endsWith;
        }

        private static boolean bfv(String str) {
            AppMethodBeat.i(32006);
            String lowerCase = Util.nullAsNil(str).toLowerCase();
            if (lowerCase.endsWith(".ppt") || lowerCase.endsWith(".pptx")) {
                AppMethodBeat.o(32006);
                return true;
            }
            AppMethodBeat.o(32006);
            return false;
        }

        private static boolean bfw(String str) {
            AppMethodBeat.i(32007);
            String lowerCase = Util.nullAsNil(str).toLowerCase();
            if (lowerCase.endsWith(".xls") || lowerCase.endsWith(".xlsx")) {
                AppMethodBeat.o(32007);
                return true;
            }
            AppMethodBeat.o(32007);
            return false;
        }

        private static boolean bfz(String str) {
            AppMethodBeat.i(32008);
            String lowerCase = Util.nullAsNil(str).toLowerCase();
            if (lowerCase.endsWith(".txt") || lowerCase.endsWith(".rtf")) {
                AppMethodBeat.o(32008);
                return true;
            }
            AppMethodBeat.o(32008);
            return false;
        }

        private static boolean bfA(String str) {
            AppMethodBeat.i(32009);
            boolean endsWith = Util.nullAsNil(str).toLowerCase().endsWith(".key");
            AppMethodBeat.o(32009);
            return endsWith;
        }

        private static boolean df(String str) {
            AppMethodBeat.i(32010);
            boolean endsWith = Util.nullAsNil(str).toLowerCase().endsWith(".html");
            AppMethodBeat.o(32010);
            return endsWith;
        }

        private static boolean bfB(String str) {
            AppMethodBeat.i(32011);
            boolean endsWith = Util.nullAsNil(str).toLowerCase().endsWith(".number");
            AppMethodBeat.o(32011);
            return endsWith;
        }

        private static boolean bfC(String str) {
            AppMethodBeat.i(32012);
            boolean endsWith = Util.nullAsNil(str).toLowerCase().endsWith(".pages");
            AppMethodBeat.o(32012);
            return endsWith;
        }

        public final /* bridge */ /* synthetic */ Object getItem(int i2) {
            return this.KtX[i2];
        }
    }

    static /* synthetic */ void e(NewFileExplorerUI newFileExplorerUI) {
        AppMethodBeat.i(32023);
        newFileExplorerUI.Kwk = new o.a(newFileExplorerUI.getContext());
        newFileExplorerUI.Kwk.ea(newFileExplorerUI.dJw);
        newFileExplorerUI.Kwk.p(Boolean.TRUE);
        newFileExplorerUI.Kwk.beQ(newFileExplorerUI.getString(R.string.ve) + newFileExplorerUI.getString(R.string.cds, new Object[]{Integer.valueOf(newFileExplorerUI.Kwh.Kwn.size()), Util.getSizeKB((long) newFileExplorerUI.Kwh.eGR())}));
        newFileExplorerUI.Kwk.a(new d.a.b() {
            /* class com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.widget.a.d.a.b
            public final void cXd() {
                AppMethodBeat.i(31983);
                Intent intent = new Intent();
                intent.setClass(NewFileExplorerUI.this.getContext(), NewFileExplorerUI.class);
                intent.putExtra("explorer_mode", 1);
                intent.putStringArrayListExtra("selected_file_lst", NewFileExplorerUI.this.Kwh.gsD());
                intent.putStringArrayListExtra("key_select_video_list", NewFileExplorerUI.this.Kwh.gsF());
                intent.putStringArrayListExtra("CropImage_OutputPath_List", NewFileExplorerUI.this.Kwh.gsE());
                intent.putExtra("GalleryUI_ToUser", NewFileExplorerUI.this.dJw);
                NewFileExplorerUI.this.startActivityForResult(intent, 0);
                AppMethodBeat.o(31983);
            }
        });
        newFileExplorerUI.Kwk.aii(R.string.yq).a(new y.a() {
            /* class com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.AnonymousClass6 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
            public final void a(boolean z, String str, int i2) {
                AppMethodBeat.i(31984);
                NewFileExplorerUI.this.hideVKB();
                if (z) {
                    Intent intent = new Intent();
                    intent.putStringArrayListExtra("selected_file_lst", NewFileExplorerUI.this.Kwh.gsD());
                    intent.putStringArrayListExtra("key_select_video_list", NewFileExplorerUI.this.Kwh.gsF());
                    intent.putStringArrayListExtra("CropImage_OutputPath_List", NewFileExplorerUI.this.Kwh.gsE());
                    intent.putExtra("GalleryUI_ToUser", NewFileExplorerUI.this.dJw);
                    intent.putExtra("with_text_content", str);
                    NewFileExplorerUI.this.setResult(-1, intent);
                    NewFileExplorerUI.this.finish();
                }
                AppMethodBeat.o(31984);
            }
        }).kdo.show();
        AppMethodBeat.o(32023);
    }
}

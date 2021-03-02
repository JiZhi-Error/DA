package com.tencent.mm.pluginsdk.ui.tools;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class FileExplorerUI extends MMActivity {
    private int KtH = 0;
    private ListView KtI;
    private a KtJ;
    private TextView KtK;
    private TextView KtL;
    private View KtM;
    private View KtN;
    private String KtO;
    private String KtP;
    private o KtQ;
    private o KtR;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(FileExplorerUI fileExplorerUI, int i2) {
        AppMethodBeat.i(141181);
        fileExplorerUI.aiP(i2);
        AppMethodBeat.o(141181);
    }

    static /* synthetic */ void gse() {
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b4w;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(141171);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_title");
        if (Util.isNullOrNil(stringExtra)) {
            setMMTitle(R.string.fo_);
        } else {
            setMMTitle(stringExtra);
        }
        initView();
        AppMethodBeat.o(141171);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(141172);
        super.onResume();
        AppMethodBeat.o(141172);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(141173);
        super.onPause();
        AppMethodBeat.o(141173);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(141174);
        super.onDestroy();
        AppMethodBeat.o(141174);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(141175);
        if (i2 != 4 || this.KtJ.KtV == null) {
            if (this.KtR != null) {
                g.aAh().azQ().set(131074, aa.z(this.KtR.her()));
            }
            if (this.KtQ != null) {
                g.aAh().azQ().set(131073, aa.z(this.KtQ.her()));
            }
            boolean onKeyDown = super.onKeyDown(i2, keyEvent);
            AppMethodBeat.o(141175);
            return onKeyDown;
        }
        if (1 == this.KtH) {
            this.KtR = this.KtJ.KtV;
        } else if (this.KtH == 0) {
            this.KtQ = this.KtJ.KtV;
        }
        this.KtJ.d(this.KtJ.KtV.heq(), this.KtJ.KtV);
        this.KtJ.notifyDataSetChanged();
        this.KtI.setSelection(0);
        AppMethodBeat.o(141175);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01bb  */
    @Override // com.tencent.mm.ui.MMActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView() {
        /*
        // Method dump skipped, instructions count: 446
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI.initView():void");
    }

    private void aiP(int i2) {
        AppMethodBeat.i(141177);
        if (1 == i2) {
            this.KtH = 1;
            this.KtL.setTextColor(getResources().getColor(R.color.ts));
            this.KtK.setTextColor(getResources().getColor(R.color.a2x));
            this.KtM.setVisibility(4);
            this.KtN.setVisibility(0);
            AppMethodBeat.o(141177);
            return;
        }
        this.KtH = 0;
        this.KtK.setTextColor(getResources().getColor(R.color.ts));
        this.KtL.setTextColor(getResources().getColor(R.color.a2x));
        this.KtM.setVisibility(0);
        this.KtN.setVisibility(4);
        AppMethodBeat.o(141177);
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private o KtV;
        private o KtW;
        private o[] KtX;
        String jpM;

        private a() {
        }

        /* synthetic */ a(FileExplorerUI fileExplorerUI, byte b2) {
            this();
        }

        public final void d(o oVar, o oVar2) {
            AppMethodBeat.i(175954);
            this.KtV = oVar;
            if (aa.z(oVar2.her()).equalsIgnoreCase(this.jpM)) {
                this.KtV = null;
            }
            this.KtW = oVar2;
            if (!this.KtW.canRead() || !this.KtW.isDirectory()) {
                this.KtX = new o[0];
            } else {
                this.KtX = this.KtW.a(new q() {
                    /* class com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI.a.AnonymousClass1 */

                    @Override // com.tencent.mm.vfs.q
                    public final boolean accept(o oVar) {
                        AppMethodBeat.i(175953);
                        if (oVar.isHidden()) {
                            AppMethodBeat.o(175953);
                            return false;
                        }
                        AppMethodBeat.o(175953);
                        return true;
                    }
                });
                if (this.KtX == null) {
                    this.KtX = new o[0];
                }
                if (this.KtX.length > 0) {
                    a(this.KtX);
                    AppMethodBeat.o(175954);
                    return;
                }
            }
            AppMethodBeat.o(175954);
        }

        public final int getCount() {
            int i2 = 0;
            if (this.KtX == null) {
                return 0;
            }
            int length = this.KtX.length;
            if (this.KtV != null) {
                i2 = 1;
            }
            return i2 + length;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(141168);
            if (this.KtV == null || i2 != 0) {
                Log.d("FileExplorer", "pos:" + i2 + ", subFile length:" + this.KtX.length);
                o[] oVarArr = this.KtX;
                if (this.KtV != null) {
                    i2--;
                }
                o oVar = oVarArr[i2];
                AppMethodBeat.o(141168);
                return oVar;
            }
            o oVar2 = this.KtV;
            AppMethodBeat.o(141168);
            return oVar2;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(141169);
            if (view == null) {
                view = View.inflate(FileExplorerUI.this, R.layout.b4x, null);
                c cVar = new c(FileExplorerUI.this, (byte) 0);
                cVar.nnL = (ImageView) view.findViewById(R.id.cg8);
                cVar.kgE = (TextView) view.findViewById(R.id.cgd);
                cVar.Kua = (TextView) view.findViewById(R.id.cgk);
                view.setTag(cVar);
            }
            c cVar2 = (c) view.getTag();
            o oVar = (o) getItem(i2);
            if (oVar == this.KtV) {
                cVar2.kgE.setText(oVar.getName());
                cVar2.nnL.setImageResource(R.drawable.bl3);
                cVar2.Kua.setVisibility(0);
            } else {
                cVar2.nnL.setImageResource(FileExplorerUI.ab(oVar));
                cVar2.kgE.setText(oVar.getName());
                cVar2.Kua.setText(DateFormat.format("yyyy-MM-dd hh:mm:ss", oVar.lastModified()).toString() + (oVar.isDirectory() ? "" : "  " + Util.getSizeKB(oVar.length())));
            }
            AppMethodBeat.o(141169);
            return view;
        }

        private void a(o[] oVarArr) {
            int i2;
            int i3 = 0;
            AppMethodBeat.i(175955);
            if (oVarArr == null || oVarArr.length == 0) {
                AppMethodBeat.o(175955);
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<b> arrayList2 = new ArrayList();
            for (o oVar : oVarArr) {
                b bVar = new b(FileExplorerUI.this, (byte) 0);
                bVar.file = oVar;
                bVar.KtZ = f.Sh(oVar.getName()).toUpperCase();
                if (oVar.isDirectory()) {
                    arrayList.add(bVar);
                } else {
                    arrayList2.add(bVar);
                }
            }
            Collections.sort(arrayList, new Comparator<b>() {
                /* class com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI.a.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(b bVar, b bVar2) {
                    AppMethodBeat.i(141165);
                    int compareTo = bVar.KtZ.compareTo(bVar2.KtZ);
                    AppMethodBeat.o(141165);
                    return compareTo;
                }
            });
            Collections.sort(arrayList2, new Comparator<b>() {
                /* class com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI.a.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(b bVar, b bVar2) {
                    AppMethodBeat.i(141166);
                    int compareTo = bVar.KtZ.compareTo(bVar2.KtZ);
                    AppMethodBeat.o(141166);
                    return compareTo;
                }
            });
            Iterator it = arrayList.iterator();
            while (true) {
                i2 = i3;
                if (!it.hasNext()) {
                    break;
                }
                oVarArr[i2] = ((b) it.next()).file;
                i3 = i2 + 1;
            }
            for (b bVar2 : arrayList2) {
                oVarArr[i2] = bVar2.file;
                i2++;
            }
            AppMethodBeat.o(175955);
        }
    }

    /* access modifiers changed from: package-private */
    public class b {
        String KtZ;
        o file;

        private b() {
        }

        /* synthetic */ b(FileExplorerUI fileExplorerUI, byte b2) {
            this();
        }
    }

    class c {
        TextView Kua;
        TextView kgE;
        ImageView nnL;

        private c() {
        }

        /* synthetic */ c(FileExplorerUI fileExplorerUI, byte b2) {
            this();
        }
    }

    public static int bfq(String str) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(141178);
        String lowerCase = str.toLowerCase();
        if (bft(lowerCase)) {
            AppMethodBeat.o(141178);
            return R.raw.app_attach_file_icon_word;
        } else if (bfr(lowerCase)) {
            AppMethodBeat.o(141178);
            return R.drawable.bl5;
        } else {
            String lowerCase2 = Util.nullAsNil(lowerCase).toLowerCase();
            if (lowerCase2.endsWith(".rar") || lowerCase2.endsWith(".zip") || lowerCase2.endsWith(".7z") || lowerCase2.endsWith("tar") || lowerCase2.endsWith(".iso")) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(141178);
                return R.raw.app_attach_file_icon_rar;
            }
            String lowerCase3 = Util.nullAsNil(lowerCase).toLowerCase();
            if (lowerCase3.endsWith(".txt") || lowerCase3.endsWith(".rtf")) {
                z2 = true;
            }
            if (z2) {
                AppMethodBeat.o(141178);
                return R.raw.app_attach_file_icon_txt;
            } else if (bfu(lowerCase)) {
                AppMethodBeat.o(141178);
                return R.raw.app_attach_file_icon_pdf;
            } else if (bfv(lowerCase)) {
                AppMethodBeat.o(141178);
                return R.raw.app_attach_file_icon_ppt;
            } else if (bfw(lowerCase)) {
                AppMethodBeat.o(141178);
                return R.raw.app_attach_file_icon_excel;
            } else {
                AppMethodBeat.o(141178);
                return R.raw.app_attach_file_icon_unknow;
            }
        }
    }

    public static boolean bfr(String str) {
        AppMethodBeat.i(141179);
        String lowerCase = Util.nullAsNil(str).toLowerCase();
        if (lowerCase.endsWith(".bmp") || lowerCase.endsWith(".png") || lowerCase.endsWith(".jpg") || lowerCase.endsWith(".jpeg") || lowerCase.endsWith(".gif")) {
            AppMethodBeat.o(141179);
            return true;
        }
        AppMethodBeat.o(141179);
        return false;
    }

    public static boolean bfs(String str) {
        AppMethodBeat.i(141180);
        String lowerCase = Util.nullAsNil(str).toLowerCase();
        if (lowerCase.endsWith(".mp3") || lowerCase.endsWith(".wma") || lowerCase.endsWith(".mp4") || lowerCase.endsWith(".rm")) {
            AppMethodBeat.o(141180);
            return true;
        }
        AppMethodBeat.o(141180);
        return false;
    }

    public static boolean bft(String str) {
        AppMethodBeat.i(205088);
        String lowerCase = Util.nullAsNil(str).toLowerCase();
        if (lowerCase.endsWith(".doc") || lowerCase.endsWith(".docx") || lowerCase.endsWith("wps")) {
            AppMethodBeat.o(205088);
            return true;
        }
        AppMethodBeat.o(205088);
        return false;
    }

    public static boolean bfu(String str) {
        AppMethodBeat.i(205089);
        boolean endsWith = Util.nullAsNil(str).toLowerCase().endsWith(".pdf");
        AppMethodBeat.o(205089);
        return endsWith;
    }

    public static boolean bfv(String str) {
        AppMethodBeat.i(205090);
        String lowerCase = Util.nullAsNil(str).toLowerCase();
        if (lowerCase.endsWith(".ppt") || lowerCase.endsWith(".pptx")) {
            AppMethodBeat.o(205090);
            return true;
        }
        AppMethodBeat.o(205090);
        return false;
    }

    public static boolean bfw(String str) {
        AppMethodBeat.i(205091);
        String lowerCase = Util.nullAsNil(str).toLowerCase();
        if (lowerCase.endsWith(".xls") || lowerCase.endsWith(".xlsx")) {
            AppMethodBeat.o(205091);
            return true;
        }
        AppMethodBeat.o(205091);
        return false;
    }

    static /* synthetic */ int ab(o oVar) {
        AppMethodBeat.i(175956);
        if (oVar.isDirectory()) {
            AppMethodBeat.o(175956);
            return R.drawable.bl4;
        }
        int bfq = bfq(oVar.getName());
        AppMethodBeat.o(175956);
        return bfq;
    }
}

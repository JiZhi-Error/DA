package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.d.aj;
import com.tencent.mm.plugin.qqmail.d.ap;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b implements CdnLogic.UploadCallback, i {
    private TextView Buf;
    private ImageView Bug;
    private Map<String, com.tencent.mm.plugin.qqmail.e.a> BvA;
    private Map<String, String> BvB;
    AbstractC1615b BvC;
    private View.OnClickListener BvD;
    private ComposeUI Bvy;
    Map<String, aj> Bvz;
    private ViewGroup ulG;

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.b$b  reason: collision with other inner class name */
    public interface AbstractC1615b {
        void eGG();

        void onComplete();
    }

    static /* synthetic */ long a(b bVar, String str) {
        AppMethodBeat.i(198712);
        long aKJ = bVar.aKJ(str);
        AppMethodBeat.o(198712);
        return aKJ;
    }

    static /* synthetic */ void b(b bVar, aj ajVar) {
        AppMethodBeat.i(198714);
        bVar.b(ajVar);
        AppMethodBeat.o(198714);
    }

    private b(ComposeUI composeUI, TextView textView, ImageView imageView, ViewGroup viewGroup) {
        AppMethodBeat.i(123021);
        this.Bvz = new HashMap();
        this.BvA = new HashMap();
        this.BvB = new HashMap();
        this.BvC = null;
        this.BvD = null;
        this.Bvy = composeUI;
        this.ulG = viewGroup;
        this.BvD = null;
        this.Buf = textView;
        this.Bug = imageView;
        eGQ();
        g.aAg().hqi.a(11665, this);
        AppMethodBeat.o(123021);
    }

    public b(ComposeUI composeUI, TextView textView, ImageView imageView, ViewGroup viewGroup, byte b2) {
        this(composeUI, textView, imageView, viewGroup);
    }

    public final void fX(List<aj> list) {
        AppMethodBeat.i(198709);
        if (list == null) {
            AppMethodBeat.o(198709);
            return;
        }
        for (aj ajVar : list) {
            this.Bvz.put(ajVar.path, ajVar);
            a(ajVar);
        }
        AppMethodBeat.o(198709);
    }

    public final boolean Tf(String str) {
        AppMethodBeat.i(123024);
        boolean containsKey = this.Bvz.containsKey(str);
        AppMethodBeat.o(123024);
        return containsKey;
    }

    /* access modifiers changed from: package-private */
    public final void a(final aj ajVar) {
        AppMethodBeat.i(123025);
        final LinearLayout linearLayout = (LinearLayout) ((ViewGroup) View.inflate(this.Bvy, R.layout.bk0, null)).findViewById(R.id.gd9);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.gd8);
        TextView textView = (TextView) linearLayout.findViewById(R.id.gd_);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.gdb);
        final ImageView imageView2 = (ImageView) linearLayout.findViewById(R.id.gda);
        ImageView imageView3 = (ImageView) linearLayout.findViewById(R.id.gd7);
        ((ViewGroup) linearLayout.getParent()).removeView(linearLayout);
        imageView.setImageResource(FileExplorerUI.bfq(ajVar.name));
        textView.setText(ajVar.name);
        textView2.setText(Util.getSizeKB(ajVar.size));
        a aVar = new a(this, (byte) 0);
        aVar.nnL = imageView;
        aVar.kgE = textView;
        aVar.Bvi = textView2;
        aVar.uploadingPB = (ProgressBar) linearLayout.findViewById(R.id.gdc);
        aVar.BvL = (TextView) linearLayout.findViewById(R.id.gdd);
        aVar.BvM = imageView2;
        aVar.BvN = imageView3;
        linearLayout.setTag(aVar);
        linearLayout.setId(Math.abs(ajVar.path.hashCode() / 2));
        if (this.BvD != null) {
            linearLayout.setOnClickListener(this.BvD);
        }
        this.ulG.addView(linearLayout);
        eGQ();
        linearLayout.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.b.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(123008);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (imageView2.getVisibility() == 0) {
                    imageView2.performClick();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(123008);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.b.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(123009);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ajVar.ulj = b.a(b.this, ajVar.path);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(123009);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.b.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(123011);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.a(b.this.Bvy, (int) R.string.fni, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.qqmail.ui.b.AnonymousClass3.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(123010);
                        if (ajVar.state == 0 || ajVar.state == 1) {
                            b.a(b.this, ajVar);
                        }
                        b.this.Bvz.remove(ajVar.path);
                        b.this.BvA.remove(ajVar.path);
                        b.this.ulG.removeView(linearLayout);
                        b.this.eGQ();
                        AppMethodBeat.o(123010);
                    }
                }, (DialogInterface.OnClickListener) null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(123011);
            }
        });
        this.ulG.post(new Runnable() {
            /* class com.tencent.mm.plugin.qqmail.ui.b.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(123012);
                b.b(b.this, ajVar);
                AppMethodBeat.o(123012);
            }
        });
        if (ajVar.state == 0) {
            ajVar.ulj = aKJ(ajVar.path);
        }
        AppMethodBeat.o(123025);
    }

    public final LinkedList<aj> eGN() {
        AppMethodBeat.i(123027);
        LinkedList<aj> linkedList = new LinkedList<>();
        for (String str : this.Bvz.keySet()) {
            linkedList.add(this.Bvz.get(str));
        }
        AppMethodBeat.o(123027);
        return linkedList;
    }

    public final void eGO() {
        com.tencent.mm.plugin.qqmail.e.a aVar;
        AppMethodBeat.i(123028);
        for (String str : this.Bvz.keySet()) {
            aj ajVar = this.Bvz.get(str);
            if (!(ajVar.state == 2 || (aVar = this.BvA.get(ajVar.path)) == null)) {
                g.aAg().hqi.a(aVar);
                ajVar.state = 3;
                b(ajVar);
                this.BvA.remove(ajVar.path);
            }
        }
        AppMethodBeat.o(123028);
    }

    /* access modifiers changed from: package-private */
    public final long aKJ(String str) {
        AppMethodBeat.i(123029);
        try {
            o oVar = new o(str);
            Log.i("MicroMsg.Mail.FileUploadHelper", "doNormalUpload %s", str, oVar.getName());
            byte[] aW = s.aW(str, 0, (int) oVar.length());
            com.tencent.mm.plugin.qqmail.e.a aVar = new com.tencent.mm.plugin.qqmail.e.a(str, (int) oVar.length(), n.bytesToHex(MessageDigest.getInstance(AndroidUtilsLight.DIGEST_ALGORITHM_SHA1).digest(aW)), MD5Util.getMD5String(aW));
            g.azz().a(aVar, 0);
            this.BvA.put(str, aVar);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Mail.FileUploadHelper", e2, "", new Object[0]);
        }
        long currentTimeMillis = System.currentTimeMillis();
        AppMethodBeat.o(123029);
        return currentTimeMillis;
    }

    public final boolean eGP() {
        AppMethodBeat.i(123031);
        for (String str : this.Bvz.keySet()) {
            aj ajVar = this.Bvz.get(str);
            if (!(ajVar.state == 2 || ajVar.state == 3)) {
                AppMethodBeat.o(123031);
                return false;
            }
        }
        AppMethodBeat.o(123031);
        return true;
    }

    public final void eGQ() {
        AppMethodBeat.i(123032);
        if (this.Bvz.size() == 0) {
            this.Buf.setText(this.Bvy.getString(R.string.fnp) + " " + this.Bvy.getString(R.string.fns));
            this.Bug.setImageResource(R.raw.qqmail_attach_icon_normal);
            ((View) this.ulG.getParent()).setVisibility(8);
        } else {
            this.Buf.setText(this.Bvy.getString(R.string.fnp) + this.Bvy.getResources().getQuantityString(R.plurals.a0, this.Bvz.size(), Integer.valueOf(this.Bvz.size()), Util.getSizeKB((long) getTotalSize())));
            this.Bug.setImageResource(R.raw.qqmail_attach_icon_pressed);
            ((View) this.ulG.getParent()).setVisibility(0);
        }
        int childCount = this.ulG.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (childCount == 1) {
                this.ulG.getChildAt(i2).setBackgroundResource(R.drawable.agg);
            } else if (i2 == 0) {
                this.ulG.getChildAt(i2).setBackgroundResource(R.drawable.agh);
            } else if (i2 <= 0 || i2 >= childCount - 1) {
                this.ulG.getChildAt(i2).setBackgroundResource(R.drawable.agj);
            } else {
                this.ulG.getChildAt(i2).setBackgroundResource(R.drawable.agi);
            }
        }
        AppMethodBeat.o(123032);
    }

    public final int getTotalSize() {
        AppMethodBeat.i(123033);
        int i2 = 0;
        for (String str : this.Bvz.keySet()) {
            i2 = (int) (this.Bvz.get(str).size + ((long) i2));
        }
        AppMethodBeat.o(123033);
        return i2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void b(aj ajVar) {
        AppMethodBeat.i(123034);
        LinearLayout linearLayout = (LinearLayout) this.ulG.findViewById(Math.abs(ajVar.path.hashCode() / 2));
        if (linearLayout == null) {
            AppMethodBeat.o(123034);
            return;
        }
        a aVar = (a) linearLayout.getTag();
        Log.i("MicroMsg.Mail.FileUploadHelper", "show upload status %d", Integer.valueOf(ajVar.state));
        switch (ajVar.state) {
            case 0:
            case 1:
                aVar.kgE.setTextColor(this.Bvy.getResources().getColor(R.color.a2x));
                aVar.uploadingPB.setVisibility(0);
                aVar.BvL.setVisibility(8);
                aVar.BvM.setVisibility(8);
                aVar.BvN.setVisibility(0);
                AppMethodBeat.o(123034);
                return;
            case 2:
                aVar.kgE.setTextColor(this.Bvy.getResources().getColor(R.color.a2x));
                aVar.uploadingPB.setVisibility(8);
                aVar.BvL.setVisibility(8);
                aVar.BvM.setVisibility(8);
                aVar.BvN.setVisibility(0);
                AppMethodBeat.o(123034);
                return;
            case 3:
                aVar.kgE.setTextColor(com.tencent.mm.cb.a.n(this.Bvy, R.color.wx));
                aVar.uploadingPB.setVisibility(8);
                aVar.BvL.setVisibility(0);
                aVar.BvM.setVisibility(0);
                aVar.BvN.setVisibility(0);
                break;
        }
        AppMethodBeat.o(123034);
    }

    /* access modifiers changed from: package-private */
    public class a {
        TextView BvL;
        ImageView BvM;
        ImageView BvN;
        TextView Bvi;
        TextView kgE;
        ImageView nnL;
        ProgressBar uploadingPB;

        private a() {
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }
    }

    @Override // com.tencent.mars.cdn.CdnLogic.UploadCallback
    public final void onUploadProgressChanged(String str, long j2, long j3) {
        AppMethodBeat.i(198710);
        Log.i("MicroMsg.Mail.FileUploadHelper", "onUploadProgressChanged fileKey:%s finish:%d total:%d", str, Long.valueOf(j2), Long.valueOf(j3));
        AppMethodBeat.o(198710);
    }

    @Override // com.tencent.mars.cdn.CdnLogic.UploadCallback
    public final void onC2CUploadCompleted(String str, final CdnLogic.C2CUploadResult c2CUploadResult) {
        AppMethodBeat.i(198711);
        Log.i("MicroMsg.Mail.FileUploadHelper", "onC2CUploadCompleted %s", str);
        if (this.BvB.containsKey(str)) {
            final aj ajVar = this.Bvz.get(this.BvB.get(str));
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.qqmail.ui.b.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(198708);
                    if (ajVar != null) {
                        if (c2CUploadResult.errorCode != 0) {
                            ajVar.state = 3;
                        } else {
                            ajVar.state = 2;
                            b.e(b.this);
                        }
                        b.b(b.this, ajVar);
                    }
                    AppMethodBeat.o(198708);
                }
            });
        }
        AppMethodBeat.o(198711);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(123035);
        if (qVar.getType() == 11665) {
            String str2 = ((com.tencent.mm.plugin.qqmail.e.a) qVar).filePath;
            Log.i("MicroMsg.Mail.FileUploadHelper", "errType %d, errCode %d, errMsg %s, filePath %s", Integer.valueOf(i2), Integer.valueOf(i3), str, str2);
            aj ajVar = this.Bvz.get(str2);
            this.BvA.remove(str2);
            if (ajVar != null) {
                if (i2 == 0 && i3 == 0) {
                    CdnLogic.C2CUploadRequest c2CUploadRequest = new CdnLogic.C2CUploadRequest();
                    c2CUploadRequest.fileKey = ((com.tencent.mm.plugin.qqmail.e.a) qVar).Btw;
                    c2CUploadRequest.setFilePath(str2);
                    c2CUploadRequest.forwardFileid = ((ap) ((com.tencent.mm.plugin.qqmail.e.a) qVar).iUB.iLL.iLR).Bte;
                    c2CUploadRequest.host = ((ap) ((com.tencent.mm.plugin.qqmail.e.a) qVar).iUB.iLL.iLR).Btd;
                    this.BvB.put(c2CUploadRequest.fileKey, str2);
                    ajVar.state = 1;
                    ajVar.svrId = ((ap) ((com.tencent.mm.plugin.qqmail.e.a) qVar).iUB.iLL.iLR).fileid;
                    b(ajVar);
                    CdnLogic.startFtnUpload(c2CUploadRequest, this);
                } else {
                    ajVar.state = 3;
                    b(ajVar);
                    AppMethodBeat.o(123035);
                    return;
                }
            }
        }
        AppMethodBeat.o(123035);
    }

    static /* synthetic */ void a(b bVar, aj ajVar) {
        AppMethodBeat.i(198713);
        com.tencent.mm.plugin.qqmail.e.a aVar = bVar.BvA.get(ajVar.path);
        if (aVar != null) {
            g.aAg().hqi.a(aVar);
        }
        AppMethodBeat.o(198713);
    }

    static /* synthetic */ void e(b bVar) {
        boolean z;
        AppMethodBeat.i(198715);
        if (bVar.eGP()) {
            Iterator<String> it = bVar.Bvz.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                if (bVar.Bvz.get(it.next()).state != 2) {
                    z = false;
                    break;
                }
            }
            if (z && bVar.BvC != null) {
                bVar.BvC.onComplete();
            }
        } else if (bVar.BvC != null) {
            AbstractC1615b bVar2 = bVar.BvC;
            bVar.Bvz.size();
            for (String str : bVar.Bvz.keySet()) {
                if (bVar.Bvz.get(str).state != 2) {
                    break;
                }
            }
            bVar2.eGG();
            AppMethodBeat.o(198715);
            return;
        }
        AppMethodBeat.o(198715);
    }
}

package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.textstatus.a.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ci;
import com.tencent.mm.storagebase.a.d;
import com.tencent.mm.storagebase.a.e;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class a extends f<String, com.tencent.mm.storage.f> implements MStorageEx.IOnStorageChange {
    public static final ColorStateList yCN = com.tencent.mm.cb.a.m(MMApplicationContext.getContext(), R.color.a0b);
    public static final ColorStateList yCO = com.tencent.mm.cb.a.m(MMApplicationContext.getContext(), R.color.uj);
    protected MMSlideDelView.f AAA;
    private HashSet<String> PSA = new HashSet<>();
    public HashMap<String, com.tencent.mm.storage.f> PSe = new HashMap<>();
    protected String PSf = null;
    protected String PSg = null;
    private List<Object> PSh;
    private List<String> PSi;
    private int PSj = 0;
    protected int[] PSk;
    String[] PSl;
    protected AddressUI.AddressUIFragment PSm;
    private Set<Integer> PSn = new HashSet();
    private int PSo = 0;
    private boolean PSp = true;
    AbstractC2109a PSq;
    private boolean PSr = false;
    boolean PSs = false;
    private String PSt;
    LinkedList<View> PSu = new LinkedList<>();
    boolean PSv;
    HashMap<View, ViewStub> PSw = new HashMap<>();
    private NoMeasuredTextView.c PSx = new NoMeasuredTextView.c() {
        /* class com.tencent.mm.ui.contact.a.AnonymousClass2 */

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.CharSequence] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.tencent.mm.ui.base.NoMeasuredTextView.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.CharSequence a(com.tencent.mm.ui.base.NoMeasuredTextView r11, java.lang.CharSequence r12, java.lang.String r13, int r14, int r15) {
            /*
            // Method dump skipped, instructions count: 241
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.contact.a.AnonymousClass2.a(com.tencent.mm.ui.base.NoMeasuredTextView, java.lang.CharSequence, java.lang.String, int, int):java.lang.CharSequence");
        }
    };
    private SparseArray<String> PSy = new SparseArray<>();
    private SparseArray<Integer> PSz = new SparseArray<>();
    private String[] Paj = null;
    View.OnClickListener dec = new View.OnClickListener() {
        /* class com.tencent.mm.ui.contact.a.AnonymousClass3 */

        public final void onClick(View view) {
            AppMethodBeat.i(37568);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.v("MicroMsg.AddressAdapter", "on delView clicked");
            a.this.plb.ebp();
            if (a.this.AAA != null) {
                a.this.AAA.cZ(((ViewStub) a.this.PSw.get(view)).getTag());
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37568);
        }
    };
    protected List<String> gzY = null;
    private WeakReference<Context> kRw;
    private String kdi = "";
    private com.tencent.mm.ui.applet.b kex = null;
    protected MMSlideDelView.g pkY;
    protected MMSlideDelView.c pkZ;
    protected MMSlideDelView.d plb = MMSlideDelView.getItemStatusCallBack();
    private boolean poG = false;
    StringBuilder sb = new StringBuilder(32);
    private int type;

    /* renamed from: com.tencent.mm.ui.contact.a$a  reason: collision with other inner class name */
    public interface AbstractC2109a {
    }

    /* access modifiers changed from: protected */
    public static class b {
        public NoMeasuredTextView PSD;
        public TextView PSE;
        public View PSF;
        public CategoryTipView PSG;
        public ViewGroup PSH;
        public ImageView gyr;
        public TextView jVP;
        public TextView yuS;
        public TextView yuT;
    }

    static /* synthetic */ boolean e(a aVar) {
        AppMethodBeat.i(233975);
        boolean gUl = aVar.gUl();
        AppMethodBeat.o(233975);
        return gUl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
    @Override // com.tencent.mm.ui.f
    public final /* synthetic */ void o(String str, int i2) {
        AppMethodBeat.i(37594);
        hi(str, i2);
        AppMethodBeat.o(37594);
    }

    public final void hi(String str, int i2) {
        AppMethodBeat.i(37569);
        if (i2 == 5) {
            this.PSA.add(str);
        }
        super.o(str, i2);
        AppMethodBeat.o(37569);
    }

    @Override // com.tencent.mm.ui.f
    public final void pause() {
        AppMethodBeat.i(37570);
        this.PSA.clear();
        super.pause();
        AppMethodBeat.o(37570);
    }

    public void notifyDataSetChanged() {
        AppMethodBeat.i(37571);
        this.PSt = z.aTY();
        if (this.PSk == null) {
            gUn();
        }
        if (getCount() == 0) {
            super.notifyDataSetChanged();
            AppMethodBeat.o(37571);
            return;
        }
        this.PSo = gGX();
        Log.i("MicroMsg.AddressAdapter", "newcursor favourCount %d", Integer.valueOf(this.PSo));
        super.notifyDataSetChanged();
        AppMethodBeat.o(37571);
    }

    public a(Context context, String str, String str2, int i2) {
        super(context);
        AppMethodBeat.i(37572);
        this.kRw = new WeakReference<>(context);
        this.context = MMApplicationContext.getContext();
        this.PSf = str;
        this.PSg = str2;
        this.type = i2;
        this.PSr = true;
        this.PSh = new LinkedList();
        this.PSi = new LinkedList();
        this.PSt = z.aTY();
        this.TAG = "MiscroMsg.AddressDrawWithCacheAdapter";
        AppMethodBeat.o(37572);
    }

    public final void setFragment(Fragment fragment) {
        this.PSm = (AddressUI.AddressUIFragment) fragment;
    }

    public final void detach() {
        AppMethodBeat.i(37573);
        if (this.kex != null) {
            this.kex.detach();
            this.kex = null;
        }
        AppMethodBeat.o(37573);
    }

    public final void setPerformItemClickListener(MMSlideDelView.g gVar) {
        this.pkY = gVar;
    }

    public final void a(MMSlideDelView.f fVar) {
        this.AAA = fVar;
    }

    public final void setGetViewPositionCallback(MMSlideDelView.c cVar) {
        this.pkZ = cVar;
    }

    public final void jB(List<String> list) {
        AppMethodBeat.i(37574);
        if (this.type != 2) {
            list.add(z.aTY());
        }
        bg.aVF();
        ci aEY = c.aSW().aEY("@t.qq.com");
        if (aEY != null) {
            list.add(aEY.name);
        }
        if (this.type == 3 || this.type == 5 || this.type == 4 || this.type == 1 || this.type == 0) {
            for (String str : ab.aUU()) {
                list.add(str);
            }
        }
        list.add("blogapp");
        this.gzY = list;
        AppMethodBeat.o(37574);
    }

    public final int getPositionForSection(int i2) {
        if (this.PSk != null && i2 >= 0 && i2 < this.PSk.length) {
            i2 = this.PSk[i2];
        }
        return this.PSo + i2;
    }

    private boolean gUl() {
        AppMethodBeat.i(37575);
        if (this.PSf.equals("@micromsg.qq.com") || this.PSf.equals("@all.contact.without.chatroom") || this.PSf.equals("@all.contact.without.chatroom.without.openim")) {
            AppMethodBeat.o(37575);
            return true;
        }
        AppMethodBeat.o(37575);
        return false;
    }

    /* access modifiers changed from: protected */
    public Cursor gUm() {
        AppMethodBeat.i(37576);
        long currentTimeMillis = System.currentTimeMillis();
        final LinkedList linkedList = new LinkedList();
        linkedList.add("weixin");
        bg.aVF();
        Cursor a2 = c.aSN().a(this.PSf, this.PSg, this.gzY, linkedList, gUl(), this.PSr);
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.ui.contact.a.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(233973);
                bg.aVF();
                Cursor a2 = c.aSN().a(a.this.PSf, a.this.PSg, a.this.gzY, linkedList, a.e(a.this), a.this.PSr);
                if (a2 != null) {
                    try {
                        if (a2 instanceof e) {
                            ArrayList arrayList = new ArrayList();
                            d dVar = ((e) a2).OtV[0];
                            int position = dVar.getPosition();
                            if (dVar != null) {
                                while (dVar.moveToNext()) {
                                    com.tencent.mm.storage.f fVar = new com.tencent.mm.storage.f();
                                    fVar.convertFrom(dVar);
                                    arrayList.add(fVar.field_username);
                                    Log.d("MicroMsg.AddressAdapter", "mStarUserList add %s %s", fVar.field_username, fVar.field_conRemark);
                                }
                                dVar.moveToPosition(position);
                            }
                            ((com.tencent.mm.plugin.story.api.e) g.ah(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().hp(arrayList);
                        }
                    } catch (Throwable th) {
                        if (a2 != null) {
                            a2.close();
                        }
                        AppMethodBeat.o(233973);
                        throw th;
                    }
                }
                if (a2 != null) {
                    a2.close();
                    AppMethodBeat.o(233973);
                    return;
                }
                AppMethodBeat.o(233973);
            }
        });
        Log.d("MicroMsg.AddressAdapter", "kevin setCursor : " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(37576);
        return a2;
    }

    /* access modifiers changed from: protected */
    public final void gUn() {
        int i2;
        AppMethodBeat.i(37577);
        int count = getCount();
        if (count == 0) {
            AppMethodBeat.o(37577);
            return;
        }
        this.PSo = gGX();
        if (this.Paj != null) {
            this.PSk = ab.a(this.PSf, this.PSg, this.gzY, this.Paj);
            this.PSl = ab.a(this.PSf, this.PSg, this.Paj, this.gzY);
        } else if (gFx()) {
            long currentTimeMillis = System.currentTimeMillis();
            HashSet hashSet = new HashSet();
            this.PSk = new int[30];
            this.PSl = new String[30];
            int i3 = this.PSo;
            int i4 = 0;
            while (i3 < count) {
                com.tencent.mm.storage.f fVar = (com.tencent.mm.storage.f) getItem(i3);
                if (fVar != null) {
                    String b2 = b(fVar, i3);
                    if (hashSet.add(b2)) {
                        this.PSk[i4] = i3 - this.PSo;
                        this.PSl[i4] = b2;
                        i2 = i4 + 1;
                    }
                    i2 = i4;
                } else {
                    Log.d("MicroMsg.AddressAdapter", "newCursor getItem is null");
                    i2 = i4;
                }
                i3++;
                i4 = i2;
            }
            Log.d("MicroMsg.AddressAdapter", "newCursor resetShowHead by Memory : " + (System.currentTimeMillis() - currentTimeMillis) + "favourCount : " + this.PSo);
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.PSk = ab.a((String[]) null, this.PSf, this.PSg, this.gzY, this.kdi);
            this.PSl = ab.a((String[]) null, this.PSf, this.PSg, this.kdi, this.gzY);
            Log.d("MicroMsg.AddressAdapter", "kevin resetShowHead part1 : " + (System.currentTimeMillis() - currentTimeMillis2));
        }
        this.PSn.clear();
        if (this.PSk != null) {
            int[] iArr = this.PSk;
            int length = iArr.length;
            for (int i5 = 0; i5 < length; i5++) {
                this.PSn.add(Integer.valueOf(iArr[i5] - 1));
            }
        }
        AppMethodBeat.o(37577);
    }

    public final void gUo() {
        AppMethodBeat.i(37578);
        this.plb.ebp();
        AppMethodBeat.o(37578);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0231  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r12, android.view.View r13, android.view.ViewGroup r14) {
        /*
        // Method dump skipped, instructions count: 589
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.contact.a.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    /* access modifiers changed from: protected */
    public void a(com.tencent.mm.storage.f fVar, b bVar) {
        AppMethodBeat.i(37580);
        try {
            bVar.jVP.setText((CharSequence) null);
            bVar.jVP.setVisibility(8);
            AppMethodBeat.o(37580);
        } catch (Throwable th) {
            AppMethodBeat.o(37580);
        }
    }

    static {
        AppMethodBeat.i(37596);
        AppMethodBeat.o(37596);
    }

    public static String getDisplayName(String str, String str2) {
        AppMethodBeat.i(37582);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(37582);
            return str2;
        }
        AppMethodBeat.o(37582);
        return str;
    }

    /* access modifiers changed from: protected */
    public final String bnp(String str) {
        AppMethodBeat.i(37583);
        if ("".length() <= 0 || "".equals(str)) {
            AppMethodBeat.o(37583);
            return str;
        }
        this.sb.append(str);
        this.sb.append("(");
        this.sb.append("");
        this.sb.append(")");
        String sb2 = this.sb.toString();
        this.sb.delete(0, this.sb.length());
        AppMethodBeat.o(37583);
        return sb2;
    }

    /* access modifiers changed from: protected */
    public int a(com.tencent.mm.storage.f fVar, int i2) {
        AppMethodBeat.i(37584);
        if (i2 < this.PSo) {
            AppMethodBeat.o(37584);
            return 32;
        } else if (fVar == null) {
            Log.e("MicroMsg.AddressAdapter", "contact is null, position:%d", Integer.valueOf(i2));
            AppMethodBeat.o(37584);
            return -1;
        } else {
            int i3 = fVar.field_showHead;
            AppMethodBeat.o(37584);
            return i3;
        }
    }

    /* access modifiers changed from: protected */
    public String b(com.tencent.mm.storage.f fVar, int i2) {
        AppMethodBeat.i(37585);
        if (i2 < this.PSo) {
            String string = getString(R.string.f3);
            AppMethodBeat.o(37585);
            return string;
        } else if (fVar.field_showHead == 31) {
            AppMethodBeat.o(37585);
            return "";
        } else if (fVar.field_showHead == 123) {
            AppMethodBeat.o(37585);
            return "#";
        } else if (fVar.field_showHead == 33) {
            String string2 = getString(R.string.e2);
            AppMethodBeat.o(37585);
            return string2;
        } else if (fVar.field_showHead == 43) {
            String string3 = getString(R.string.g7f);
            AppMethodBeat.o(37585);
            return string3;
        } else if (fVar.field_showHead == 32) {
            String string4 = getString(R.string.f3);
            AppMethodBeat.o(37585);
            return string4;
        } else {
            String str = this.PSy.get(fVar.field_showHead);
            if (str != null) {
                AppMethodBeat.o(37585);
                return str;
            }
            String valueOf = String.valueOf((char) fVar.field_showHead);
            this.PSy.put(fVar.field_showHead, valueOf);
            AppMethodBeat.o(37585);
            return valueOf;
        }
    }

    @Override // com.tencent.mm.ui.f
    public int getCount() {
        AppMethodBeat.i(37586);
        int count = super.getCount();
        AppMethodBeat.o(37586);
        return count;
    }

    private String getString(int i2) {
        AppMethodBeat.i(37587);
        String str = this.PSy.get(i2);
        if (str == null) {
            str = this.context.getString(i2);
            this.PSy.put(i2, str);
        }
        AppMethodBeat.o(37587);
        return str;
    }

    @Override // com.tencent.mm.ui.f
    public final d<String> gGY() {
        AppMethodBeat.i(37588);
        d<String> dVar = (d) gUm();
        AppMethodBeat.o(37588);
        return dVar;
    }

    @Override // com.tencent.mm.ui.f
    public final f<String, com.tencent.mm.storage.f>.c b(d<String> dVar) {
        AppMethodBeat.i(233974);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            f<String, com.tencent.mm.storage.f>.c cVar = new f.c(dVar, (byte) 0);
            AppMethodBeat.o(233974);
            return cVar;
        }
        f<String, com.tencent.mm.storage.f>.c cVar2 = new f.c(dVar);
        AppMethodBeat.o(233974);
        return cVar2;
    }

    @Override // com.tencent.mm.ui.f
    public final ArrayList<com.tencent.mm.storage.f> bo(ArrayList<String> arrayList) {
        AppMethodBeat.i(37589);
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(arrayList.get(i2));
        }
        ArrayList<com.tencent.mm.storage.f> arrayList3 = new ArrayList<>(arrayList2.size());
        bg.aVF();
        Cursor iK = c.aSN().iK(arrayList2);
        while (iK.moveToNext()) {
            com.tencent.mm.storage.f fVar = new com.tencent.mm.storage.f();
            fVar.convertFrom(iK);
            arrayList3.add(fVar);
        }
        iK.close();
        Log.d("MicroMsg.AddressAdapter", "rebulidAllChangeData :" + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(37589);
        return arrayList3;
    }

    @Override // com.tencent.mm.ui.f
    public final SparseArray<String>[] a(HashSet<f.b<String, com.tencent.mm.storage.f>> hashSet, SparseArray<String>[] sparseArrayArr) {
        AppMethodBeat.i(37590);
        SparseArray<String>[] sparseArrayArr2 = new SparseArray[sparseArrayArr.length];
        LinkedList linkedList = new LinkedList();
        linkedList.add("weixin");
        long currentTimeMillis = System.currentTimeMillis();
        bg.aVF();
        Cursor b2 = c.aSN().b(this.PSf, this.PSg, this.gzY, linkedList, gUl(), this.PSr);
        if (b2 instanceof e) {
            d[] dVarArr = ((e) b2).OtV;
            int length = dVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                dVarArr[i2].akA(5000);
                sparseArrayArr2[i2] = new SparseArray<>();
                int i3 = 0;
                while (dVarArr[i2].moveToNext()) {
                    sparseArrayArr2[i2].put(i3, dVarArr[i2].getString(0));
                    i3++;
                }
            }
            this.PSo = dVarArr[0].getCount();
        } else {
            sparseArrayArr2[0] = new SparseArray<>();
            int i4 = 0;
            while (b2.moveToNext()) {
                sparseArrayArr2[0].put(i4, b2.getString(0));
                i4++;
            }
        }
        b2.close();
        Log.d("MicroMsg.AddressAdapter", "refreshPosistion last :" + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(37590);
        return sparseArrayArr2;
    }

    public final void gUp() {
        AppMethodBeat.i(37591);
        super.o(null, 1);
        AppMethodBeat.o(37591);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(37592);
        if (obj == null || !(obj instanceof String)) {
            Log.d("MicroMsg.AddressAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
            AppMethodBeat.o(37592);
            return;
        }
        bg.aVF();
        if (mStorageEx == c.aSN()) {
            if (ab.IR((String) obj) || this.PSA.contains((String) obj)) {
                Log.d("MicroMsg.AddressAdapter", "newcursor is stranger ，return");
            } else {
                super.o((String) obj, 2);
                if (this.PSs && this.PSm != null) {
                    this.PSm.PTd = true;
                    Log.d("MicroMsg.AddressAdapter", "ADDRESS onNotifyChange");
                    AppMethodBeat.o(37592);
                    return;
                }
            }
        }
        AppMethodBeat.o(37592);
    }

    /* access modifiers changed from: protected */
    public void b(com.tencent.mm.storage.f fVar, b bVar) {
        CharSequence charSequence;
        AppMethodBeat.i(37581);
        if (as.bjp(fVar.field_username)) {
            String bN = ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).bN(fVar.field_openImAppid, fVar.field_descWordingId);
            if (!Util.isNullOrNil(bN)) {
                if ("3552365301".equals(fVar.field_openImAppid)) {
                    bN = "@".concat(String.valueOf(bN));
                }
                bVar.PSD.aR(bN, R.color.wh, 14);
            } else {
                bVar.PSD.aR(null, 0, 0);
            }
        } else {
            bVar.PSD.aR(null, 0, 0);
        }
        if (ab.Iy(fVar.field_username) || ab.IB(fVar.field_username)) {
            bVar.PSD.setCompoundRightDrawablesWithIntrinsicBounds(R.raw.open_im_main_logo);
            bVar.PSD.setDrawRightDrawable(true);
        } else if (bVar.PSD.OVM) {
            bVar.PSD.setDrawRightDrawable(false);
        }
        CharSequence charSequence2 = fVar.NON;
        if (charSequence2 == null) {
            try {
                charSequence = l.e(this.context, (CharSequence) bnp(getDisplayName(fVar.arJ(), fVar.field_username)), com.tencent.mm.cb.a.aG(this.context, R.dimen.is));
            } catch (Exception e2) {
                charSequence = null;
            }
            if (charSequence == null) {
                charSequence = "";
            }
            bVar.PSD.setText(charSequence);
        } else {
            bVar.PSD.setText(charSequence2);
        }
        ((com.tencent.mm.plugin.textstatus.a.c) g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).setTextWithStatus(bVar.PSD, fVar.field_username, a.b.CONTACT_LIST);
        AppMethodBeat.o(37581);
    }

    /* Return type fixed from 'com.tencent.mm.storagebase.a.a' to match base method */
    @Override // com.tencent.mm.ui.f
    public final /* synthetic */ com.tencent.mm.storage.f gFJ() {
        AppMethodBeat.i(37595);
        com.tencent.mm.storage.f fVar = new com.tencent.mm.storage.f();
        AppMethodBeat.o(37595);
        return fVar;
    }
}

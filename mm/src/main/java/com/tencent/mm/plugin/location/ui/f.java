package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class f {
    Context context;
    private String gzn = "";
    private MMHandler mHandler = new MMHandler(Looper.getMainLooper());
    private boolean mIsInit = false;
    MMHorList yII;
    a yIJ;
    private int yIK;
    c yIL = null;

    public interface c {
        void aDg(String str);
    }

    public f(Context context2, View view, String str) {
        AppMethodBeat.i(55905);
        this.context = context2;
        this.yII = (MMHorList) view;
        this.gzn = str;
        edl();
        AppMethodBeat.o(55905);
    }

    private void edl() {
        AppMethodBeat.i(55906);
        LinkedList<String> PY = n.ecS().PY(this.gzn);
        Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "initAvatarList, memebers.size=%d", Integer.valueOf(PY.size()));
        ArrayList<b> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (String str : PY) {
            if (!Util.isNullOrNil(str)) {
                arrayList.add(new b(str));
                arrayList2.add(str);
            }
        }
        av(arrayList);
        aw(arrayList2);
        this.yII.invalidate();
        this.yIJ.notifyDataSetChanged();
        AppMethodBeat.o(55906);
    }

    private void av(ArrayList<b> arrayList) {
        AppMethodBeat.i(55907);
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.yIP) {
                next.edo();
            }
        }
        this.yIK = com.tencent.mm.cb.a.fromDPToPix(this.context, 60);
        this.yII.setOverScrollEnabled(true);
        this.yII.setItemWidth(this.yIK);
        this.yII.setCenterInParent(true);
        this.yII.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.location.ui.f.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(55893);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/ShareHeaderAvatarViewMgr$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                String str = (String) view.getTag();
                if (!Util.isNullOrNil(str)) {
                    h.INSTANCE.a(10997, "15", 0, 0, 0);
                    if (f.this.yIL != null) {
                        f.this.yIL.aDg(str);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/location/ui/ShareHeaderAvatarViewMgr$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(55893);
            }
        });
        this.yIJ = new a(arrayList);
        this.yII.setAdapter((ListAdapter) this.yIJ);
        AppMethodBeat.o(55907);
    }

    private void aDb(String str) {
        AppMethodBeat.i(55908);
        Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberEnter, usernmae=%s", str);
        if (this.yIJ.aDf(str)) {
            AppMethodBeat.o(55908);
            return;
        }
        b bVar = new b(str);
        a aVar = this.yIJ;
        aVar.yIO.add(bVar);
        aVar.notifyDataSetChanged();
        this.yII.invalidate();
        AppMethodBeat.o(55908);
    }

    private void aDc(String str) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(55909);
        Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberExit, username=%s", str);
        if (this.yIJ.aDf(str)) {
            a aVar = this.yIJ;
            while (true) {
                i2 = i3;
                if (i2 >= aVar.yIO.size()) {
                    i2 = -1;
                    break;
                } else if (aVar.yIO.get(i2).username.equals(str)) {
                    break;
                } else {
                    i3 = i2 + 1;
                }
            }
            if (i2 != -1) {
                aVar.yIO.remove(i2);
                aVar.notifyDataSetChanged();
            }
            this.yII.invalidate();
        }
        AppMethodBeat.o(55909);
    }

    public final void aDd(String str) {
        final int i2 = 0;
        AppMethodBeat.i(55910);
        Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberTalk, username=%s", str);
        if (this.yIJ.aDf(str)) {
            this.yIJ.aDe(str).edo();
            this.yIJ.notifyDataSetChanged();
            this.yII.invalidate();
            if (this.yII.getIsTouching() || Util.isNullOrNil(str)) {
                AppMethodBeat.o(55910);
                return;
            }
            a aVar = this.yIJ;
            int i3 = 0;
            while (true) {
                if (i3 >= aVar.yIO.size()) {
                    i3 = -1;
                    break;
                } else if (aVar.yIO.get(i3).username.equals(str)) {
                    break;
                } else {
                    i3++;
                }
            }
            Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker, index=%d", Integer.valueOf(i3));
            if (i3 != -1) {
                int i4 = i3 * this.yIK;
                int currentPosition = this.yII.getCurrentPosition();
                if (i4 >= currentPosition) {
                    currentPosition = i4 > currentPosition + (this.yIK * 3) ? i4 - (this.yIK * 3) : 0;
                }
                if (i3 != 0) {
                    i2 = currentPosition;
                }
                this.mHandler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.location.ui.f.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(55894);
                        Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker pos=%d", Integer.valueOf(i2));
                        f.this.yII.alA(i2);
                        AppMethodBeat.o(55894);
                    }
                });
            }
        }
        AppMethodBeat.o(55910);
    }

    public final void edm() {
        AppMethodBeat.i(55911);
        a aVar = this.yIJ;
        Iterator<b> it = aVar.yIO.iterator();
        while (it.hasNext()) {
            it.next().edp();
        }
        aVar.notifyDataSetChanged();
        this.yII.invalidate();
        AppMethodBeat.o(55911);
    }

    /* access modifiers changed from: package-private */
    public class b {
        String username;
        private LinearLayout.LayoutParams xOV;
        boolean yIP = false;
        a yIQ;

        public b(String str) {
            AppMethodBeat.i(55902);
            this.username = str;
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.ShareHeaderAvatarViewMgr", "init HeaderAvatar, username can't not be null");
                AppMethodBeat.o(55902);
                return;
            }
            this.yIQ = new a();
            this.yIQ.yIR = (RelativeLayout) ((LayoutInflater) f.this.context.getSystemService("layout_inflater")).inflate(R.layout.b2d, (ViewGroup) null);
            this.yIQ.jWS = (ImageView) this.yIQ.yIR.findViewById(R.id.wm);
            a.b.d(this.yIQ.jWS, this.username);
            this.yIQ.yIR.setTag(this.username);
            this.xOV = new LinearLayout.LayoutParams(-2, -2);
            this.xOV.leftMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(f.this.context, 5.0f);
            this.xOV.rightMargin = BackwardSupportUtil.BitmapFactory.fromDPToPix(f.this.context, 5.0f);
            this.xOV.gravity = 17;
            AppMethodBeat.o(55902);
        }

        public final void edo() {
            AppMethodBeat.i(55903);
            Log.i("MicroMsg.ShareHeaderAvatarViewMgr", "setTalking, username=%s", this.username);
            this.yIQ.yIR.setBackgroundResource(R.drawable.bgw);
            this.yIQ.yIR.invalidate();
            this.yIP = true;
            AppMethodBeat.o(55903);
        }

        public final void edp() {
            AppMethodBeat.i(55904);
            Log.i("MicroMsg.ShareHeaderAvatarViewMgr", "exitTalking, username=%s", this.username);
            this.yIQ.yIR.setBackgroundResource(R.drawable.bgv);
            this.yIQ.yIR.invalidate();
            this.yIP = false;
            AppMethodBeat.o(55904);
        }

        /* access modifiers changed from: package-private */
        public class a {
            ImageView jWS;
            RelativeLayout yIR;

            a() {
            }
        }
    }

    public final void aw(ArrayList<String> arrayList) {
        AppMethodBeat.i(55912);
        Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, members.size=%d", Integer.valueOf(arrayList.size()));
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList<String> edn = this.yIJ.edn();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (edn.indexOf(next) == -1) {
                arrayList2.add(next);
            }
        }
        Iterator<String> it2 = edn.iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            if (arrayList.indexOf(next2) == -1) {
                arrayList3.add(next2);
            }
        }
        Log.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, newMember.size=%d, removeMember.size=%d", Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList3.size()));
        if (arrayList2.size() > 0) {
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                aDb((String) it3.next());
            }
        }
        if (arrayList3.size() > 0) {
            Iterator it4 = arrayList3.iterator();
            while (it4.hasNext()) {
                aDc((String) it4.next());
            }
        }
        AppMethodBeat.o(55912);
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        ArrayList<b> yIO = new ArrayList<>();

        public a(ArrayList<b> arrayList) {
            AppMethodBeat.i(55895);
            this.yIO.addAll(arrayList);
            AppMethodBeat.o(55895);
        }

        public final int getCount() {
            AppMethodBeat.i(55896);
            int size = this.yIO.size();
            AppMethodBeat.o(55896);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(55897);
            b bVar = this.yIO.get(i2);
            AppMethodBeat.o(55897);
            return bVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(55898);
            RelativeLayout relativeLayout = this.yIO.get(i2).yIQ.yIR;
            AppMethodBeat.o(55898);
            return relativeLayout;
        }

        public final b aDe(String str) {
            AppMethodBeat.i(55899);
            for (int i2 = 0; i2 < this.yIO.size(); i2++) {
                if (this.yIO.get(i2).username.equals(str)) {
                    b bVar = this.yIO.get(i2);
                    AppMethodBeat.o(55899);
                    return bVar;
                }
            }
            AppMethodBeat.o(55899);
            return null;
        }

        public final boolean aDf(String str) {
            AppMethodBeat.i(55900);
            for (int i2 = 0; i2 < this.yIO.size(); i2++) {
                if (this.yIO.get(i2).username.equals(str)) {
                    AppMethodBeat.o(55900);
                    return true;
                }
            }
            AppMethodBeat.o(55900);
            return false;
        }

        public final ArrayList<String> edn() {
            AppMethodBeat.i(55901);
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<b> it = this.yIO.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().username);
            }
            AppMethodBeat.o(55901);
            return arrayList;
        }
    }
}

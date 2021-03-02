package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.plugin.fav.ui.a.d;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.protocal.protobuf.anl;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavTagEditUI extends MMActivity {
    private g tfP;
    private List<String> tfQ;
    private FavTagPanel tfR;
    private FavTagPanel tfS;
    private ListView tfT;
    private ListView tfU;
    private TextView tfV;
    private c tfW;
    private d tfX;
    private boolean tfY;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(FavTagEditUI favTagEditUI) {
        AppMethodBeat.i(106931);
        favTagEditUI.XH();
        AppMethodBeat.o(106931);
    }

    static /* synthetic */ void c(FavTagEditUI favTagEditUI) {
        AppMethodBeat.i(106932);
        favTagEditUI.cWb();
        AppMethodBeat.o(106932);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a7z;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        LinkedList<String> linkedList;
        AppMethodBeat.i(106925);
        super.onCreate(bundle);
        final long longExtra = getIntent().getLongExtra("key_fav_item_id", -1);
        if (-1 != longExtra) {
            this.tfP = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(longExtra);
        }
        this.tfQ = getIntent().getStringArrayListExtra("key_fav_result_list");
        this.tfS = (FavTagPanel) findViewById(R.id.cdh);
        this.tfT = (ListView) findViewById(R.id.ih_);
        this.tfU = (ListView) findViewById(R.id.hf4);
        this.tfV = (TextView) findViewById(R.id.fb7);
        this.tfS.Bz(true);
        this.tfS.setTagEditTextBG(R.drawable.ay6);
        this.tfS.setIsAllowEnterCharacter(true);
        this.tfS.setCallBack(new MMTagPanel.a() {
            /* class com.tencent.mm.plugin.fav.ui.FavTagEditUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void anb(String str) {
                AppMethodBeat.i(106913);
                FavTagEditUI.this.tfS.removeTag(str);
                FavTagEditUI.this.tfW.ast(str);
                if (FavTagEditUI.this.tfR != null) {
                    FavTagEditUI.this.tfR.dn(str, false);
                }
                FavTagEditUI.c(FavTagEditUI.this);
                AppMethodBeat.o(106913);
            }

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void anc(String str) {
            }

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void and(String str) {
                AppMethodBeat.i(106914);
                FavTagEditUI.this.tfS.removeTag(str);
                FavTagEditUI.this.tfW.ast(str);
                if (FavTagEditUI.this.tfR != null) {
                    FavTagEditUI.this.tfR.dn(str, false);
                }
                FavTagEditUI.c(FavTagEditUI.this);
                AppMethodBeat.o(106914);
            }

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void ane(String str) {
                AppMethodBeat.i(106915);
                if (!Util.isNullOrNil(str)) {
                    d dVar = FavTagEditUI.this.tfX;
                    dVar.thC.clear();
                    dVar.thB.clear();
                    dVar.qLO = Util.nullAs(str, "");
                    l favTagSetMgr = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr();
                    boolean isNullOrNil = Util.isNullOrNil(str);
                    ArrayList arrayList = new ArrayList(16);
                    Iterator<anm> it = favTagSetMgr.taG.xuO.iterator();
                    while (it.hasNext()) {
                        Iterator<anl> it2 = it.next().Lym.iterator();
                        while (it2.hasNext()) {
                            anl next = it2.next();
                            if (isNullOrNil || next.FeZ.contains(str)) {
                                arrayList.add(next.FeZ);
                            }
                        }
                    }
                    dVar.thB.addAll(arrayList);
                    dVar.notifyDataSetChanged();
                    FavTagEditUI.this.tfU.setVisibility(0);
                    FavTagEditUI.this.tfT.setVisibility(8);
                } else {
                    FavTagEditUI.this.tfU.setVisibility(8);
                    FavTagEditUI.this.tfT.setVisibility(0);
                }
                FavTagEditUI.c(FavTagEditUI.this);
                AppMethodBeat.o(106915);
            }

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void anf(String str) {
                AppMethodBeat.i(106916);
                if (Util.isNullOrNil(str)) {
                    Log.d("MicroMsg.FavTagEditUI", "on create tag, fail, tag is empty");
                    AppMethodBeat.o(106916);
                    return;
                }
                FavTagEditUI.this.tfS.dm(str, true);
                FavTagEditUI.c(FavTagEditUI.this);
                AppMethodBeat.o(106916);
            }

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void cIk() {
            }

            @Override // com.tencent.mm.ui.base.MMTagPanel.a
            public final void E(boolean z, int i2) {
                AppMethodBeat.i(106917);
                FavTagEditUI.this.tfY = z;
                FavTagEditUI.this.tfV.setVisibility((!FavTagEditUI.this.tfY || i2 <= 0) ? 8 : 0);
                FavTagEditUI.this.tfV.setText(FavTagEditUI.this.getString(R.string.ccs, new Object[]{Integer.valueOf(i2)}));
                FavTagEditUI.c(FavTagEditUI.this);
                AppMethodBeat.o(106917);
            }
        });
        this.tfS.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.FavTagEditUI.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(106918);
                FavTagEditUI.this.tfS.gLd();
                FavTagEditUI.this.showVKB();
                AppMethodBeat.o(106918);
            }
        }, 100);
        if (this.tfP != null) {
            this.tfS.a(this.tfP.field_tagProto.Lyo, this.tfP.field_tagProto.Lyo);
        } else if (this.tfQ != null) {
            this.tfS.a(this.tfQ, this.tfQ);
        }
        this.tfW = new c(getContext()) {
            /* class com.tencent.mm.plugin.fav.ui.FavTagEditUI.AnonymousClass7 */

            @Override // com.tencent.mm.plugin.fav.ui.a.c
            public final void aso(String str) {
                AppMethodBeat.i(106919);
                FavTagEditUI.this.tfS.dm(str, true);
                if (FavTagEditUI.this.tfR != null) {
                    FavTagEditUI.this.tfR.dn(str, true);
                }
                FavTagEditUI.c(FavTagEditUI.this);
                AppMethodBeat.o(106919);
            }

            @Override // com.tencent.mm.plugin.fav.ui.a.c
            public final void asp(String str) {
                AppMethodBeat.i(106920);
                FavTagEditUI.this.tfS.removeTag(str);
                if (FavTagEditUI.this.tfR != null) {
                    FavTagEditUI.this.tfR.dn(str, false);
                }
                FavTagEditUI.c(FavTagEditUI.this);
                AppMethodBeat.o(106920);
            }
        };
        c cVar = this.tfW;
        if (this.tfP == null) {
            linkedList = null;
        } else {
            linkedList = this.tfP.field_tagProto.Lyo;
        }
        cVar.dK(linkedList);
        if (this.tfP != null && !this.tfP.field_tagProto.Lyn.isEmpty()) {
            View inflate = View.inflate(getContext(), R.layout.a83, null);
            TextView textView = (TextView) inflate.findViewById(R.id.cco);
            textView.setText(getString(R.string.caz));
            textView.setVisibility(0);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ei);
            this.tfR = (FavTagPanel) inflate.findViewById(R.id.cdj);
            this.tfR.setVisibility(0);
            this.tfR.a(this.tfP.field_tagProto.Lyo, this.tfP.field_tagProto.Lyn);
            this.tfR.setBackgroundResource(R.drawable.b9x);
            this.tfR.setPadding(0, 0, 0, dimensionPixelSize);
            this.tfR.setCallBack(new MMTagPanel.a() {
                /* class com.tencent.mm.plugin.fav.ui.FavTagEditUI.AnonymousClass8 */

                @Override // com.tencent.mm.ui.base.MMTagPanel.a
                public final void anb(String str) {
                    AppMethodBeat.i(106921);
                    FavTagEditUI.this.tfS.removeTag(str);
                    FavTagEditUI.this.tfW.ast(str);
                    FavTagEditUI.c(FavTagEditUI.this);
                    AppMethodBeat.o(106921);
                }

                @Override // com.tencent.mm.ui.base.MMTagPanel.a
                public final void anc(String str) {
                    AppMethodBeat.i(106922);
                    FavTagEditUI.this.tfS.dm(str, true);
                    FavTagEditUI.this.tfW.ass(str);
                    FavTagEditUI.c(FavTagEditUI.this);
                    AppMethodBeat.o(106922);
                }

                @Override // com.tencent.mm.ui.base.MMTagPanel.a
                public final void and(String str) {
                }

                @Override // com.tencent.mm.ui.base.MMTagPanel.a
                public final void cIk() {
                }

                @Override // com.tencent.mm.ui.base.MMTagPanel.a
                public final void ane(String str) {
                }

                @Override // com.tencent.mm.ui.base.MMTagPanel.a
                public final void anf(String str) {
                }

                @Override // com.tencent.mm.ui.base.MMTagPanel.a
                public final void E(boolean z, int i2) {
                }
            });
            this.tfT.addHeaderView(inflate);
        }
        if (((af) com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().cUF() > 0) {
            this.tfT.addHeaderView(View.inflate(getContext(), R.layout.a82, null));
        }
        this.tfT.setAdapter((ListAdapter) this.tfW);
        this.tfT.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavTagEditUI.AnonymousClass9 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(106923);
                FavTagEditUI.this.tfS.gLe();
                AppMethodBeat.o(106923);
                return false;
            }
        });
        this.tfX = new d(getContext()) {
            /* class com.tencent.mm.plugin.fav.ui.FavTagEditUI.AnonymousClass10 */

            @Override // com.tencent.mm.plugin.fav.ui.a.d
            public final void anW(String str) {
                AppMethodBeat.i(106924);
                FavTagEditUI.this.tfS.dm(str, true);
                FavTagEditUI.this.tfW.ass(str);
                FavTagEditUI.this.tfS.gLc();
                FavTagEditUI.this.tfS.gLe();
                FavTagEditUI.c(FavTagEditUI.this);
                AppMethodBeat.o(106924);
            }
        };
        this.tfU.setAdapter((ListAdapter) this.tfX);
        this.tfU.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavTagEditUI.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(106910);
                FavTagEditUI.this.tfS.gLe();
                AppMethodBeat.o(106910);
                return false;
            }
        });
        setMMTitle(R.string.c9s);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavTagEditUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(106909);
                FavTagEditUI.a(FavTagEditUI.this);
                AppMethodBeat.o(106909);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.vl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavTagEditUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(106911);
                if (FavTagEditUI.this.tfY) {
                    FavTagEditUI.c(FavTagEditUI.this);
                    AppMethodBeat.o(106911);
                } else {
                    ArrayList<String> tagList = FavTagEditUI.this.tfS.getTagList();
                    String trim = FavTagEditUI.this.tfS.getEditText().trim();
                    if (!Util.isNullOrNil(trim)) {
                        tagList.remove(trim);
                        tagList.add(trim);
                    }
                    FavTagEditUI.this.tfP = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(longExtra);
                    if (FavTagEditUI.this.tfP != null) {
                        FavTagEditUI.a(FavTagEditUI.this.tfP, tagList, FavTagEditUI.this.getIntent().getIntExtra("key_fav_scene", 1));
                        Intent intent = new Intent();
                        intent.putExtra("key_fav_result_list", tagList);
                        FavTagEditUI.this.setResult(-1, intent);
                    } else {
                        String[] strArr = new String[tagList.size()];
                        Iterator<String> it = tagList.iterator();
                        int i2 = 0;
                        while (it.hasNext()) {
                            strArr[i2] = it.next();
                            i2++;
                        }
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_fav_result_array", strArr);
                        intent2.putExtra("key_fav_result_list", tagList);
                        FavTagEditUI.this.setResult(-1, intent2);
                    }
                    FavTagEditUI.this.finish();
                    FavTagEditUI.this.hideVKB();
                    AppMethodBeat.o(106911);
                }
                return true;
            }
        }, null, t.b.GREEN);
        cWb();
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().a(this.tfW);
        AppMethodBeat.o(106925);
    }

    private void cWb() {
        AppMethodBeat.i(106926);
        if (this.tfY) {
            Log.w("MicroMsg.FavTagEditUI", "match max length, disable finish button");
            if (isOptionMenuEnable(0)) {
                enableOptionMenu(0, false);
            }
            AppMethodBeat.o(106926);
            return;
        }
        if (this.tfP == null) {
            if (this.tfS.getTagCount() > 0 || this.tfS.getEditText().length() > 0) {
                if (!isOptionMenuEnable(0)) {
                    enableOptionMenu(0, true);
                    AppMethodBeat.o(106926);
                    return;
                }
            } else if (isOptionMenuEnable(0)) {
                enableOptionMenu(0, false);
                AppMethodBeat.o(106926);
                return;
            }
        } else if (this.tfP.field_tagProto.Lyo.size() == this.tfS.getTagCount() && this.tfS.getEditText().length() <= 0) {
            ArrayList<String> tagList = this.tfS.getTagList();
            for (int i2 = 0; i2 < tagList.size(); i2++) {
                if (!tagList.get(i2).equals(this.tfP.field_tagProto.Lyo.get(i2))) {
                    if (!isOptionMenuEnable(0)) {
                        enableOptionMenu(0, true);
                    }
                    AppMethodBeat.o(106926);
                    return;
                }
            }
            if (isOptionMenuEnable(0)) {
                enableOptionMenu(0, false);
            }
        } else if (!isOptionMenuEnable(0)) {
            enableOptionMenu(0, true);
            AppMethodBeat.o(106926);
            return;
        }
        AppMethodBeat.o(106926);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(106927);
        super.onDestroy();
        l favTagSetMgr = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr();
        c cVar = this.tfW;
        if (cVar == null) {
            AppMethodBeat.o(106927);
            return;
        }
        favTagSetMgr.bGH.remove(cVar.toString());
        AppMethodBeat.o(106927);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(106928);
        if (i2 == 4) {
            XH();
            AppMethodBeat.o(106928);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(106928);
        return onKeyDown;
    }

    private void XH() {
        AppMethodBeat.i(106929);
        h.c(getContext(), getString(R.string.cay), "", getString(R.string.ha), getString(R.string.sz), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavTagEditUI.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(106912);
                FavTagEditUI.this.finish();
                AppMethodBeat.o(106912);
            }
        }, null);
        AppMethodBeat.o(106929);
    }

    public static void a(g gVar, Collection<String> collection, int i2) {
        HashSet hashSet;
        AppMethodBeat.i(106930);
        if (gVar == null) {
            AppMethodBeat.o(106930);
            return;
        }
        Log.d("MicroMsg.FavTagEditUI", "mod tags %s", collection);
        HashSet hashSet2 = new HashSet();
        hashSet2.addAll(gVar.field_tagProto.Lyo);
        gVar.field_tagProto.Lyo.clear();
        if (collection == null || collection.isEmpty()) {
            hashSet = hashSet2;
        } else {
            gVar.field_tagProto.Lyo.addAll(collection);
            hashSet2.removeAll(collection);
            hashSet = hashSet2;
        }
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(gVar, ch.COL_LOCALID);
        b.p(gVar);
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavTagSetMgr().j(hashSet);
        b.a(gVar, i2);
        AppMethodBeat.o(106930);
    }
}

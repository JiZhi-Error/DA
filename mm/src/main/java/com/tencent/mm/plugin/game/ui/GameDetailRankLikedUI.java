package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.protobuf.bz;
import com.tencent.mm.plugin.game.protobuf.ca;
import com.tencent.mm.plugin.game.protobuf.ej;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import java.util.List;

public class GameDetailRankLikedUI extends MMActivity {
    private static final String TAG = ("MicroMsg" + GameDetailRankLikedUI.class.getSimpleName());
    private Dialog ocE;
    private ListView xQs;
    private a xQt;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static {
        AppMethodBeat.i(42002);
        AppMethodBeat.o(42002);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42000);
        super.onCreate(bundle);
        initView();
        String stringExtra = getIntent().getStringExtra("extra_appdi");
        if (Util.isNullOrNil(stringExtra)) {
            finish();
            AppMethodBeat.o(42000);
            return;
        }
        d.a aVar = new d.a();
        aVar.iLN = new bz();
        aVar.iLO = new ca();
        aVar.uri = "/cgi-bin/mmgame-bin/getuplist";
        aVar.funcId = 1331;
        d aXF = aVar.aXF();
        ((bz) aXF.iLK.iLR).hik = stringExtra;
        aa.a(aXF, new aa.a() {
            /* class com.tencent.mm.plugin.game.ui.GameDetailRankLikedUI.AnonymousClass2 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                AppMethodBeat.i(41994);
                if (i2 == 0 && i3 == 0) {
                    a aVar = GameDetailRankLikedUI.this.xQt;
                    LinkedList<ej> linkedList = ((ca) dVar.iLL.iLR).xMg;
                    if (linkedList != null) {
                        aVar.cvc.clear();
                        aVar.cvc.addAll(linkedList);
                        aVar.notifyDataSetChanged();
                    }
                    GameDetailRankLikedUI.this.ocE.dismiss();
                    AppMethodBeat.o(41994);
                } else {
                    Log.e(GameDetailRankLikedUI.TAG, "CGI return is not OK. (%d, %d)(%s)", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    GameDetailRankLikedUI.this.finish();
                    AppMethodBeat.o(41994);
                }
                return 0;
            }
        });
        AppMethodBeat.o(42000);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.apx;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(42001);
        setMMTitle(R.string.doc);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.game.ui.GameDetailRankLikedUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(41993);
                GameDetailRankLikedUI.this.finish();
                AppMethodBeat.o(41993);
                return true;
            }
        });
        this.xQs = (ListView) findViewById(R.id.dex);
        this.xQt = new a(this);
        this.xQs.setAdapter((ListAdapter) this.xQt);
        this.ocE = c.gl(getContext());
        this.ocE.show();
        AppMethodBeat.o(42001);
    }

    /* access modifiers changed from: package-private */
    public static class a extends BaseAdapter {
        List<ej> cvc = new LinkedList();
        private Context mContext;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(41999);
            ej Ou = Ou(i2);
            AppMethodBeat.o(41999);
            return Ou;
        }

        public a(Context context) {
            AppMethodBeat.i(41995);
            this.mContext = context;
            AppMethodBeat.o(41995);
        }

        public final int getCount() {
            AppMethodBeat.i(41996);
            int size = this.cvc.size();
            AppMethodBeat.o(41996);
            return size;
        }

        private ej Ou(int i2) {
            AppMethodBeat.i(41997);
            ej ejVar = this.cvc.get(i2);
            AppMethodBeat.o(41997);
            return ejVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        /* renamed from: com.tencent.mm.plugin.game.ui.GameDetailRankLikedUI$a$a  reason: collision with other inner class name */
        static class C1406a {
            public ImageView keC;
            public TextView pwO;
            public TextView uGh;

            private C1406a() {
            }

            /* synthetic */ C1406a(byte b2) {
                this();
            }
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1406a aVar;
            AppMethodBeat.i(41998);
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.apy, viewGroup, false);
                aVar = new C1406a((byte) 0);
                aVar.keC = (ImageView) view.findViewById(R.id.deu);
                aVar.uGh = (TextView) view.findViewById(R.id.dev);
                aVar.pwO = (TextView) view.findViewById(R.id.dew);
                view.setTag(aVar);
            } else {
                aVar = (C1406a) view.getTag();
            }
            ej Ou = Ou(i2);
            a.b.a(aVar.keC, Ou.xNH, 0.5f, false);
            as Kn = ((l) g.af(l.class)).aSN().Kn(Ou.xNH);
            if (Kn != null) {
                aVar.uGh.setText(new SpannableString(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, Kn.arJ(), aVar.uGh.getTextSize())));
            } else {
                aVar.uGh.setText("");
            }
            aVar.pwO.setText(Ou.xNI);
            AppMethodBeat.o(41998);
            return view;
        }
    }
}

package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.c;
import com.tencent.mm.plugin.ipcall.model.e.f;
import com.tencent.mm.plugin.ipcall.model.f.g;
import com.tencent.mm.plugin.ipcall.model.f.h;
import com.tencent.mm.plugin.ipcall.model.f.j;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.protocal.protobuf.bxz;
import com.tencent.mm.protocal.protobuf.ewg;
import com.tencent.mm.protocal.protobuf.ewl;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public class IPCallRechargeUI extends MMActivity implements i {
    TextView jVn;
    private MMHandler mHandler = new MMHandler() {
        /* class com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(25873);
            switch (message.what) {
                case 1002:
                    IPCallRechargeUI.this.yxr.setVisibility(0);
                    IPCallRechargeUI.k(IPCallRechargeUI.this);
                    AppMethodBeat.o(25873);
                    return;
                default:
                    Log.w("MicroMsg.IPCallRechargeUI", "unknow message, cannt handle.");
                    AppMethodBeat.o(25873);
                    return;
            }
        }
    };
    private int rid = -1;
    private String[] rih;
    private k.a riw = new k.a() {
        /* class com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.AnonymousClass1 */

        @Override // com.tencent.mm.pluginsdk.model.k.a
        public final void Y(ArrayList<q> arrayList) {
            AppMethodBeat.i(25871);
            IPCallRechargeUI.this.yxm.ysr = Util.nowMilliSecond();
            if (arrayList == null || arrayList.size() <= 0) {
                if (IPCallRechargeUI.this.yuB != null && IPCallRechargeUI.this.yuB.isShowing()) {
                    IPCallRechargeUI.this.yuB.dismiss();
                }
                Log.i("MicroMsg.IPCallRechargeUI", "[onQueryFinish] result=null");
                IPCallRechargeUI.this.rid = 10236;
                IPCallRechargeUI.this.asq();
                AppMethodBeat.o(25871);
                return;
            }
            IPCallRechargeUI.this.yxd = new String[arrayList.size()];
            IPCallRechargeUI.this.yxe = new String[arrayList.size()];
            q qVar = arrayList.get(0);
            if (qVar.JVq == 10232) {
                Log.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product OK size=" + arrayList.size());
                Iterator<q> it = arrayList.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    q next = it.next();
                    IPCallRechargeUI.this.yxd[i2] = new BigDecimal(next.JVp).divide(new BigDecimal(1000000)).toString();
                    IPCallRechargeUI.this.yxe[i2] = next.JVo;
                    i2++;
                }
                if (IPCallRechargeUI.this.yxi > 0 && IPCallRechargeUI.this.yxe.length > 0) {
                    String str = IPCallRechargeUI.this.yxe[0];
                    if (!Util.isNullOrNil(str) && !str.equals(IPCallRechargeUI.this.yxg)) {
                        Log.i("MicroMsg.IPCallRechargeUI", "remote currency:" + IPCallRechargeUI.this.yxg + ",google wallet currency:" + str);
                        IPCallRechargeUI.a(IPCallRechargeUI.this, str);
                        AppMethodBeat.o(25871);
                        return;
                    }
                }
                if (IPCallRechargeUI.this.yuB != null && IPCallRechargeUI.this.yuB.isShowing()) {
                    IPCallRechargeUI.this.yuB.dismiss();
                }
                IPCallRechargeUI.this.asq();
                AppMethodBeat.o(25871);
                return;
            }
            if (IPCallRechargeUI.this.yuB != null && IPCallRechargeUI.this.yuB.isShowing()) {
                IPCallRechargeUI.this.yuB.dismiss();
            }
            IPCallRechargeUI.this.rid = qVar.JVq;
            Log.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product Failed Status:" + IPCallRechargeUI.this.rid);
            IPCallRechargeUI.this.asq();
            AppMethodBeat.o(25871);
        }
    };
    ProgressDialog yuB;
    private String[] yxd;
    private String[] yxe;
    private String yxf;
    private String yxg;
    private boolean yxh = false;
    private int yxi;
    private int yxj = -1;
    private String yxk;
    private String yxl;
    private h yxm = new h();
    private g yxn = new g();
    private j yxo = new j();
    RelativeLayout yxp;
    GridView yxq;
    ListView yxr;
    a yxs;
    Button yxt;
    f yxu;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public IPCallRechargeUI() {
        AppMethodBeat.i(25888);
        AppMethodBeat.o(25888);
    }

    static /* synthetic */ void a(IPCallRechargeUI iPCallRechargeUI, String str) {
        AppMethodBeat.i(25897);
        iPCallRechargeUI.aCm(str);
        AppMethodBeat.o(25897);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25889);
        super.onCreate(bundle);
        bg.azz().a(929, this);
        setMMTitle(R.string.e79);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25875);
                IPCallRechargeUI.this.finish();
                AppMethodBeat.o(25875);
                return true;
            }
        });
        addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.AnonymousClass6 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25876);
                IPCallRechargeUI.h(IPCallRechargeUI.this);
                AppMethodBeat.o(25876);
                return true;
            }
        });
        this.yxp = (RelativeLayout) findViewById(R.id.e95);
        this.yxq = (GridView) findViewById(R.id.guw);
        this.yxr = (ListView) findViewById(R.id.gv0);
        ViewGroup viewGroup = (ViewGroup) View.inflate(getContext(), R.layout.ax3, null);
        this.yxr.addFooterView(viewGroup, null, false);
        this.yxs = new a(this);
        this.yxr.setAdapter((ListAdapter) this.yxs);
        this.jVn = (TextView) viewGroup.findViewById(R.id.ior);
        this.yxt = (Button) findViewById(R.id.ahq);
        String string = getString(R.string.e7e);
        Spannable newSpannable = Spannable.Factory.getInstance().newSpannable(string);
        newSpannable.setSpan(new ClickableSpan() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.AnonymousClass7 */

            public final void onClick(View view) {
                String str;
                AppMethodBeat.i(25877);
                ((TextView) view).setHighlightColor(IPCallRechargeUI.this.getResources().getColor(R.color.ac_));
                Intent intent = new Intent();
                String str2 = IPCallRechargeUI.this.getString(R.string.e7d) + "&usedcc=";
                List<Integer> eag = c.ead().eag();
                if (eag.size() > 0) {
                    int size = eag.size();
                    if (size > 5) {
                        size = 5;
                    }
                    int i2 = 0;
                    while (i2 < size) {
                        String aCw = com.tencent.mm.plugin.ipcall.a.a.aCw(eag.get(i2).toString());
                        if (!Util.isNullOrNil(aCw)) {
                            str = str2 + aCw + "|";
                        } else {
                            str = str2;
                        }
                        i2++;
                        str2 = str;
                    }
                    if (str2.endsWith("|")) {
                        str2 = str2.substring(0, str2.length() - 1);
                    }
                } else {
                    str2 = str2 + com.tencent.mm.plugin.ipcall.a.a.aCw(com.tencent.mm.plugin.ipcall.a.c.ebO());
                }
                intent.putExtra("rawUrl", str2);
                intent.putExtra("showShare", false);
                com.tencent.mm.br.c.b(IPCallRechargeUI.this, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(25877);
            }

            public final void updateDrawState(TextPaint textPaint) {
                AppMethodBeat.i(25878);
                textPaint.setColor(IPCallRechargeUI.this.getResources().getColor(R.color.x0));
                textPaint.setUnderlineText(false);
                AppMethodBeat.o(25878);
            }
        }, 0, string.length(), 33);
        this.jVn.setText(newSpannable);
        this.jVn.setMovementMethod(LinkMovementMethod.getInstance());
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.yuB = com.tencent.mm.ui.base.h.a((Context) context, getString(R.string.e6r), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.AnonymousClass8 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(25879);
                try {
                    if (IPCallRechargeUI.this.yxu != null) {
                        bg.azz().a(IPCallRechargeUI.this.yxu);
                    }
                    IPCallRechargeUI.this.finish();
                    AppMethodBeat.o(25879);
                } catch (Exception e2) {
                    Log.e("MicroMsg.IPCallRechargeUI", "cancel getProductListScene error: %s", e2.getMessage());
                    AppMethodBeat.o(25879);
                }
            }
        });
        aCm("");
        this.yxm.start();
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(257, 4, 1, true);
        AppMethodBeat.o(25889);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(25890);
        super.onDestroy();
        this.yxm.yrT = Util.nowMilliSecond();
        this.yxm.finish();
        bg.azz().b(929, this);
        AppMethodBeat.o(25890);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ax5;
    }

    private void aCm(String str) {
        String aCw;
        AppMethodBeat.i(25891);
        List<Integer> eag = c.ead().eag();
        if (eag.size() == 0) {
            aCw = com.tencent.mm.plugin.ipcall.a.a.aCw(com.tencent.mm.plugin.ipcall.a.c.ebO());
        } else {
            aCw = com.tencent.mm.plugin.ipcall.a.a.aCw(eag.get(0).toString());
        }
        this.yxu = new f(aCw, str);
        bg.azz().a(this.yxu, 0);
        AppMethodBeat.o(25891);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        int i4;
        int i5;
        int i6;
        String str;
        AppMethodBeat.i(25892);
        Log.i("MicroMsg.IPCallRechargeUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 2001) {
            boolean z = false;
            if (intent != null) {
                i6 = intent.getIntExtra("key_err_code", 0);
                String stringExtra = intent.getStringExtra("key_err_msg");
                long longExtra = intent.getLongExtra("key_launch_ts", 0);
                int intExtra = intent.getIntExtra("key_gw_error_code", 0);
                i5 = intent.getIntExtra("key_response_position", 0);
                if (i6 == 100000001) {
                    z = true;
                }
                Log.i("MicroMsg.IPCallRechargeUI", "onActivityResult pay.errCode:[%d] errMsg:[%s] errGWCode:[%s] errPosition:[%d] isFailedConsume:[%s]", Integer.valueOf(i6), stringExtra, Integer.valueOf(intExtra), Integer.valueOf(i5), String.valueOf(z));
                if (i6 != 6 || intExtra == 0) {
                    this.yxn.ysl = (long) i6;
                } else {
                    this.yxn.ysl = (long) intExtra;
                }
                if (i5 == 3) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(257, 9, 1, true);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(257, 11, 1, true);
                    this.yxn.ysl = 0;
                    this.yxn.ysm = 2;
                    str = getString(R.string.e9s);
                } else {
                    if (i5 != 1) {
                        if (i3 == -1 && i6 == 0) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(257, 9, 1, true);
                            str = stringExtra;
                        } else if (z) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(257, 9, 1, true);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(257, 12, 1, true);
                            this.yxn.ysl = 0;
                            this.yxn.ysm = 1;
                        }
                    }
                    str = stringExtra;
                }
                this.yxn.ysk = longExtra;
                this.yxn.yrT = Util.nowMilliSecond();
                this.yxn.finish();
                i4 = intExtra;
            } else {
                i4 = 0;
                i5 = 0;
                i6 = 0;
                str = "";
            }
            if (i3 == -1) {
                if (intent != null && i6 == 0) {
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                    intent.getStringArrayListExtra("key_response_series_ids");
                    Iterator<String> it = stringArrayListExtra.iterator();
                    while (it.hasNext()) {
                        Log.i("MicroMsg.IPCallRechargeUI", "buy product ok productId:", Util.nullAsNil(it.next()));
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(257, 6, 1, true);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(257, 10, 1, true);
                    Toast.makeText(this, (int) R.string.e8s, 0).show();
                    finish();
                    AppMethodBeat.o(25892);
                    return;
                } else if (intent != null && i6 == 100000002) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(257, 6, 1, true);
                    amQ(str);
                    AppMethodBeat.o(25892);
                    return;
                } else if (intent != null && i6 == 109) {
                    amQ(str);
                    AppMethodBeat.o(25892);
                    return;
                } else if (intent != null && i6 == 1) {
                    String string = getString(R.string.e8q);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(257, 8, 1, true);
                    Toast.makeText(this, string, 0).show();
                    AppMethodBeat.o(25892);
                    return;
                } else if (intent == null || i6 != 113) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(257, 7, 1, true);
                    if (i5 == 3) {
                        amQ(str);
                        AppMethodBeat.o(25892);
                        return;
                    } else if (i6 == 100000001 || i6 == 6) {
                        if (i4 == 0) {
                            Toast.makeText(this, getString(R.string.e6o), 0).show();
                            AppMethodBeat.o(25892);
                            return;
                        }
                        String string2 = getString(R.string.e6q);
                        if (!aCn(string2)) {
                            Toast.makeText(this, string2, 0).show();
                        }
                    }
                } else {
                    com.tencent.mm.ui.base.h.d(this, getString(R.string.e8b), getString(R.string.e8r), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.AnonymousClass10 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(25881);
                            IPCallRechargeUI.j(IPCallRechargeUI.this);
                            AppMethodBeat.o(25881);
                        }
                    });
                    AppMethodBeat.o(25892);
                    return;
                }
            }
            AppMethodBeat.o(25892);
            return;
        }
        if (i2 == 2002) {
            if (this.yuB != null && this.yuB.isShowing()) {
                this.yuB.dismiss();
            }
            String str2 = "";
            int i7 = 0;
            int i8 = 0;
            boolean z2 = false;
            if (intent != null) {
                i7 = intent.getIntExtra("key_err_code", 0);
                str2 = intent.getStringExtra("key_err_msg");
                i8 = intent.getIntExtra("key_response_position", 0);
                if (i7 == 100000001) {
                    z2 = true;
                }
                Log.i("MicroMsg.IPCallRechargeUI", "onActivityResult restore.errCode:[%d] errMsg:[%s] errPosition:[%d] isFailedConsume:[%s]", Integer.valueOf(i7), str2, Integer.valueOf(i8), String.valueOf(z2));
            }
            String str3 = str2;
            this.yxo.ysu = (long) i7;
            this.yxo.yss = 0;
            if (i3 != -1) {
                this.yxo.yst = 2;
                Log.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore failed");
                Toast.makeText(this, (int) R.string.e96, 0).show();
            } else if (intent == null || i7 != 0) {
                if (z2) {
                    this.yxo.yst = 1;
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(257, 17, 1, true);
                    str3 = getString(R.string.e97);
                } else if (i8 == 3) {
                    this.yxo.yst = 2;
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(257, 16, 1, true);
                } else {
                    this.yxo.yst = 2;
                }
                Log.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore not ok");
                Toast.makeText(this, str3, 0).show();
            } else {
                ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("key_response_product_ids");
                if (stringArrayListExtra2 == null || stringArrayListExtra2.size() <= 0) {
                    this.yxo.yst = 3;
                    Log.i("MicroMsg.IPCallRechargeUI", "onActivityResult. no product can be restored");
                    Toast.makeText(this, (int) R.string.e97, 0).show();
                } else {
                    this.yxo.yst = 0;
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(257, 15, 1, true);
                    Log.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore ok");
                    com.tencent.mm.ui.base.h.d(this, getString(R.string.e98), getString(R.string.e99), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.AnonymousClass11 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(25882);
                            IPCallRechargeUI.this.finish();
                            AppMethodBeat.o(25882);
                        }
                    });
                }
            }
            this.yxo.yrT = Util.nowMilliSecond();
            this.yxo.finish();
        }
        AppMethodBeat.o(25892);
    }

    private void amQ(String str) {
        AppMethodBeat.i(25893);
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.e8r);
        }
        com.tencent.mm.ui.base.h.d(this, str, getString(R.string.e8r), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.AnonymousClass12 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(25893);
    }

    private boolean aCn(String str) {
        AppMethodBeat.i(25894);
        if (com.tencent.mm.plugin.ipcall.a.c.ebP() && this.yxj >= 0) {
            Object item = this.yxs.getItem(this.yxj);
            if ((item instanceof ewg) && !Util.isNullOrNil(((ewg) item).Nud)) {
                final String str2 = ((ewg) item).Nud;
                Log.i("MicroMsg.IPCallRechargeUI", "tryHandleShowWebViewPayDialog:".concat(String.valueOf(str2)));
                com.tencent.mm.ui.base.h.a((Context) this, str, getString(R.string.e8r), getString(R.string.e83), getString(R.string.sz), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(25872);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(257, 3, 1, true);
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", str2);
                        intent.putExtra("showShare", false);
                        com.tencent.mm.br.c.b(IPCallRechargeUI.this, "webview", ".ui.tools.WebViewUI", intent);
                        AppMethodBeat.o(25872);
                    }
                }, (DialogInterface.OnClickListener) null);
                AppMethodBeat.o(25894);
                return true;
            }
        }
        AppMethodBeat.o(25894);
        return false;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(25895);
        Log.i("MicroMsg.IPCallRechargeUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", Integer.valueOf(i3), str);
        if (qVar instanceof f) {
            h hVar = this.yxm;
            hVar.ysp = Util.nowMilliSecond();
            hVar.ysq = (long) i3;
            if (i2 == 0 && i3 == 0) {
                bxz bxz = ((f) qVar).yry;
                this.yxs.cvc = bxz.CellList;
                this.yxs.yxy = bxz;
                this.yxs.notifyDataSetChanged();
                this.rih = new String[bxz.CellList.size()];
                Iterator<ewg> it = bxz.CellList.iterator();
                int i4 = 0;
                while (it.hasNext()) {
                    this.rih[i4] = it.next().ProductID;
                    i4++;
                }
                this.yxk = bxz.Mdz;
                this.yxl = bxz.MdA;
                this.yxf = bxz.Mdu;
                this.yxg = bxz.Mdy;
                this.yxi = bxz.Mdx;
                if (this.yxh) {
                    this.yxe = new String[bxz.CellList.size()];
                    for (int i5 = 0; i5 < this.yxe.length; i5++) {
                        this.yxe[i5] = bxz.Mdy;
                    }
                    this.yxd = new String[bxz.CellList.size()];
                    for (int i6 = 0; i6 < this.yxd.length; i6++) {
                        this.yxd[i6] = IPCallDynamicTextView.aCl(bxz.CellList.get(i6).MJz);
                    }
                }
                if (((f) qVar).yrz) {
                    Log.i("MicroMsg.IPCallRechargeUI", "onSceneEnd IsUnkownCurency=true");
                    if (this.rih != null && this.rih.length > 0) {
                        Log.i("MicroMsg.IPCallRechargeUI", "startQueryGooglePrice");
                        k.a(this, this.rih, this.riw);
                    }
                    AppMethodBeat.o(25895);
                    return;
                }
                if (this.yuB != null && this.yuB.isShowing()) {
                    this.yuB.dismiss();
                }
                asq();
                AppMethodBeat.o(25895);
                return;
            }
            if (this.yuB != null && this.yuB.isShowing()) {
                this.yuB.dismiss();
            }
            Toast.makeText(getContext(), getString(R.string.e6o), 0).show();
            finish();
        }
        AppMethodBeat.o(25895);
    }

    public final void asq() {
        AppMethodBeat.i(25896);
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(1002);
        }
        AppMethodBeat.o(25896);
    }

    /* access modifiers changed from: package-private */
    public static class a extends BaseAdapter {
        List<ewg> cvc = null;
        private IPCallRechargeUI yxx = null;
        bxz yxy = null;

        public a(IPCallRechargeUI iPCallRechargeUI) {
            AppMethodBeat.i(25884);
            Assert.assertTrue(true);
            this.yxx = iPCallRechargeUI;
            AppMethodBeat.o(25884);
        }

        public final int getCount() {
            AppMethodBeat.i(25885);
            if (this.cvc == null) {
                AppMethodBeat.o(25885);
                return 0;
            }
            int size = this.cvc.size();
            AppMethodBeat.o(25885);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(25886);
            if (this.cvc != null) {
                ewg ewg = this.cvc.get(i2);
                AppMethodBeat.o(25886);
                return ewg;
            }
            AppMethodBeat.o(25886);
            return null;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1448a aVar;
            AppMethodBeat.i(25887);
            if (view == null) {
                view = ((LayoutInflater) this.yxx.getSystemService("layout_inflater")).inflate(R.layout.ax4, viewGroup, false);
                aVar = new C1448a(this, (byte) 0);
                aVar.ywE = (TextView) view.findViewById(R.id.iwd);
                aVar.yxA = (TextView) view.findViewById(R.id.iwc);
                aVar.yxB = (TextView) view.findViewById(R.id.iwb);
                aVar.yxC = (TextView) view.findViewById(R.id.iwa);
                aVar.yxD = (Button) view.findViewById(R.id.aeb);
                view.setTag(aVar);
            } else {
                aVar = (C1448a) view.getTag();
            }
            ewg ewg = (ewg) getItem(i2);
            if (ewg == null) {
                AppMethodBeat.o(25887);
            } else {
                aVar.ywE.setText(ewg.MJz);
                aVar.yxA.setText(ewg.Nua);
                aVar.yxB.setText(ewg.Nub);
                if (Util.isNullOrNil(ewg.Nub)) {
                    aVar.yxB.setVisibility(8);
                } else {
                    aVar.yxB.setVisibility(0);
                }
                if (this.yxy != null) {
                    aVar.yxC.setText(String.format(this.yxx.getString(R.string.e7c), com.tencent.mm.plugin.ipcall.a.a.aCu(this.yxy.Mdu), String.valueOf(ewg.NtY)));
                }
                aVar.yxD.setTag(Integer.valueOf(i2));
                aVar.yxD.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.a.AnonymousClass1 */

                    public final void onClick(View view) {
                        boolean z;
                        AppMethodBeat.i(25883);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallRechargeUI$RechargeAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        IPCallRechargeUI iPCallRechargeUI = a.this.yxx;
                        if (!ChannelUtil.isGPVersion()) {
                            d.a aVar = new d.a(iPCallRechargeUI);
                            aVar.aoS(R.string.e94);
                            aVar.aoV(R.string.w1).c(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0044: INVOKE  
                                  (wrap: com.tencent.mm.ui.widget.a.d$a : 0x003b: INVOKE  (r0v14 com.tencent.mm.ui.widget.a.d$a) = (r1v6 'aVar' com.tencent.mm.ui.widget.a.d$a), (wrap: int : ?: SGET   com.tencent.mm.R.string.w1 int) type: VIRTUAL call: com.tencent.mm.ui.widget.a.d.a.aoV(int):com.tencent.mm.ui.widget.a.d$a)
                                  (wrap: com.tencent.mm.plugin.ipcall.a.c$1 : 0x0041: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.ipcall.a.c$1) =  call: com.tencent.mm.plugin.ipcall.a.c.1.<init>():void type: CONSTRUCTOR)
                                 type: VIRTUAL call: com.tencent.mm.ui.widget.a.d.a.c(android.content.DialogInterface$OnClickListener):com.tencent.mm.ui.widget.a.d$a in method: com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.a.1.onClick(android.view.View):void, file: classes.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0041: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.ipcall.a.c$1) =  call: com.tencent.mm.plugin.ipcall.a.c.1.<init>():void type: CONSTRUCTOR in method: com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.a.1.onClick(android.view.View):void, file: classes.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	... 19 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.ipcall.a.c, state: GENERATED_AND_UNLOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	... 25 more
                                */
                            /*
                            // Method dump skipped, instructions count: 149
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.a.AnonymousClass1.onClick(android.view.View):void");
                        }
                    });
                    AppMethodBeat.o(25887);
                }
                return view;
            }

            /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI$a$a  reason: collision with other inner class name */
            class C1448a {
                TextView ywE;
                TextView yxA;
                TextView yxB;
                TextView yxC;
                Button yxD;

                private C1448a() {
                }

                /* synthetic */ C1448a(a aVar, byte b2) {
                    this();
                }
            }
        }

        static /* synthetic */ void h(IPCallRechargeUI iPCallRechargeUI) {
            AppMethodBeat.i(25898);
            com.tencent.mm.ui.base.h.b(iPCallRechargeUI.getContext(), null, null, iPCallRechargeUI.getResources().getString(R.string.e95), new h.d() {
                /* class com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.AnonymousClass9 */

                @Override // com.tencent.mm.ui.base.h.d
                public final void oj(int i2) {
                    AppMethodBeat.i(25880);
                    switch (i2) {
                        case 0:
                            Log.i("MicroMsg.IPCallRechargeUI", "start restore");
                            IPCallRechargeUI.this.yxo.start();
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(257, 14, 1, true);
                            Intent intent = new Intent();
                            intent.putExtra("key_action_type", 200002);
                            intent.putExtra("key_force_google", true);
                            com.tencent.mm.br.c.b(IPCallRechargeUI.this, "wallet_index", ".ui.WalletIapUI", intent, 2002);
                            IPCallRechargeUI iPCallRechargeUI = IPCallRechargeUI.this;
                            if (!iPCallRechargeUI.isFinishing()) {
                                AppCompatActivity context = iPCallRechargeUI.getContext();
                                iPCallRechargeUI.getString(R.string.zb);
                                iPCallRechargeUI.yuB = com.tencent.mm.ui.base.h.a((Context) context, iPCallRechargeUI.getString(R.string.e6r), false, (DialogInterface.OnCancelListener) null);
                                break;
                            } else {
                                Log.i("MicroMsg.IPCallRechargeUI", "[showLoadingDialog] acitivity is finished.");
                                AppMethodBeat.o(25880);
                                return;
                            }
                    }
                    AppMethodBeat.o(25880);
                }
            });
            AppMethodBeat.o(25898);
        }

        static /* synthetic */ void j(IPCallRechargeUI iPCallRechargeUI) {
            AppMethodBeat.i(25899);
            if (iPCallRechargeUI.yxs != null) {
                iPCallRechargeUI.yxs.cvc = null;
                iPCallRechargeUI.yxs.notifyDataSetChanged();
            }
            if (iPCallRechargeUI.yxr != null) {
                iPCallRechargeUI.yxr.setVisibility(4);
            }
            if (iPCallRechargeUI.yuB != null) {
                iPCallRechargeUI.yuB.show();
            }
            iPCallRechargeUI.aCm("");
            AppMethodBeat.o(25899);
        }

        static /* synthetic */ void k(IPCallRechargeUI iPCallRechargeUI) {
            AppMethodBeat.i(25900);
            if (!Util.isNullOrNil(iPCallRechargeUI.yxk) && !Util.isNullOrNil(iPCallRechargeUI.yxl)) {
                Log.i("MicroMsg.IPCallRechargeUI", "showGotoExchangeRecordsAlert");
                com.tencent.mm.ui.base.h.a((Context) iPCallRechargeUI, iPCallRechargeUI.yxl, iPCallRechargeUI.yxk, iPCallRechargeUI.getString(R.string.e7_), iPCallRechargeUI.getString(R.string.e7a), false, (DialogInterface.OnClickListener) null, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(25874);
                        IPCallRechargeUI.this.finish();
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", IPCallRechargeUI.this.getString(R.string.e6g));
                        intent.putExtra("showShare", false);
                        com.tencent.mm.br.c.b(IPCallRechargeUI.this, "webview", ".ui.tools.WebViewUI", intent);
                        AppMethodBeat.o(25874);
                    }
                });
            }
            AppMethodBeat.o(25900);
        }

        static /* synthetic */ void b(IPCallRechargeUI iPCallRechargeUI, int i2) {
            boolean z;
            AppMethodBeat.i(25901);
            if (iPCallRechargeUI.rid != -1) {
                switch (iPCallRechargeUI.rid) {
                    case 10233:
                        String string = iPCallRechargeUI.getString(R.string.e8p);
                        if (!iPCallRechargeUI.aCn(string)) {
                            Toast.makeText(iPCallRechargeUI, string, 0).show();
                            break;
                        }
                        break;
                    case 10234:
                        String string2 = iPCallRechargeUI.getString(R.string.e8j);
                        if (!iPCallRechargeUI.aCn(string2)) {
                            com.tencent.mm.ui.base.h.a((Context) iPCallRechargeUI, string2, iPCallRechargeUI.getString(R.string.e8r), true, (DialogInterface.OnClickListener) null);
                            break;
                        }
                        break;
                    case 10235:
                        String string3 = iPCallRechargeUI.getString(R.string.e9q);
                        if (!iPCallRechargeUI.aCn(string3)) {
                            Toast.makeText(iPCallRechargeUI, string3, 0).show();
                            break;
                        }
                        break;
                    default:
                        String string4 = iPCallRechargeUI.getString(R.string.e6q);
                        if (!iPCallRechargeUI.aCn(string4)) {
                            Toast.makeText(iPCallRechargeUI, string4, 0).show();
                            break;
                        }
                        break;
                }
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                iPCallRechargeUI.yxj = i2;
                Log.i("MicroMsg.IPCallRechargeUI", "ProductId:%s, PackPrice:%s,Currency:%s, index:%d", iPCallRechargeUI.rih[i2], iPCallRechargeUI.yxd[i2], iPCallRechargeUI.yxe[i2], Integer.valueOf(i2));
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(257, 5, 1, true);
                iPCallRechargeUI.yxn.start();
                if (iPCallRechargeUI.yxs.getItem(i2) instanceof ewg) {
                    iPCallRechargeUI.yxn.ysi = ((ewg) iPCallRechargeUI.yxs.getItem(i2)).NtZ;
                }
                iPCallRechargeUI.yxn.ysj = iPCallRechargeUI.yxe[i2];
                iPCallRechargeUI.yxn.ysh = (long) i2;
                iPCallRechargeUI.yxn.ysn = iPCallRechargeUI.rih[i2];
                Intent intent = new Intent();
                intent.putExtra("key_product_id", iPCallRechargeUI.rih[i2]);
                intent.putExtra("key_currency_type", iPCallRechargeUI.yxe[i2]);
                intent.putExtra("key_price", iPCallRechargeUI.yxe[i2] + iPCallRechargeUI.yxd[i2]);
                intent.putExtra("key_force_google", true);
                if (iPCallRechargeUI.yxs.getItem(i2) instanceof ewg) {
                    String str = ((ewg) iPCallRechargeUI.yxs.getItem(i2)).Nuc;
                    if (!Util.isNullOrNil(str)) {
                        Log.i("md5:%s", str);
                        ewl ewl = new ewl();
                        ewl.Nuc = str;
                        try {
                            intent.putExtra("key_ext_info", Base64.encodeToString(ewl.toByteArray(), 2));
                        } catch (IOException e2) {
                            Log.e("MicroMsg.IPCallRechargeUI", e2.getMessage());
                        }
                    }
                }
                com.tencent.mm.br.c.b(iPCallRechargeUI, "wallet_index", ".ui.WalletIapUI", intent, 2001);
            }
            AppMethodBeat.o(25901);
        }
    }

package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
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
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.g.a.dz;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.tools.l;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceManageDeviceUI extends MMActivity {
    private ListView mListView;
    private a rIA;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a4s;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(24067);
        super.onCreate(bundle);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24052);
                ExdeviceManageDeviceUI.this.finish();
                AppMethodBeat.o(24052);
                return true;
            }
        });
        setMMTitle(R.string.c0n);
        dz dzVar = new dz();
        dzVar.dHd.dHe = true;
        EventCenter.instance.publish(dzVar);
        initView();
        bg.azz().a(537, this.rIA);
        AppMethodBeat.o(24067);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(24068);
        this.mListView = (ListView) findViewById(R.id.ed2);
        this.rIA = new a(this);
        View.inflate(this, R.layout.a4e, null);
        this.mListView.setAdapter((ListAdapter) this.rIA);
        AppMethodBeat.o(24068);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(24069);
        this.rIA.ad(ad.cKL().cLB());
        this.rIA.notifyDataSetChanged();
        AppMethodBeat.o(24069);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(24070);
        super.onDestroy();
        bg.azz().b(537, this.rIA);
        AppMethodBeat.o(24070);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(24071);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0 && this.rIA.rIC) {
            updateOptionMenuText(0, getString(R.string.tt));
            a aVar = this.rIA;
            if (aVar.rIC) {
                aVar.rIC = false;
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI.a.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(24056);
                        a.this.notifyDataSetChanged();
                        AppMethodBeat.o(24056);
                    }
                });
            }
            AppMethodBeat.o(24071);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(24071);
        return onKeyDown;
    }

    /* access modifiers changed from: package-private */
    public static final class a extends BaseAdapter implements i {
        private o.g pqy;
        private WeakReference<Context> pzq;
        private List<b> rFg;
        private c rFu;
        boolean rIC;
        private View.OnClickListener rID;
        private l rIE;
        private volatile int rIF = -1;
        private q tipDialog = null;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(24064);
            b GH = GH(i2);
            AppMethodBeat.o(24064);
            return GH;
        }

        public a(Context context) {
            AppMethodBeat.i(24058);
            this.pzq = new WeakReference<>(context);
            this.rFg = new LinkedList();
            this.rIE = new l(context);
            c.a aVar = new c.a();
            aVar.jbq = R.drawable.bd0;
            this.rFu = aVar.bdv();
            this.pqy = new o.g() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI.a.AnonymousClass1 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(24053);
                    int itemId = menuItem.getItemId();
                    int count = a.this.getCount();
                    Log.d("MicroMsg.ExdeviceManageDeviceUI", "onMenuItemSelected, itemId(%d), count(%d).", Integer.valueOf(itemId), Integer.valueOf(count));
                    if (itemId < 0 || itemId >= count) {
                        AppMethodBeat.o(24053);
                        return;
                    }
                    a.this.rIF = itemId;
                    a.a(a.this, (b) a.this.rFg.get(itemId));
                    a.this.notifyDataSetChanged();
                    AppMethodBeat.o(24053);
                }
            };
            this.rID = new View.OnClickListener() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI.a.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(24054);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceManageDeviceUI$DeviceAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (a.this.rIC) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceManageDeviceUI$DeviceAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(24054);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof Integer)) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceManageDeviceUI$DeviceAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(24054);
                        return;
                    }
                    int intValue = ((Integer) tag).intValue();
                    if (intValue < 0 || intValue >= a.this.getCount()) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceManageDeviceUI$DeviceAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(24054);
                        return;
                    }
                    b GH = a.this.GH(intValue);
                    Context context = (Context) a.this.pzq.get();
                    if (context == null) {
                        Log.e("MicroMsg.ExdeviceManageDeviceUI", "Start activity failed, context is null.");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceManageDeviceUI$DeviceAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(24054);
                        return;
                    }
                    a.a(context, GH);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceManageDeviceUI$DeviceAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(24054);
                }
            };
            ad(ad.cKL().cLB());
            AppMethodBeat.o(24058);
        }

        public final void ad(List<b> list) {
            AppMethodBeat.i(24059);
            this.rFg.clear();
            if (list == null || list.size() == 0) {
                AppMethodBeat.o(24059);
                return;
            }
            this.rFg.addAll(list);
            AppMethodBeat.o(24059);
        }

        public final int getCount() {
            AppMethodBeat.i(24060);
            int size = this.rFg.size();
            AppMethodBeat.o(24060);
            return size;
        }

        public final b GH(int i2) {
            AppMethodBeat.i(24061);
            b bVar = this.rFg.get(i2);
            AppMethodBeat.o(24061);
            return bVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1002a aVar;
            String str;
            String nullAsNil;
            AppMethodBeat.i(24062);
            b GH = GH(i2);
            if (view == null) {
                aVar = new C1002a((byte) 0);
                view = View.inflate(viewGroup.getContext(), R.layout.a4r, null);
                aVar.rII = view.findViewById(R.id.be3);
                aVar.kgE = (TextView) view.findViewById(R.id.ft9);
                aVar.rIJ = view.findViewById(R.id.bm_);
                aVar.nnL = (ImageView) view.findViewById(R.id.dtb);
                view.setTag(aVar);
            } else {
                aVar = (C1002a) view.getTag();
            }
            if (GH == null) {
                nullAsNil = "";
            } else {
                if (!Util.isNullOrNil(GH.fMb)) {
                    str = GH.fMb;
                } else if (!Util.isNullOrNil(GH.fMc)) {
                    str = GH.fMc;
                } else if (GH.field_mac != 0) {
                    str = com.tencent.mm.plugin.exdevice.k.b.Dj(GH.field_mac);
                } else if (!Util.isNullOrNil(GH.field_deviceID)) {
                    str = GH.field_deviceID;
                } else {
                    str = null;
                }
                nullAsNil = Util.nullAsNil(str);
            }
            Log.d("MicroMsg.ExdeviceManageDeviceUI", "position(%s), name(%s), mac(%s).", Integer.valueOf(i2), nullAsNil, Long.valueOf(GH.field_mac));
            aVar.kgE.setText(nullAsNil);
            com.tencent.mm.av.q.bcV().a(GH.iconUrl, aVar.nnL, this.rFu);
            aVar.rIJ.setTag(Integer.valueOf(i2));
            if (this.rIC) {
                aVar.rIJ.setVisibility(0);
            } else {
                aVar.rIJ.setVisibility(8);
            }
            aVar.rII.setTag(Integer.valueOf(i2));
            aVar.rII.setOnClickListener(this.rID);
            AppMethodBeat.o(24062);
            return view;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(24063);
            if (qVar == null) {
                Log.e("MicroMsg.ExdeviceManageDeviceUI", "scene is null.");
                AppMethodBeat.o(24063);
                return;
            }
            if (qVar instanceof x) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.dismiss();
                }
                if (i2 == 0 && i3 == 0) {
                    if (this.rIF < 0 || this.rIF >= this.rFg.size()) {
                        AppMethodBeat.o(24063);
                        return;
                    }
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI.a.AnonymousClass6 */

                        public final void run() {
                            AppMethodBeat.i(24057);
                            a.this.rFg.remove(a.this.rIF);
                            a.this.notifyDataSetChanged();
                            a.this.rIF = -1;
                            AppMethodBeat.o(24057);
                        }
                    });
                }
            }
            AppMethodBeat.o(24063);
        }

        /* renamed from: com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI$a$a  reason: collision with other inner class name */
        static class C1002a {
            TextView kgE;
            ImageView nnL;
            View rII;
            View rIJ;

            private C1002a() {
            }

            /* synthetic */ C1002a(byte b2) {
                this();
            }
        }

        static /* synthetic */ void a(a aVar, final b bVar) {
            AppMethodBeat.i(24065);
            if (bVar == null || aVar.pzq == null) {
                AppMethodBeat.o(24065);
                return;
            }
            Context context = aVar.pzq.get();
            if (context == null) {
                Log.e("MicroMsg.ExdeviceManageDeviceUI", "context is null.");
                AppMethodBeat.o(24065);
                return;
            }
            context.getString(R.string.zb);
            aVar.tipDialog = h.a(context, context.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI.a.AnonymousClass3 */

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            bg.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceManageDeviceUI.a.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(24055);
                    cat cat = new cat();
                    cat.oTH = bVar.field_deviceID;
                    cat.KLO = bVar.field_deviceType;
                    bg.azz().a(new x(cat, 2), 0);
                    AppMethodBeat.o(24055);
                }
            });
            AppMethodBeat.o(24065);
        }

        static /* synthetic */ void a(Context context, b bVar) {
            AppMethodBeat.i(24066);
            Intent intent = new Intent();
            intent.putExtra("device_type", bVar.field_deviceType);
            intent.putExtra(TPDownloadProxyEnum.USER_DEVICE_ID, bVar.field_deviceID);
            intent.putExtra("device_mac", bVar.field_mac);
            intent.putExtra("device_brand_name", bVar.field_brandName);
            intent.putExtra("device_desc", bVar.fMd);
            intent.putExtra("device_title", bVar.fMc);
            intent.putExtra("device_icon_url", bVar.iconUrl);
            intent.putExtra("device_alias", bVar.fMb);
            intent.putExtra("device_jump_url", bVar.jumpUrl);
            intent.putExtra("subscribe_flag", 1);
            com.tencent.mm.br.c.b(context, "exdevice", ".ui.ExdeviceDeviceProfileUI", intent, 1000);
            AppMethodBeat.o(24066);
        }
    }
}

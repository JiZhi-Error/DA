package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.g;
import java.util.HashMap;

@i
public class SettingsAboutMicroMsgFlavorBlue extends MMPreference {
    private String[] Dan = {"7.0.21", "7.0.20", "7.0.19", "7.0.18"};
    private String[] Dao = {"小程序\n   1.connectWifi Android 10适配\n   2.视频相关bug修改\n   3.音视频编辑组件网络流添加断点续传功能，能对网络资源进行缓存;网络流添加seek支持;硬编码改成兼容性更好的VBR（动态码率）模式，编解码速度更快\n   4.websocket细分返回的错误信息\n小游戏\n   1.connectWifi Android 10适配\n   2.视频相关bug修改\n   3.音视频编辑组件网络流添加断点续传功能，能对网络资源进行缓存;网络流添加seek支持;硬编码改成兼容性更好的VBR（动态码率）模式，编解码速度更快\n   4.websocket细分返回的错误信息\n   5.小游戏性能优化方案渲染层更新\n", "小程序\n   1.优化小程序进程分配策略\n   2.优化小程序js注入耗时\n   3.修复全屏相关bug\n小游戏\n   1.启动阶段功能模块懒加载，进程加载优化，优化启动速度\n   2.性能面板增加js注入耗时、首屏渲染耗时\n   3.优化从朋友圈分享的卡片点开跳转速度\n", "小程序\n   1.优化识别二维码打开小程序的速度\n   2.worker 支持 CPU Profile\n   3.修复蓝牙线程安全问题\n   4.WebSocket切后台时支持主动断开连接\n   5.音频延迟以及CPU占用优化\n小游戏\n   1.worker 支持 CPU Profile\n   2.修复蓝牙线程安全问题\n   3.WebSocket切后台时支持主动断开连接\n   4.音频延迟以及CPU占用优化\n", "小程序\n   1.小程序正式版,拥有体验版权限的开发者能打开菜单中的开发调试\n   2.小程序webiew与service通信优化\n   3.小程序界面层级优化\n   4.小程序界面显示重构\n小游戏\n   1.小游戏正式版,拥有体验版权限的开发者能打开菜单中的开发调试\n   2.修复相同图片重复解码时内存泄漏问题\n"};
    HashMap<String, String> Dap = new HashMap<>();
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsAboutMicroMsgFlavorBlue() {
        AppMethodBeat.i(256499);
        AppMethodBeat.o(256499);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.ce;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(256500);
        super.onCreate(bundle);
        hideActionbarLine();
        for (int i2 = 0; i2 < this.Dan.length; i2++) {
            this.Dap.put(this.Dan[i2], this.Dao[i2]);
        }
        initView();
        AppMethodBeat.o(256500);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(256501);
        super.onResume();
        eSS();
        AppMethodBeat.o(256501);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(256502);
        super.onDestroy();
        AppMethodBeat.o(256502);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(256503);
        setMMTitle(getResources().getString(R.string.dl6));
        setActionbarColor(getContext().getResources().getColor(R.color.f3045c));
        setBackGroundColorResource(R.color.afz);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgFlavorBlue.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(256497);
                SettingsAboutMicroMsgFlavorBlue.this.hideVKB();
                SettingsAboutMicroMsgFlavorBlue.this.finish();
                AppMethodBeat.o(256497);
                return true;
            }
        });
        if (getListView() != null) {
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ce);
            getListView().setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            getListView().setBackgroundColor(getContext().getResources().getColor(R.color.f3045c));
        }
        eSS();
        AppMethodBeat.o(256503);
    }

    private void eSS() {
        AppMethodBeat.i(256504);
        this.screen = getPreferenceScreen();
        this.screen.removeAll();
        for (int i2 = 0; i2 < this.Dan.length; i2++) {
            IconPreference iconPreference = new IconPreference(this);
            this.screen.c(iconPreference);
            iconPreference.setKey(this.Dan[i2]);
            iconPreference.setTitle(this.Dan[i2]);
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(256504);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(256505);
        String str = preference.mKey;
        Log.i("MicroMsg.SettingsAboutMicroMsgFlavorBlue", str + " item has been clicked!");
        final g gVar = new g(getContext(), 2, 2);
        gVar.T(getResources().getString(R.string.w0));
        gVar.ape(0);
        gVar.QOT = new g.a() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgFlavorBlue.AnonymousClass2 */

            @Override // com.tencent.mm.ui.widget.a.g.a
            public final void onClick() {
                AppMethodBeat.i(256498);
                gVar.bMo();
                AppMethodBeat.o(256498);
            }
        };
        gVar.aE(str);
        TextView textView = new TextView(this);
        textView.setText(this.Dap.get(str));
        gVar.setCustomView(textView);
        gVar.dGm();
        AppMethodBeat.o(256505);
        return true;
    }
}

package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import com.tencent.luggage.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.api.bucket.ApplicationLifeCycleBucket;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.plugin.game.luggage.a.b;
import com.tencent.mm.plugin.game.luggage.c.b;
import com.tencent.mm.plugin.game.luggage.i.a;
import com.tencent.mm.plugin.multitask.PluginMultiTask;
import com.tencent.mm.plugin.webview.luggage.webview_impl.LuggageWebMultiTaskUIC;
import com.tencent.mm.plugin.webview.ui.tools.game.BatteryManager;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.ao;
import org.json.JSONException;
import org.json.JSONObject;

public class PluginLuggageGame extends f implements ApplicationLifeCycleBucket, c, b {
    private p netChanged = new p.a() {
        /* class com.tencent.mm.plugin.game.luggage.PluginLuggageGame.AnonymousClass1 */
        private final byte[] glH = new byte[0];

        {
            AppMethodBeat.i(186841);
            AppMethodBeat.o(186841);
        }

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            AppMethodBeat.i(186842);
            synchronized (this.glH) {
                try {
                    if (a.dTW() != null) {
                        a dTW = a.dTW();
                        String formatedNetType = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
                        dTW.xzn.b(new d(formatedNetType) {
                            /* class com.tencent.mm.plugin.game.luggage.i.a.AnonymousClass7 */
                            final /* synthetic */ String xzu;

                            {
                                this.xzu = r2;
                            }

                            @Override // com.tencent.luggage.d.d
                            public final String name() {
                                return "onNetWorkChange";
                            }

                            @Override // com.tencent.luggage.d.d
                            public final JSONObject Ld() {
                                AppMethodBeat.i(186992);
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("networkType", this.xzu);
                                } catch (JSONException e2) {
                                }
                                AppMethodBeat.o(186992);
                                return jSONObject;
                            }
                        });
                        dTW.xzo.evaluateJavascript(String.format("if (SystemInfo == 'undefined' || SystemInfo.networkType == 'undefined) {return;} SystemInfo.networkType=\"%s\"; console.log(SystemInfo.networkType);", formatedNetType), null);
                    }
                } finally {
                    AppMethodBeat.o(186842);
                }
            }
        }
    };

    public PluginLuggageGame() {
        AppMethodBeat.i(186843);
        AppMethodBeat.o(186843);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(83013);
        if (gVar.aBb() || gVar.FY(":tools") || gVar.FY(":toolsmp") || gVar.FY(":lite")) {
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.game.luggage.a.a.class, new e(new d()));
        }
        AppMethodBeat.o(83013);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onCreate() {
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onLowMemory() {
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onTrimMemory(int i2) {
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onTerminate() {
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onConfigurationChanged(Configuration configuration) {
        a dTW;
        AppMethodBeat.i(186844);
        if (ao.awS() && ao.awN() && (dTW = a.dTW()) != null) {
            dTW.xzo.evaluateJavascript(String.format("if (SystemInfo == 'undefined' || SystemInfo.isDarkMode == 'undefined) {return;} SystemInfo.isDarkMode=%b; console.log(SystemInfo.isDarkMode);", Boolean.valueOf(ao.isDarkMode())), null);
        }
        AppMethodBeat.o(186844);
    }

    @Override // com.tencent.tinker.entry.ApplicationLifeCycle
    public void onBaseContextAttached(Context context) {
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(83014);
        if (BatteryManager.JpJ == null) {
            BatteryManager.JpJ = new BatteryManager.BatteryChangedReceiver((byte) 0);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        MMApplicationContext.getContext().registerReceiver(BatteryManager.JpJ, intentFilter);
        com.tencent.mm.kernel.g.aAg().a(this.netChanged);
        ((PluginMultiTask) com.tencent.mm.kernel.g.ah(PluginMultiTask.class)).registerMultiTaskUIC(5, LuggageWebMultiTaskUIC.class);
        if (com.tencent.mm.plugin.game.luggage.c.a.xxj == null) {
            com.tencent.mm.plugin.game.luggage.c.a.xxj = new a.b() {
                /* class com.tencent.mm.plugin.game.luggage.c.a.AnonymousClass1 */

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // com.tencent.mm.plugin.downloader.b.a.b
                public final void O(int i2, long j2) {
                    AppMethodBeat.i(186889);
                    switch (i2) {
                        case 1:
                            com.tencent.mm.plugin.downloader.g.a Cw = com.tencent.mm.plugin.downloader.model.d.Cw(j2);
                            if (Cw != null) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("appid", Cw.field_appId);
                                    jSONObject.put("download_id", Cw.field_downloadId);
                                    jSONObject.put("state", "download_start");
                                    Bundle bundle = new Bundle();
                                    bundle.putString("name", "wxdownload:state_change");
                                    bundle.putString("data", jSONObject.toString());
                                    ToolsProcessIPCService.a(bundle, com.tencent.mm.plugin.webview.luggage.a.a.class, null);
                                    b.a aVar = b.xxl;
                                    b.a.am(bundle);
                                    AppMethodBeat.o(186889);
                                    return;
                                } catch (JSONException e2) {
                                }
                            }
                            AppMethodBeat.o(186889);
                            return;
                        case 2:
                            com.tencent.mm.plugin.downloader.g.a Cw2 = com.tencent.mm.plugin.downloader.model.d.Cw(j2);
                            if (Cw2 != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("appid", Cw2.field_appId);
                                    jSONObject2.put("download_id", Cw2.field_downloadId);
                                    if (!Cw2.field_fromDownloadApp || !Cw2.field_downloadInWifi || NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                                        jSONObject2.put("state", "download_pause");
                                    } else {
                                        jSONObject2.put("state", "download_wait_for_wifi");
                                    }
                                    Bundle bundle2 = new Bundle();
                                    bundle2.putString("name", "wxdownload:state_change");
                                    bundle2.putString("data", jSONObject2.toString());
                                    ToolsProcessIPCService.a(bundle2, com.tencent.mm.plugin.webview.luggage.a.a.class, null);
                                    b.a aVar2 = b.xxl;
                                    b.a.am(bundle2);
                                    AppMethodBeat.o(186889);
                                    return;
                                } catch (JSONException e3) {
                                }
                            }
                            AppMethodBeat.o(186889);
                            return;
                        case 3:
                            com.tencent.mm.plugin.downloader.g.a Cw3 = com.tencent.mm.plugin.downloader.model.d.Cw(j2);
                            if (Cw3 != null) {
                                JSONObject jSONObject3 = new JSONObject();
                                try {
                                    jSONObject3.put("appid", Cw3.field_appId);
                                    jSONObject3.put("download_id", Cw3.field_downloadId);
                                    jSONObject3.put("state", "download_succ");
                                    Bundle bundle3 = new Bundle();
                                    bundle3.putString("name", "wxdownload:state_change");
                                    bundle3.putString("data", jSONObject3.toString());
                                    ToolsProcessIPCService.a(bundle3, com.tencent.mm.plugin.webview.luggage.a.a.class, null);
                                    b.a aVar3 = b.xxl;
                                    b.a.am(bundle3);
                                    AppMethodBeat.o(186889);
                                    return;
                                } catch (JSONException e4) {
                                }
                            }
                            AppMethodBeat.o(186889);
                            return;
                        case 4:
                            com.tencent.mm.plugin.downloader.g.a Cw4 = com.tencent.mm.plugin.downloader.model.d.Cw(j2);
                            if (Cw4 != null) {
                                JSONObject jSONObject4 = new JSONObject();
                                try {
                                    jSONObject4.put("appid", Cw4.field_appId);
                                    jSONObject4.put("download_id", Cw4.field_downloadId);
                                    jSONObject4.put("state", "download_removed");
                                    Bundle bundle4 = new Bundle();
                                    bundle4.putString("name", "wxdownload:state_change");
                                    bundle4.putString("data", jSONObject4.toString());
                                    ToolsProcessIPCService.a(bundle4, com.tencent.mm.plugin.webview.luggage.a.a.class, null);
                                    b.a aVar4 = b.xxl;
                                    b.a.am(bundle4);
                                    AppMethodBeat.o(186889);
                                    return;
                                } catch (JSONException e5) {
                                }
                            }
                            AppMethodBeat.o(186889);
                            return;
                        case 5:
                            com.tencent.mm.plugin.downloader.g.a Cw5 = com.tencent.mm.plugin.downloader.model.d.Cw(j2);
                            if (Cw5 != null) {
                                JSONObject jSONObject5 = new JSONObject();
                                try {
                                    jSONObject5.put("appid", Cw5.field_appId);
                                    jSONObject5.put("download_id", Cw5.field_downloadId);
                                    jSONObject5.put("state", "download_fail");
                                    Bundle bundle5 = new Bundle();
                                    bundle5.putString("name", "wxdownload:state_change");
                                    bundle5.putString("data", jSONObject5.toString());
                                    ToolsProcessIPCService.a(bundle5, com.tencent.mm.plugin.webview.luggage.a.a.class, null);
                                    b.a aVar5 = b.xxl;
                                    b.a.am(bundle5);
                                    AppMethodBeat.o(186889);
                                    return;
                                } catch (JSONException e6) {
                                }
                            }
                            AppMethodBeat.o(186889);
                            return;
                        case 6:
                            com.tencent.mm.plugin.downloader.g.a Cw6 = com.tencent.mm.plugin.downloader.model.d.Cw(j2);
                            if (Cw6 != null && Cw6.field_totalSize != 0) {
                                int i3 = (int) ((((double) Cw6.field_downloadedSize) / ((double) Cw6.field_totalSize)) * 100.0d);
                                float f2 = (((float) Cw6.field_downloadedSize) / ((float) Cw6.field_totalSize)) * 100.0f;
                                Log.d("MicroMsg.JsDownloadEventDispatch", "onDownloadTaskProgressChanged, progressFloat: %f", Float.valueOf(f2));
                                JSONObject jSONObject6 = new JSONObject();
                                try {
                                    jSONObject6.put("appid", Cw6.field_appId);
                                    jSONObject6.put("download_id", Cw6.field_downloadId);
                                    jSONObject6.put("progress", i3);
                                    jSONObject6.put("progress_float", (double) f2);
                                    Bundle bundle6 = new Bundle();
                                    bundle6.putString("name", "wxdownload:progress_change");
                                    bundle6.putString("data", jSONObject6.toString());
                                    ToolsProcessIPCService.a(bundle6, com.tencent.mm.plugin.webview.luggage.a.a.class, null);
                                    b.a aVar6 = b.xxl;
                                    b.a.am(bundle6);
                                    AppMethodBeat.o(186889);
                                    return;
                                } catch (JSONException e7) {
                                    break;
                                }
                            } else {
                                Log.w("MicroMsg.JsDownloadEventDispatch", "loadDownloadProgress failed");
                                AppMethodBeat.o(186889);
                                return;
                            }
                        case 7:
                            com.tencent.mm.plugin.downloader.g.a Cw7 = com.tencent.mm.plugin.downloader.model.d.Cw(j2);
                            if (Cw7 != null) {
                                JSONObject jSONObject7 = new JSONObject();
                                try {
                                    jSONObject7.put("appid", Cw7.field_appId);
                                    jSONObject7.put("download_id", Cw7.field_downloadId);
                                    jSONObject7.put("state", "download_resumed");
                                    Bundle bundle7 = new Bundle();
                                    bundle7.putString("name", "wxdownload:state_change");
                                    bundle7.putString("data", jSONObject7.toString());
                                    ToolsProcessIPCService.a(bundle7, com.tencent.mm.plugin.webview.luggage.a.a.class, null);
                                    b.a aVar7 = b.xxl;
                                    b.a.am(bundle7);
                                    AppMethodBeat.o(186889);
                                    return;
                                } catch (JSONException e8) {
                                }
                            }
                            AppMethodBeat.o(186889);
                            return;
                    }
                    AppMethodBeat.o(186889);
                }
            };
        }
        com.tencent.mm.plugin.downloader.b.a.a(com.tencent.mm.plugin.game.luggage.c.a.xxj);
        AppMethodBeat.o(83014);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(83015);
        if (BatteryManager.JpJ != null) {
            MMApplicationContext.getContext().unregisterReceiver(BatteryManager.JpJ);
        }
        BatteryManager.JpJ = null;
        com.tencent.mm.kernel.g.aAg().b(this.netChanged);
        com.tencent.mm.plugin.downloader.b.a.b(com.tencent.mm.plugin.game.luggage.c.a.xxj);
        com.tencent.mm.plugin.game.luggage.c.a.xxj = null;
        AppMethodBeat.o(83015);
    }
}

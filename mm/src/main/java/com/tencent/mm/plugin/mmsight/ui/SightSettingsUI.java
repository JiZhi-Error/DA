package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class SightSettingsUI extends MMActivity {
    private d gVN = new d(this);
    private LinkedList<b> hUG = new LinkedList<>();
    private ListView hUI;
    private a zDP;
    private CaptureMMProxy zta;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SightSettingsUI() {
        AppMethodBeat.i(94737);
        AppMethodBeat.o(94737);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bt2;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(94738);
        super.onCreate(bundle);
        this.zta = new CaptureMMProxy(this.gVN);
        this.gVN.connect(new Runnable() {
            /* class com.tencent.mm.plugin.mmsight.ui.SightSettingsUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(94730);
                Log.i("MicroMsg.SightSettingsUI", "has connect");
                SightSettingsUI.a(SightSettingsUI.this);
                AppMethodBeat.o(94730);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.mmsight.ui.SightSettingsUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(94731);
                SightSettingsUI.this.finish();
                AppMethodBeat.o(94731);
                return false;
            }
        });
        AppMethodBeat.o(94738);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(94739);
        super.onDestroy();
        this.gVN.release();
        AppMethodBeat.o(94739);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(94740);
        super.onResume();
        AppMethodBeat.o(94740);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(94741);
        super.onPause();
        AppMethodBeat.o(94741);
    }

    /* access modifiers changed from: package-private */
    public class b {
        public String hUN;
        ar.a hUO;
        String[] hUP;
        int[] zDT;

        public b(String str, ar.a aVar, String[] strArr, int[] iArr) {
            this.hUN = str;
            this.hUP = strArr;
            this.hUO = aVar;
            this.zDT = iArr;
        }

        /* access modifiers changed from: package-private */
        public final String QW(int i2) {
            for (int i3 = 0; i3 < this.zDT.length; i3++) {
                if (i2 == this.zDT[i3] && i3 < this.hUP.length) {
                    return this.hUP[i3];
                }
            }
            return this.hUP[0];
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        a() {
        }

        public final int getCount() {
            AppMethodBeat.i(94733);
            int size = SightSettingsUI.this.hUG.size();
            AppMethodBeat.o(94733);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(94734);
            Object obj = SightSettingsUI.this.hUG.get(i2);
            AppMethodBeat.o(94734);
            return obj;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(94735);
            TextView textView = new TextView(SightSettingsUI.this);
            final b bVar = (b) getItem(i2);
            textView.setText(bVar.hUN + "->:" + bVar.QW(((Integer) SightSettingsUI.this.zta.get(bVar.hUO, 0)).intValue()));
            textView.setGravity(17);
            textView.setTextSize(1, 20.0f);
            textView.setHeight(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 50));
            if (i2 % 2 == 1) {
                textView.setBackgroundColor(Color.parseColor("#e2efda"));
            }
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.mmsight.ui.SightSettingsUI.a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(94732);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/ui/SightSettingsUI$ChoiceAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    b bVar2 = bVar;
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    for (int i2 = 0; i2 < bVar2.hUP.length; i2++) {
                        linkedList.add(bVar2.hUP[i2]);
                        linkedList2.add(Integer.valueOf(i2));
                    }
                    h.a(SightSettingsUI.this, "", linkedList, linkedList2, "", new h.e() {
                        /* class com.tencent.mm.plugin.mmsight.ui.SightSettingsUI.b.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.base.h.e
                        public final void cy(int i2, int i3) {
                            AppMethodBeat.i(94736);
                            try {
                                SightSettingsUI.this.zta.set(b.this.hUO, Integer.valueOf(b.this.zDT[i2]));
                                SightSettingsUI.this.zDP.notifyDataSetChanged();
                                AppMethodBeat.o(94736);
                            } catch (Exception e2) {
                                Log.printErrStackTrace("MicroMsg.SightSettingsUI", e2, "", new Object[0]);
                                AppMethodBeat.o(94736);
                            }
                        }
                    });
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mmsight/ui/SightSettingsUI$ChoiceAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(94732);
                }
            });
            AppMethodBeat.o(94735);
            return textView;
        }
    }

    static /* synthetic */ void a(SightSettingsUI sightSettingsUI) {
        AppMethodBeat.i(94742);
        sightSettingsUI.hUG.add(new b("打开测试信息", ar.a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, new String[]{"Y", "N"}, new int[]{1, 0}));
        sightSettingsUI.hUG.add(new b("拍照方式", ar.a.USERINFO_LOCAL_SIGHT_CAPTURE_TYPE_INT_SYNC, new String[]{"Image流", "预览帧"}, new int[]{1, 2}));
        sightSettingsUI.hUG.add(new b("CameraApi", ar.a.USERINFO_LOCAL_SIGHT_CAMERA_API_INT_SYNC, new String[]{"Camera2", "Camera1"}, new int[]{2, 1}));
        sightSettingsUI.hUG.add(new b("对焦方案", ar.a.USERINFO_LOCAL_SIGHT_FOCUS_INT_SYNC, new String[]{"System", "啊..."}, new int[]{1, 0}));
        sightSettingsUI.hUG.add(new b("裁剪方案", ar.a.USERINFO_LOCAL_SIGHT_FFMMPEGCUT_INT_SYNC, new String[]{BuildConfig.KINDA_DEFAULT, "mediacodecv21", "mediacodecv", "ffmpeg"}, new int[]{-1, 1, 2, 3}));
        sightSettingsUI.hUG.add(new b("是否把双通音频压成单通道", ar.a.USERINFO_LOCAL_SIGHT_COMPRESS_TO_SINGLE_CHANNEL_INT_SYNC, new String[]{"-1", "yes", "no"}, new int[]{-1, 1, 0}));
        sightSettingsUI.hUG.add(new b("Thread", ar.a.USERINFO_LOCAL_SIGHT_THREADCOUNT_INT_SYNC, new String[]{"-1", "1", "2", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "4", "5", "6"}, new int[]{-1, 1, 2, 3, 4, 5, 6}));
        sightSettingsUI.hUG.add(new b("裁剪预览MediaPlayer", ar.a.USERINFO_LOCAL_SIGHT_CLIP_PREVIEW_MEDIA_PLAYER_INT_SYNC, new String[]{BuildConfig.KINDA_DEFAULT, "系统方案", "MediaCodec解码播放方案"}, new int[]{-1, 1, 2}));
        sightSettingsUI.hUG.add(new b("音频录制方案", ar.a.USERINFO_LOCAL_SIGHT_AUDIO_RECORDER_TYPE_INT_SYNC, new String[]{"-1", "MediaCodec", "MediaRecorder"}, new int[]{-1, 1, 2}));
        sightSettingsUI.hUG.add(new b("预览裁剪方式", ar.a.USERINFO_LOCAL_SIGHT_PREVIEW_CROP_INT_SYNC, new String[]{"跟随配置", "预览GPU裁剪", "预览CPU裁剪"}, new int[]{-1, 1, 2}));
        sightSettingsUI.hUG.add(new b("预设配置", ar.a.USERINFO_LOCAL_SIGHT_SETTING_PRESET_INT_SYNC, new String[]{"跟后台配置", "MediaCodec+540p录制", "MediaCodec+720p双倍码率录制+后期压缩", "FFMpeg+540p录制", "FFMpeg+720p双倍码率录制+后期压缩", "MediaCodec+720p原码率录制", "FFMpeg+720p原码率录制", "MediaCodec+1080p+实时压缩", "MediaCodec+1080p+实时压缩/旋转", "FFMpeg+1080p+实时压缩", "FFMpeg+1080p+实时压缩/旋转", "MediaCodec+1080p双倍码率+后压+实时压缩"}, new int[]{-1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}));
        sightSettingsUI.hUG.add(new b("重编码抛异常到兜底逻辑", ar.a.USERINFO_LOCAL_SIGHT_REMUX_THROW_ERROR_INT_SYNC, new String[]{"不抛异常", "抛异常"}, new int[]{-1, 1}));
        sightSettingsUI.hUG.add(new b("录制创建编码器抛异常", ar.a.USERINFO_LOCAL_SIGHT_RECORD_THROW_ERROR_INT_SYNC, new String[]{"不抛异常", "抛异常"}, new int[]{-1, 1}));
        sightSettingsUI.hUG.add(new b("转码使用ffmpeg合成器", ar.a.USERINFO_LOCAL_SIGHT_RECORD_USE_FFMPEG_INT_SYNC, new String[]{"使用默认配置", "使用MP4V2", "使用FFMPEG"}, new int[]{-1, 1, 2}));
        sightSettingsUI.hUG.add(new b("拍摄使用ffmpeg合成器", ar.a.USERINFO_LOCAL_SIGHT_CAPTURE_USE_FFMPEG_INT_SYNC, new String[]{"使用默认配置", "使用MP4V2", "使用FFMPEG"}, new int[]{-1, 1, 2}));
        sightSettingsUI.hUG.add(new b("ffmpeg合成器写入Codec PTS", ar.a.USERINFO_LOCAL_SIGHT_RECORD_USE_FFMPEG_CODEC_PTS_INT_SYNC, new String[]{"使用默认配置", "写入Codec pts", "不写入Codec pts，自己计算"}, new int[]{-1, 1, 2}));
        sightSettingsUI.hUI = (ListView) sightSettingsUI.findViewById(R.id.ed2);
        sightSettingsUI.zDP = new a();
        sightSettingsUI.hUI.setAdapter((ListAdapter) sightSettingsUI.zDP);
        AppMethodBeat.o(94742);
    }
}

package com.tencent.mm.plugin.audio;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.plugin.audio.broadcast.base.BaseAudioReceiver;
import com.tencent.mm.plugin.audio.broadcast.bluetooth.BluetoothReceiver;
import com.tencent.mm.plugin.audio.broadcast.headset.HeadsetPlugReceiver;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\t\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0002¢\u0006\u0002\u0010\fJ1\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0002¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\bH\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/audio/AudioBroadcastHelper;", "Lcom/tencent/mm/booter/CoreService$BroadcastRegisterHelper;", "()V", "broadcastReceiverHashMap", "Ljava/util/HashMap;", "", "Landroid/content/BroadcastReceiver;", "registerBroadcast", "", "receiver", "actions", "", "(Landroid/content/BroadcastReceiver;[Ljava/lang/String;)V", "categories", "(Landroid/content/BroadcastReceiver;[Ljava/lang/String;[Ljava/lang/String;)V", NativeProtocol.WEB_DIALOG_ACTION, "registerBroadcasts", "unRegisterBroadcast", "unRegisterBroadcasts", "Companion", "plugin-audio_release"})
public final class a implements CoreService.a {
    public static final C0829a oHA = new C0829a((byte) 0);
    private final HashMap<String, BroadcastReceiver> broadcastReceiverHashMap = new HashMap<>();

    static {
        AppMethodBeat.i(223931);
        AppMethodBeat.o(223931);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/audio/AudioBroadcastHelper$Companion;", "", "()V", "TAG", "", "plugin-audio_release"})
    /* renamed from: com.tencent.mm.plugin.audio.a$a  reason: collision with other inner class name */
    public static final class C0829a {
        private C0829a() {
        }

        public /* synthetic */ C0829a(byte b2) {
            this();
        }
    }

    public a() {
        AppMethodBeat.i(223930);
        AppMethodBeat.o(223930);
    }

    @Override // com.tencent.mm.booter.CoreService.a
    public final void registerBroadcasts() {
        AppMethodBeat.i(223925);
        Log.i("MicroMsg.AudioBroadcastHelper", "registerBroadcasts()");
        BluetoothReceiver bluetoothReceiver = new BluetoothReceiver();
        String simpleName = BluetoothReceiver.class.getSimpleName();
        p.g(simpleName, "BluetoothReceiver::class.java.simpleName");
        this.broadcastReceiverHashMap.put(simpleName, bluetoothReceiver);
        registerBroadcast(bluetoothReceiver, new String[]{"android.media.ACTION_SCO_AUDIO_STATE_UPDATED", "android.bluetooth.headset.profile.action.ACTIVE_DEVICE_CHANGED", "android.bluetooth.adapter.action.STATE_CHANGED", "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED", "android.bluetooth.device.action.ACL_DISCONNECTED", "android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED"}, new String[0]);
        HeadsetPlugReceiver headsetPlugReceiver = new HeadsetPlugReceiver();
        String simpleName2 = HeadsetPlugReceiver.class.getSimpleName();
        p.g(simpleName2, "HeadsetPlugReceiver::class.java.simpleName");
        this.broadcastReceiverHashMap.put(simpleName2, headsetPlugReceiver);
        registerBroadcast(headsetPlugReceiver, "android.intent.action.HEADSET_PLUG");
        BaseAudioReceiver baseAudioReceiver = new BaseAudioReceiver();
        String simpleName3 = BaseAudioReceiver.class.getSimpleName();
        p.g(simpleName3, "BaseAudioReceiver::class.java.simpleName");
        this.broadcastReceiverHashMap.put(simpleName3, baseAudioReceiver);
        registerBroadcast(baseAudioReceiver, "android.media.AUDIO_BECOMING_NOISY");
        AppMethodBeat.o(223925);
    }

    @Override // com.tencent.mm.booter.CoreService.a
    public final void unRegisterBroadcasts() {
        AppMethodBeat.i(223926);
        Log.i("MicroMsg.AudioBroadcastHelper", "unRegisterBroadcasts()");
        try {
            BroadcastReceiver broadcastReceiver = this.broadcastReceiverHashMap.get(BluetoothReceiver.class.getSimpleName());
            if (broadcastReceiver == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.audio.broadcast.bluetooth.BluetoothReceiver");
                AppMethodBeat.o(223926);
                throw tVar;
            }
            unRegisterBroadcast((BluetoothReceiver) broadcastReceiver);
            BroadcastReceiver broadcastReceiver2 = this.broadcastReceiverHashMap.get(HeadsetPlugReceiver.class.getSimpleName());
            if (broadcastReceiver2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.audio.broadcast.headset.HeadsetPlugReceiver");
                AppMethodBeat.o(223926);
                throw tVar2;
            }
            unRegisterBroadcast((HeadsetPlugReceiver) broadcastReceiver2);
            BroadcastReceiver broadcastReceiver3 = this.broadcastReceiverHashMap.get(BaseAudioReceiver.class.getSimpleName());
            if (broadcastReceiver3 == null) {
                t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.audio.broadcast.base.BaseAudioReceiver");
                AppMethodBeat.o(223926);
                throw tVar3;
            }
            unRegisterBroadcast((BaseAudioReceiver) broadcastReceiver3);
            AppMethodBeat.o(223926);
        } catch (Exception e2) {
            Log.e("MicroMsg.AudioBroadcastHelper", "unRegisterBroadcasts() Exception = %s ", e2.getMessage());
            AppMethodBeat.o(223926);
        }
    }

    private static void registerBroadcast(BroadcastReceiver broadcastReceiver, String str) {
        AppMethodBeat.i(223927);
        registerBroadcast(broadcastReceiver, new String[]{str}, new String[0]);
        AppMethodBeat.o(223927);
    }

    private static void registerBroadcast(BroadcastReceiver broadcastReceiver, String[] strArr, String[] strArr2) {
        AppMethodBeat.i(223928);
        Log.i("MicroMsg.AudioBroadcastHelper", "registerBroadcast: " + broadcastReceiver.getClass().getSimpleName());
        IntentFilter intentFilter = new IntentFilter();
        if (!Util.isNullOrNil((String[]) Arrays.copyOf(strArr, strArr.length))) {
            for (String str : strArr) {
                intentFilter.addAction(str);
            }
        }
        Util.isNullOrNil((String[]) Arrays.copyOf(strArr2, 0));
        MMApplicationContext.getContext().registerReceiver(broadcastReceiver, intentFilter);
        AppMethodBeat.o(223928);
    }

    private static void unRegisterBroadcast(BroadcastReceiver broadcastReceiver) {
        AppMethodBeat.i(223929);
        Log.i("MicroMsg.AudioBroadcastHelper", "unRegisterBroadcast: " + broadcastReceiver.getClass().getSimpleName());
        MMApplicationContext.getContext().unregisterReceiver(broadcastReceiver);
        AppMethodBeat.o(223929);
    }
}

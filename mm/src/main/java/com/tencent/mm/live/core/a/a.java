package com.tencent.mm.live.core.a;

import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/live/core/log/LiveErrorCodeTranslate;", "", "()V", "LIVE_CDN_SEI_MSG", "", "LIVE_ERR_CODE", "LIVE_FIRST_FRAME_HEIGHT", "LIVE_FIRST_FRAME_WIDTH", "LIVE_MEDIA_ENABLE", "LIVE_STREAM_TYPE", "LIVE_USER_EXIT_REASON", "LIVE_USER_ID", "translate", TMQQDownloaderOpenSDKConst.UINTYPE_CODE, "", "plugin-core_release"})
public final class a {
    public static final a hCB = new a();

    static {
        AppMethodBeat.i(196570);
        AppMethodBeat.o(196570);
    }

    private a() {
    }

    public static String qw(int i2) {
        switch (i2) {
            case TXLiteAVCode.ERR_SERVER_CENTER_CONN_ROOM_INVALID_SEQ:
                return "连麦请求序号错乱";
            case TXLiteAVCode.ERR_SERVER_CENTER_CONN_ROOM_CONNED_USER_FULL:
                return "被连麦用户达到资源上限";
            case TXLiteAVCode.ERR_SERVER_CENTER_CONN_ROOM_CONNED_USER_DELETED:
                return "被连麦用户已被删除";
            case TXLiteAVCode.ERR_SERVER_CENTER_CONN_ROOM_CONNED_USER_NOT_EXIST:
                return "被连麦用户不存在";
            case TXLiteAVCode.ERR_SERVER_CENTER_CONN_ROOM_CONNED_REACH_MAX_ROOM:
                return "被连麦房间达到连麦上限";
            case TXLiteAVCode.ERR_SERVER_CENTER_CONN_ROOM_CONNED_ROOM_NOT_EXIST:
                return "被连麦房间不存在";
            case TXLiteAVCode.ERR_SERVER_CENTER_CONN_ROOM_CANCEL_FAILED:
                return "取消跨房间连麦失败";
            case TXLiteAVCode.ERR_SERVER_CENTER_CONN_ROOM_FAILED:
                return "跨房间连麦失败";
            case TXLiteAVCode.ERR_SERVER_CENTER_CONN_ROOM_USER_NOT_CONNED:
                return "本用户未发起连麦";
            case TXLiteAVCode.ERR_SERVER_CENTER_CONN_ROOM_NOT_CONNED:
                return "本房间无连麦";
            case TXLiteAVCode.ERR_SERVER_CENTER_CONN_ROOM_SIG_GROUPID:
                return "跨房间连麦签名不匹配";
            case TXLiteAVCode.ERR_SERVER_CENTER_CONN_ROOM_INVALID_SIG_TIME:
                return "跨房间连麦签名时间戳错误";
            case TXLiteAVCode.ERR_SERVER_CENTER_CONN_ROOM_PARSE_SIG:
                return "跨房间连麦签名解析错误";
            case TXLiteAVCode.ERR_SERVER_CENTER_CONN_ROOM_NO_KEY:
                return "未找到跨房间连麦签名解密密钥";
            case TXLiteAVCode.ERR_SERVER_CENTER_CONN_ROOM_DECRYPT_SIG:
                return "跨房间连麦签名解密失败";
            case TXLiteAVCode.ERR_SERVER_CENTER_CONN_ROOM_NO_SIG:
                return "跨房间连麦无签名";
            case TXLiteAVCode.ERR_SERVER_CENTER_CONN_ROOM_REQ:
                return "跨房间连麦请求格式错误";
            case TXLiteAVCode.ERR_SERVER_CENTER_CONN_ROOM_REQ_TIMEOUT:
                return "跨房间连麦请求超时";
            case TXLiteAVCode.ERR_SERVER_CENTER_CONN_ROOM_REACH_MAX_RETRY_TIMES:
                return "跨房间连麦重试次数耗尽";
            case TXLiteAVCode.ERR_SERVER_CENTER_CONN_ROOM_REACH_MAX_NUM:
                return "达到跨房间连麦上限";
            case TXLiteAVCode.ERR_SERVER_CENTER_CONN_ROOM_NOT_SUPPORT:
                return "不支持跨房间连麦";
            case TXLiteAVCode.ERR_SERVER_CENTER_ANOTHER_USER_PUSH_SUB_VIDEO:
                return "其他用户正在上行辅路";
            case TXLiteAVCode.ERR_SERVER_CENTER_NO_PRIVILEDGE_PUSH_SUB_VIDEO:
                return "没有权限上行辅路";
            case TXLiteAVCode.ERR_SERVER_INFO_SERVICE_SUSPENDED:
                return "服务不可用。请检查：套餐包剩余分钟数是否大于0，腾讯云账号是否欠费";
            case TXLiteAVCode.ERR_CONNECT_OTHER_ROOM_AS_AUDIENCE:
                return "当前是观众角色，不能请求或断开跨房连麦，需要先 switchRole() 到主播";
            case TXLiteAVCode.ERR_ROOM_REQUEST_CONN_ROOM_INVALID_PARAM:
                return "无效参数";
            case TXLiteAVCode.ERR_ROOM_REQUEST_DISCONN_ROOM_TIMEOUT:
                return "请求退出连麦超时";
            case TXLiteAVCode.ERR_ROOM_REQUEST_CONN_ROOM_TIMEOUT:
                return "请求连麦超时";
            case TXLiteAVCode.ERR_ROOM_REQUEST_QUIT_ROOM_TIMEOUT:
                return "请求退房超时";
            case TXLiteAVCode.ERR_CLOUD_MIX_TRANSCODING_REQUEST_TIME_OUT:
                return "旁路转推回包异常";
            case TXLiteAVCode.ERR_PUBLISH_CDN_STREAM_REQUEST_TIME_OUT:
                return "旁路转推请求超时";
            case TXLiteAVCode.ERR_USER_SIG_INVALID:
                return "进房参数 userSig 不正确";
            case TXLiteAVCode.ERR_USER_ID_INVALID:
                return "进房参数 userID 不正确";
            case TXLiteAVCode.ERR_ROOM_ID_INVALID:
                return "进房参数 roomId 错误";
            case TXLiteAVCode.ERR_SDK_APPID_INVALID:
                return "进房参数 sdkAppId 错误";
            case TXLiteAVCode.ERR_ENTER_ROOM_PARAM_NULL:
                return "进房参数为空，请检查 enterRoom:appScene: 接口调用是否传入有效的 param";
            case TXLiteAVCode.ERR_ROOM_REQUEST_ENTER_ROOM_TIMEOUT:
                return "请求进房超时，请检查网络";
            case TXLiteAVCode.ERR_ROOM_REQUEST_AVSEAT_FAIL:
                return "请求视频位失败";
            case TXLiteAVCode.ERR_ROOM_CONNECT_FAIL:
                return "连接接口机服务器失败";
            case TXLiteAVCode.ERR_ROOM_REQUEST_IP_FAIL:
                return "拉取接口机服务器地址失败";
            case TXLiteAVCode.ERR_ROOM_HEARTBEAT_FAIL:
                return "心跳失败，客户端定时向服务器发送数据包，告诉服务器自己活着，这个错误通常是发包超时";
            case TXLiteAVCode.ERR_ROOM_ENTER_FAIL:
                return "进入房间失败";
            case TXLiteAVCode.ERR_RTMP_ACC_FETCH_STREAM_FAIL:
                return "直播，RTMPACC 低延时拉流失败，且经过多次重试无法恢复";
            case TXLiteAVCode.ERR_PLAY_LIVE_STREAM_SERVER_REFUSE:
                return "直播，服务器拒绝连接请求";
            case -2307:
                return "直播，切流失败（切流可以播放不同画面大小的视频）";
            case -2306:
                return "点播，获取点播文件信息失败";
            case -2305:
                return "点播，音视频流解密失败";
            case -2304:
                return "H265 解码失败";
            case -2303:
                return "播放的文件不存在";
            case -2302:
                return "直播，获取加速拉流的地址失败";
            case -2301:
                return "直播，网络断连，且经多次重连抢救无效，可以放弃治疗，更多重试请自行重启播放";
            case TXLiteAVCode.ERR_BUFFER_TYPE_UNSUPPORTED:
                return "设置的 buffer type 不支持";
            case TXLiteAVCode.ERR_PIXEL_FORMAT_UNSUPPORTED:
                return "设置的 pixel format 不支持";
            case TXLiteAVCode.ERR_RTMP_PUSH_SERVER_REFUSE:
                return "直播，服务器拒绝连接请求，可能是该推流地址已经被占用，或者 TXSecret 校验失败，或者是过期了，或者是欠费了";
            case TXLiteAVCode.ERR_RTMP_PUSH_NO_NETWORK:
                return "直播，网络不可用，请确认 Wi-Fi、移动数据或者有线网络是否正常";
            case TXLiteAVCode.ERR_RTMP_PUSH_NET_ALLADDRESS_FAIL:
                return "直播，连接推流服务器失败（若支持智能选路，IP 全部失败）";
            case TXLiteAVCode.ERR_SPEAKER_STOP_FAIL:
                return "停止扬声器失败";
            case TXLiteAVCode.ERR_SPEAKER_SET_PARAM_FAIL:
                return "扬声器设置参数失败";
            case TXLiteAVCode.ERR_SPEAKER_START_FAIL:
                return "打开扬声器失败，例如在 Windows 或 Mac 设备，扬声器的配置程序（驱动程序）异常，禁用后重新启用设备，或者重启机器，或者更新配置程序";
            case TXLiteAVCode.ERR_MIC_STOP_FAIL:
                return "停止麦克风失败";
            case TXLiteAVCode.ERR_MIC_OCCUPY:
                return "麦克风正在被占用中，例如移动设备正在通话时，打开麦克风会失败";
            case TXLiteAVCode.ERR_MIC_SET_PARAM_FAIL:
                return "麦克风设置参数失败";
            case TXLiteAVCode.ERR_MIC_NOT_AUTHORIZED:
                return "麦克风设备未授权，通常在移动设备出现，可能是权限被用户拒绝了";
            case TXLiteAVCode.ERR_CAMERA_OCCUPY:
                return "摄像头正在被占用中，可尝试打开其他摄像头";
            case TXLiteAVCode.ERR_CAMERA_SET_PARAM_FAIL:
                return "摄像头参数设置出错（参数不支持或其它）";
            case TXLiteAVCode.ERR_CAMERA_NOT_AUTHORIZED:
                return "摄像头设备未授权，通常在移动设备出现，可能是权限被用户拒绝了";
            case -1313:
                return "直播，推流地址非法，例如不是 RTMP 协议的地址";
            case -1309:
                return "录屏失败，在 Android 平台，需要5.0以上的系统";
            case -1308:
                return "开始录屏失败，如果在移动设备出现，可能是权限被用户拒绝了，如果在 Windows 或 Mac 系统的设备出现，请检查录屏接口的参数是否符合要求";
            case -1307:
                return "直播，推流出现网络断开，且经过多次重试无法恢复";
            case -1306:
                return "不支持的音频采样率";
            case -1305:
                return "不支持的视频分辨率";
            case -1304:
                return "音频帧编码失败，例如传入自定义音频数据，SDK 无法处理";
            case -1303:
                return "视频帧编码失败，例如 iOS 设备切换到其他应用时，硬编码器可能被系统释放，再切换回来时，硬编码器重启前，可能会抛出";
            case -1302:
                return "打开麦克风失败，例如在 Windows 或 Mac 设备，麦克风的配置程序（驱动程序）异常，禁用后重新启用设备，或者重启机器，或者更新配置程序";
            case -1301:
                return "打开摄像头失败，例如在 Windows 或 Mac 设备，摄像头的配置程序（驱动程序）异常，禁用后重新启用设备，或者重启机器，或者更新配置程序";
            case 0:
                return "无错误";
            case 1001:
                return "直播，已经连接 RTMP 推流服务器";
            case 1002:
                return "直播，已经与 RTMP 服务器握手完毕，开始推流";
            case 1003:
                return "打开摄像头成功";
            case 1004:
                return "录屏启动成功";
            case 1005:
                return "上行动态调整分辨率";
            case 1006:
                return "码率动态调整";
            case 1007:
                return "首帧画面采集完成";
            case 1008:
                return "编码器启动成功";
            case 1018:
                return "进入房间成功";
            case 1019:
                return "退出房间";
            case 1020:
                return "下发房间成员列表（不包括自己）";
            case 1021:
                return "WiFi 切换到4G 会触发断线重连，此时需要重新进入房间（拉取最优的服务器地址）";
            case TXLiteAVCode.EVT_RTMP_PUSH_PUBLISH_START:
                return "直播，与 RTMP 服务器连接后，收到 NetStream.Publish.Start 消息，表明流发布成功（SDK 内部事件，不会对外抛出）";
            case TXLiteAVCode.EVT_HW_ENCODER_START_SUCC:
                return "硬编码器启动成功";
            case TXLiteAVCode.EVT_SW_ENCODER_START_SUCC:
                return "软编码器启动成功";
            case 1031:
                return "进房通知";
            case 1032:
                return "退房通知";
            case 1033:
                return "视频状态位变化通知";
            case 1034:
                return "音频状态位变化通知";
            case 1101:
                return "网络状况不佳：上行带宽太小，上传数据受阻";
            case 1102:
                return "直播，网络断连; 已启动自动重连（自动重连连续失败超过三次会放弃）";
            case 1103:
                return "硬编码启动出现问题，自动切换到软编码";
            case 1107:
                return "当前 CPU 使用率太高，无法满足软件编码需求，自动切换到硬件编码";
            case 1109:
                return "软编码启动失败";
            case 2001:
                return "直播，已经连接 RTMP 拉流服务器";
            case 2002:
                return "直播，已经与 RTMP 服务器握手完毕，开始拉流";
            case 2003:
                return "渲染首个视频数据包（IDR）";
            case 2004:
                return "视频播放开始";
            case 2005:
                return "视频播放进度";
            case 2006:
                return "视频播放结束";
            case 2007:
                return "视频播放 loading";
            case 2008:
                return "解码器启动";
            case 2009:
                return "下行视频分辨率改变";
            case 2010:
                return "点播，获取点播文件信息成功";
            case 2011:
                return "视频旋转角度发生改变";
            case 2012:
                return "消息事件";
            case 2013:
                return "点播，视频加载完毕";
            case 2014:
                return "点播，loading 结束";
            case 2015:
                return "直播，切流成功（切流可以播放不同画面大小的视频）";
            case 2016:
                return "点播，TCP 连接成功（SDK 内部事件，不会对外抛出）";
            case TXLiteAVCode.EVT_VOD_PLAY_FIRST_VIDEO_PACKET:
                return "点播，收到首帧数据（SDK 内部事件，不会对外抛出）";
            case TXLiteAVCode.EVT_VOD_PLAY_DNS_RESOLVED:
                return "点播，DNS 解析完成（SDK 内部事件，不会对外抛出）";
            case TXLiteAVCode.EVT_VOD_PLAY_SEEK_COMPLETE:
                return "点播，视频播放 Seek 完成（SDK 内部事件，不会对外抛出）";
            case TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES:
                return "视频解码器缓存帧数过多，超过40帧（SDK 内部事件，不会对外抛出）";
            case TXLiteAVCode.EVT_HW_DECODER_START_SUCC:
                return "硬解码器启动成功（SDK 内部事件，不会对外抛出）";
            case TXLiteAVCode.EVT_SW_DECODER_START_SUCC:
                return "硬解码器启动成功（SDK 内部事件，不会对外抛出）";
            case TXLiteAVCode.EVT_AUDIO_JITTER_STATE_FIRST_LOADING:
                return "音频首次加载（SDK 内部事件，不会对外抛出）";
            case TXLiteAVCode.EVT_MIC_START_SUCC:
                return "麦克风启动成功";
            case 2028:
                return "视频流MetaData事件";
            case TXLiteAVCode.EVT_MIC_RELEASE_SUCC:
                return "释放麦克风占用";
            case 2101:
                return "当前视频帧解码失败。";
            case 2102:
                return "当前音频帧解码失败。";
            case 2103:
                return "直播，网络断连; 已启动自动重连（自动重连连续失败超过三次会放弃）";
            case 2105:
                return "当前视频播放出现卡顿。";
            case 2106:
                return "硬解启动失败，采用软解码";
            case 2108:
                return "当前流硬解第一个 I 帧失败，SDK 自动切软解";
            case TXLiteAVCode.WARNING_SW_DECODER_START_FAIL:
                return "软解码器启动失败";
            case 2110:
                return "视频渲染失败";
            case 3001:
                return "直播，DNS 解析失败";
            case 3002:
                return "直播，服务器连接失败";
            case 3003:
                return "直播，与 RTMP 服务器握手失败";
            case 3004:
                return "直播，服务器主动断开";
            case 3005:
                return "直播，RTMP 读/写失败，将会断开连接";
            case 3006:
                return "直播，RTMP 写失败（SDK 内部错误码，不会对外抛出）";
            case TXLiteAVCode.WARNING_RTMP_READ_FAIL:
                return "直播，RTMP 读失败（SDK 内部错误码，不会对外抛出）";
            case TXLiteAVCode.WARNING_RTMP_NO_DATA:
                return "直播，超过30s 没有数据发送，主动断开连接";
            case TXLiteAVCode.WARNING_PLAY_LIVE_STREAM_INFO_CONNECT_FAIL:
                return "直播，connect 服务器调用失败（SDK 内部错误码，不会对外抛出）";
            case TXLiteAVCode.WARNING_NO_STEAM_SOURCE_FAIL:
                return "直播，连接失败，该流地址无视频（SDK 内部错误码，不会对外抛出）";
            case TXLiteAVCode.WARNING_ROOM_DISCONNECT:
                return "网络断开连接";
            case TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE:
                return "当前是观众角色，忽略上行音视频数据";
            case TXLiteAVCode.WARNING_AUDIO_RECORDING_WRITE_FAIL:
                return "音频录制写入文件失败";
            case TXLiteAVCode.EVT_ROOM_REQUEST_IP_SUCC:
                return "拉取接口机服务器地址成功";
            case TXLiteAVCode.EVT_ROOM_CONNECT_SUCC:
                return "连接接口机服务器成功";
            case TXLiteAVCode.EVT_ROOM_REQUEST_AVSEAT_SUCC:
                return "请求视频位成功";
            default:
                return "";
        }
    }
}

package com.tencent.mars.cdn;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Keep;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.recovery.wx.util.EncryptUtil;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class CdnLogic {
    public static final int HIT_FILEID = 1;
    public static final int HIT_UPLOADCHECKMD5 = 2;
    public static final int HIT_UPLOADWITHMD5 = 3;
    public static final int ImageFormat_HEVC = 2;
    public static final int ImageFormat_JPEG = 1;
    public static final int MediaTypeAppImage = 20301;
    public static final int MediaTypeFriendsADImageThumb = 20204;
    public static final int MediaTypeFriendsImageThumb = 20205;
    public static final int MediaTypeFriendsVideoThumbImage = 20250;
    public static final int MediaType_F2F_VOICE_RESOURCE = 101;
    public static final int MediaType_FAVORITE_FILE = 10001;
    public static final int MediaType_FAVORITE_VIDEO = 10002;
    public static final int MediaType_FILE = 5;
    public static final int MediaType_FRIENDS = 20201;
    public static final int MediaType_FRIENDS_Video = 20202;
    public static final int MediaType_FULLSIZEIMAGE = 1;
    public static final int MediaType_GlanceVideo = 90;
    public static final int MediaType_IMAGE = 2;
    public static final int MediaType_SnsAdLangdingPageVideo = 100;
    public static final int MediaType_THUMBIMAGE = 3;
    public static final int MediaType_TinyVideo = 6;
    public static final int MediaType_VIDEO = 4;
    public static final int MediaType_WIMDownload = 19;
    public static final int NO_ERROR = 0;
    public static final int NO_HITCACHE = 0;
    public static final int PreloadMode = 2;
    public static final int StorageMode = 0;
    private static final String TAG = "mars.CdnLogic";
    public static final int VideoFormat_Unknown = 0;
    public static final int VideoFormat_X264 = 1;
    public static final int VideoFormat_X265 = 2;
    public static final int VideoPlayMode = 1;
    public static final String defaultApprovedVideoHosts = "vweixinf.tc.qq.com,szwbwxsns.video.qq.com,szxzwxsns.video.qq.com,szzjwxsns.video.qq.com,shwbwxsns.video.qq.com,shxzwxsns.video.qq.com,shzjwxsns.video.qq.com,wxsnsdy.wxs.qq.com,vweixinthumb.tc.qq.com,wxsnsdythumb.wxs.qq.com,wxappthumb.tc.qq.com,wxapp.tc.qq.com";
    public static final int kAppTypeAdImage = 109;
    public static final int kAppTypeAdVideo = 105;
    public static final int kAppTypeAny = 0;
    public static final int kAppTypeC2C = 1;
    public static final int kAppTypeC2CGroupChat = 2;
    public static final int kAppTypeEmoji = 110;
    public static final int kAppTypeFavorite = 10;
    public static final int kAppTypeFestivalImage = 257;
    public static final int kAppTypeFestivalVideo = 258;
    public static final int kAppTypeFinderVideo = 251;
    public static final int kAppTypeHDVideo = 205;
    public static final int kAppTypeHwPage = 200;
    public static final int kAppTypeMultiJpeg = 101;
    public static final int kAppTypeMultiVCodec = 108;
    public static final int kAppTypeMultiWebp = 104;
    public static final int kAppTypeNearEvent = 201;
    public static final int kAppTypeP2021 = 255;
    public static final int kAppTypeSelfieEmoji = 111;
    public static final int kAppTypeShop = 200;
    public static final int kAppTypeSingleJpeg = 100;
    public static final int kAppTypeSingleVCodec = 107;
    public static final int kAppTypeSingleWebp = 103;
    public static final int kAppTypeUnknown = -1;
    public static final int kAppTypeUserStatus = 256;
    public static final int kAppTypeVideo = 102;
    public static final int kAppTypeVideoThumb = 150;
    public static final int kAppTypeYunStorage = 202;
    public static final int kBizAny = 0;
    public static final int kBizApp = 4;
    public static final int kBizC2C = 1;
    public static final int kBizDC = 5;
    public static final int kBizFavorite = 2;
    public static final int kBizGeneric = 65535;
    public static final int kBizSns = 3;
    public static final int kBizUnknown = -1;
    public static final int kErrSafeProtoNoAeskey = -21111;
    public static final int kErrUploadHevcIllegal = -5103237;
    public static final int kIpSource_NewDNS = 1;
    public static final int kIpSource_None = 0;
    public static final int kIpSource_SysDNS = 2;
    public static final int kMediaGamePacket = 30002;
    public static final int kMediaLittleAppPacket = 30001;
    public static final int kMediaTypeAdImage = 20204;
    public static final int kMediaTypeAdVideo = 20210;
    public static final int kMediaTypeAny = 0;
    public static final int kMediaTypeAppFile = 20303;
    public static final int kMediaTypeAppImageStorage = 20304;
    public static final int kMediaTypeAppVideo = 20302;
    public static final int kMediaTypeBackupFile = 20001;
    public static final int kMediaTypeBeatificFile = 10011;
    public static final int kMediaTypeBigFile = 7;
    public static final int kMediaTypeEmojiGIF = 20402;
    public static final int kMediaTypeEmojiNormal = 20401;
    public static final int kMediaTypeEmojiWXAM = 20403;
    public static final int kMediaTypeExposeImage = 11000;
    public static final int kMediaTypeFavoriteBigFile = 10007;
    public static final int kMediaTypeFavoriteFile = 10001;
    public static final int kMediaTypeFavoriteVideo = 10002;
    public static final int kMediaTypeFile = 5;
    public static final int kMediaTypeFriends = 20201;
    public static final int kMediaTypeFriendsVideo = 20202;
    public static final int kMediaTypeFriendsVideoThumbImage = 20250;
    public static final int kMediaTypeFullSizeImage = 1;
    public static final int kMediaTypeHWDevice = 20322;
    public static final int kMediaTypeHWDeviceFile = 20303;
    public static final int kMediaTypeImage = 2;
    public static final int kMediaTypeNearEvent = 20310;
    public static final int kMediaTypeShop = 20301;
    public static final int kMediaTypeSmartHwPage = 20321;
    public static final int kMediaTypeStoryAudio = 40001;
    public static final int kMediaTypeThumbImage = 3;
    public static final int kMediaTypeTinyVideo = 6;
    public static final int kMediaTypeVideo = 4;
    public static final int kMultiImageDownload = 2;
    public static final int kNetTypeDisconnected = -1;
    public static final int kNetTypeMobile = 2;
    public static final int kNetTypeOther = 3;
    public static final int kNetTypeWifi = 1;
    public static final int kSingleImageDownload = 1;

    public interface AppCallback {
        void onBadNetworkProbed();

        void reportFlow(int i2, int i3, int i4, int i5);

        void requestGetCDN(int i2);

        String[] resolveHost(String str, boolean z, int[] iArr);
    }

    public static class BatchSnsReqImageData {
        public String decryptKey = "";
        public String fileKey = "";
        public String imageCachePath = "";
        public int picIndex = 0;
        public boolean retry = true;
        public int totalFileSize = 0;
        public String url = "";
    }

    public static class C2CDownloadResult {
        public String argInfo = "";
        public long availableBytes = 0;
        public int averageConnectCost = 0;
        public int averageRequestCost = 0;
        public int averageRequestSize = 0;
        public int averageSpeed = 0;
        public String batchImageFileKey = "";
        public BatchSnsReqImageData[] batchImageNeedRetry = null;
        public String batchPicFeedId = "";
        public int cSeqCheck = 0;
        public String clientIP = "";
        public int connectCostTime = 0;
        public CronetTaskResult cronetTaskResult = null;
        public boolean crossNet = false;
        public long currentFileSize = 0;
        public int delayTime = 0;
        public int detailErrorCode = 0;
        public int detailErrorType = 0;
        public int dnsCostTime = 0;
        public long enQueueTime = 0;
        public long endTime = 0;
        public int errorCode = 0;
        public long fileSize = 0;
        public int fileType = 0;
        public String fileid = "";
        public int firstConnectCost = 0;
        public boolean firstRequestCompleted = false;
        public int firstRequestCost = 0;
        public int firstRequestDownloadSize = 0;
        public int firstRequestSize = 0;
        public boolean fromCronet = false;
        public String httpResponseHeader = "";
        public int httpStatusCode = 0;
        public boolean isResume = false;
        public boolean isSnsImageProtocolAvailable;
        public int lastNetType = -1;
        public int lastSvrPort = 0;
        public boolean moovCompleted = false;
        public int moovCost = 0;
        public int moovFailReason = 0;
        public int moovRequestTimes = 0;
        public int moovSize = 0;
        public int netConnectTimes = 0;
        public String picCachePath = "";
        public int picIndex = -1;
        public int previousCompletedSize = 0;
        public String realUsedURL = "";
        public int receiveCostTime = 0;
        public long recvedBytes = 0;
        public int requestCompletedCount = 0;
        public int requestTimeoutCount = 0;
        public int requestTotalCount = 0;
        public String serverIP = "";
        public long startTime = 0;
        public int svrFallbackCount = 0;
        public String systemErrorDescribe = "";
        public long taskStartTime = 0;
        public long traceId = 0;
        public String traceMsg = "";
        public String transforMsg = "";
        public int transportProtocol = 0;
        public int transportProtocolError = 0;
        public long tryWritenBytes = 0;
        public boolean usePrivateProtocol = false;
        public String[] usedSvrIps;
        public String videoFlag = "";
        public int videoFormat = 0;
        public int waitResponseCostTime = 0;
        public String xErrorNo = "";
    }

    public static class C2CUploadResult {
        public String aeskey = "";
        public String clientIP = "";
        public int connectCostTime = 0;
        public boolean crossNet = false;
        public int delayTime = 0;
        public int detailErrorCode = 0;
        public int detailErrorType = 0;
        public String emojiMD5 = "";
        public int errorCode = 0;
        public boolean existOnSvr = false;
        public int fileCrc32 = 0;
        public int fileSize = 0;
        public String fileUrl = "";
        public String fileid = "";
        public String filemd5 = "";
        public int filetype = 0;
        public int hitCache = 0;
        public boolean isResume = false;
        public boolean isVideoReduced = false;
        public int midfileSize = 0;
        public String mp4identifymd5 = "";
        public int receiveCostTime = 0;
        public boolean sendmsgFromCDN = false;
        public String serverIP = "";
        public byte[] skeyrespbuf = null;
        public String systemErrorDescribe = "";
        public int thumbfileSize = 0;
        public String thumbfileUrl = "";
        public String thumbfilemd5 = "";
        public String touser = "";
        public String transforMsg = "";
        public int transportProtocol = 0;
        public int transportProtocolError = 0;
        public boolean uploadBySafecdn = false;
        public String[] usedSvrIps;
        public String videofileid = "";
        public int waitResponseCostTime = 0;
    }

    public static class CdnInfo {
        public byte[] authkey = null;
        public int frontid = 0;
        public String frontip1 = null;
        public String frontip2 = null;
        public int[] frontports = null;
        public int nettype = 0;
        public int uin = 0;
        public int ver = 0;
        public int zoneid = 0;
        public String zoneip1 = null;
        public String zoneip2 = null;
        public int[] zoneports = null;
    }

    public static class CdnInfoParams {
        public int c2CretryIntervalMs = 0;
        public int c2CrwtimeoutMs = 0;
        public int c2CshowErrorDelayMs = 0;
        public int snsretryIntervalMs = 0;
        public int snsrwtimeoutMs = 0;
        public int snsshowErrorDelayMs = 0;
    }

    public static class CdnTaskStateInfo {
        public static final int kCompleted = 104;
        public static final int kNotExits = 103;
        public static final int kPausing = 102;
        public static final int kRunning = 100;
        public static final int kWaiting = 101;
        public long completeSize = 0;
        public long fileTotalSize = 0;
        public int taskState = -100;
    }

    public static class CertVerifyResult {
        public byte[][] certificateChain = null;
        public boolean isIssuedByKnownRoot = false;
        public int status = 0;
    }

    public static class CertificateVerifyPolicy {
        public static final int kIngoreError = 2;
        public static final int kNoVerify = 0;
        public static final int kStrictVerify = 1;
    }

    public static class CronetTaskResult {
        public WebPageProfile performance = null;
        public int statusCode = 0;
        public String statusText = "";
        public boolean useHttp2 = false;
        public boolean useQuic = false;
    }

    public interface DownloadCallback {
        void onC2CDownloadCompleted(String str, C2CDownloadResult c2CDownloadResult);

        void onDownloadProgressChanged(String str, long j2, long j3, boolean z);
    }

    public static class GetCdnScene {
        public static final int GET_CDN_AUTH = 1;
        public static final int GET_CDN_CHECK = 4;
        public static final int GET_CDN_DEFAULT = 0;
        public static final int GET_CDN_IGNORE_FETCH_RETRY = 6;
        public static final int GET_CDN_MARS_CACHE_EXPIRED = 9;
        public static final int GET_CDN_MARS_SVR_REQUEST = 8;
        public static final int GET_CDN_MARS_TIMING_FETCH = 7;
        public static final int GET_CDN_NETWORK_CHANGE = 2;
        public static final int GET_CDN_NETWORK_CHANGE_RETRY = 3;
        public static final int GET_CDN_TEST = 5;
        public static final int GET_CDN_USER_ATTRIBUTE_CHANGED = 10;
    }

    public static class HostIPHint {
        public HostIpMap[] hostMap;
    }

    public static class HostIpMap {
        public String host;
        public String ip;
        public int port;
    }

    public interface SessionCallback {
        byte[] decodeSessionResponseBuf(String str, byte[] bArr);

        byte[] getSessionRequestBuf(String str, byte[] bArr);
    }

    public static class SnsUploadVersion {
        public static final int kVersion100M = 1;
        public static final int kVersion30M = 0;
    }

    public static class SpeedType {
        public static final int stDownload = 2;
        public static final int stUpload = 1;
    }

    public static class TransportProtocol {
        public static final int HTTP = 1;
        public static final int HTTP3 = 4;
        public static final int HTTPS = 2;
        public static final int QUIC = 3;
        public static final int TCP = 0;
    }

    public interface UploadCallback {
        void onC2CUploadCompleted(String str, C2CUploadResult c2CUploadResult);

        void onUploadProgressChanged(String str, long j2, long j3);
    }

    public static class VideoFlagPolicy {
        public static final int kVideoFlagAuto = 0;
        public static final int kVideoFlagMustMatch = 1;
    }

    public interface VideoStreamingCallback {
        void onDataAvailable(String str, long j2, long j3);

        void onDownloadToEnd(String str, long j2, long j3);

        void onM3U8Ready(String str, String str2);

        void onMoovReadyWithFlag(String str, long j2, long j3, String str2);

        void onPreloadCompletedWithResult(String str, long j2, long j3, C2CDownloadResult c2CDownloadResult);
    }

    public static native boolean allowBatchImageDownload();

    public static native int calcFileCrc32(String str);

    public static native String calcFileMD5(String str);

    public static native String calcMP4IdentifyMD5(String str);

    public static native int cancelDownloadTaskWithResult(String str, C2CDownloadResult c2CDownloadResult);

    public static native void cancelTask(String str);

    public static native int cancelUploadTaskWithResult(String str, C2CUploadResult c2CUploadResult);

    public static native String createAeskey();

    public static native String createUniqueFilekey(String str, String str2);

    private static native ArrayList<String> getLoadLibraries();

    public static native int getRecentAverageSpeed(int i2);

    public static native boolean getSnsImagePrivateProtocolAvalible();

    public static native CdnTaskStateInfo httpMultiSocketDownloadTaskState(String str);

    public static native boolean isVideoDataAvailable(String str, long j2, long j3);

    private static native void onCreate(String str);

    public static native int pauseHttpMultiSocketDownloadTask(String str);

    public static native int queryContinuousSize(String str, long j2, long[] jArr);

    public static native int queryDownloadedSize(String str, long[] jArr);

    public static native long queryFilesizeLimit(int i2, int i3);

    public static native String queryM3U8Data(String str);

    public static native boolean queryVideoMoovInfo(C2CDownloadRequest c2CDownloadRequest, long[] jArr);

    public static native int requestVideoData(String str, long j2, long j3, int i2);

    public static native int resumeHttpMultiSocketDownloadTask(String str);

    private static native void setAppCallback(AppCallback appCallback);

    public static native void setCdnInfo(byte[] bArr, byte[] bArr2);

    public static native void setCdnInfoParams(CdnInfoParams cdnInfoParams, CdnInfoParams cdnInfoParams2, int i2);

    public static native void setConfig(Config config);

    public static native void setDebugIP(String str);

    public static native void setFlowLimitPerHour(int i2);

    public static native void setLegacyCdnInfo(CdnInfo cdnInfo, CdnInfo cdnInfo2, CdnInfo cdnInfo3, CdnInfo cdnInfo4, byte[] bArr, byte[] bArr2);

    private static native void setRSAPublicKeyParams(String str, String str2, String str3);

    public static native void setSnsImagePrivateProtocolAvalible(boolean z);

    public static native void setSnsImageStreamProtocolAvalible(boolean z);

    private static native void setToUserCiper(String str);

    public static native void setUseIPv6Cdn(boolean z);

    public static native int startC2CDownload(C2CDownloadRequest c2CDownloadRequest, DownloadCallback downloadCallback);

    public static native int startC2CUpload(C2CUploadRequest c2CUploadRequest, UploadCallback uploadCallback);

    public static native int startCronetFileDownload(C2CDownloadRequest c2CDownloadRequest, DownloadCallback downloadCallback);

    public static native int startCronetSimpleRequest(C2CDownloadRequest c2CDownloadRequest, DownloadCallback downloadCallback);

    public static native int startFtnUpload(C2CUploadRequest c2CUploadRequest, UploadCallback uploadCallback);

    public static native int startHttpMultiSocketDownloadTask(C2CDownloadRequest c2CDownloadRequest, DownloadCallback downloadCallback);

    public static native int startHttpVideoStreamingDownload(C2CDownloadRequest c2CDownloadRequest, VideoStreamingCallback videoStreamingCallback, DownloadCallback downloadCallback, int i2);

    public static native int startHttpsDownload(C2CDownloadRequest c2CDownloadRequest, DownloadCallback downloadCallback);

    public static native int startSNSDownload(C2CDownloadRequest c2CDownloadRequest, VideoStreamingCallback videoStreamingCallback, DownloadCallback downloadCallback, int i2);

    public static native int startSSUpload(C2CUploadRequest c2CUploadRequest, SessionCallback sessionCallback, UploadCallback uploadCallback);

    public static native int startURLDownload(C2CDownloadRequest c2CDownloadRequest, DownloadCallback downloadCallback);

    public static native int startVideoStreamingDownload(C2CDownloadRequest c2CDownloadRequest, VideoStreamingCallback videoStreamingCallback, DownloadCallback downloadCallback, int i2);

    public static native boolean taskExist(String str);

    public static native void triggerPreConnect(String str, String[] strArr, boolean z);

    public static class C2CUploadRequest {
        public int apptype = 0;
        public String bigfileSignature = "";
        public int bizscene = 0;
        public int chatType = 0;
        public boolean checkExistOnly = false;
        public int connectionCount = 1;
        public String customHeader = "";
        public String debugIP = "";
        public String emojiExtinfo = "";
        public boolean enableHitCheck = true;
        public String fakeBigfileSignature = "";
        public String fakeBigfileSignatureAeskey = "";
        public byte[] fileBuffer;
        public String fileKey = "";
        private String filePath = "";
        public int fileSize = 0;
        public int fileType = 0;
        public String filemd5 = "";
        public boolean forceNoSafeCdn = false;
        public String forwardAeskey = "";
        public String forwardFileid = "";
        public String host = "";
        public int isLargeSVideo = 0;
        public boolean isSmallVideo = false;
        public boolean isSnsAdVideo = false;
        public boolean isStorageMode = false;
        public boolean isStreamMedia = false;
        public int lastError = 0;
        public int marscdnBizType = -1;
        public int midfileSize = 0;
        public String midimgPath = "";
        public boolean needCompressImage = false;
        public boolean onlyCheckExist = false;
        public int queueTimeoutSeconds = 1800;
        public boolean sendmsgFromCDN = false;
        public int snsVersion = 0;
        public String statePath = "";
        private String thumbfilePath = "";
        public byte[] thumbnailBuffer;
        public String toUser = "";
        public int transforTimeoutSeconds = 600;
        public boolean trySafeCdn = false;
        public boolean useMultithread = false;
        public int videoSource = 0;

        public void setFilePath(String str) {
            this.filePath = s.k(str, false);
            if (Util.isNullOrNil(this.filePath)) {
                this.filePath = "";
            }
        }

        public void setThumbfilePath(String str) {
            this.thumbfilePath = s.k(str, false);
            if (Util.isNullOrNil(this.thumbfilePath)) {
                this.thumbfilePath = "";
            }
        }

        public void setMidimgPath(String str) {
            this.midimgPath = s.k(str, false);
            if (Util.isNullOrNil(this.midimgPath)) {
                this.midimgPath = "";
            }
        }
    }

    public static class C2CDownloadRequest {
        public String aeskey = "";
        public boolean allow_mobile_net_download = false;
        public String argInfo = "";
        public String bakup_url = "";
        public BatchSnsReqImageData[] batchSnsReqImageDatas = null;
        public String bigfileSignature = "";
        public int certificateVerifyPolicy = 2;
        public int chatType = 0;
        public int concurrentCount = 1;
        public int connectionCount = 1;
        public String customHeader = "";
        public String[] dcIpList = null;
        public int dcIpListSource = 2;
        public String debugIP = "";
        public int expectImageFormat = 1;
        public String fakeBigfileSignature = "";
        public String fakeBigfileSignatureAeskey = "";
        public String feedId = "";
        public int feedPicCount;
        public String fileKey = "";
        public int fileSize = 0;
        public int fileType = 0;
        public String fileid = "";
        public String hlsVideoFlag = "";
        public String host = "";
        public HostIPHint hostIPHint = null;
        public String httpMethod = "";
        public boolean isAutoStart = false;
        public boolean isColdSnsData = false;
        public boolean isHLSVideo = false;
        public boolean isHotSnsVideo = false;
        public boolean isLargeSVideo = false;
        public boolean isSilentTask = false;
        public boolean isSmallVideo = false;
        public boolean isStorageMode = false;
        public boolean is_resume_task = false;
        public int limitRate = 0;
        public int marscdnAppType = -1;
        public int marscdnBizType = -1;
        public int maxHttpRedirectCount = 3;
        public String msgExtra = "";
        public int msgType = 1;
        public String[] ocIpList = null;
        public int ocIpListSource = 2;
        public long preloadMinSize = 0;
        public int preloadRatio = 30;
        public int queueTimeoutSeconds = 1800;
        public CronetLogic.QuicTaskParams quicTaskParams = null;
        public String referer = "";
        public String requestVideoFlag = "";
        public int requestVideoFormat = 1;
        private String savePath = "";
        public String serialized_verify_headers = "";
        public String signalQuality = "";
        public String snsCipherKey = "";
        public String snsScene = "";
        private String statePath = "";
        public long taskStartTime = 0;
        public int transforTimeoutSeconds = 600;
        public String url = "";
        public boolean useMultithread = false;
        public boolean useNewdns = false;
        public String videofileid = "";
        public int videoflagPolicy = 1;
        public boolean wifiAutoStart = false;

        public void setSavePath(String str) {
            this.savePath = s.k(str, false);
        }

        public void setStatePath(String str) {
            this.statePath = s.k(str, false);
        }

        public C2CDownloadRequest fakeBigfileSignature(String str) {
            this.fakeBigfileSignature = str;
            return this;
        }

        public C2CDownloadRequest fakeBigfileSignatureAeskey(String str) {
            this.fakeBigfileSignatureAeskey = str;
            return this;
        }

        public C2CDownloadRequest argInfo(String str) {
            this.argInfo = str;
            return this;
        }

        public C2CDownloadRequest limitRate(int i2) {
            this.limitRate = i2;
            return this;
        }

        public C2CDownloadRequest isSilentTask(boolean z) {
            this.isSilentTask = z;
            return this;
        }

        public C2CDownloadRequest queueTimeoutSeconds(int i2) {
            this.queueTimeoutSeconds = i2;
            return this;
        }

        public C2CDownloadRequest transforTimeoutSeconds(int i2) {
            this.transforTimeoutSeconds = i2;
            return this;
        }

        public C2CDownloadRequest chatType(int i2) {
            this.chatType = i2;
            return this;
        }

        public C2CDownloadRequest isStorageMode(boolean z) {
            this.isStorageMode = z;
            return this;
        }

        public C2CDownloadRequest isSmallVideo(boolean z) {
            this.isSmallVideo = z;
            return this;
        }

        public C2CDownloadRequest isLargeSVideo(boolean z) {
            this.isLargeSVideo = z;
            return this;
        }

        public C2CDownloadRequest isAutoStart(boolean z) {
            this.isAutoStart = z;
            return this;
        }

        public C2CDownloadRequest videofileid(String str) {
            this.videofileid = str;
            return this;
        }

        public C2CDownloadRequest msgExtra(String str) {
            this.msgExtra = str;
            return this;
        }

        public C2CDownloadRequest bigfileSignature(String str) {
            this.bigfileSignature = str;
            return this;
        }

        public C2CDownloadRequest requestVideoFormat(int i2) {
            this.requestVideoFormat = i2;
            return this;
        }

        public C2CDownloadRequest isColdSnsData(boolean z) {
            this.isColdSnsData = z;
            return this;
        }

        public C2CDownloadRequest preloadRatio(int i2) {
            this.preloadRatio = i2;
            return this;
        }

        public C2CDownloadRequest host(String str) {
            this.host = str;
            return this;
        }

        public C2CDownloadRequest referer(String str) {
            this.referer = str;
            return this;
        }

        public C2CDownloadRequest ocIpList(String[] strArr) {
            this.ocIpList = strArr;
            return this;
        }

        public C2CDownloadRequest ocIpListSource(int i2) {
            this.ocIpListSource = i2;
            return this;
        }

        public C2CDownloadRequest dcIpList(String[] strArr) {
            this.dcIpList = strArr;
            return this;
        }

        public C2CDownloadRequest dcIpListSource(int i2) {
            this.dcIpListSource = i2;
            return this;
        }

        public C2CDownloadRequest snsCipherKey(String str) {
            this.snsCipherKey = str;
            return this;
        }

        public C2CDownloadRequest signalQuality(String str) {
            this.signalQuality = str;
            return this;
        }

        public C2CDownloadRequest snsScene(String str) {
            this.snsScene = str;
            return this;
        }

        public C2CDownloadRequest customHeader(String str) {
            this.customHeader = str;
            return this;
        }

        public C2CDownloadRequest bakup_url(String str) {
            this.bakup_url = str;
            return this;
        }

        public C2CDownloadRequest serialized_verify_headers(String str) {
            this.serialized_verify_headers = str;
            return this;
        }

        public C2CDownloadRequest allow_mobile_net_download(boolean z) {
            this.allow_mobile_net_download = z;
            return this;
        }

        public C2CDownloadRequest is_resume_task(boolean z) {
            this.is_resume_task = z;
            return this;
        }

        public C2CDownloadRequest concurrentCount(int i2) {
            this.concurrentCount = i2;
            return this;
        }

        public C2CDownloadRequest maxHttpRedirectCount(int i2) {
            this.maxHttpRedirectCount = i2;
            return this;
        }

        public C2CDownloadRequest wifiAutoStart(boolean z) {
            this.wifiAutoStart = z;
            return this;
        }

        public C2CDownloadRequest statePath(String str) {
            setStatePath(str);
            return this;
        }

        public C2CDownloadRequest connectionCount(int i2) {
            this.connectionCount = i2;
            return this;
        }

        public C2CDownloadRequest useMultithread(boolean z) {
            this.useMultithread = z;
            return this;
        }

        public C2CDownloadRequest certificateVerifyPolicy(int i2) {
            this.certificateVerifyPolicy = i2;
            return this;
        }

        public C2CDownloadRequest expectImageFormat(int i2) {
            this.expectImageFormat = i2;
            return this;
        }

        public static C2CDownloadRequest createC2C(String str, String str2, int i2, String str3) {
            C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
            c2CDownloadRequest.fileid = str;
            c2CDownloadRequest.aeskey = str2;
            c2CDownloadRequest.fileType = i2;
            c2CDownloadRequest.setSavePath(str3);
            c2CDownloadRequest.marscdnBizType = 1;
            c2CDownloadRequest.marscdnAppType = 1;
            return c2CDownloadRequest;
        }

        public static C2CDownloadRequest createSNS(String str, int i2, String str2) {
            C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
            c2CDownloadRequest.url = str;
            c2CDownloadRequest.fileType = i2;
            c2CDownloadRequest.setSavePath(str2);
            c2CDownloadRequest.marscdnBizType = 3;
            c2CDownloadRequest.marscdnAppType = 100;
            return c2CDownloadRequest;
        }

        public static C2CDownloadRequest createFavorite(String str, String str2, int i2, String str3) {
            C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
            c2CDownloadRequest.fileid = str;
            c2CDownloadRequest.aeskey = str2;
            c2CDownloadRequest.fileType = i2;
            c2CDownloadRequest.setSavePath(str3);
            c2CDownloadRequest.marscdnBizType = 2;
            c2CDownloadRequest.marscdnAppType = 10;
            return c2CDownloadRequest;
        }

        public static C2CDownloadRequest createC2CVideo(String str, String str2, int i2, String str3) {
            C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
            c2CDownloadRequest.fileid = str;
            c2CDownloadRequest.aeskey = str2;
            c2CDownloadRequest.fileType = i2;
            c2CDownloadRequest.setSavePath(str3);
            c2CDownloadRequest.marscdnBizType = 1;
            c2CDownloadRequest.marscdnAppType = 1;
            return c2CDownloadRequest;
        }

        public static C2CDownloadRequest createHttpVideo(String str, String str2) {
            C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
            c2CDownloadRequest.url = str;
            c2CDownloadRequest.setSavePath(str2);
            c2CDownloadRequest.marscdnBizType = 4;
            c2CDownloadRequest.marscdnAppType = 102;
            return c2CDownloadRequest;
        }

        public static C2CDownloadRequest createHttp(String str, String str2) {
            C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
            c2CDownloadRequest.url = str;
            c2CDownloadRequest.setSavePath(str2);
            c2CDownloadRequest.marscdnBizType = 4;
            c2CDownloadRequest.marscdnAppType = 102;
            return c2CDownloadRequest;
        }
    }

    @Keep
    public static class WebPageProfile implements Parcelable {
        public static final Parcelable.Creator<WebPageProfile> CREATOR = new Parcelable.Creator<WebPageProfile>() {
            /* class com.tencent.mars.cdn.CdnLogic.WebPageProfile.AnonymousClass1 */

            @Override // android.os.Parcelable.Creator
            public final WebPageProfile createFromParcel(Parcel parcel) {
                return new WebPageProfile(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final WebPageProfile[] newArray(int i2) {
                return new WebPageProfile[i2];
            }
        };
        public long SSLconnectionEnd;
        public long SSLconnectionStart;
        public long connectEnd;
        public long connectStart;
        public long domainLookUpEnd;
        public long domainLookUpStart;
        public int downstreamThroughputKbpsEstimate;
        public long fetchStart;
        public int httpRttEstimate;
        public int networkTypeEstimate;
        public String peerIP = "";
        public int port;
        public String protocol = "";
        public long receivedBytedCount;
        public long redirectEnd;
        public long redirectStart;
        public long requestEnd;
        public long requestStart;
        public long responseEnd;
        public long responseStart;
        public int rtt;
        public long sendBytesCount;
        public boolean socketReused;
        public int statusCode;
        public int throughputKbps;
        public int transportRttEstimate;

        public String toString() {
            return "WebPageProfile{redirectStart=" + this.redirectStart + ", redirectEnd=" + this.redirectEnd + ", fetchStart=" + this.fetchStart + ", domainLookUpStart=" + this.domainLookUpStart + ", domainLookUpEnd=" + this.domainLookUpEnd + ", connectStart=" + this.connectStart + ", connectEnd=" + this.connectEnd + ", SSLconnectionStart=" + this.SSLconnectionStart + ", SSLconnectionEnd=" + this.SSLconnectionEnd + ", requestStart=" + this.requestStart + ", requestEnd=" + this.requestEnd + ", responseStart=" + this.responseStart + ", responseEnd=" + this.responseEnd + ", protocol='" + this.protocol + '\'' + ", rtt=" + this.rtt + ", statusCode=" + this.statusCode + ", networkTypeEstimate=" + this.networkTypeEstimate + ", httpRttEstimate=" + this.httpRttEstimate + ", transportRttEstimate=" + this.transportRttEstimate + ", downstreamThroughputKbpsEstimate=" + this.downstreamThroughputKbpsEstimate + ", throughputKbps=" + this.throughputKbps + ", peerIP='" + this.peerIP + '\'' + ", port=" + this.port + ", socketReused=" + this.socketReused + ", sendBytesCount=" + this.sendBytesCount + ", receivedBytedCount=" + this.receivedBytedCount + '}';
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeLong(this.redirectStart);
            parcel.writeLong(this.redirectEnd);
            parcel.writeLong(this.fetchStart);
            parcel.writeLong(this.domainLookUpStart);
            parcel.writeLong(this.domainLookUpEnd);
            parcel.writeLong(this.connectStart);
            parcel.writeLong(this.connectEnd);
            parcel.writeLong(this.SSLconnectionStart);
            parcel.writeLong(this.SSLconnectionEnd);
            parcel.writeLong(this.requestStart);
            parcel.writeLong(this.requestEnd);
            parcel.writeLong(this.responseStart);
            parcel.writeLong(this.responseEnd);
            parcel.writeString(this.protocol);
            parcel.writeInt(this.rtt);
            parcel.writeInt(this.statusCode);
            parcel.writeInt(this.networkTypeEstimate);
            parcel.writeInt(this.httpRttEstimate);
            parcel.writeInt(this.transportRttEstimate);
            parcel.writeInt(this.downstreamThroughputKbpsEstimate);
            parcel.writeInt(this.throughputKbps);
            parcel.writeString(this.peerIP);
            parcel.writeInt(this.port);
            parcel.writeByte(this.socketReused ? (byte) 1 : 0);
            parcel.writeLong(this.sendBytesCount);
            parcel.writeLong(this.receivedBytedCount);
        }

        public WebPageProfile() {
        }

        protected WebPageProfile(Parcel parcel) {
            this.redirectStart = parcel.readLong();
            this.redirectEnd = parcel.readLong();
            this.fetchStart = parcel.readLong();
            this.domainLookUpStart = parcel.readLong();
            this.domainLookUpEnd = parcel.readLong();
            this.connectStart = parcel.readLong();
            this.connectEnd = parcel.readLong();
            this.SSLconnectionStart = parcel.readLong();
            this.SSLconnectionEnd = parcel.readLong();
            this.requestStart = parcel.readLong();
            this.requestEnd = parcel.readLong();
            this.responseStart = parcel.readLong();
            this.responseEnd = parcel.readLong();
            this.protocol = parcel.readString();
            this.rtt = parcel.readInt();
            this.statusCode = parcel.readInt();
            this.networkTypeEstimate = parcel.readInt();
            this.httpRttEstimate = parcel.readInt();
            this.transportRttEstimate = parcel.readInt();
            this.downstreamThroughputKbpsEstimate = parcel.readInt();
            this.throughputKbps = parcel.readInt();
            this.peerIP = parcel.readString();
            this.port = parcel.readInt();
            this.socketReused = parcel.readByte() != 0;
            this.sendBytesCount = parcel.readLong();
            this.receivedBytedCount = parcel.readLong();
        }
    }

    public static class Config {
        public int AckSlice = 8192;
        public String ApprovedVideoHosts = CdnLogic.defaultApprovedVideoHosts;
        public int C2COverloadDelaySeconds = 10;
        public int EnableCDNVerifyConnect = 1;
        public int EnableCDNVideoRedirectOC = 1;
        public int EnableSafeCDN = 0;
        public int EnableSnsImageDownload = 0;
        public int EnableSnsStreamDownload = 0;
        public int EnableSnsVideoRedirect = 0;
        public int EnableStreamUploadVideo = 1;
        public String MiscellaneousExptValues = "";
        public int MobileEtl = 70;
        public int Ptl = 35;
        public String QuicExptValues = "";
        public int SNSOverloadDelaySeconds = 60;
        public int UseDynamicETL = 0;
        public int UseStreamCDN = 1;
        public int WifiEtl = 90;

        public String toString() {
            return String.format("UseStreamCDN:%d,enableverify:%d,enableoc:%d,enablevideo:%d,c2coverload:%d,snsoverload:%d,safecdn:%d,snsstream:%d, snsimage:%d, snsvideo redirect:%d", Integer.valueOf(this.UseStreamCDN), Integer.valueOf(this.EnableCDNVerifyConnect), Integer.valueOf(this.EnableCDNVideoRedirectOC), Integer.valueOf(this.EnableStreamUploadVideo), Integer.valueOf(this.C2COverloadDelaySeconds), Integer.valueOf(this.SNSOverloadDelaySeconds), Integer.valueOf(this.EnableSafeCDN), Integer.valueOf(this.EnableSnsStreamDownload), Integer.valueOf(this.EnableSnsImageDownload), Integer.valueOf(this.EnableSnsVideoRedirect));
        }
    }

    public static void Initialize(String str, AppCallback appCallback, String str2, String str3, String str4, String str5) {
        Log.i(TAG, "init cdnlogic");
        setAppCallback(appCallback);
        onCreate(s.k(str, true));
        setRSAPublicKeyParams(str2, str3, str4);
        setToUserCiper(str5);
    }

    public static void InitSavePath(String str, AppCallback appCallback) {
        setAppCallback(appCallback);
        onCreate(str);
    }

    public static void UnInitialize() {
        Log.w(TAG, "uninit cdnlogic");
        setAppCallback(null);
    }

    public static int doCertificateVerify(String str, byte[][] bArr) {
        Log.i(TAG, "certifivate verify for %s", str);
        try {
            AndroidCertVerifyResult verifyServerCertificates = X509Util.verifyServerCertificates(bArr, EncryptUtil.KEY_ALGORITHM, str);
            Log.i(TAG, "host %s verify result %d, isknownroots %b", str, Integer.valueOf(verifyServerCertificates.getStatus()), Boolean.valueOf(verifyServerCertificates.isIssuedByKnownRoot()));
            return verifyServerCertificates.getStatus();
        } catch (KeyStoreException e2) {
            Log.e(TAG, e2.getLocalizedMessage());
            return -1;
        } catch (NoSuchAlgorithmException e3) {
            Log.e(TAG, e3.getLocalizedMessage());
            return -1;
        } catch (IllegalArgumentException e4) {
            Log.e(TAG, e4.getLocalizedMessage());
            return -1;
        } catch (Exception e5) {
            Log.e(TAG, e5.getLocalizedMessage());
            return -1;
        }
    }

    public static int isFileReady(String str) {
        if (!new o(str).exists()) {
            return -1;
        }
        Log.i(TAG, "checkFileProperty sdcard state ".concat(String.valueOf(g.getExternalStorageState())));
        int uSBState = getUSBState();
        if (2 != uSBState) {
            return uSBState;
        }
        Log.i(TAG, "checkFileProperty usb is connecting PC");
        return uSBState;
    }

    public static int getUSBState() {
        Intent registerReceiver = MMApplicationContext.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            try {
                return registerReceiver.getIntExtra("plugged", 0);
            } catch (Exception e2) {
                Log.e(TAG, "err:%s", e2.getMessage());
            }
        }
        return -1;
    }

    public static long queryFreeSpace(String str) {
        o oVar = new o(str);
        if (!oVar.isDirectory()) {
            oVar = oVar.heq();
        }
        do {
            long usableSpace = oVar.getUsableSpace();
            if (usableSpace > 0) {
                return usableSpace;
            }
            oVar = oVar.heq();
        } while (oVar != null);
        return 0;
    }

    public static CertVerifyResult doCertificateVerifyWithDetail(String str, byte[][] bArr) {
        Log.i(TAG, "certifivate verify for %s", str);
        try {
            AndroidCertVerifyResult verifyServerCertificates = X509Util.verifyServerCertificates(bArr, EncryptUtil.KEY_ALGORITHM, str);
            CertVerifyResult certVerifyResult = new CertVerifyResult();
            certVerifyResult.status = verifyServerCertificates.getStatus();
            certVerifyResult.isIssuedByKnownRoot = verifyServerCertificates.isIssuedByKnownRoot();
            certVerifyResult.certificateChain = verifyServerCertificates.getCertificateChainEncoded();
            verifyServerCertificates.getCertificateChainEncoded();
            Log.i(TAG, "host %s verify result %d, isknownroots %b", str, Integer.valueOf(verifyServerCertificates.getStatus()), Boolean.valueOf(verifyServerCertificates.isIssuedByKnownRoot()));
            return certVerifyResult;
        } catch (KeyStoreException e2) {
            Log.e(TAG, e2.getLocalizedMessage());
            CertVerifyResult certVerifyResult2 = new CertVerifyResult();
            certVerifyResult2.status = -1;
            return certVerifyResult2;
        } catch (NoSuchAlgorithmException e3) {
            Log.e(TAG, e3.getLocalizedMessage());
            CertVerifyResult certVerifyResult3 = new CertVerifyResult();
            certVerifyResult3.status = -1;
            return certVerifyResult3;
        } catch (IllegalArgumentException e4) {
            Log.e(TAG, e4.getLocalizedMessage());
            CertVerifyResult certVerifyResult4 = new CertVerifyResult();
            certVerifyResult4.status = -1;
            return certVerifyResult4;
        } catch (Exception e5) {
            Log.e(TAG, e5.getLocalizedMessage());
            CertVerifyResult certVerifyResult5 = new CertVerifyResult();
            certVerifyResult5.status = -1;
            return certVerifyResult5;
        }
    }

    public static String getSystemProperty(String str) {
        return System.getProperty(str);
    }
}

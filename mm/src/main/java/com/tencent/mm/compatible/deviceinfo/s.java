package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class s {
    s() {
    }

    public static boolean a(String str, o oVar, c cVar, b bVar, k kVar, aa aaVar, ag agVar, t tVar, y yVar, ad adVar, x xVar, a aVar, x xVar2) {
        AppMethodBeat.i(155743);
        try {
            Log.d("MicroMsg.DeviceInfoParser", "xml: ".concat(String.valueOf(str)));
            Map<String, String> parseXml = XmlParser.parseXml(str, "deviceinfoconfig", null);
            if (parseXml == null) {
                Log.i("MicroMsg.DeviceInfoParser", "hy: null device config");
                AppMethodBeat.o(155743);
                return false;
            }
            if (parseXml.get(".deviceinfoconfig.voip.cpu.armv7") != null) {
                oVar.gHU = Util.getInt(parseXml.get(".deviceinfoconfig.voip.cpu.armv7"), 0);
                oVar.gHT = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.cpu.armv6") != null) {
                oVar.gHV = Util.getInt(parseXml.get(".deviceinfoconfig.voip.cpu.armv6"), 0);
                oVar.gHT = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.num") != null) {
                cVar.gFx = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.num"), 0);
                cVar.gFy = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.surface") != null) {
                cVar.gFz = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.surface"), 0);
                cVar.gFA = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.format") != null) {
                cVar.gFD = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.format"), 0);
                cVar.bik = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.autofloatcamera") != null) {
                cVar.gFB = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.autofloatcamera"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.manufloat") != null) {
                cVar.gFC = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.manufloat"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.back.enable") != null) {
                cVar.gFG.gGn = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.back.enable"), 0);
                cVar.gFH = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.back.fps") != null) {
                cVar.gFG.fps = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.back.fps"), 0);
                cVar.gFH = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.back.orien") != null) {
                cVar.gFG.gGo = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.back.orien"), 0);
                cVar.gFH = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.back.rotate") != null) {
                cVar.gFG.dYT = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.back.rotate"), 0);
                cVar.gFH = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.back.isleft") != null) {
                cVar.gFG.gGp = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.back.isleft"), 0);
                cVar.gFH = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.back.width") != null) {
                cVar.gFG.width = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.back.width"), 0);
                cVar.gFH = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.back.height") != null) {
                cVar.gFG.height = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.back.height"), 0);
                cVar.gFH = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.front.enable") != null) {
                cVar.gFE.gGn = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.front.enable"), 0);
                cVar.gFF = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.front.fps") != null) {
                cVar.gFE.fps = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.front.fps"), 0);
                cVar.gFF = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.front.orien") != null) {
                cVar.gFE.gGo = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.front.orien"), 0);
                cVar.gFF = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.front.rotate") != null) {
                cVar.gFE.dYT = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.front.rotate"), 0);
                cVar.gFF = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.front.isleft") != null) {
                cVar.gFE.gGp = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.front.isleft"), 0);
                cVar.gFF = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.front.width") != null) {
                cVar.gFE.width = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.front.width"), 0);
                cVar.gFF = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.front.height") != null) {
                cVar.gFE.height = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.front.height"), 0);
                cVar.gFF = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.videorecord.frotate") != null) {
                cVar.gFJ = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.videorecord.frotate"), 0);
                cVar.gFI = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.videorecord.forientation") != null) {
                cVar.gFK = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.videorecord.forientation"), 0);
                cVar.gFI = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.videorecord.brotate") != null) {
                cVar.gFL = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.videorecord.brotate"), 0);
                cVar.gFI = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.videorecord.borientation") != null) {
                cVar.gFM = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.videorecord.borientation"), 0);
                cVar.gFI = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.videorecord.num") != null) {
                cVar.gFN = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
                cVar.gFO = true;
                cVar.gFI = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
                cVar.gFQ = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
                cVar.gFP = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold") != null) {
                cVar.gFR = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.scannerImageQuality") != null) {
                cVar.gFS = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.scannerImageQuality"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval") != null) {
                cVar.gGf = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.focusType") != null) {
                cVar.gGg = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.focusType"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.videorecord.num") != null) {
                cVar.gFN = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
                cVar.gFO = true;
                cVar.gFI = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
                cVar.gFQ = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
                cVar.gFP = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.useFixFPSMode") != null) {
                cVar.gFT = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.useFixFPSMode"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.useRangeFPSMode") != null) {
                cVar.gFU = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.useRangeFPSMode"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat") != null) {
                cVar.gFV = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.useMeteringMode") != null) {
                cVar.gFW = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.useMeteringMode"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode") != null) {
                cVar.gFX = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported") != null) {
                cVar.gFY = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.sightCameraID") != null) {
                cVar.gGa = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.sightCameraID"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.needEnhance") != null) {
                cVar.gGb = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.needEnhance"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.support480enc") != null) {
                cVar.gGc = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.support480enc"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.supportHWenc") != null) {
                cVar.gGd = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.supportHWenc"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.voipBeauty") != null) {
                cVar.gGh = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.voipBeauty"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.voipBeautyWhite") != null) {
                cVar.gGi = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.voipBeautyWhite"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.enable720cap") != null) {
                cVar.gGe = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.enable720cap"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.stFilter") != null) {
                cVar.gGj = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.stFilter"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.fpsMin") != null) {
                cVar.gGk = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.fpsMin"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.fpsMax") != null) {
                cVar.gGl = Util.getInt(parseXml.get(".deviceinfoconfig.voip.camera.fpsMax"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.camera.autoRotate") != null) {
                cVar.gGm = Util.getBoolean(parseXml.get(".deviceinfoconfig.voip.camera.autoRotate"), false);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.streamtype") != null) {
                bVar.gDB = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.streamtype"), 0);
                bVar.gDA = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.smode") != null) {
                bVar.gDC = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.smode"), 0);
                bVar.gDA = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.omode") != null) {
                bVar.gDD = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.omode"), 0);
                bVar.gDA = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.ospeaker") != null) {
                bVar.gDE = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.ospeaker"), 0);
                bVar.gDA = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.operating") != null) {
                bVar.gDF = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.operating"), 0);
                bVar.gDA = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.moperating") != null) {
                bVar.gDG = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.moperating"), 0);
                bVar.gDA = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.mstreamtype") != null) {
                bVar.gDH = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.mstreamtype"), 0);
                bVar.gDA = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.recordmode") != null) {
                bVar.gDI = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.recordmode"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
                bVar.gDJ = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.aecmode") != null) {
                bVar.gDK = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.aecmode"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.nsmode") != null) {
                bVar.gDL = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.nsmode"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.volummode") != null) {
                bVar.gDM = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.volummode"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.sourcemode") != null) {
                bVar.gEd = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.sourcemode"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.micmode") != null) {
                bVar.gEc = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.micmode"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.speakerMode") != null) {
                bVar.gEe = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.speakerMode"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.phoneMode") != null) {
                bVar.gEf = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.phoneMode"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType") != null) {
                bVar.gEg = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.speakerstreamtype") != null) {
                bVar.gEh = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.speakerstreamtype"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.phonestreamtype") != null) {
                bVar.gEi = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.phonestreamtype"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.ringphonestream") != null) {
                bVar.gEk = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.ringphonestream"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.ringphonemode") != null) {
                bVar.gEl = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.ringphonemode"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.ringspeakerstream") != null) {
                bVar.gEm = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.ringspeakerstream"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.ringspeakermode") != null) {
                bVar.gEn = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.ringspeakermode"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.aecmodenew") != null) {
                bVar.gEo = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.aecmodenew"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.nsmodenew") != null) {
                bVar.gEp = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.nsmodenew"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.nsModeNewMulti") != null) {
                bVar.gEq = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.nsModeNewMulti"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.voipfullbandcfg") != null) {
                bVar.gEr = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.voipfullbandcfg"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.agcmodenew") != null) {
                bVar.gEs = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.agcmodenew"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.agcmode") != null) {
                bVar.gEt = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.agcmode"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.agctargetdb") != null) {
                bVar.gEu = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.agctargetdb"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.agcgaindb") != null) {
                bVar.gEv = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.agcgaindb"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.agcflag") != null) {
                bVar.gEw = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.agcflag"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.agclimiter") != null) {
                bVar.gEx = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.agclimiter"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.agcCompRatio") != null) {
                bVar.gEy = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.agcCompRatio"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.agcDnGainThr") != null) {
                bVar.gEz = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.agcDnGainThr"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.waveAgcMode") != null) {
                bVar.gEA = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.waveAgcMode"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.waveAgcSpkGain") != null) {
                bVar.gEB = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.waveAgcSpkGain"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.waveAgcPhnGain") != null) {
                bVar.gEC = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.waveAgcPhnGain"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.waveAgcHeadsetGain") != null) {
                bVar.gED = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.waveAgcHeadsetGain"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.waveAgcCRatio") != null) {
                bVar.gEF = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.waveAgcCRatio"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.waveAgcDnTHR") != null) {
                bVar.gEG = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.waveAgcDnTHR"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.waveAgcTarget") != null) {
                bVar.gEE = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.waveAgcTarget"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.waveAgcBase") != null) {
                bVar.gEH = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.waveAgcBase"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.waveAgcGainTHR") != null) {
                bVar.gEI = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.waveAgcGainTHR"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.waveAgcDampTHR") != null) {
                bVar.gEJ = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.waveAgcDampTHR"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.waveAgcDamper") != null) {
                bVar.gEK = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.waveAgcDamper"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.inputvolumescale") != null) {
                bVar.gDN = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.inputvolumescale"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.outputvolumescale") != null) {
                bVar.gDO = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.outputvolumescale"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker") != null) {
                bVar.gDP = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker") != null) {
                bVar.gDQ = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.ehanceheadsetec") != null) {
                bVar.gDX = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.ehanceheadsetec"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset") != null) {
                bVar.gDY = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker") != null) {
                bVar.gDZ = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec") != null) {
                bVar.gEa = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.enablerectimer") != null) {
                bVar.gEL = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.enablerectimer"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.enablePlayTimer") != null) {
                bVar.gEM = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.enablePlayTimer"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof0") != null) {
                bVar.gEO[0] = (short) Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof0"), 0);
                bVar.gEN = 1;
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof1") != null) {
                bVar.gEO[1] = (short) Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof1"), 0);
                bVar.gEN = 1;
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof2") != null) {
                bVar.gEO[2] = (short) Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof2"), 0);
                bVar.gEN = 1;
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof3") != null) {
                bVar.gEO[3] = (short) Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof3"), 0);
                bVar.gEN = 1;
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof4") != null) {
                bVar.gEO[4] = (short) Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof4"), 0);
                bVar.gEN = 1;
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof5") != null) {
                bVar.gEO[5] = (short) Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof5"), 0);
                bVar.gEN = 1;
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof6") != null) {
                bVar.gEO[6] = (short) Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof6"), 0);
                bVar.gEN = 1;
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof7") != null) {
                bVar.gEO[7] = (short) Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof7"), 0);
                bVar.gEN = 1;
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof8") != null) {
                bVar.gEO[8] = (short) Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof8"), 0);
                bVar.gEN = 1;
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof9") != null) {
                bVar.gEO[9] = (short) Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof9"), 0);
                bVar.gEN = 1;
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof10") != null) {
                bVar.gEO[10] = (short) Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof10"), 0);
                bVar.gEN = 1;
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof11") != null) {
                bVar.gEO[11] = (short) Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof11"), 0);
                bVar.gEN = 1;
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof12") != null) {
                bVar.gEO[12] = (short) Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof12"), 0);
                bVar.gEN = 1;
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof13") != null) {
                bVar.gEO[13] = (short) Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof13"), 0);
                bVar.gEN = 1;
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof14") != null) {
                bVar.gEO[14] = (short) Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.correctcof.cof14"), 0);
                bVar.gEN = 1;
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.correctoff") != null && Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.correctoff"), 0) == 1) {
                bVar.gEN = 0;
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone") != null) {
                bVar.gDR = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker") != null) {
                bVar.gDS = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0") != null) {
                bVar.gEP[0] = (short) Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1") != null) {
                bVar.gEP[1] = (short) Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.agcrxflag") != null) {
                bVar.gEZ = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.agcrxflag"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.agcrxtargetdb") != null) {
                bVar.gFa = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.agcrxtargetdb"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.agcrxgaindb") != null) {
                bVar.gFb = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.agcrxgaindb"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.agcrxlimiter") != null) {
                bVar.gFc = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.agcrxlimiter"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.spkecenable") != null) {
                bVar.gER = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.spkecenable"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.enableXnoiseSup") != null) {
                bVar.gEb = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.enableXnoiseSup"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
                bVar.gDJ = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.mt3dFlag") != null) {
                bVar.gFd = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.mt3dFlag"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.mt3dAzim1") != null) {
                bVar.gFe = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.mt3dAzim1"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.mt3dAzim2") != null) {
                bVar.gFf = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.mt3dAzim2"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.mt3dAzim3") != null) {
                bVar.gFg = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.mt3dAzim3"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.mt3dAzim4") != null) {
                bVar.gFh = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.mt3dAzim4"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.mt3dAzim5") != null) {
                bVar.gFi = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.mt3dAzim5"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.mt3dAzim6") != null) {
                bVar.gFj = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.mt3dAzim6"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.mt3dAzim7") != null) {
                bVar.gFk = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.mt3dAzim7"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.mt3dAzim8") != null) {
                bVar.gFl = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.mt3dAzim8"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.mt3dElvl1") != null) {
                bVar.gFm = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.mt3dElvl1"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.mt3dElvl2") != null) {
                bVar.gFn = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.mt3dElvl2"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.mt3dElvl3") != null) {
                bVar.gFo = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.mt3dElvl3"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.mt3dElvl4") != null) {
                bVar.gFp = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.mt3dElvl4"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.mt3dElvl5") != null) {
                bVar.gFq = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.mt3dElvl5"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.mt3dElvl6") != null) {
                bVar.gFr = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.mt3dElvl6"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.mt3dElvl7") != null) {
                bVar.gFs = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.mt3dElvl7"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.mt3dElvl8") != null) {
                bVar.gFt = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.mt3dElvl8"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.forbiddenUseSco") != null) {
                bVar.gDT = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.forbidSco"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.audioForbiddenStrategy") != null) {
                bVar.gDU = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.audioForbiddenStrategy"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.audioForbiddenRefreshTime") != null) {
                bVar.gDV = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.audioForbiddenRefreshTime"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.audioForbiddenRequestTimes") != null) {
                bVar.gDW = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.audioForbiddenRequestTimes"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.mt3dPhi") != null) {
                bVar.gFu = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.mt3dPhi"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.mt3dTheta1") != null) {
                bVar.gFv = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.mt3dTheta1"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.audio.mt3dTheta2") != null) {
                bVar.gFw = Util.getInt(parseXml.get(".deviceinfoconfig.voip.audio.mt3dTheta2"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.ipcall.speakermode") != null) {
                bVar.gET = Util.getInt(parseXml.get(".deviceinfoconfig.voip.ipcall.speakermode"), 0);
                bVar.gES = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.ipcall.phonemode") != null) {
                bVar.gEU = Util.getInt(parseXml.get(".deviceinfoconfig.voip.ipcall.phonemode"), 0);
                bVar.gES = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.ipcall.sourcemode") != null) {
                bVar.gEV = Util.getInt(parseXml.get(".deviceinfoconfig.voip.ipcall.sourcemode"), 0);
                bVar.gES = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.ipcall.streamtype") != null) {
                bVar.gEW = Util.getInt(parseXml.get(".deviceinfoconfig.voip.ipcall.streamtype"), 0);
                bVar.gES = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype") != null) {
                bVar.gEX = Util.getInt(parseXml.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype"), 0);
                bVar.gES = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.ipcall.phonestreamtype") != null) {
                bVar.gEY = Util.getInt(parseXml.get(".deviceinfoconfig.voip.ipcall.phonestreamtype"), 0);
                bVar.gES = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.js") != null) {
                kVar.gGA = true;
                kVar.gGB = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.js"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.js") != null) {
                kVar.gGs = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.js"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.stopbluetoothbr") != null) {
                kVar.gGt = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.stopbluetoothbr"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.stopbluetoothbu") != null) {
                kVar.gGu = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.stopbluetoothbu"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.setbluetoothscoon") != null) {
                kVar.gGw = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.setbluetoothscoon"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.startbluetoothsco") != null) {
                kVar.gGv = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.startbluetoothsco"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.voicesearchfastmode") != null) {
                kVar.gGx = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.voicesearchfastmode"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.pcmreadmode") != null) {
                kVar.gGz = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.pcmreadmode"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.pcmbufferrate") != null) {
                kVar.gGy = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.pcmbufferrate"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.app") != null) {
                kVar.gGC = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.app"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp") != null) {
                kVar.gHg = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns") != null) {
                kVar.gHh = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec") != null) {
                kVar.gHi = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc") != null) {
                kVar.gHj = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.voipnewrenderer") != null) {
                kVar.gHk = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.voipnewrenderer"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.voipUseRemovePreviewCallback") != null) {
                kVar.gHn = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.voipUseRemovePreviewCallback"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.voipUseCameraApi2") != null) {
                kVar.gHo = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.voipUseCameraApi2"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.voipUseNewCameraModular") != null) {
                kVar.gHp = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.voipUseNewCameraModular"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.voipgpurgb2yuv") != null) {
                kVar.gHq = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.voipgpurgb2yuv"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.voipgpucrop") != null) {
                kVar.gHr = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.voipgpucrop"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.groupRs") != null) {
                kVar.gHf = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.groupRs"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.vmfd") != null) {
                kVar.gGD = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.vmfd"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.htcvoicemode") != null) {
                kVar.gGE = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.htcvoicemode"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.samsungvoicemode") != null) {
                kVar.gGF = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.samsungvoicemode"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.speexbufferrate") != null) {
                kVar.gGG = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.speexbufferrate"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.linespe") != null) {
                kVar.gGH = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.linespe"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.fixspan") != null) {
                kVar.gGS = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.fixspan"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.extvideo") != null) {
                kVar.gGI = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.extvideo"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.extvideosam") != null) {
                kVar.gGJ = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.extvideosam"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.sysvideodegree") != null) {
                kVar.gGK = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.sysvideodegree"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.mmnotify") != null) {
                kVar.gGN = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.mmnotify"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.extsharevcard") != null) {
                kVar.gGM = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.extsharevcard"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.audioformat") != null) {
                kVar.gGO = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.audioformat"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.qrcam") != null) {
                kVar.gGP = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.qrcam"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.sysvideofdegree") != null) {
                kVar.gGL = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.sysvideofdegree"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.audioformat") != null) {
                kVar.gGO = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.audioformat"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.qrcam") != null) {
                kVar.gGP = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.qrcam"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.base") != null) {
                kVar.gHs = parseXml.get(".deviceinfoconfig.voip.common.base");
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.packageinfo") != null) {
                kVar.gHt = parseXml.get(".deviceinfoconfig.voip.common.packageinfo");
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.classloader") != null) {
                kVar.gHu = parseXml.get(".deviceinfoconfig.voip.common.classloader");
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.resources") != null) {
                kVar.gHv = parseXml.get(".deviceinfoconfig.voip.common.resources");
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.sysvideofp") != null) {
                kVar.gGQ = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.sysvideofp"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.extstoragedir") != null) {
                kVar.gHw = parseXml.get(".deviceinfoconfig.voip.common.extstoragedir");
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.extpubdir") != null) {
                kVar.gHx = parseXml.get(".deviceinfoconfig.voip.common.extpubdir");
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.extdatadir") != null) {
                kVar.gHy = parseXml.get(".deviceinfoconfig.voip.common.extdatadir");
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.extrootdir") != null) {
                kVar.gHz = parseXml.get(".deviceinfoconfig.voip.common.extrootdir");
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.extstoragestate") != null) {
                kVar.gHA = parseXml.get(".deviceinfoconfig.voip.common.extstoragestate");
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.extcachedir") != null) {
                kVar.gHB = parseXml.get(".deviceinfoconfig.voip.common.extcachedir");
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.extvideoplayer") != null) {
                kVar.gGR = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.extvideoplayer"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.loadDrawable") != null) {
                kVar.gHC = parseXml.get(".deviceinfoconfig.voip.common.loadDrawable");
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.loadXmlResourceParser") != null) {
                kVar.gHD = parseXml.get(".deviceinfoconfig.voip.common.loadXmlResourceParser");
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.sensorNearFar") != null && 1 == Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.sensorNearFar"), 0)) {
                SensorController.sensorNearFar = true;
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio") != null) {
                SensorController.configNearFarDivideRatio = Util.getDouble(parseXml.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio"), 0.0d);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.sightFullType") != null) {
                kVar.gHE = parseXml.get(".deviceinfoconfig.voip.common.sightFullType");
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.slyTextureView") != null) {
                kVar.gHF = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.slyTextureView"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.checkSightDraftMd5") != null) {
                kVar.gHG = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.checkSightDraftMd5"), 1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.swipeBackConfig") != null) {
                kVar.gHH = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.swipeBackConfig"), 1);
                b.du(kVar.gHH == 1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.canDecodeWebp") != null) {
                kVar.gHI = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.canDecodeWebp"), 1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.isScanZoom") != null) {
                kVar.gGT = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.isScanZoom"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio") != null) {
                kVar.gGU = Util.getDouble(parseXml.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio"), -1.0d);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.notificationSetMode") != null) {
                kVar.gHJ = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.notificationSetMode"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.hevcTransCodeMediaCodec") != null) {
                kVar.gHK = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.hevcTransCodeMediaCodec"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.videoSupportHevcDecode") != null) {
                kVar.gHL = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.videoSupportHevcDecode"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.checkOnPauseWindowsFocus") != null) {
                kVar.gHM = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.checkOnPauseWindowsFocus"), 1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.vcodec1MaxEncRes") != null) {
                kVar.gGV = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.vcodec1MaxEncRes"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.vcodec2MaxEncRes") != null) {
                kVar.gGW = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.vcodec2MaxEncRes"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.hw264MaxEncRes") != null) {
                kVar.gGX = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.hw264MaxEncRes"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.hw265MaxEncRes") != null) {
                kVar.gGY = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.hw265MaxEncRes"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.vcodec1MixMaxEncRes") != null) {
                kVar.gGZ = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.vcodec1MixMaxEncRes"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.vcodec1MaxDecRes") != null) {
                kVar.gHa = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.vcodec1MaxDecRes"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.vcodec2MaxDecRes") != null) {
                kVar.gHb = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.vcodec2MaxDecRes"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.hw264MaxDecRes") != null) {
                kVar.gHc = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.hw264MaxDecRes"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.hw265MaxDecRes") != null) {
                kVar.gHd = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.hw265MaxDecRes"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.common.vcodec1MaxDecRes") != null) {
                kVar.gHe = Util.getInt(parseXml.get(".deviceinfoconfig.voip.common.vcodec1MixMaxDecRes"), -1);
            }
            if (parseXml.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo") != null) {
                aaVar.gKa = Util.getInt(parseXml.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo"), 0) == 1;
            }
            if (parseXml.get(".deviceinfoconfig.voip.mediaRecorder.width") != null) {
                aaVar.mVideoWidth = Util.getInt(parseXml.get(".deviceinfoconfig.voip.mediaRecorder.width"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.mediaRecorder.height") != null) {
                aaVar.mVideoHeight = Util.getInt(parseXml.get(".deviceinfoconfig.voip.mediaRecorder.height"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.mediaRecorder.frameRate") != null) {
                aaVar.gKb = Util.getInt(parseXml.get(".deviceinfoconfig.voip.mediaRecorder.frameRate"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate") != null) {
                aaVar.gKc = Util.getInt(parseXml.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.mediaRecorder.useSystem") != null) {
                aaVar.gKd = Util.getInt(parseXml.get(".deviceinfoconfig.voip.mediaRecorder.useSystem"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek") != null) {
                aaVar.gKe = Util.getInt(parseXml.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC") != null) {
                aaVar.gKf = Util.getInt(parseXml.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate") != null) {
                aaVar.gKg = Util.getInt(parseXml.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera") != null) {
                aaVar.gKh = Util.getInt(parseXml.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.mediaRecorder.useFDWithFileSize") != null) {
                aaVar.gKi = Util.getInt(parseXml.get(".deviceinfoconfig.voip.mediaRecorder.useFDWithFileSize"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.voip.webview.notifythread") != null) {
                agVar.gKI = Util.getInt(parseXml.get(".deviceinfoconfig.voip.webview.notifythread"), 0) == 1;
            }
            if (parseXml.get(".deviceinfoconfig.voip.webview.forceUseSysWebView") != null) {
                agVar.gKJ = Util.getInt(parseXml.get(".deviceinfoconfig.voip.webview.forceUseSysWebView"), 0) == 1;
                Log.i("MicroMsg.DeviceInfoParser", "save forceusesystemwebview = %b", Boolean.valueOf(agVar.gKJ));
                MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit().putBoolean("tbs_force_user_sys_webview", agVar.gKJ).commit();
            }
            kVar.dump();
            int i2 = Util.getInt(parseXml.get(".deviceinfoconfig.fingerprint.forceFingerprintStatus"), 0);
            int i3 = Util.getInt(parseXml.get(".deviceinfoconfig.fingerprint.supportExportEntrance"), 0);
            Log.i("MicroMsg.DeviceInfoParser", "hy: got fingerprint force status: %d", Integer.valueOf(i2));
            if (tVar != null) {
                tVar.ox(i2);
                tVar.ow(i3);
            }
            int i4 = Util.getInt(parseXml.get(".deviceinfoconfig.soter.isSupport"), 0);
            Log.i("MicroMsg.DeviceInfoParser", "hy: get soter status: %d", Integer.valueOf(i4));
            if (adVar != null) {
                adVar.dt(i4 > 0);
                adVar.oB(i4);
            }
            if (i2 == 11 && i3 == 11 && adVar != null) {
                tVar.ox(1);
                tVar.ow(1);
                adVar.dt(true);
                adVar.oB(1);
                adVar.apf();
                Log.i("MicroMsg.DeviceInfoParser", "py: hw patch is available now!");
            }
            String str2 = parseXml.get(".deviceinfoconfig.freeWifi.operations.bizUserName");
            Log.i("MicroMsg.DeviceInfoParser", "lm: got PublicNum: %s", str2);
            if (yVar != null) {
                yVar.DY(str2);
            }
            Map<String, String> parseXml2 = XmlParser.parseXml(str, "manufacturerName", null);
            Log.i("MicroMsg.DeviceInfoParser", "lm: got manufacturerNameMaps: %s", parseXml2);
            if (yVar != null) {
                yVar.r(parseXml2);
            }
            int i5 = Util.getInt(parseXml.get(".deviceinfoconfig.style.swipback"), 0);
            Log.i("MicroMsg.DeviceInfoParser", "lm: got swipback: %d", Integer.valueOf(i5));
            if (yVar != null) {
                yVar.oy(i5);
            }
            int i6 = Util.getInt(parseXml.get(".deviceinfoconfig.game.isLimit"), 0);
            String str3 = parseXml.get(".deviceinfoconfig.game.limitPrompt");
            Log.i("MicroMsg.DeviceInfoParser", "lm: get game status: %d,gamePrompt:%s", Integer.valueOf(i6), str3);
            if (aVar != null) {
                aVar.dq(i6 == 1);
                aVar.DR(str3);
            }
            if (parseXml.get(".deviceinfoconfig.debug.screenCast") != null) {
                kVar.gHl = Util.getInt(parseXml.get(".deviceinfoconfig.debug.screenCast"), 0);
            }
            if (parseXml.get(".deviceinfoconfig.debug.blackBoardProjectDebug") != null) {
                kVar.gHm = Util.getInt(parseXml.get(".deviceinfoconfig.debug.blackBoardProjectDebug"), 0);
            }
            int i7 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.recordertype"), -1);
            int i8 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.needRotateEachFrame"), -1);
            int i9 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.enableHighResolutionRecord"), -1);
            int i10 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.landscapeRecordModeEnable"), -1);
            int i11 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.transcodeDecoderType"), -1);
            int i12 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.mediaPlayerType"), -1);
            int i13 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.strategyMask"), -1);
            int i14 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.recorderOption"), -1);
            int i15 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.useMetering"), -1);
            int i16 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.transcodeEncoderType"), -1);
            int i17 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.checkSendVideoBitrate"), -1);
            int i18 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.cpuCrop"), -1);
            int i19 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.storyRecorderType"), -1);
            int i20 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.backgroundRemux"), -1);
            int i21 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.emojiPreviewSize"), -1);
            int i22 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.emojiStickerSampleSize"), -1);
            int i23 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.emojiUseSmallModel"), -1);
            int i24 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.emojiUseGpuSegment"), -1);
            int i25 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.c2cRemuxUseSoftEncode"), -1);
            int i26 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.snsRemuxUseSoftEncode"), -1);
            int i27 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.takePhotoAlignType"), -1);
            int i28 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.nativeToThumb"), -1);
            int i29 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.HWQPCfg"), -1);
            int i30 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.useCameraApi2"), -1);
            int i31 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.fullFuncApi2"), -1);
            int i32 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.camera2UseRecordStream"), -1);
            int i33 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.vendorCameraEffectSupported"), -1);
            int i34 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.useImageStreamCapture"), -1);
            int i35 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.useRenderScriptCropImage"), -1);
            int i36 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.isVendorDebugModeSupported"), -1);
            int i37 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.captureC2CHwHevcEncodeEnable"), -1);
            int i38 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.captureSNSHwHevcEncodeEnable"), -1);
            int i39 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.captureC2CSwHevcEncodeEnable"), -1);
            int i40 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.captureSNSSwHevcEncodeEnable"), -1);
            int i41 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.remuxC2CHwHevcEncodeEnable"), -1);
            int i42 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.remuxSNSHwHevcEncodeEnable"), -1);
            int i43 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.remuxC2CSwHevcEncodeEnable"), -1);
            int i44 = Util.getInt(parseXml.get(".deviceinfoconfig.mmsight.remuxSNSSwHevcEncodeEnable"), -1);
            if (xVar != null) {
                xVar.gIP = i7;
                xVar.gIQ = i8;
                xVar.gIR = i9;
                xVar.gIS = i10;
                xVar.gIT = i11;
                xVar.gIU = i12;
                xVar.gIV = i13;
                xVar.gIW = i14;
                xVar.gIX = i15;
                xVar.gIY = i16;
                xVar.gIZ = i17;
                xVar.gJc = i21;
                xVar.gJd = i22;
                xVar.gJe = i23;
                xVar.gJf = i24;
                xVar.gJn = i25;
                xVar.gJo = i26;
                xVar.gJq = i27;
                xVar.gJr = i28;
                xVar.gJp = i29;
                xVar.gJg = i30;
                xVar.gJi = i31;
                xVar.gJh = i32;
                xVar.gJj = i33;
                xVar.gJk = i34;
                xVar.gJl = i35;
                xVar.gJm = i36;
                xVar.gJs = i37;
                xVar.gJt = i38;
                xVar.gJu = i39;
                xVar.gJv = i40;
                xVar.gJw = i41;
                xVar.gJx = i42;
                xVar.gJy = i43;
                xVar.gJz = i44;
                Log.i("MicroMsg.DeviceInfoParser", "get mmSightRecorderInfo: %s", xVar.toString());
            }
            if (xVar2 != null) {
                xVar2.gIP = i19;
                xVar2.gIQ = i8;
                xVar2.gIR = i9;
                xVar2.gIS = i10;
                xVar2.gIT = i11;
                xVar2.gIU = i12;
                xVar2.gIV = i13;
                xVar2.gIW = i14;
                xVar2.gIX = i15;
                xVar2.gIY = i16;
                xVar2.gIZ = i17;
                xVar2.gJa = i18;
                xVar2.gJb = i20;
                Log.i("MicroMsg.DeviceInfoParser", "get mmStoryRecorderInfo: %s", xVar2.toString());
            }
            AppMethodBeat.o(155743);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.DeviceInfoParser", e2, "", new Object[0]);
            AppMethodBeat.o(155743);
            return false;
        }
    }
}

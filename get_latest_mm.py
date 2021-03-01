import json
import re
from pathlib import Path

import requests

url = "https://weixin.qq.com/cgi-bin/readtemplate?uin=&stype=&promote=&fr=&lang=zh_CN&ADTAG=&check=false&t=weixin_download_method&sys=android&loc=weixin,android,web,0"
get = requests.get(url, verify=False)
text = get.text

pattern = re.search('(?<=https://dldir1.qq.com/weixin/android/).*?(?=.apk)', text, re.M | re.I)

version = pattern.group()

mm_version_file = 'mm.version'
data = {}
mm_version = Path('./%s' % mm_version_file)
if mm_version.is_file():
    with open('mm.version', 'r') as f:
        data = f.readline()
    data = json.loads(data)
    load_version = data['version']
    if mm_version <= load_version:
        exit()

r = requests.get("https://dldir1.qq.com/weixin/android/" + version + ".apk")

with open('{}.apk'.format(version), 'wb') as f:
    f.write(r.content)

data = {
    'version': version
}
data = json.dumps(data)
with open('%s' % mm_version_file, 'w') as f:
    f.write(data.encode())

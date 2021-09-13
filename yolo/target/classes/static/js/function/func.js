function createXHR() {
    if (typeof XMLHttpRequest != 'undefined') {
        return new XMLHttpRequest();
    } else if (typeof ActiveXObject != 'undefined') {
        var version = [
            'MSXML2.XMLHttp.6.0',
            'MSXML2.XMLHttp.3.0',
            'MSXML2.XMLHttp'
        ];
        for (var i = 0; version.length; i++) {
            try {
                return new ActiveXObject(version[i]);
            } catch (e) {
                throw new Error();
            }
        }
    } else{
        throw new Error('系统或浏览器不支持XHR对象');
    }
}


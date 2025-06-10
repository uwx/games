var programInfo = [];
function newparticle() {
    return {
        loaded: 0,
        x: 0,
        y: 0,
        z: 0,
        mat: null,
        ni: 0,
        alpha: false,
        vbuf: null,
        cbuf: null,
        ibuf: null
    };
}
function loadparticle(file, rad) {
    rad.loaded = 0;
    var rawFile = new XMLHttpRequest();
    rawFile.open("GET", file, true);
    rawFile.onreadystatechange = function () {
        if (rawFile.readyState === 4) {
            if (rawFile.status === 200 || rawFile.status == 0) {
                var allText = rawFile.responseText;
                var readlines = allText.split('\n');
                var indice = [];
                var vert = [];
                var gradetyp = 0;
                var cgr = [255, 255, 0, 255, 255, 0, 0, 255];
                var scale = 1;
                var mid = [0, 0, 0];
                for (var i = 0; i < readlines.length; i++) {
                    var line = readlines[i].trim();
                    if (strtsWith(line, "scale")) {
                        scale = getFloatValue("scale", line, 0);
                    }
                    if (strtsWith(line, "midx")) {
                        mid[0] = (getFloatValue("midx", line, 0) * scale);
                    }
                    if (strtsWith(line, "midy")) {
                        mid[1] = (getFloatValue("midy", line, 0) * scale);
                    }
                    if (strtsWith(line, "midz")) {
                        mid[2] = (getFloatValue("midz", line, 0) * scale);
                    }
                    if (strtsWith(line, "enableAlpha()")) {
                        rad.alpha = true;
                    }
                    if (strtsWith(line, "xgrade")) {
                        gradetyp = 0;
                        for (var k = 0; k < 8; k++) {
                            cgr[k] = getIntValue("xgrade", line, k);
                        }
                    }
                    if (strtsWith(line, "ygrade")) {
                        gradetyp = 1;
                        for (var k = 0; k < 8; k++) {
                            cgr[k] = getIntValue("ygrade", line, k);
                        }
                    }
                    if (strtsWith(line, "zgrade")) {
                        gradetyp = 2;
                        for (var k = 0; k < 8; k++) {
                            cgr[k] = getIntValue("zgrade", line, k);
                        }
                    }
                    if (strtsWith(line, "cphigh")) {
                        gradetyp = 3;
                        for (var k = 0; k < 8; k++) {
                            cgr[k] = getIntValue("cphigh", line, k);
                        }
                    }
                    if (strtsWith(line, "fixpoint")) {
                        gradetyp = 4;
                        for (var k = 0; k < 12; k++) {
                            cgr[k] = getIntValue("fixpoint", line, k);
                        }
                    }
                    if (line.indexOf("v(") != -1) {
                        line = line.substring(2, line.indexOf(")v"));
                        vert = line.split(',');
                    }
                    if (line.indexOf("p(") != -1) {
                        line = line.substring(2, line.indexOf(")p"));
                        indice = line.split(',');
                    }
                }
                rad.ni = indice.length;
                if (scale != 1) {
                    for (var i = 0; i < vert.length; i++) {
                        vert[i] *= scale;
                    }
                }
                rad.vbuf = gl.createBuffer();
                gl.bindBuffer(gl.ARRAY_BUFFER, rad.vbuf);
                gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(vert), gl.STATIC_DRAW);
                var col = [];
                for (var i = 0; i < (vert.length / 3); i++) {
                    var shf = 0;
                    if (gradetyp <= 2) {
                        if (vert[((i * 3) + gradetyp)] < mid[gradetyp]) {
                            shf = 4;
                        }
                    }
                    if (gradetyp == 3) {
                        if (i == 2 || i == 5) {
                            shf = 4;
                        }
                    }
                    if (gradetyp == 4) {
                        var dist = Math.sqrt((vert[(i * 3)] * vert[(i * 3)]) + (vert[((i * 3) + 1)] * vert[((i * 3) + 1)]) + (vert[((i * 3) + 2)] * vert[((i * 3) + 2)]));
                        if (dist < 66) {
                            shf = 4;
                        }
                        if (dist < 62) {
                            shf = 8;
                        }
                    }
                    for (var k = 0; k < 4; k++) {
                        col[((i * 4) + k)] = (cgr[(shf + k)] / 255);
                    }
                }
                rad.cbuf = gl.createBuffer();
                gl.bindBuffer(gl.ARRAY_BUFFER, rad.cbuf);
                gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(col), gl.STATIC_DRAW);
                rad.ibuf = gl.createBuffer();
                gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, rad.ibuf);
                gl.bufferData(gl.ELEMENT_ARRAY_BUFFER, new Uint16Array(indice), gl.STATIC_DRAW);
                rad.mat = mat4.create();
                rad.loaded = 1;
            }
        }
    };
    rawFile.send(null);
}
function newrad3D() {
    return {
        loaded: 0,
        x: 0,
        y: 0,
        z: 0,
        colrad: 0,
        mat: null,
        ont: 0,
        ni: 0,
        nt: 0,
        altscale: 1,
        alpha: false,
        ownlight: false,
        ownshade: false,
        tri: null,
        vrt: null,
        nrm: null,
        tex: null,
        dvrt: null,
        vbuf: null,
        nbuf: null,
        tbuf: null,
        ibuf: null,
        texture: null
    };
}
function loadrad3D(file, rad) {
    rad.loaded = 0;
    var rawFile = new XMLHttpRequest();
    rawFile.open("GET", file, true);
    rawFile.onreadystatechange = function () {
        if (rawFile.readyState === 4) {
            if (rawFile.status === 200 || rawFile.status == 0) {
                var allText = rawFile.responseText;
                var readlines = allText.split('\n');
                var texufile = [];
                texufile[0] = "none";
                var bcr = 128,
                bcg = 128,
                bcb = 128,
                bca = 255;
                var scale = 1;
                for (var i = 0; i < readlines.length; i++) {
                    var line = readlines[i].trim();
                    if (strtsWith(line, "scale")) {
                        scale = getFloatValue("scale", line, 0);
                    }
                    if (strtsWith(line, "enableAlpha()")) {
                        rad.alpha = true;
                    }
                    if (strtsWith(line, "ownLight()")) {
                        rad.ownlight = true;
                    }
                    if (strtsWith(line, "ownShade()")) {
                        rad.ownshade = true;
                    }
                    if (strtsWith(line, "texture")) {
                        texufile[rad.nt] = getStringValue("texture", line, 0);
                        if (rad.nt == 0) {
                            bcr = getIntValue("texture", line, 1);
                            bcg = getIntValue("texture", line, 2);
                            bcb = getIntValue("texture", line, 3);
                            bca = getIntValue("texture", line, 4);
                        }
                        rad.nt++;
                    }
                    if (line.indexOf("v(") != -1) {
                        line = line.substring(2, line.indexOf(")v"));
                        rad.vrt = line.split(',');
                    }
                    if (line.indexOf("n(") != -1) {
                        line = line.substring(2, line.indexOf(")n"));
                        rad.nrm = line.split(',');
                    }
                    if (line.indexOf("t(") != -1) {
                        line = line.substring(2, line.indexOf(")t"));
                        rad.tex = line.split(',');
                    }
                    if (line.indexOf("p(") != -1) {
                        line = line.substring(2, line.indexOf(")p"));
                        rad.tri = line.split(',');
                    }
                }
                rad.ni = (rad.tri.length / 3);
                scale *= rad.altscale;
                if (scale != 1) {
                    for (var i = 0; i < rad.vrt.length; i++) {
                        rad.vrt[i] *= scale;
                    }
                }
                if (rad.nt == 0) {
                    rad.nt = 1;
                }
                var indice = [];
                var vert = [];
                var norm = [];
                var texu = [];
                for (var i = 0; i < rad.ni; i++) {
                    indice[i] = i;
                    vert[(i * 3)] = rad.vrt[(rad.tri[(i * 3)] * 3)];
                    vert[((i * 3) + 1)] = rad.vrt[((rad.tri[(i * 3)] * 3) + 1)];
                    vert[((i * 3) + 2)] = rad.vrt[((rad.tri[(i * 3)] * 3) + 2)];
                    var tcrad = Math.sqrt((vert[(i * 3)] * vert[(i * 3)]) + (vert[((i * 3) + 1)] * vert[((i * 3) + 1)]) + (vert[((i * 3) + 2)] * vert[((i * 3) + 2)]));
                    if (tcrad > rad.colrad) {
                        rad.colrad = tcrad;
                    }
                    if ((!rad.ownlight) && (!rad.ownshade)) {
                        norm[(i * 3)] = rad.nrm[(rad.tri[((i * 3) + 1)] * 3)];
                        norm[((i * 3) + 1)] = rad.nrm[((rad.tri[((i * 3) + 1)] * 3) + 1)];
                        norm[((i * 3) + 2)] = rad.nrm[((rad.tri[((i * 3) + 1)] * 3) + 2)];
                    }
                    texu[(i * 2)] = rad.tex[(rad.tri[((i * 3) + 2)] * 2)];
                    texu[((i * 2) + 1)] = (1 - rad.tex[((rad.tri[((i * 3) + 2)] * 2) + 1)]);
                }
                rad.vbuf = gl.createBuffer();
                gl.bindBuffer(gl.ARRAY_BUFFER, rad.vbuf);
                gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(vert), gl.STATIC_DRAW);
                if ((!rad.ownlight) && (!rad.ownshade)) {
                    rad.nbuf = gl.createBuffer();
                    gl.bindBuffer(gl.ARRAY_BUFFER, rad.nbuf);
                    gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(norm), gl.STATIC_DRAW);
                }
                rad.tbuf = gl.createBuffer();
                gl.bindBuffer(gl.ARRAY_BUFFER, rad.tbuf);
                gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(texu), gl.STATIC_DRAW);
                rad.ibuf = gl.createBuffer();
                gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, rad.ibuf);
                gl.bufferData(gl.ELEMENT_ARRAY_BUFFER, new Uint16Array(indice), gl.STATIC_DRAW);
                if (rad.nt == 1) {
                    rad.texture = gl.createTexture();
                    gl.bindTexture(gl.TEXTURE_2D, rad.texture);
                } else {
                    rad.texture = [];
                    rad.texture[0] = gl.createTexture();
                    gl.bindTexture(gl.TEXTURE_2D, rad.texture[0]);
                }
                var pixel = new Uint8Array([bcr, bcg, bcb, bca]);
                gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, 1, 1, 0, gl.RGBA, gl.UNSIGNED_BYTE, pixel);
                rad.loaded = 1;
                if (texufile[0] != "none") {
                    if (rad.nt == 1) {
                        var image = new Image();
                        image.onload = function () {
                            gl.bindTexture(gl.TEXTURE_2D, rad.texture);
                            gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, gl.RGBA, gl.UNSIGNED_BYTE, image);
                            if (isPowerOf2(image.width) && isPowerOf2(image.height)) {
                                gl.generateMipmap(gl.TEXTURE_2D);
                            } else {
                                gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_S, gl.CLAMP_TO_EDGE);
                                gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_T, gl.CLAMP_TO_EDGE);
                                gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MIN_FILTER, gl.LINEAR);
                            }
                            rad.loaded++;
                        };
                        image.src = texufile[0];
                    } else {
                        var image0 = new Image();
                        image0.onload = function () {
                            rad.texture[0] = gl.createTexture();
                            gl.bindTexture(gl.TEXTURE_2D, rad.texture[0]);
                            gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, gl.RGBA, gl.UNSIGNED_BYTE, image0);
                            if (isPowerOf2(image0.width) && isPowerOf2(image0.height)) {
                                gl.generateMipmap(gl.TEXTURE_2D);
                            } else {
                                gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_S, gl.CLAMP_TO_EDGE);
                                gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_T, gl.CLAMP_TO_EDGE);
                                gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MIN_FILTER, gl.LINEAR);
                            }
                            rad.loaded++;
                        };
                        image0.src = texufile[0];
                        var image1 = new Image();
                        image1.onload = function () {
                            rad.texture[1] = gl.createTexture();
                            gl.bindTexture(gl.TEXTURE_2D, rad.texture[1]);
                            gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, gl.RGBA, gl.UNSIGNED_BYTE, image1);
                            if (isPowerOf2(image1.width) && isPowerOf2(image1.height)) {
                                gl.generateMipmap(gl.TEXTURE_2D);
                            } else {
                                gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_S, gl.CLAMP_TO_EDGE);
                                gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_T, gl.CLAMP_TO_EDGE);
                                gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MIN_FILTER, gl.LINEAR);
                            }
                            rad.loaded++;
                        };
                        image1.src = texufile[1];
                        if (rad.nt > 2) {
                            var image2 = new Image();
                            image2.onload = function () {
                                rad.texture[2] = gl.createTexture();
                                gl.bindTexture(gl.TEXTURE_2D, rad.texture[2]);
                                gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, gl.RGBA, gl.UNSIGNED_BYTE, image2);
                                if (isPowerOf2(image2.width) && isPowerOf2(image2.height)) {
                                    gl.generateMipmap(gl.TEXTURE_2D);
                                } else {
                                    gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_S, gl.CLAMP_TO_EDGE);
                                    gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_T, gl.CLAMP_TO_EDGE);
                                    gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MIN_FILTER, gl.LINEAR);
                                }
                                rad.loaded++;
                            };
                            image2.src = texufile[2];
                        }
                        if (rad.nt > 3) {
                            var image3 = new Image();
                            image3.onload = function () {
                                rad.texture[3] = gl.createTexture();
                                gl.bindTexture(gl.TEXTURE_2D, rad.texture[3]);
                                gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, gl.RGBA, gl.UNSIGNED_BYTE, image3);
                                if (isPowerOf2(image3.width) && isPowerOf2(image3.height)) {
                                    gl.generateMipmap(gl.TEXTURE_2D);
                                } else {
                                    gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_S, gl.CLAMP_TO_EDGE);
                                    gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_T, gl.CLAMP_TO_EDGE);
                                    gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MIN_FILTER, gl.LINEAR);
                                }
                                rad.loaded++;
                            };
                            image3.src = texufile[3];
                        }
                        if (rad.nt > 4) {
                            var image4 = new Image();
                            image4.onload = function () {
                                rad.texture[4] = gl.createTexture();
                                gl.bindTexture(gl.TEXTURE_2D, rad.texture[4]);
                                gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, gl.RGBA, gl.UNSIGNED_BYTE, image4);
                                if (isPowerOf2(image4.width) && isPowerOf2(image4.height)) {
                                    gl.generateMipmap(gl.TEXTURE_2D);
                                } else {
                                    gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_S, gl.CLAMP_TO_EDGE);
                                    gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_T, gl.CLAMP_TO_EDGE);
                                    gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MIN_FILTER, gl.LINEAR);
                                }
                                rad.loaded++;
                            };
                            image4.src = texufile[4];
                        }
                        if (rad.nt > 5) {
                            var image5 = new Image();
                            image5.onload = function () {
                                rad.texture[5] = gl.createTexture();
                                gl.bindTexture(gl.TEXTURE_2D, rad.texture[5]);
                                gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, gl.RGBA, gl.UNSIGNED_BYTE, image5);
                                if (isPowerOf2(image5.width) && isPowerOf2(image5.height)) {
                                    gl.generateMipmap(gl.TEXTURE_2D);
                                } else {
                                    gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_S, gl.CLAMP_TO_EDGE);
                                    gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_T, gl.CLAMP_TO_EDGE);
                                    gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MIN_FILTER, gl.LINEAR);
                                }
                                rad.loaded++;
                            };
                            image5.src = texufile[5];
                        }
                    }
                } else {
                    rad.loaded++;
                }
                rad.mat = mat4.create();
            }
        }
    };
    rawFile.send(null);
}
function genterrain(sed, rot, rad) {
    seed = sed;
    if (rad.loaded) {
        rad.loaded = 0;
        gl.deleteBuffer(rad.vbuf);
        rad.vbuf = null;
        gl.deleteBuffer(rad.tbuf);
        rad.tbuf = null;
        gl.deleteBuffer(rad.ibuf);
        rad.ibuf = null;
        gl.deleteTexture(rad.texture);
        rad.texture = null;
    }
    rad.ownshade = true;
    var rocky = false;
    if (mrandom() > mrandom()) {
        rocky = true;
    }
    var wid = Math.floor(6 + (mrandom() * 14));
    var hid = Math.floor(6 + (mrandom() * 14));
    var varw = (4 + (mrandom() * 2));
    var varh = (4 + (mrandom() * 2));
    var mxs = Math.floor((wid * 0.2667) * mrandom());
    var mxe = Math.floor((wid * 0.2667) * mrandom());
    var mzs = Math.floor((hid * 0.2667) * mrandom());
    var mze = Math.floor((hid * 0.2667) * mrandom());
    var nxs = Math.floor((wid * 0.2667) * mrandom());
    var nxe = Math.floor((wid * 0.2667) * mrandom());
    var nzs = Math.floor((hid * 0.2667) * mrandom());
    var nze = Math.floor((hid * 0.2667) * mrandom());
    var maxx = 0;
    var minx = 0;
    var maxz = 0;
    var minz = 0;
    var rx = [];
    var rz = [];
    var ry = [];
    var maxdist = Math.sqrt((((wid * varw * 0.5) + (varw * 0.5)) * ((wid * varw * 0.5) + (varw * 0.5))) + (((hid * varh * 0.5) + (varh * 0.5)) * ((hid * varh * 0.5) + (varh * 0.5))));
    var flxr = Math.sqrt(((varw * varw * 10) / wid) + ((varh * varh * 10) / hid));
    flxr = ((flxr * 1.2) + (flxr * mrandom() * 2.7));
    for (var i = 0; i < wid; i++) {
        rx[i] = [];
        rz[i] = [];
        ry[i] = [];
        for (var j = 0; j < hid; j++) {
            rx[i][j] = ((varw * i) - (wid * varw * 0.5) + (varw * 0.5) - (mrandom() * varw));
            rz[i][j] = ((varh * j) - (hid * varh * 0.5) + (varh * 0.5) - (mrandom() * varh));
            var ong = false;
            if (i == 0) {
                ong = true;
            }
            if (j == 0) {
                ong = true;
            }
            if (j == (hid - 1)) {
                ong = true;
            }
            if (i == (wid - 1)) {
                ong = true;
            }
            if ((j == 1) && ((i - 1) <= mxs || (i + 1) >= (wid - mxe - 1))) {
                ong = true;
            }
            if ((i == 1) && ((j - 1) <= mzs || (j + 1) >= (hid - mze - 1))) {
                ong = true;
            }
            if ((j == (hid - 2)) && ((i - 1) <= nxs || (i + 1) >= (wid - nxe - 1))) {
                ong = true;
            }
            if ((i == (wid - 2)) && ((j - 1) <= nzs || (j + 1) >= (hid - nze - 1))) {
                ong = true;
            }
            ry[i][j] = 0;
            if (!ong) {
                var vdist = Math.sqrt((rx[i][j] * rx[i][j]) + (rz[i][j] * rz[i][j]));
                if (rocky) {
                    ry[i][j] = ((1 - (vdist / maxdist)) * (flxr + (flxr * mrandom() * 0.5)));
                    if (ry[i][j] < 0) {
                        ry[i][j] = 0;
                    }
                } else {
                    ry[i][j] = ((1 - (vdist / maxdist)) * (1 - (vdist / maxdist)) * (flxr + (flxr * mrandom() * 0.5)));
                    if (ry[i][j] < 0) {
                        ry[i][j] = 0;
                    }
                }
            }
            if (rx[i][j] > maxx) {
                maxx = rx[i][j];
            }
            if (rx[i][j] < minx) {
                minx = rx[i][j];
            }
            if (rz[i][j] > maxz) {
                maxz = rz[i][j];
            }
            if (rz[i][j] < minz) {
                minz = rz[i][j];
            }
        }
    }
    var texu = [];
    rad.vrt = [];
    rad.nrm = [];
    rad.tri = [];
    var nv = 0;
    var nm = 0;
    var at = 0;
    for (var i = 0; i < (wid - 1); i++) {
        for (var j = 0; j < (hid - 1); j++) {
            var nogo = false;
            if ((j == 0) && (i <= mxs || i >= (wid - mxe - 2))) {
                nogo = true;
            }
            if ((i == 0) && (j <= mzs || j >= (hid - mze - 2))) {
                nogo = true;
            }
            if ((j == (hid - 2)) && (i <= nxs || i >= (wid - nxe - 2))) {
                nogo = true;
            }
            if ((i == (wid - 2)) && (j <= nzs || j >= (hid - nze - 2))) {
                nogo = true;
            }
            if (!nogo) {
                var vex = [];
                var vez = [];
                var vey = [];
                if ((i < (wid * 0.5)) && (j < (hid * 0.5))) {
                    vex[0] = rx[i][j];
                    vez[0] = rz[i][j];
                    vey[0] = ry[i][j];
                    vex[1] = rx[i][(j + 1)];
                    vez[1] = rz[i][(j + 1)];
                    vey[1] = ry[i][(j + 1)];
                    vex[2] = rx[(i + 1)][(j + 1)];
                    vez[2] = rz[(i + 1)][(j + 1)];
                    vey[2] = ry[(i + 1)][(j + 1)];
                }
                if ((i >= (wid * 0.5)) && (j < (hid * 0.5))) {
                    vex[2] = rx[i][j];
                    vez[2] = rz[i][j];
                    vey[2] = ry[i][j];
                    vex[1] = rx[(i + 1)][j];
                    vez[1] = rz[(i + 1)][j];
                    vey[1] = ry[(i + 1)][j];
                    vex[0] = rx[i][(j + 1)];
                    vez[0] = rz[i][(j + 1)];
                    vey[0] = ry[i][(j + 1)];
                }
                if ((i < (wid * 0.5)) && (j >= (hid * 0.5))) {
                    vex[0] = rx[i][j];
                    vez[0] = rz[i][j];
                    vey[0] = ry[i][j];
                    vex[1] = rx[i][(j + 1)];
                    vez[1] = rz[i][(j + 1)];
                    vey[1] = ry[i][(j + 1)];
                    vex[2] = rx[(i + 1)][j];
                    vez[2] = rz[(i + 1)][j];
                    vey[2] = ry[(i + 1)][j];
                }
                if ((i >= (wid * 0.5)) && (j >= (hid * 0.5))) {
                    vex[0] = rx[i][(j + 1)];
                    vez[0] = rz[i][(j + 1)];
                    vey[0] = ry[i][(j + 1)];
                    vex[1] = rx[(i + 1)][(j + 1)];
                    vez[1] = rz[(i + 1)][(j + 1)];
                    vey[1] = ry[(i + 1)][(j + 1)];
                    vex[2] = rx[i][j];
                    vez[2] = rz[i][j];
                    vey[2] = ry[i][j];
                }
                var rmx = ((vey[1] - vey[0]) * (vez[2] - vez[0]) - (vez[1] - vez[0]) * (vey[2] - vey[0]));
                var rmy = ((vez[1] - vez[0]) * (vex[2] - vex[0]) - (vex[1] - vex[0]) * (vez[2] - vez[0]));
                var rmz = ((vex[1] - vex[0]) * (vey[2] - vey[0]) - (vey[1] - vey[0]) * (vex[2] - vex[0]));
                var normx = (rmx / Math.sqrt((rmx * rmx) + (rmy * rmy) + (rmz * rmz)));
                var normy = (rmy / Math.sqrt((rmx * rmx) + (rmy * rmy) + (rmz * rmz)));
                var normz = (rmz / Math.sqrt((rmx * rmx) + (rmy * rmy) + (rmz * rmz)));
                var im = -1;
                for (var k = 0; k < nm; k++) {
                    if ((rad.nrm[(k * 3)] == normx) && (rad.nrm[((k * 3) + 1)] == normy) && (rad.nrm[((k * 3) + 2)] == normz)) {
                        im = k;
                    }
                }
                if (im == -1) {
                    im = nm;
                    nm++;
                    rad.nrm[(im * 3)] = normx;
                    rad.nrm[((im * 3) + 1)] = normy;
                    rad.nrm[((im * 3) + 2)] = normz;
                }
                for (var v = 0; v < 3; v++) {
                    var iv = -1;
                    for (var k = 0; k < nv; k++) {
                        if ((rad.vrt[(k * 3)] == vex[v]) && (rad.vrt[((k * 3) + 2)] == vez[v])) {
                            iv = k;
                        }
                    }
                    if (iv == -1) {
                        iv = nv;
                        nv++;
                        texu[(iv * 2)] = ((vex[v] - minx) / (maxx - minx));
                        texu[((iv * 2) + 1)] = ((vez[v] - minz) / (maxz - minz));
                        rad.vrt[(iv * 3)] = vex[v];
                        rad.vrt[((iv * 3) + 1)] = vey[v];
                        rad.vrt[((iv * 3) + 2)] = vez[v];
                    }
                    rad.tri[at] = iv;
                    at++;
                    rad.tri[at] = im;
                    at++;
                    rad.tri[at] = iv;
                    at++;
                }
                if ((i < (wid * 0.5)) && (j < (hid * 0.5))) {
                    vex[2] = rx[i][j];
                    vez[2] = rz[i][j];
                    vey[2] = ry[i][j];
                    vex[1] = rx[(i + 1)][j];
                    vez[1] = rz[(i + 1)][j];
                    vey[1] = ry[(i + 1)][j];
                    vex[0] = rx[(i + 1)][(j + 1)];
                    vez[0] = rz[(i + 1)][(j + 1)];
                    vey[0] = ry[(i + 1)][(j + 1)];
                }
                if ((i >= (wid * 0.5)) && (j < (hid * 0.5))) {
                    vex[0] = rx[(i + 1)][(j + 1)];
                    vez[0] = rz[(i + 1)][(j + 1)];
                    vey[0] = ry[(i + 1)][(j + 1)];
                    vex[1] = rx[(i + 1)][j];
                    vez[1] = rz[(i + 1)][j];
                    vey[1] = ry[(i + 1)][j];
                    vex[2] = rx[i][(j + 1)];
                    vez[2] = rz[i][(j + 1)];
                    vey[2] = ry[i][(j + 1)];
                }
                if ((i < (wid * 0.5)) && (j >= (hid * 0.5))) {
                    vex[2] = rx[(i + 1)][(j + 1)];
                    vez[2] = rz[(i + 1)][(j + 1)];
                    vey[2] = ry[(i + 1)][(j + 1)];
                    vex[1] = rx[i][(j + 1)];
                    vez[1] = rz[i][(j + 1)];
                    vey[1] = ry[i][(j + 1)];
                    vex[0] = rx[(i + 1)][j];
                    vez[0] = rz[(i + 1)][j];
                    vey[0] = ry[(i + 1)][j];
                }
                if ((i >= (wid * 0.5)) && (j >= (hid * 0.5))) {
                    vex[2] = rx[(i + 1)][j];
                    vez[2] = rz[(i + 1)][j];
                    vey[2] = ry[(i + 1)][j];
                    vex[1] = rx[(i + 1)][(j + 1)];
                    vez[1] = rz[(i + 1)][(j + 1)];
                    vey[1] = ry[(i + 1)][(j + 1)];
                    vex[0] = rx[i][j];
                    vez[0] = rz[i][j];
                    vey[0] = ry[i][j];
                }
                var rmx = ((vey[1] - vey[0]) * (vez[2] - vez[0]) - (vez[1] - vez[0]) * (vey[2] - vey[0]));
                var rmy = ((vez[1] - vez[0]) * (vex[2] - vex[0]) - (vex[1] - vex[0]) * (vez[2] - vez[0]));
                var rmz = ((vex[1] - vex[0]) * (vey[2] - vey[0]) - (vey[1] - vey[0]) * (vex[2] - vex[0]));
                var normx = (rmx / Math.sqrt((rmx * rmx) + (rmy * rmy) + (rmz * rmz)));
                var normy = (rmy / Math.sqrt((rmx * rmx) + (rmy * rmy) + (rmz * rmz)));
                var normz = (rmz / Math.sqrt((rmx * rmx) + (rmy * rmy) + (rmz * rmz)));
                var im = -1;
                for (var k = 0; k < nm; k++) {
                    if ((rad.nrm[(k * 3)] == normx) && (rad.nrm[((k * 3) + 1)] == normy) && (rad.nrm[((k * 3) + 2)] == normz)) {
                        im = k;
                    }
                }
                if (im == -1) {
                    im = nm;
                    nm++;
                    rad.nrm[(im * 3)] = normx;
                    rad.nrm[((im * 3) + 1)] = normy;
                    rad.nrm[((im * 3) + 2)] = normz;
                }
                for (var v = 0; v < 3; v++) {
                    var iv = -1;
                    for (var k = 0; k < nv; k++) {
                        if ((rad.vrt[(k * 3)] == vex[v]) && (rad.vrt[((k * 3) + 2)] == vez[v])) {
                            iv = k;
                        }
                    }
                    if (iv == -1) {
                        iv = nv;
                        nv++;
                        texu[(iv * 2)] = ((vex[v] - minx) / (maxx - minx));
                        texu[((iv * 2) + 1)] = ((vez[v] - minz) / (maxz - minz));
                        rad.vrt[(iv * 3)] = vex[v];
                        rad.vrt[((iv * 3) + 1)] = vey[v];
                        rad.vrt[((iv * 3) + 2)] = vez[v];
                    }
                    rad.tri[at] = iv;
                    at++;
                    rad.tri[at] = im;
                    at++;
                    rad.tri[at] = iv;
                    at++;
                }
            }
        }
    }
    var tr = "r";
    if (rocky) {
        tr = "s";
    }
    var tm = (Math.floor(mrandom() * 3) + 1);
    if (tm == 4) {
        tm = 3;
    }
    texufile = "data/3D/textures/m" + tr + "" + tm + ".png";
    rad.ni = (rad.tri.length / 3);
    var scale = 10;
    if (scale != 1) {
        for (var i = 0; i < rad.vrt.length; i++) {
            rad.vrt[i] *= scale;
        }
    }
    var indice = [];
    var vert = [];
    var texuo = [];
    for (var i = 0; i < rad.ni; i++) {
        indice[i] = i;
        vert[(i * 3)] = rad.vrt[(rad.tri[(i * 3)] * 3)];
        vert[((i * 3) + 1)] = rad.vrt[((rad.tri[(i * 3)] * 3) + 1)];
        vert[((i * 3) + 2)] = rad.vrt[((rad.tri[(i * 3)] * 3) + 2)];
        var tcrad = Math.sqrt((vert[(i * 3)] * vert[(i * 3)]) + (vert[((i * 3) + 1)] * vert[((i * 3) + 1)]) + (vert[((i * 3) + 2)] * vert[((i * 3) + 2)]));
        if (tcrad > rad.colrad) {
            rad.colrad = tcrad;
        }
        texuo[(i * 2)] = texu[(rad.tri[((i * 3) + 2)] * 2)];
        texuo[((i * 2) + 1)] = texu[((rad.tri[((i * 3) + 2)] * 2) + 1)];
    }
    rad.vbuf = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, rad.vbuf);
    gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(vert), gl.STATIC_DRAW);
    rad.tbuf = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, rad.tbuf);
    gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(texuo), gl.STATIC_DRAW);
    rad.ibuf = gl.createBuffer();
    gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, rad.ibuf);
    gl.bufferData(gl.ELEMENT_ARRAY_BUFFER, new Uint16Array(indice), gl.STATIC_DRAW);
    rad.texture = gl.createTexture();
    gl.bindTexture(gl.TEXTURE_2D, rad.texture);
    var pixel = new Uint8Array([192, 192, 192, 255]);
    gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, 1, 1, 0, gl.RGBA, gl.UNSIGNED_BYTE, pixel);
    rad.loaded = 1;
    var image = new Image();
    image.onload = function () {
        gl.bindTexture(gl.TEXTURE_2D, rad.texture);
        gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, gl.RGBA, gl.UNSIGNED_BYTE, image);
        if (isPowerOf2(image.width) && isPowerOf2(image.height)) {
            gl.generateMipmap(gl.TEXTURE_2D);
        } else {
            gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_S, gl.CLAMP_TO_EDGE);
            gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_T, gl.CLAMP_TO_EDGE);
            gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MIN_FILTER, gl.LINEAR);
        }
        rad.loaded = 2;
    };
    image.src = texufile;
    rad.nt = 1;
    rad.mat = mat4.create();
    mat4.rotate(rad.mat, rad.mat, (rot * (Math.PI / 180)), [0, 1, 0]);
}
function drawparticle(rad) {
    if (rad.loaded) {
        if (rad.alpha) {
            gl.enable(gl.BLEND);
            gl.blendFunc(gl.SRC_ALPHA, gl.ONE_MINUS_SRC_ALPHA);
        }
        rad.mat[12] = (rad.x - camx);
        rad.mat[13] = (rad.y - camy);
        rad.mat[14] = (rad.z - camz);
        gl.bindBuffer(gl.ARRAY_BUFFER, rad.vbuf);
        gl.vertexAttribPointer(programInfo[0].attribLocations.vertexPosition, 3, gl.FLOAT, false, 0, 0);
        gl.enableVertexAttribArray(programInfo[0].attribLocations.vertexPosition);
        gl.bindBuffer(gl.ARRAY_BUFFER, rad.cbuf);
        gl.vertexAttribPointer(programInfo[0].attribLocations.vertexColor, 4, gl.FLOAT, false, 0, 0);
        gl.enableVertexAttribArray(programInfo[0].attribLocations.vertexColor);
        gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, rad.ibuf);
        gl.useProgram(programInfo[0].program);
        gl.uniformMatrix4fv(programInfo[0].uniformLocations.projectionMatrix, false, cmat);
        gl.uniformMatrix4fv(programInfo[0].uniformLocations.modelViewMatrix, false, rad.mat);
        gl.drawElements(gl.TRIANGLES, rad.ni, gl.UNSIGNED_SHORT, 0);
        if (rad.alpha) {
            gl.disable(gl.BLEND);
        }
    }
}
function drawrad3D(rad) {
    if (rad.loaded) {
        if (rad.alpha) {
            gl.enable(gl.BLEND);
            gl.blendFunc(gl.SRC_ALPHA, gl.ONE_MINUS_SRC_ALPHA);
        }
        var pro = 1;
        if (rad.ownshade) {
            pro = 2;
        }
        if (rad.ownlight) {
            pro = 3;
        }
        rad.mat[12] = (rad.x - camx);
        rad.mat[13] = (rad.y - camy);
        rad.mat[14] = (rad.z - camz);
        if ((!rad.ownlight) && (!rad.ownshade)) {
            var normalMatrix = mat4.create();
            mat4.invert(normalMatrix, rad.mat);
            mat4.transpose(normalMatrix, normalMatrix);
        }
        gl.bindBuffer(gl.ARRAY_BUFFER, rad.vbuf);
        gl.vertexAttribPointer(programInfo[pro].attribLocations.vertexPosition, 3, gl.FLOAT, false, 0, 0);
        gl.enableVertexAttribArray(programInfo[pro].attribLocations.vertexPosition);
        if ((!rad.ownlight) && (!rad.ownshade)) {
            gl.bindBuffer(gl.ARRAY_BUFFER, rad.nbuf);
            gl.vertexAttribPointer(programInfo[1].attribLocations.vertexNormal, 3, gl.FLOAT, false, 0, 0);
            gl.enableVertexAttribArray(programInfo[1].attribLocations.vertexNormal);
        }
        gl.bindBuffer(gl.ARRAY_BUFFER, rad.tbuf);
        gl.vertexAttribPointer(programInfo[pro].attribLocations.textureCoord, 2, gl.FLOAT, false, 0, 0);
        gl.enableVertexAttribArray(programInfo[pro].attribLocations.textureCoord);
        gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, rad.ibuf);
        gl.useProgram(programInfo[pro].program);
        gl.uniformMatrix4fv(programInfo[pro].uniformLocations.projectionMatrix, false, cmat);
        gl.uniformMatrix4fv(programInfo[pro].uniformLocations.modelViewMatrix, false, rad.mat);
        if ((!rad.ownlight) && (!rad.ownshade)) {
            gl.uniformMatrix4fv(programInfo[pro].uniformLocations.normalMatrix, false, normalMatrix);
        }
        gl.activeTexture(gl.TEXTURE0);
        if (rad.nt == 1) {
            gl.bindTexture(gl.TEXTURE_2D, rad.texture);
        } else {
            gl.bindTexture(gl.TEXTURE_2D, rad.texture[rad.ont]);
        }
        gl.uniform1i(programInfo[pro].uniformLocations.uSampler, 0);
        gl.drawElements(gl.TRIANGLES, rad.ni, gl.UNSIGNED_SHORT, 0);
        if (rad.alpha) {
            gl.disable(gl.BLEND);
        }
    }
}
function shadowmap(crft, shd, rad) {
    if ((Math.abs(crft.x - rad.x) < (crft.colrad + rad.colrad)) && (Math.abs(crft.z - rad.z) < (crft.colrad + rad.colrad))) {
        var gotmapped = false;
        var snormx = 0;
        var snormy = 0;
        var snormz = 0;
        for (var i = 0; i < (rad.ni / 3); i++) {
            var vertx = [];
            var verty = [];
            var vertz = [];
            for (var v = 0; v < 3; v++) {
                var vp = rad.tri[((i * 9) + (v * 3))];
                vertx[v] = ((rad.vrt[(vp * 3)] * rad.mat[0]) + (rad.vrt[((vp * 3) + 2)] * rad.mat[8]));
                verty[v] = rad.vrt[((vp * 3) + 1)];
                vertz[v] = ((rad.vrt[((vp * 3) + 2)] * rad.mat[10]) + (rad.vrt[(vp * 3)] * rad.mat[2]));
            }
            var areaOrig = Math.abs(((vertx[1] - vertx[0]) * (vertz[2] - vertz[0])) - ((vertx[2] - vertx[0]) * (vertz[1] - vertz[0])));
            var px = (shd.x - rad.x);
            var pz = (shd.z - rad.z);
            var area1 = Math.abs(((vertx[0] - px) * (vertz[1] - pz)) - ((vertx[1] - px) * (vertz[0] - pz)));
            var area2 = Math.abs(((vertx[1] - px) * (vertz[2] - pz)) - ((vertx[2] - px) * (vertz[1] - pz)));
            var area3 = Math.abs(((vertx[2] - px) * (vertz[0] - pz)) - ((vertx[0] - px) * (vertz[2] - pz)));
            if ((area1 + area2 + area3) <= (areaOrig + 10)) {
                var vp = rad.tri[((i * 9) + 1)];
                if (rad.nrm[((vp * 3) + 1)] > 0.06) {
                    var fct = 0;
                    if ((vertz[0] - vertz[1]) != 0) {
                        fct = ((shd.z - (vertz[1] + rad.z)) / (vertz[0] - vertz[1]));
                    } else {
                        fct = 0;
                    }
                    var lx = (vertx[1] + ((vertx[0] - vertx[1]) * fct));
                    var ly = (verty[1] + ((verty[0] - verty[1]) * fct));
                    if ((vertz[0] - vertz[2]) != 0) {
                        fct = ((shd.z - (vertz[2] + rad.z)) / (vertz[0] - vertz[2]));
                    } else {
                        fct = 0;
                    }
                    var tx = (vertx[2] + ((vertx[0] - vertx[2]) * fct));
                    var ty = (verty[2] + ((verty[0] - verty[2]) * fct));
                    if ((tx - lx) != 0) {
                        fct = ((shd.x - (lx + rad.x)) / (tx - lx));
                    } else {
                        fct = 0;
                    }
                    var shdy = (ly + ((ty - ly) * fct));
                    if ((shdy < crft.y) && (shdy > shd.y)) {
                        snormx = ((rad.nrm[(vp * 3)] * rad.mat[0]) + (rad.nrm[((vp * 3) + 2)] * rad.mat[8]));
                        snormy = rad.nrm[((vp * 3) + 1)];
                        snormz = ((rad.nrm[((vp * 3) + 2)] * rad.mat[10]) + (rad.nrm[(vp * 3)] * rad.mat[2]));
                        shd.y = shdy;
                    }
                    gotmapped = true;
                }
            }
        }
        if (gotmapped) {
            shd.mat[0] = crft.mat[0];
            shd.mat[1] = ( - (snormx * crft.mat[0]) + (snormz * crft.mat[8]));
            shd.mat[2] = crft.mat[2];
            if (Math.abs(shd.mat[0]) > Math.abs(shd.mat[2])) {
                if ((shd.mat[0] >= 0) && (shd.mat[0] < 0.37)) {
                    shd.mat[0] = 0.37;
                }
                if ((shd.mat[0] < 0) && (shd.mat[0] > -0.37)) {
                    shd.mat[0] = -0.37;
                }
            } else {
                if ((shd.mat[2] >= 0) && (shd.mat[2] < 0.37)) {
                    shd.mat[2] = 0.37;
                }
                if ((shd.mat[2] < 0) && (shd.mat[2] > -0.37)) {
                    shd.mat[2] = -0.37;
                }
            }
            shd.mat[4] = crft.mat[4];
            shd.mat[5] = snormy;
            shd.mat[6] = crft.mat[6];
            shd.mat[8] = crft.mat[8];
            shd.mat[9] = ( - (snormz * crft.mat[10]) + (snormx * crft.mat[2]));
            shd.mat[10] = crft.mat[10];
            if (Math.abs(shd.mat[8]) > Math.abs(shd.mat[10])) {
                if ((shd.mat[8] >= 0) && (shd.mat[8] < 0.37)) {
                    shd.mat[8] = 0.37;
                }
                if ((shd.mat[8] < 0) && (shd.mat[8] > -0.37)) {
                    shd.mat[8] = -0.37;
                }
            } else {
                if ((shd.mat[10] >= 0) && (shd.mat[10] < 0.37)) {
                    shd.mat[10] = 0.37;
                }
                if ((shd.mat[10] < 0) && (shd.mat[10] > -0.37)) {
                    shd.mat[10] = -0.37;
                }
            }
        }
    }
}
function colide(typ, id, objc, rad, geardown) {
    if ((ncolchk < maxncolchk) && (Math.abs(objc.x - rad.x) < (objc.colrad + rad.colrad)) && (objc.y < (objc.colrad + rad.colrad)) && (Math.abs(objc.z - rad.z) < (objc.colrad + rad.colrad))) {
        ncolchk++;
        var colided = false;
        var ycomp = false;
        var dcol = 10;
        var normx = 0,
        normy = 0,
        normz = 0;
        for (var i = 0; i < (rad.ni / 3); i++) {
            if (!colided) {
                var vertx = [];
                var verty = [];
                var vertz = [];
                for (var v = 0; v < 3; v++) {
                    var vp = rad.tri[((i * 9) + (v * 3))];
                    vertx[v] = ((rad.vrt[(vp * 3)] * rad.mat[0]) + (rad.vrt[((vp * 3) + 2)] * rad.mat[8]));
                    verty[v] = rad.vrt[((vp * 3) + 1)];
                    vertz[v] = ((rad.vrt[((vp * 3) + 2)] * rad.mat[10]) + (rad.vrt[(vp * 3)] * rad.mat[2]));
                }
                var vp = rad.tri[((i * 9) + 1)];
                normx = ((rad.nrm[(vp * 3)] * rad.mat[0]) + (rad.nrm[((vp * 3) + 2)] * rad.mat[8]));
                normy = rad.nrm[((vp * 3) + 1)];
                normz = ((rad.nrm[((vp * 3) + 2)] * rad.mat[10]) + (rad.nrm[(vp * 3)] * rad.mat[2]));
                var crx = (objc.x - rad.x);
                var cry = (objc.y - rad.y);
                var crz = (objc.z - rad.z);
                if ((Math.abs(normx) > Math.abs(normy)) && (Math.abs(normx) > Math.abs(normz))) {
                    var areaOrig = Math.abs(((verty[1] - verty[0]) * (vertz[2] - vertz[0])) - ((verty[2] - verty[0]) * (vertz[1] - vertz[0])));
                    var area1 = Math.abs(((verty[0] - cry) * (vertz[1] - crz)) - ((verty[1] - cry) * (vertz[0] - crz)));
                    var area2 = Math.abs(((verty[1] - cry) * (vertz[2] - crz)) - ((verty[2] - cry) * (vertz[1] - crz)));
                    var area3 = Math.abs(((verty[2] - cry) * (vertz[0] - crz)) - ((verty[0] - cry) * (vertz[2] - crz)));
                    if ((area1 + area2 + area3) <= (areaOrig + 10)) {
                        var fct = 0;
                        if ((vertz[0] - vertz[1]) != 0) {
                            fct = ((objc.z - (vertz[1] + rad.z)) / (vertz[0] - vertz[1]));
                        } else {
                            fct = 0;
                        }
                        var lx = (vertx[1] + ((vertx[0] - vertx[1]) * fct));
                        var ly = (verty[1] + ((verty[0] - verty[1]) * fct));
                        if ((vertz[0] - vertz[2]) != 0) {
                            fct = ((objc.z - (vertz[2] + rad.z)) / (vertz[0] - vertz[2]));
                        } else {
                            fct = 0;
                        }
                        var tx = (vertx[2] + ((vertx[0] - vertx[2]) * fct));
                        var ty = (verty[2] + ((verty[0] - verty[2]) * fct));
                        if ((ty - ly) != 0) {
                            fct = ((objc.y - (ly + rad.y)) / (ty - ly));
                        } else {
                            fct = 0;
                        }
                        var colx = ((lx + rad.x) + ((tx - lx) * fct));
                        if ((Math.abs(objc.mat[4]) > Math.abs(objc.mat[0])) && (Math.abs(objc.mat[4]) > Math.abs(objc.mat[8]))) {
                            ycomp = true;
                        } else {
                            ycomp = false;
                        }
                        if (normx > 0) {
                            if (!ycomp) {
                                colx += (objc.colrad * 0.7);
                            } else {
                                colx += geardown;
                            }
                            if ((objc.x <= colx) && (objc.x > (colx - dcol))) {
                                colided = true;
                                objc.x = colx;
                            }
                        } else {
                            if (!ycomp) {
                                colx -= (objc.colrad * 0.7);
                            } else {
                                colx -= geardown;
                            }
                            if ((objc.x >= colx) && (objc.x < (colx + dcol))) {
                                colided = true;
                                objc.x = colx;
                            }
                        }
                    }
                }
                if ((Math.abs(normy) > Math.abs(normx)) && (Math.abs(normy) > Math.abs(normz))) {
                    var areaOrig = Math.abs(((vertx[1] - vertx[0]) * (vertz[2] - vertz[0])) - ((vertx[2] - vertx[0]) * (vertz[1] - vertz[0])));
                    var area1 = Math.abs(((vertx[0] - crx) * (vertz[1] - crz)) - ((vertx[1] - crx) * (vertz[0] - crz)));
                    var area2 = Math.abs(((vertx[1] - crx) * (vertz[2] - crz)) - ((vertx[2] - crx) * (vertz[1] - crz)));
                    var area3 = Math.abs(((vertx[2] - crx) * (vertz[0] - crz)) - ((vertx[0] - crx) * (vertz[2] - crz)));
                    if ((area1 + area2 + area3) <= (areaOrig + 10)) {
                        var fct = 0;
                        if ((vertz[0] - vertz[1]) != 0) {
                            fct = ((objc.z - (vertz[1] + rad.z)) / (vertz[0] - vertz[1]));
                        } else {
                            fct = 0;
                        }
                        var lx = (vertx[1] + ((vertx[0] - vertx[1]) * fct));
                        var ly = (verty[1] + ((verty[0] - verty[1]) * fct));
                        if ((vertz[0] - vertz[2]) != 0) {
                            fct = ((objc.z - (vertz[2] + rad.z)) / (vertz[0] - vertz[2]));
                        } else {
                            fct = 0;
                        }
                        var tx = (vertx[2] + ((vertx[0] - vertx[2]) * fct));
                        var ty = (verty[2] + ((verty[0] - verty[2]) * fct));
                        if ((tx - lx) != 0) {
                            fct = ((objc.x - (lx + rad.x)) / (tx - lx));
                        } else {
                            fct = 0;
                        }
                        var coly = ((ly + rad.y) + ((ty - ly) * fct));
                        if ((Math.abs(objc.mat[5]) > Math.abs(objc.mat[1])) && (Math.abs(objc.mat[5]) > Math.abs(objc.mat[9]))) {
                            ycomp = true;
                        } else {
                            ycomp = false;
                        }
                        if (normy > 0) {
                            if (!ycomp) {
                                coly += (objc.colrad * 0.7);
                            } else {
                                coly += geardown;
                            }
                            if ((objc.y <= coly) && (objc.y > (coly - dcol))) {
                                colided = true;
                                objc.y = coly;
                            }
                        } else {
                            if (!ycomp) {
                                coly -= (objc.colrad * 0.7);
                            } else {
                                coly -= geardown;
                            }
                            if ((objc.y >= coly) && (objc.y < (coly + dcol))) {
                                colided = true;
                                objc.y = coly;
                            }
                        }
                    }
                }
                if ((Math.abs(normz) > Math.abs(normx)) && (Math.abs(normz) > Math.abs(normy))) {
                    var areaOrig = Math.abs(((vertx[1] - vertx[0]) * (verty[2] - verty[0])) - ((vertx[2] - vertx[0]) * (verty[1] - verty[0])));
                    var area1 = Math.abs(((vertx[0] - crx) * (verty[1] - cry)) - ((vertx[1] - crx) * (verty[0] - cry)));
                    var area2 = Math.abs(((vertx[1] - crx) * (verty[2] - cry)) - ((vertx[2] - crx) * (verty[1] - cry)));
                    var area3 = Math.abs(((vertx[2] - crx) * (verty[0] - cry)) - ((vertx[0] - crx) * (verty[2] - cry)));
                    if ((area1 + area2 + area3) <= (areaOrig + 10)) {
                        var fct = 0;
                        if ((verty[0] - verty[1]) != 0) {
                            fct = ((objc.y - (verty[1] + rad.y)) / (verty[0] - verty[1]));
                        } else {
                            fct = 0;
                        }
                        var lx = (vertx[1] + ((vertx[0] - vertx[1]) * fct));
                        var lz = (vertz[1] + ((vertz[0] - vertz[1]) * fct));
                        if ((verty[0] - verty[2]) != 0) {
                            fct = ((objc.y - (verty[2] + rad.y)) / (verty[0] - verty[2]));
                        } else {
                            fct = 0;
                        }
                        var tx = (vertx[2] + ((vertx[0] - vertx[2]) * fct));
                        var tz = (vertz[2] + ((vertz[0] - vertz[2]) * fct));
                        if ((tx - lx) != 0) {
                            fct = ((objc.x - (lx + rad.x)) / (tx - lx));
                        } else {
                            fct = 0;
                        }
                        var colz = ((lz + rad.z) + ((tz - lz) * fct));
                        if ((Math.abs(objc.mat[6]) > Math.abs(objc.mat[2])) && (Math.abs(objc.mat[6]) > Math.abs(objc.mat[10]))) {
                            ycomp = true;
                        } else {
                            ycomp = false;
                        }
                        if (normz > 0) {
                            if (!ycomp) {
                                colz += (objc.colrad * 0.7);
                            } else {
                                colz += geardown;
                            }
                            if ((objc.z <= colz) && (objc.z > (colz - dcol))) {
                                colided = true;
                                objc.z = colz;
                            }
                        } else {
                            if (!ycomp) {
                                colz -= (objc.colrad * 0.7);
                            } else {
                                colz -= geardown;
                            }
                            if ((objc.z >= colz) && (objc.z < (colz + dcol))) {
                                colided = true;
                                objc.z = colz;
                            }
                        }
                    }
                }
            }
        }
        if (colided) {
            if (typ == 0) {
                sparkcrash(id, normx, normy, normz, ycomp, 0);
            }
            if (typ == 1) {
                laserflum(id, normx, normy, normz);
            }
            if (typ == 2) {
                procoldetectd(id, objc.x, objc.y, objc.z, normx, normy, normz);
            }
        }
    }
}
function setworld(wmr, wmg, wmb, fgr, fgg, fgb, ldx, ldy, ldz) {
    var ambcol = [(0.6 * wmr), (0.6 * wmg), (0.6 * wmb)];
    var defcol = [wmr, wmg, wmb];
    var dirvec = [ldx, ldy, ldz];
    var fogcol = [(fgr * wmr), (fgg * wmg), (fgb * wmb)];
    var fogstart = 1000;
    var fogend = 7600;
    var vsSource = [];
    var fsSource = [];
    vsSource[0] = `attribute vec4 aVertexPosition; attribute vec4 aVertexColor; uniform mat4 uModelViewMatrix; uniform mat4 uProjectionMatrix; varying lowp vec4 vColor; varying vec3 v_posf; void main(void) { gl_Position = uProjectionMatrix * uModelViewMatrix * aVertexPosition; vColor = aVertexColor; v_posf = (uModelViewMatrix * aVertexPosition).xyz; }`;
    fsSource[0] = `precision mediump float; varying vec3 v_posf; varying lowp vec4 vColor; highp vec4 u_fogColor=vec4(` + fogcol[0] + `,` + fogcol[1] + `,` + fogcol[2] + `,1);highp float u_fogNear=` + fogstart + `.0;highp float u_fogFar=` + fogend + `.0; void main(void) { float abx=abs(v_posf.x); float aby=abs(v_posf.y); float abz=abs(v_posf.z); float fct=(abs(abx-abz)/(abx+abz)); float mav=((abx+abz)/(2.0-fct)); float fogDistance=((mav+(mav*(1.0-fct)*0.414))+(aby*0.5)); float fogAmount = smoothstep(u_fogNear, u_fogFar, fogDistance);gl_FragColor = mix(vColor, u_fogColor, fogAmount); }`;
    vsSource[1] = `attribute vec4 aVertexPosition; attribute vec3 aVertexNormal; attribute vec2 aTextureCoord; uniform mat4 uNormalMatrix; uniform mat4 uModelViewMatrix; uniform mat4 uProjectionMatrix; varying highp vec2 vTextureCoord; varying highp vec3 vLighting;varying vec3 v_posf; void main(void) { gl_Position = uProjectionMatrix * uModelViewMatrix * aVertexPosition; vTextureCoord = aTextureCoord; highp vec3 ambientLight = vec3(` + ambcol[0] + `,` + ambcol[1] + `,` + ambcol[2] + `); highp vec3 directionalLightColor = vec3(` + defcol[0] + `,` + defcol[1] + `,` + defcol[2] + `); highp vec3 directionalVector = normalize(vec3(` + dirvec[0] + `,` + dirvec[1] + `,` + dirvec[2] + `)); highp vec4 transformedNormal = uNormalMatrix * vec4(aVertexNormal, 1.0); highp float directional = max(dot(transformedNormal.xyz, directionalVector), 0.0); vLighting = ambientLight + (directionalLightColor * directional); v_posf = (uModelViewMatrix * aVertexPosition).xyz; }`;
    fsSource[1] = `precision mediump float;varying highp vec2 vTextureCoord; varying highp vec3 vLighting; varying vec3 v_posf;uniform sampler2D uSampler; highp vec4 u_fogColor=vec4(` + fogcol[0] + `,` + fogcol[1] + `,` + fogcol[2] + `,1);highp float u_fogNear=` + fogstart + `.0;highp float u_fogFar=` + fogend + `.0; void main(void) { highp vec4 texelColor = texture2D(uSampler, vTextureCoord); float abx=abs(v_posf.x); float aby=abs(v_posf.y); float abz=abs(v_posf.z); float fct=(abs(abx-abz)/(abx+abz)); float mav=((abx+abz)/(2.0-fct)); float fogDistance=((mav+(mav*(1.0-fct)*0.414))+(aby*0.5)); float fogAmount = smoothstep(u_fogNear, u_fogFar, fogDistance);highp vec4 color=vec4(texelColor.rgb * vLighting, texelColor.a); gl_FragColor = mix(color, u_fogColor, fogAmount); }`;
    vsSource[2] = `attribute vec4 aVertexPosition; attribute vec2 aTextureCoord; uniform mat4 uModelViewMatrix; uniform mat4 uProjectionMatrix; varying highp vec2 vTextureCoord; varying highp vec3 vLighting; varying vec3 v_posf;void main(void) { gl_Position = uProjectionMatrix * uModelViewMatrix * aVertexPosition; vTextureCoord = aTextureCoord; highp vec3 ambientLight=vec3(` + defcol[0] + `,` + defcol[1] + `,` + defcol[2] + `); vLighting = ambientLight; v_posf = (uModelViewMatrix * aVertexPosition).xyz; }`;
    fsSource[2] = `precision mediump float;varying highp vec2 vTextureCoord; varying highp vec3 vLighting; varying vec3 v_posf;uniform sampler2D uSampler; highp vec4 u_fogColor=vec4(` + fogcol[0] + `,` + fogcol[1] + `,` + fogcol[2] + `,1);highp float u_fogNear=` + fogstart + `.0;highp float u_fogFar=` + fogend + `.0; void main(void) { highp vec4 texelColor = texture2D(uSampler, vTextureCoord); float abx=abs(v_posf.x); float aby=abs(v_posf.y); float abz=abs(v_posf.z); float fct=(abs(abx-abz)/(abx+abz)); float mav=((abx+abz)/(2.0-fct)); float fogDistance=((mav+(mav*(1.0-fct)*0.414))+(aby*0.5)); float fogAmount = smoothstep(u_fogNear, u_fogFar, fogDistance);highp vec4 color=vec4(texelColor.rgb * vLighting, texelColor.a); gl_FragColor = mix(color, u_fogColor, fogAmount); }`;
    vsSource[3] = `attribute vec4 aVertexPosition; attribute vec2 aTextureCoord; uniform mat4 uModelViewMatrix; uniform mat4 uProjectionMatrix; varying highp vec2 vTextureCoord; varying vec3 v_posf;void main(void) { gl_Position = uProjectionMatrix * uModelViewMatrix * aVertexPosition; vTextureCoord = aTextureCoord; v_posf = (uModelViewMatrix * aVertexPosition).xyz; }`;
    fsSource[3] = `precision mediump float;varying highp vec2 vTextureCoord; varying vec3 v_posf;uniform sampler2D uSampler; highp vec4 u_fogColor=vec4(` + fogcol[0] + `,` + fogcol[1] + `,` + fogcol[2] + `,1);highp float u_fogNear=` + fogstart + `.0;highp float u_fogFar=` + fogend + `.0; void main(void) { highp vec4 texelColor = texture2D(uSampler, vTextureCoord); float abx=abs(v_posf.x); float aby=abs(v_posf.y); float abz=abs(v_posf.z); float fct=(abs(abx-abz)/(abx+abz)); float mav=((abx+abz)/(2.0-fct)); float fogDistance=((mav+(mav*(1.0-fct)*0.414))+(aby*0.5)); float fogAmount = smoothstep(u_fogNear, u_fogFar, fogDistance);highp vec4 color=vec4(texelColor.rgb, texelColor.a); gl_FragColor = mix(color, u_fogColor, fogAmount); }`;
    var shaderProgram = [];
    for (var i = 0; i < 4; i++) {
        programInfo[i] = null;
        shaderProgram[i] = initShaderProgram(gl, vsSource[i], fsSource[i]);
    }
    programInfo[0] = {
        program: shaderProgram[0],
        attribLocations: {
            vertexPosition: gl.getAttribLocation(shaderProgram[0], 'aVertexPosition'),
            vertexColor: gl.getAttribLocation(shaderProgram[0], 'aVertexColor'),
        },
        uniformLocations: {
            projectionMatrix: gl.getUniformLocation(shaderProgram[0], 'uProjectionMatrix'),
            modelViewMatrix: gl.getUniformLocation(shaderProgram[0], 'uModelViewMatrix'),
        }
    };
    programInfo[1] = {
        program: shaderProgram[1],
        attribLocations: {
            vertexPosition: gl.getAttribLocation(shaderProgram[1], 'aVertexPosition'),
            vertexNormal: gl.getAttribLocation(shaderProgram[1], 'aVertexNormal'),
            textureCoord: gl.getAttribLocation(shaderProgram[1], 'aTextureCoord'),
        },
        uniformLocations: {
            projectionMatrix: gl.getUniformLocation(shaderProgram[1], 'uProjectionMatrix'),
            modelViewMatrix: gl.getUniformLocation(shaderProgram[1], 'uModelViewMatrix'),
            normalMatrix: gl.getUniformLocation(shaderProgram[1], 'uNormalMatrix'),
            uSampler: gl.getUniformLocation(shaderProgram[1], 'uSampler'),
        }
    };
    programInfo[2] = {
        program: shaderProgram[2],
        attribLocations: {
            vertexPosition: gl.getAttribLocation(shaderProgram[2], 'aVertexPosition'),
            textureCoord: gl.getAttribLocation(shaderProgram[2], 'aTextureCoord'),
        },
        uniformLocations: {
            projectionMatrix: gl.getUniformLocation(shaderProgram[2], 'uProjectionMatrix'),
            modelViewMatrix: gl.getUniformLocation(shaderProgram[2], 'uModelViewMatrix'),
            uSampler: gl.getUniformLocation(shaderProgram[2], 'uSampler'),
        }
    };
    programInfo[3] = {
        program: shaderProgram[3],
        attribLocations: {
            vertexPosition: gl.getAttribLocation(shaderProgram[3], 'aVertexPosition'),
            textureCoord: gl.getAttribLocation(shaderProgram[3], 'aTextureCoord'),
        },
        uniformLocations: {
            projectionMatrix: gl.getUniformLocation(shaderProgram[3], 'uProjectionMatrix'),
            modelViewMatrix: gl.getUniformLocation(shaderProgram[3], 'uModelViewMatrix'),
            uSampler: gl.getUniformLocation(shaderProgram[3], 'uSampler'),
        }
    };
}
function initShaderProgram(gl, vsSource, fsSource) {
    const vertexShader = loadShader(gl, gl.VERTEX_SHADER, vsSource);
    const fragmentShader = loadShader(gl, gl.FRAGMENT_SHADER, fsSource);
    const shaderProgram = gl.createProgram();
    gl.attachShader(shaderProgram, vertexShader);
    gl.attachShader(shaderProgram, fragmentShader);
    gl.linkProgram(shaderProgram);
    if (!gl.getProgramParameter(shaderProgram, gl.LINK_STATUS)) {
        alert('Unable to initialize the shader program: ' + gl.getProgramInfoLog(shaderProgram));
        return null;
    }
    return shaderProgram;
}
function loadShader(gl, type, source) {
    const shader = gl.createShader(type);
    gl.shaderSource(shader, source);
    gl.compileShader(shader);
    if (!gl.getShaderParameter(shader, gl.COMPILE_STATUS)) {
        alert('An error occurred compiling the shaders: ' + gl.getShaderInfoLog(shader));
        gl.deleteShader(shader);
        return null;
    }
    return shader;
}
function isPowerOf2(value) {
    return ((value & (value - 1)) == 0);
}
function getonscreen(m, rad) {
    var x = rad.mat[12];
    var y = rad.mat[13];
    var z = rad.mat[14];
    var w = x * m[0 * 4 + 3] + y * m[1 * 4 + 3] + z * m[2 * 4 + 3] + m[3 * 4 + 3];
    var propoint = [((x * m[0 * 4 + 0] + y * m[1 * 4 + 0] + z * m[2 * 4 + 0] + m[3 * 4 + 0]) / w), ((x * m[0 * 4 + 1] + y * m[1 * 4 + 1] + z * m[2 * 4 + 1] + m[3 * 4 + 1]) / w), ((x * m[0 * 4 + 2] + y * m[1 * 4 + 2] + z * m[2 * 4 + 2] + m[3 * 4 + 2]) / w)];
    return [((propoint[0] * 0.5 + 0.5) * canw), ((propoint[1] * -0.5 + 0.5) * canh)];
}
function getxyzscreen(m, x, y, z) {
    x -= camx;
    y -= camy;
    z -= camz;
    var w = x * m[0 * 4 + 3] + y * m[1 * 4 + 3] + z * m[2 * 4 + 3] + m[3 * 4 + 3];
    var propoint = [((x * m[0 * 4 + 0] + y * m[1 * 4 + 0] + z * m[2 * 4 + 0] + m[3 * 4 + 0]) / w), ((x * m[0 * 4 + 1] + y * m[1 * 4 + 1] + z * m[2 * 4 + 1] + m[3 * 4 + 1]) / w), ((x * m[0 * 4 + 2] + y * m[1 * 4 + 2] + z * m[2 * 4 + 2] + m[3 * 4 + 2]) / w)];
    return [((propoint[0] * 0.5 + 0.5) * canw), ((propoint[1] * -0.5 + 0.5) * canh)];
}
var seed = 0;
function mrandom() {
    var rand = (Math.sin(seed * (Math.PI / 1800)) * 1000);
    seed++;
    if (seed >= 3600) {
        seed = 0;
    }
    rand = (rand - Math.floor(rand));
    return rand;
}
function py(x1, x2, z1, z2) {
    return Math.sqrt(((x1 - x2) * (x1 - x2)) + ((z1 - z2) * (z1 - z2)));
}
function pyd(x1, x2, y1, y2, z1, z2) {
    return Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)) + ((z1 - z2) * (z1 - z2)));
}
function strtsWith(line, sval) {
    return (line.substring(0, sval.length) == sval);
}
function getIntValue(func, strn, indx) {
    var ret = -1;
    try {
        var w = 0,
        c = 0,
        got = 0;
        var o = "",
        r = "";
        w = (func.length + 1);
        while ((w < strn.length) && (got != 2)) {
            o = "" + strn.charAt(w);
            if (o == "," || o == ")") {
                c++;
                if (got == 1 || c > indx) {
                    got = 2;
                }
            } else {
                if (c == indx) {
                    r += o;
                    got = 1;
                }
            }
            w++;
        }
        if (r == "") {
            r = "-1";
        }
        ret = parseInt(r);
        var rrc = "" + ret;
        if (rrc == "NaN") {
            ret = -1;
        }
    } catch (err) {
        ret = -1;
    }
    return ret;
}
function getStringValue(func, strn, indx) {
    var ret = "";
    try {
        var w = 0,
        c = 0,
        got = 0;
        var o = "",
        r = "";
        w = (func.length + 1);
        while ((w < strn.length) && (got != 2)) {
            o = "" + strn.charAt(w);
            if (o == "," || o == ")") {
                c++;
                if (got == 1 || c > indx) {
                    got = 2;
                }
            } else {
                if (c == indx) {
                    r += o;
                    got = 1;
                }
            }
            w++;
        }
        ret = r;
    } catch (err) {
        ret = "";
    }
    return ret;
}
function getFloatValue(func, strn, indx) {
    var ret = -1;
    try {
        var w = 0,
        c = 0,
        got = 0;
        var o = "",
        r = "";
        w = (func.length + 1);
        while ((w < strn.length) && (got != 2)) {
            o = "" + strn.charAt(w);
            if (o == "," || o == ")") {
                c++;
                if (got == 1 || c > indx) {
                    got = 2;
                }
            } else {
                if (c == indx) {
                    r += o;
                    got = 1;
                }
            }
            w++;
        }
        if (r == "") {
            r = "-1";
        }
        ret = parseFloat(r);
        var rrc = "" + ret;
        if (rrc == "NaN") {
            ret = -1;
        }
    } catch (err) {
        ret = -1;
    }
    return ret;
}
var isphone = false;
if (navigator.userAgent.match(/Android/i) || navigator.userAgent.match(/BlackBerry/i) || navigator.userAgent.match(/iPhone|iPad|iPod/i) || navigator.userAgent.match(/Opera Mini/i) || navigator.userAgent.match(/IEMobile/i)) {
    isphone = true;
}
var isios = false;
if (navigator.userAgent.match(/iPhone|iPad|iPod/i)) {
    isios = true;
}
var rosize = new Image();
if (!isphone) {
    rosize.src = "data/resize.gif";
} else {
    rosize.src = "data/rotate.gif";
}
var rdres = 1;
if (screen.width <= 680) {
    rdres = 2;
}
var btn = [];
var logo = null;
var logoman = null;
var logobg = null;
var room1 = null;
var room2 = null;
var door1 = null;
var door2 = null;
var scrin = null;
var iscrin = null;
var lsl = null;
var pausebg = null;
var endi = null;
var rewd = null;
var inst = [];
var ground = newrad3D();
var skydom = newrad3D();
var obst = [];
for (var i = 0; i < 8; i++) {
    obst[i] = newrad3D();
}
var craft = [];
for (var i = 0; i < 10; i++) {
    craft[i] = newrad3D();
}
var laser = [];
for (var i = 0; i < 10; i++) {
    laser[i] = newparticle();
}
var fcraft = [];
for (var i = 0; i < 10; i++) {
    fcraft[i] = newparticle();
}
var shad = [];
for (var i = 0; i < 10; i++) {
    shad[i] = newrad3D();
}
var crbg = newparticle();
var arrow = [];
for (var i = 0; i < 2; i++) {
    arrow[i] = newrad3D();
}
var checkpoint = newparticle();
var cptext = newparticle();
var cpfinish = newparticle();
var fixpoint = newparticle();
var fixdisk = newrad3D();
var fixrew = newrad3D();
var firespark = newrad3D();
var explode = [];
for (var i = 0; i < 3; i++) {
    explode[i] = newrad3D();
}
var dust = [];
for (var i = 0; i < 2; i++) {
    dust[i] = newrad3D();
}
var smoke = [];
for (var i = 0; i < 3; i++) {
    smoke[i] = newrad3D();
}
var flum = newrad3D();
var confeloaded = false;
var confe = [];
function loadconfe() {
    if (!confeloaded) {
        for (var i = 0; i < 29; i++) {
            confe[i] = new Image();
            confe[i].src = "data/interface" + rdres + "/conf/" + i + ".png";
        }
        confeloaded = true;
    }
}
var dataload = 0;
var imgsload = 0;
var fragload = 0;
var pokiready = false;
function loaddata() {
    if (gl) {
        drawloading();
        if (fragload == 1) {
            for (var i = 0; i < 10; i++) {
                loadrad3D("data/3D/craft" + i + ".r3d", craft[i]);
                loadparticle("data/3D/laser" + i + ".prt", laser[i]);
                shad[i].altscale = 1.0526;
                loadrad3D("data/3D/shad" + i + ".r3d", shad[i]);
            }
        }
        if (fragload == 2) {
            loadparticle("data/3D/crbg.prt", crbg);
            loadrad3D("data/3D/ground.r3d", ground);
            loadrad3D("data/3D/skydom.r3d", skydom);
        }
        if (fragload == 3) {
            for (var i = 0; i < 2; i++) {
                loadrad3D("data/3D/arrow" + i + ".r3d", arrow[i]);
            }
        }
        if (fragload == 4) {
            loadparticle("data/3D/checkpoint.prt", checkpoint);
            loadparticle("data/3D/cptext.prt", cptext);
            loadparticle("data/3D/cpfinsih.prt", cpfinish);
            loadparticle("data/3D/fixpoint.prt", fixpoint);
            loadrad3D("data/3D/fixdisk.r3d", fixdisk);
            loadrad3D("data/3D/fixrew.r3d", fixrew);
        }
        if (fragload == 5) {
            for (var i = 0; i < 8; i++) {
                loadrad3D("data/3D/obst" + (i + 1) + ".r3d", obst[i]);
            }
        }
        if (fragload == 6) {
            loadrad3D("data/3D/firespark.r3d", firespark);
            var ranit = Math.random();
            var globalts = 1;
            if (ranit < 0.33) {
                globalts = 0.9;
            }
            if (ranit > 0.66) {
                globalts = 1.1;
            }
            for (var i = 0; i < 3; i++) {
                explode[i].altscale = globalts;
                loadrad3D("data/3D/exp" + i + ".r3d", explode[i]);
                globalts += 0.1;
                if (globalts > 1.15) {
                    globalts = 0.9;
                }
            }
        }
        if (fragload == 7) {
            for (var i = 0; i < 2; i++) {
                loadrad3D("data/3D/dst" + i + ".r3d", dust[i]);
            }
            ranit = Math.random();
            globalts = 1;
            if (ranit < 0.33) {
                globalts = 0.9;
            }
            if (ranit > 0.66) {
                globalts = 1.1;
            }
            for (var i = 0; i < 3; i++) {
                smoke[i].altscale = globalts;
                loadrad3D("data/3D/smk" + i + ".r3d", smoke[i]);
                globalts += 0.1;
                if (globalts > 1.15) {
                    globalts = 0.9;
                }
            }
            loadrad3D("data/3D/flm.r3d", flum);
        }
        if (fragload == 8) {
            for (var k = 0; k < 2; k++) {
                btn[k] = [];
                for (var i = 0; i < 2; i++) {
                    btn[k][i] = new Image();
                    btn[k][i].onload = function () {
                        imgsload += 1;
                    };
                    btn[k][i].src = "data/interface" + rdres + "/btn" + k + "" + i + ".png";
                }
            }
            logo = new Image();
            logo.onload = function () {
                imgsload += 6;
            };
            logo.src = "data/interface" + rdres + "/logo.png";
            logoman = new Image();
            logoman.onload = function () {
                imgsload += 8;
            };
            logoman.src = "data/interface" + rdres + "/logoman.png";
            logobg = new Image();
            logobg.onload = function () {
                imgsload += 20;
            };
            logobg.src = "data/interface" + rdres + "/logobg.png";
            room1 = new Image();
            room1.onload = function () {
                imgsload += 81;
            };
            room1.src = "data/interface" + rdres + "/room1.png";
            room2 = new Image();
            room2.onload = function () {
                imgsload += 70;
            };
            room2.src = "data/interface" + rdres + "/room2.png";
            door1 = new Image();
            door1.onload = function () {
                imgsload += 22;
            };
            door1.src = "data/interface" + rdres + "/door1.png";
            door2 = new Image();
            door2.onload = function () {
                imgsload += 27;
            };
            door2.src = "data/interface" + rdres + "/door2.png";
            scrin = new Image();
            scrin.onload = function () {
                imgsload += 27;
            };
            scrin.src = "data/interface" + rdres + "/screen.png";
            iscrin = new Image();
            iscrin.onload = function () {
                imgsload += 8;
            };
            iscrin.src = "data/interface" + rdres + "/iscreen.png";
            lsl = new Image();
            lsl.onload = function () {
                imgsload += 1;
            };
            lsl.src = "data/interface" + rdres + "/lsl.png";
            pausebg = new Image();
            pausebg.onload = function () {
                imgsload += 35;
            };
            pausebg.src = "data/interface" + rdres + "/pause.png";
            endi = new Image();
            endi.onload = function () {
                imgsload += 27;
            };
            endi.src = "data/interface" + rdres + "/end.png";
            rewd = new Image();
            rewd.onload = function () {
                imgsload += 1;
            };
            rewd.src = "data/interface" + rdres + "/rewd.png";
            for (var i = 0; i < 19; i++) {
                inst[i] = new Image();
                inst[i].onload = function () {
                    imgsload += 5;
                    drawloading();
                };
                inst[i].src = "data/interface" + rdres + "/inst" + (i + 1) + ".png";
            }
        }
        if (fragload == 9) {
            loadsnd(43);
            loadsnd(44);
        }
        for (var i = 0; i < 10; i++) {
            if ((craft[i].loaded) && (craft[i].loaded == (craft[i].nt + 1))) {
                dataload += 27;
                craft[i].loaded++;
                createfix(craft[i], fcraft[i]);
            }
            if (laser[i].loaded == 1) {
                dataload++;
                laser[i].loaded++;
            }
            if ((shad[i].loaded) && (shad[i].loaded == (shad[i].nt + 1))) {
                dataload++;
                shad[i].loaded++;
            }
        }
        if (crbg.loaded == 1) {
            dataload++;
            crbg.loaded++;
        }
        if ((ground.loaded) && (ground.loaded == (ground.nt + 1))) {
            dataload += 37;
            ground.loaded++;
        }
        if ((skydom.loaded) && (skydom.loaded == (skydom.nt + 1))) {
            dataload += 37;
            skydom.loaded++;
        }
        for (var i = 0; i < 2; i++) {
            if ((arrow[i].loaded) && (arrow[i].loaded == (arrow[i].nt + 1))) {
                dataload++;
                arrow[i].loaded++;
            }
        }
        if (checkpoint.loaded == 1) {
            dataload += 3;
            checkpoint.loaded++;
        }
        if (cptext.loaded == 1) {
            dataload += 3;
            cptext.loaded++;
        }
        if (cpfinish.loaded == 1) {
            dataload += 3;
            cpfinish.loaded++;
        }
        if (fixpoint.loaded == 1) {
            dataload += 3;
            fixpoint.loaded++;
        }
        if ((fixdisk.loaded) && (fixdisk.loaded == (fixdisk.nt + 1))) {
            dataload += 14;
            fixdisk.loaded++;
        }
        if ((fixrew.loaded) && (fixrew.loaded == (fixrew.nt + 1))) {
            dataload += 14;
            fixrew.loaded++;
        }
        for (var i = 0; i < 8; i++) {
            if ((obst[i].loaded) && (obst[i].loaded == (obst[i].nt + 1))) {
                dataload += 25;
                obst[i].loaded++;
            }
        }
        if ((firespark.loaded) && (firespark.loaded == (firespark.nt + 1))) {
            dataload += 9;
            firespark.loaded++;
        }
        for (var i = 0; i < 3; i++) {
            if ((explode[i].loaded) && (explode[i].loaded == (explode[i].nt + 1))) {
                dataload += 9;
                explode[i].loaded++;
            }
        }
        for (var i = 0; i < 2; i++) {
            if ((dust[i].loaded) && (dust[i].loaded == (dust[i].nt + 1))) {
                dataload += 9;
                dust[i].loaded++;
            }
        }
        for (var i = 0; i < 3; i++) {
            if ((smoke[i].loaded) && (smoke[i].loaded == (smoke[i].nt + 1))) {
                dataload += 9;
                smoke[i].loaded++;
            }
        }
        if ((flum.loaded) && (flum.loaded == (flum.nt + 1))) {
            dataload += 9;
            flum.loaded++;
        }
        if (fragload != 10) {
            fragload++;
        }
        if (((dataload + imgsload + intersndload + 240) == 1400) && (pokiready)) {
            var valsav = getInfo("invertcontrols");
            if (valsav == 2) {
                invertcontrols = true;
            }
            valsav = getInfo("showfixing");
            if (valsav == 2) {
                showfixing = false;
            }
            showplay = getInfo("showplay");
            if (showplay == -1) {
                showplay = 1;
            }
            unlocked = getInfo("unlocked");
            if (unlocked == -1) {
                unlocked = 1;
            }
            sel[0] = getInfo("selected");
            if (sel[0] == -1) {
                sel[0] = 0;
            }
            if (unlocked != 13) {
                stage = unlocked;
            } else {
                stage = (1 + Math.floor(Math.random() * 12));
                if (stage == 13) {
                    stage = 12;
                }
                canreset = true;
            }
            ladtime = ltime;
            if ((stage == 1) && (showplay)) {
                sel[0] = 0;
                infase = 5;
                flw = 2;
                flh = 1;
                fase = 5;
                prepcnt = 1;
                loadstage();
            } else {
                playintertrack();
                fase = 1;
                mfase = 0;
            }
            for (var i = 0; i < 43; i++) {
                loadsnd(i);
            }
            loadingComplete();
        }
    } else {
        rd.fillStyle = "#000000";
        rd.fillRect(0, 0, canw, canh);
        rd.font = "" + (20 * (mh + mw)) + "px teko";
        rd.textAlign = "left";
        rd.textBaseline = "middle";
        rd.fillStyle = "#FFFFFF";
        rd.fillText("Sorry, your device does not seem to have WEBGL", (30 * mw), (100 * mh));
        rd.fillText("The game will not be able to work without it", (30 * mw), (160 * mh));
        rd.fillText("Please try the game on another device", (30 * mw), (220 * mh));
    }
}
function newobo() {
    return {
        typ: 0,
        x: 0,
        z: 0,
        mat: null
    };
}
function newpnt() {
    return {
        x: 0,
        y: 0,
        z: 0,
        mat: null,
        rot: 0,
        typ: 0
    };
}
function newfpnt() {
    return {
        x: 0,
        y: 0,
        z: 0,
        mat: null,
        rmat: null,
        rot: 0
    };
}
var nb = 0;
var obo = [];
var nf = 0;
var fix = [];
var nc = 0;
var chk = [];
var mnt = [];
var nm = 0;
var stageload = 0;
function loadstage() {
    stageload = 2;
    var rawFile = new XMLHttpRequest();
    rawFile.open("GET", "data/stages/stage" + stage + ".txt", true);
    rawFile.onreadystatechange = function () {
        if (rawFile.readyState === 4) {
            if (rawFile.status === 200 || rawFile.status == 0) {
                var allText = rawFile.responseText;
                var readlines = allText.split('\n');
                nb = 0;
                nf = 0;
                nc = 0;
                nm = 0;
                for (var i = 0; i < readlines.length; i++) {
                    var line = readlines[i].trim();
                    if (strtsWith(line, "name")) {
                        stagename = getStringValue("name", line, 0);
                    }
                    if (strtsWith(line, "world")) {
                        var def = [];
                        for (var k = 0; k < 9; k++) {
                            def[k] = getFloatValue("world", line, k);
                        }
                        setworld(def[0], def[1], def[2], def[3], def[4], def[5], def[6], def[7], def[8]);
                    }
                    if (strtsWith(line, "nlaps")) {
                        nlaps = getIntValue("nlaps", line, 0);
                    }
                    if (strtsWith(line, "obst")) {
                        obo[nb] = newobo();
                        obo[nb].mat = mat4.create();
                        obo[nb].typ = getIntValue("obst", line, 0);
                        obo[nb].x = getFloatValue("obst", line, 1);
                        obo[nb].z = getFloatValue("obst", line, 2);
                        var rot = getFloatValue("obst", line, 3);
                        mat4.rotate(obo[nb].mat, obo[nb].mat, (rot * (Math.PI / 180)), [0, 1, 0]);
                        nb++;
                    }
                    if (strtsWith(line, "checkpoint")) {
                        chk[nc] = newpnt();
                        chk[nc].mat = mat4.create();
                        chk[nc].x = getFloatValue("checkpoint", line, 0);
                        chk[nc].y = getFloatValue("checkpoint", line, 1);
                        chk[nc].z = getFloatValue("checkpoint", line, 2);
                        chk[nc].rot = getFloatValue("checkpoint", line, 3);
                        mat4.rotate(chk[nc].mat, chk[nc].mat, (chk[nc].rot * (Math.PI / 180)), [0, 1, 0]);
                        chk[nc].typ = getFloatValue("checkpoint", line, 4);
                        nc++;
                    }
                    if (strtsWith(line, "fixpoint")) {
                        fix[nf] = newfpnt();
                        fix[nf].mat = mat4.create();
                        fix[nf].rmat = mat4.create();
                        fix[nf].x = getFloatValue("fixpoint", line, 0);
                        fix[nf].y = getFloatValue("fixpoint", line, 1);
                        fix[nf].z = getFloatValue("fixpoint", line, 2);
                        fix[nf].rot = getFloatValue("fixpoint", line, 3);
                        mat4.rotate(fix[nf].mat, fix[nf].mat, (fix[nf].rot * (Math.PI / 180)), [0, 1, 0]);
                        mat4.rotate(fix[nf].rmat, fix[nf].rmat, (fix[nf].rot * (Math.PI / 180)), [0, 1, 0]);
                        nf++;
                    }
                    if (strtsWith(line, "terrain")) {
                        mnt[nm] = newrad3D();
                        var mntrot = getFloatValue("terrain", line, 3);
                        var sedo = getIntValue("terrain", line, 0);
                        genterrain(sedo, mntrot, mnt[nm]);
                        mnt[nm].x = getFloatValue("terrain", line, 1);
                        mnt[nm].z = getFloatValue("terrain", line, 2);
                        nm++;
                    }
                }
                selectinish = false;
                stageload = 1;
            }
        }
    };
    rawFile.send(null);
}
function newfirespark() {
    return {
        x: 0,
        y: 0,
        z: 0,
        mat: null,
        vx: 0,
        vy: 0,
        vz: 0,
        burn: 0,
        smoke: 0,
        typ: 0,
        vrot: 0
    };
}
var ns = 0;
var spf = [];
function sparksfly(mag, x, y, z, trgx, trgy, trgz) {
    var nsi = Math.floor(mag + (mag * Math.random()));
    while (nsi > 0) {
        spf[ns] = newfirespark();
        spf[ns].x = (x + 2 - (4 * Math.random()));
        spf[ns].y = (y + 2 - (4 * Math.random()));
        spf[ns].z = (z + 2 - (4 * Math.random()));
        spf[ns].mat = mat4.create();
        mat4.rotate(spf[ns].mat, spf[ns].mat, (360 * Math.random() * (Math.PI / 180)), [0, 1, 0]);
        mat4.rotate(spf[ns].mat, spf[ns].mat, (360 * Math.random() * (Math.PI / 180)), [1, 0, 0]);
        var vrg = (0.5 + (Math.random() * 3));
        spf[ns].vx = (trgx + (spf[ns].mat[8] * vrg));
        spf[ns].vy = (trgy + (spf[ns].mat[9] * vrg));
        spf[ns].vz = (trgz + (spf[ns].mat[10] * vrg));
        var omegn = (0.25 + (Math.random() * 0.75));
        var omeg = Math.floor(Math.random() * 3);
        if (omeg == 3) {
            omeg = 2;
        }
        omeg *= 4;
        spf[ns].mat[omeg] *= omegn;
        spf[ns].mat[(omeg + 1)] *= omegn;
        spf[ns].mat[(omeg + 2)] *= omegn;
        omeg += 4;
        if (omeg == 12) {
            omeg = 0;
        }
        spf[ns].mat[omeg] *= omegn;
        spf[ns].mat[(omeg + 1)] *= omegn;
        spf[ns].mat[(omeg + 2)] *= omegn;
        var scl = (1 + (Math.random() * 0.5));
        for (var i = 0; i < 8; i += 4) {
            spf[ns].mat[i] *= scl;
            spf[ns].mat[(i + 1)] * scl;
            spf[ns].mat[(i + 2)] *= scl;
        }
        spf[ns].vrot = (25 * Math.random());
        spf[ns].burn = Math.floor(20 + (Math.random() * 20));
        spf[ns].smoke = Math.floor(5 + (Math.random() * 5));
        spf[ns].typ = Math.floor(Math.random() * 4);
        ns++;
        nsi--;
    }
}
function newexp() {
    return {
        x: 0,
        y: 0,
        z: 0,
        xyrot: 0,
        vx: 0,
        vy: 0,
        vz: 0,
        typ: 0,
        ani: 0
    };
}
var ne = 0;
var exp = [];
var ewer = [];
function expl(x, y, z, trgx, trgy, trgz) {
    exp[ne] = newexp();
    exp[ne].x = (x + 3 - (6 * Math.random()));
    exp[ne].y = (y + 3 - (6 * Math.random()));
    exp[ne].z = (z + 3 - (6 * Math.random()));
    exp[ne].vx = trgx;
    exp[ne].vy = trgy;
    exp[ne].vz = trgz;
    exp[ne].xyrot = (360 * Math.random());
    exp[ne].typ = Math.floor(Math.random() * 3);
    if (exp[ne].typ == 3) {
        exp[ne].typ = 2;
    }
    exp[ne].ani = 0;
    ewer[ne] = ne;
    ne++;
}
var nd = 0;
var dst = [];
var dwer = [];
function dustup(x, y, z, trgx, trgy, trgz) {
    dst[nd] = newexp();
    dst[nd].x = (x + 3 - (6 * Math.random()));
    dst[nd].y = (y + 3 - (6 * Math.random()));
    dst[nd].z = (z + 3 - (6 * Math.random()));
    dst[nd].vx = trgx;
    dst[nd].vy = trgy;
    dst[nd].vz = trgz;
    dst[nd].xyrot = (360 * Math.random());
    dst[nd].typ = Math.floor(Math.random() * 2);
    if (dst[nd].typ == 2) {
        dst[nd].typ = 1;
    }
    dst[nd].ani = 0;
    dwer[nd] = nd;
    nd++;
}
function flumup(x, y, z) {
    dst[nd] = newexp();
    dst[nd].x = x;
    dst[nd].y = y;
    dst[nd].z = z;
    dst[nd].xyrot = (360 * Math.random());
    dst[nd].typ = 7;
    dst[nd].ani = 0;
    dwer[nd] = nd;
    nd++;
}
var nk = 0;
var smk = [];
var swer = [];
function smokin(c, x, y, z, trgx, trgy, trgz) {
    if (Math.random() > 0.333) {
        var ki = (nk - 1);
        while ((ki > 0) && (smk[ki].ani == -1)) {
            ki--;
        }
        nk = (ki + 1);
        var foundki = false;
        ki = 0;
        while ((ki < nk) && (!foundki)) {
            if (smk[ki].ani == -1) {
                foundki = true;
            } else {
                ki++;
            }
        }
        if (!foundki) {
            ki = nk;
        }
        smk[ki] = newexp();
        var vari = 2;
        if (oncrash[c]) {
            vari = 3;
        }
        smk[ki].x = (x + vari - (vari * 2 * Math.random()));
        smk[ki].y = (y + vari - (vari * 2 * Math.random()));
        smk[ki].z = (z + vari - (vari * 2 * Math.random()));
        smk[ki].vx = trgx;
        smk[ki].vy = trgy;
        smk[ki].vz = trgz;
        smk[ki].xyrot = (360 * Math.random());
        smk[ki].typ = Math.floor(Math.random() * 3);
        if (smk[ki].typ == 3) {
            smk[ki].typ = 2;
        }
        smk[ki].ani = 0;
        swer[ki] = ki;
        if (!foundki) {
            nk++;
        }
    }
}
var cntan = 0;
var difxz = 0;
var isonscreen = [false, false, false, false, false];
var crftons = [];
for (var i = 0; i < 5; i++) {
    crftons[i] = [];
}
var ncolchk = 0;
var maxncolchk = 100;
var cntcolchk = 0;
var cntupcolchk = 0;
var fixadon = false;
var ladtime = 0;
function worldworks() {
    if (actat == 5) {
        if (cntcolchk == 0) {
            maxncolchk = (ncolchk - 10);
            if (maxncolchk < 5) {
                maxncolchk = 5;
            }
            cntcolchk = 5;
        }
    } else {
        if (maxncolchk < 100) {
            cntupcolchk++;
            if (cntupcolchk == 200) {
                maxncolchk += 5;
                cntupcolchk = 0;
            }
        }
    }
    if (cntcolchk) {
        cntcolchk--;
    }
    ncolchk = 0;
    skydom.x = camx;
    skydom.z = camz;
    var amat = mat4.create();
    mat4.rotate(amat, amat, (camxz * (Math.PI / 180)), [0, 1, 0]);
    mat4.rotate(amat, amat, ((camzy + 10) * (Math.PI / 180)), [1, 0, 0]);
    mat4.rotate(amat, amat, (-camxy * (Math.PI / 180)), [0, 0, 1]);
    for (var i = 0; i < 2; i++) {
        arrow[i].x = (camx + (20 * amat[8]) + (6 * amat[4]));
        arrow[i].y = (camy + (20 * amat[9]) + (6 * amat[5]));
        arrow[i].z = (camz - (20 * amat[10]) - (6 * amat[6]));
    }
    var unda = (arrow[0].z - apntz);
    if ((unda <= 0.1) && (unda >= 0)) {
        unda = 0.1;
    }
    if ((unda >= -0.1) && (unda < 0)) {
        unda = -0.1;
    }
    var arxz = -Math.abs(Math.atan((arrow[0].x - apntx) / unda) * (180 / Math.PI));
    if (arrow[0].x < apntx) {
        if (arrow[0].z < apntz) {
            arxz = ((90 - arxz) + 90);
        }
    } else {
        if (arrow[0].z < apntz) {
            arxz += 180;
        } else {
            arxz = ((90 - arxz) + 270);
        }
    }
    unda = py(arrow[0].x, apntx, arrow[0].z, apntz);
    if (unda <= 0.1) {
        unda = 0.1;
    }
    var arzy = (Math.atan((arrow[0].y - apnty) / unda) * (180 / Math.PI));
    if (arrow[0].z > apntz) {
        arzy = -arzy;
    }
    arxz = -arxz;
    while (arxz > 360) {
        arxz -= 360;
    }
    while (arxz < 0) {
        arxz += 360;
    }
    while (camxz > 360) {
        camxz -= 360;
    }
    while (camxz < 0) {
        camxz += 360;
    }
    if ((arxz < 90) && (camxz > 270)) {
        difxz = (arxz + 360 - camxz);
        if (difxz > 130) {
            arxz = (130 - 360 + camxz);
        }
        if (difxz < -130) {
            arxz = (-130 - 360 + camxz);
        }
    } else {
        if ((arxz > 270) && (camxz < 90)) {
            difxz = (arxz - 360 - camxz);
            if (difxz > 130) {
                arxz = (130 + 360 + camxz);
            }
            if (difxz < -130) {
                arxz = (-130 + 360 + camxz);
            }
        } else {
            difxz = (arxz - camxz);
            var am360 = 0;
            if (difxz > 180) {
                difxz = (difxz - 360);
                am360 = 360;
            }
            if (difxz < -180) {
                difxz = (360 + difxz);
                am360 = -360;
            }
            if (difxz > 130) {
                arxz = (130 + camxz + am360);
            }
            if (difxz < -130) {
                arxz = (camxz - 130 + am360);
            }
        }
    }
    for (var i = 0; i < 2; i++) {
        arrow[i].mat = mat4.create();
        mat4.rotate(arrow[i].mat, arrow[i].mat, (arzy * (Math.PI / 180)), [1, 0, 0]);
        mat4.rotate(arrow[i].mat, arrow[i].mat, (arxz * (Math.PI / 180)), [0, -1, 0]);
    }
    while (arzy > 360) {
        arzy -= 360;
    }
    while (arzy < 0) {
        arzy += 360;
    }
    while (camzy > 360) {
        camzy -= 360;
    }
    while (camzy < 0) {
        camzy += 360;
    }
    var difzy = Math.abs(arzy - camzy);
    if ((arzy < 90) && (camzy > 270)) {
        difzy = (arzy + (360 - camzy));
    }
    if ((arzy > 270) && (camzy < 90)) {
        difzy = (camzy + (360 - arzy));
    }
    if (Math.abs(difxz) > 22 || difzy > 22) {
        if (arrowalpha < 1) {
            arrowalpha += 0.1;
            if (arrowalpha > 1) {
                arrowalpha = 1;
            }
            for (var i = 0; i < 2; i++) {
                gl.bindTexture(gl.TEXTURE_2D, arrow[i].texture);
                var pixel = new Uint8Array([arcol[i][0], arcol[i][1], arcol[i][2], (arrowalpha * 255)]);
                gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, 1, 1, 0, gl.RGBA, gl.UNSIGNED_BYTE, pixel);
            }
        }
    } else {
        if (arrowalpha > 0) {
            arrowalpha -= 0.1;
            if (arrowalpha < 0) {
                arrowalpha = 0;
            }
            for (var i = 0; i < 2; i++) {
                gl.bindTexture(gl.TEXTURE_2D, arrow[i].texture);
                var pixel = new Uint8Array([arcol[i][0], arcol[i][1], arcol[i][2], (arrowalpha * 255)]);
                gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, 1, 1, 0, gl.RGBA, gl.UNSIGNED_BYTE, pixel);
            }
        }
    }
    for (var c = 0; c < 5; c++) {
        if (!showswitch) {
            for (var i = (c + 1); i < 5; i++) {
                if ((!takeoff[c]) && (!takeoff[i])) {
                    var cldist = pyd(craft[sel[c]].x, craft[sel[i]].x, craft[sel[c]].y, craft[sel[i]].y, craft[sel[c]].z, craft[sel[i]].z);
                    if (cldist < ((craft[sel[i]].colrad + craft[sel[c]].colrad) * 0.5)) {
                        sparkcrash(c, ((craft[sel[c]].x - craft[sel[i]].x) / cldist), ((craft[sel[c]].y - craft[sel[i]].y) / cldist), ((craft[sel[c]].z - craft[sel[i]].z) / cldist), false, 1);
                        sparkcrash(i, ((craft[sel[i]].x - craft[sel[c]].x) / cldist), ((craft[sel[i]].y - craft[sel[c]].y) / cldist), ((craft[sel[i]].z - craft[sel[c]].z) / cldist), false, 1);
                    }
                }
            }
        }
        for (var i = 0; i < nm; i++) {
            colide(0, c, craft[sel[c]], mnt[i], 2);
        }
        for (var i = 0; i < nb; i++) {
            obst[obo[i].typ].x = obo[i].x;
            obst[obo[i].typ].z = obo[i].z;
            obst[obo[i].typ].mat = obo[i].mat;
            colide(0, c, craft[sel[c]], obst[obo[i].typ], 2);
        }
        var ycomp = false;
        if ((Math.abs(craft[sel[c]].mat[5]) > Math.abs(craft[sel[c]].mat[1])) && (Math.abs(craft[sel[c]].mat[5]) > Math.abs(craft[sel[c]].mat[9]))) {
            ycomp = true;
        } else {
            ycomp = false;
        }
        var grndcolide = false;
        if (ycomp) {
            if (craft[sel[c]].y < 2) {
                craft[sel[c]].y = 2;
                grndcolide = true;
            }
        } else {
            if (craft[sel[c]].y < (craft[sel[c]].colrad * 0.7)) {
                craft[sel[c]].y = (craft[sel[c]].colrad * 0.7);
                grndcolide = true;
            }
        }
        if (grndcolide) {
            sparkcrash(c, 0, 1, 0, ycomp, 0);
        }
        if (craft[sel[c]].x > 6200) {
            craft[sel[c]].x -= ((craft[sel[c]].x - 6200) / 5);
        }
        if (craft[sel[c]].x < -6200) {
            craft[sel[c]].x -= ((craft[sel[c]].x + 6200) / 5);
        }
        if (craft[sel[c]].z > 6200) {
            craft[sel[c]].z -= ((craft[sel[c]].z - 6200) / 5);
        }
        if (craft[sel[c]].z < -6200) {
            craft[sel[c]].z -= ((craft[sel[c]].z + 6200) / 5);
        }
        if (craft[sel[c]].y > 2200) {
            craft[sel[c]].y -= ((craft[sel[c]].y - 2200) / 5);
        }
        if ((c != 0) && (camode == 0) && (!oncrash[0])) {
            isonscreen[c] = false;
            if ((Math.abs(craft[sel[0]].mat[8]) > Math.abs(craft[sel[0]].mat[9])) && (Math.abs(craft[sel[0]].mat[8]) > Math.abs(craft[sel[0]].mat[10]))) {
                if (craft[sel[0]].mat[8] > 0) {
                    if (craft[sel[c]].x > craft[sel[0]].x) {
                        isonscreen[c] = true;
                    }
                } else {
                    if (craft[sel[c]].x < craft[sel[0]].x) {
                        isonscreen[c] = true;
                    }
                }
            }
            if ((Math.abs(craft[sel[0]].mat[9]) > Math.abs(craft[sel[0]].mat[8])) && (Math.abs(craft[sel[0]].mat[9]) > Math.abs(craft[sel[0]].mat[10]))) {
                if (craft[sel[0]].mat[9] > 0) {
                    if (craft[sel[c]].y > craft[sel[0]].y) {
                        isonscreen[c] = true;
                    }
                } else {
                    if (craft[sel[c]].y < craft[sel[0]].y) {
                        isonscreen[c] = true;
                    }
                }
            }
            if ((Math.abs(craft[sel[0]].mat[10]) > Math.abs(craft[sel[0]].mat[8])) && (Math.abs(craft[sel[0]].mat[10]) > Math.abs(craft[sel[0]].mat[9]))) {
                if (craft[sel[0]].mat[10] > 0) {
                    if (craft[sel[c]].z > craft[sel[0]].z) {
                        isonscreen[c] = true;
                    }
                } else {
                    if (craft[sel[c]].z < craft[sel[0]].z) {
                        isonscreen[c] = true;
                    }
                }
            }
            if (isonscreen[c]) {
                crftons[c] = getonscreen(cmat, craft[sel[c]]);
                if ((crftons[c][0] <  - (15 * mw)) || (crftons[c][0] > (canw + (15 * mw)))) {
                    isonscreen[c] = false;
                }
            }
        } else {
            isonscreen[c] = true;
        }
        shad[sel[c]].x = craft[sel[c]].x;
        shad[sel[c]].y = 0;
        shad[sel[c]].z = craft[sel[c]].z;
        shad[sel[c]].mat[0] = craft[sel[c]].mat[0];
        shad[sel[c]].mat[1] = 0;
        shad[sel[c]].mat[2] = craft[sel[c]].mat[2];
        if (Math.abs(shad[sel[c]].mat[0]) > Math.abs(shad[sel[c]].mat[2])) {
            if ((shad[sel[c]].mat[0] >= 0) && (shad[sel[c]].mat[0] < 0.37)) {
                shad[sel[c]].mat[0] = 0.37;
            }
            if ((shad[sel[c]].mat[0] < 0) && (shad[sel[c]].mat[0] > -0.37)) {
                shad[sel[c]].mat[0] = -0.37;
            }
        } else {
            if ((shad[sel[c]].mat[2] >= 0) && (shad[sel[c]].mat[2] < 0.37)) {
                shad[sel[c]].mat[2] = 0.37;
            }
            if ((shad[sel[c]].mat[2] < 0) && (shad[sel[c]].mat[2] > -0.37)) {
                shad[sel[c]].mat[2] = -0.37;
            }
        }
        shad[sel[c]].mat[4] = craft[sel[c]].mat[4];
        shad[sel[c]].mat[5] = 1;
        shad[sel[c]].mat[6] = craft[sel[c]].mat[6];
        shad[sel[c]].mat[8] = craft[sel[c]].mat[8];
        shad[sel[c]].mat[9] = 0;
        shad[sel[c]].mat[10] = craft[sel[c]].mat[10];
        if (Math.abs(shad[sel[c]].mat[8]) > Math.abs(shad[sel[c]].mat[10])) {
            if ((shad[sel[c]].mat[8] >= 0) && (shad[sel[c]].mat[8] < 0.37)) {
                shad[sel[c]].mat[8] = 0.37;
            }
            if ((shad[sel[c]].mat[8] < 0) && (shad[sel[c]].mat[8] > -0.37)) {
                shad[sel[c]].mat[8] = -0.37;
            }
        } else {
            if ((shad[sel[c]].mat[10] >= 0) && (shad[sel[c]].mat[10] < 0.37)) {
                shad[sel[c]].mat[10] = 0.37;
            }
            if ((shad[sel[c]].mat[10] < 0) && (shad[sel[c]].mat[10] > -0.37)) {
                shad[sel[c]].mat[10] = -0.37;
            }
        }
        if (isonscreen[c]) {
            for (var i = 0; i < nm; i++) {
                shadowmap(craft[sel[c]], shad[sel[c]], mnt[i]);
            }
            for (var i = 0; i < nb; i++) {
                obst[obo[i].typ].x = obo[i].x;
                obst[obo[i].typ].z = obo[i].z;
                obst[obo[i].typ].mat = obo[i].mat;
                shadowmap(craft[sel[c]], shad[sel[c]], obst[obo[i].typ]);
            }
        }
    }
    if (!fixadon) {
        if (unlocked >= 3) {
            if ((ltime - ladtime) > 120000) {
                //fixadon = true;
            }
        }
    }
    if (cntan == 0) {
        fixdisk.ont++;
        if (fixdisk.ont == 5) {
            fixdisk.ont = 0;
        }
        cntan = 1;
    } else {
        cntan--;
    }
    for (var i = 0; i < nf; i++) {
        mat4.rotate(fix[i].mat, fix[i].mat, 0.05, [0, 0, 1]);
        if (fixadon) {
            fix[i].rmat = mat4.create();
            mat4.rotate(fix[i].rmat, fix[i].rmat, (fix[i].rot * (Math.PI / 180)), [0, 1, 0]);
            var flipit = false;
            if (Math.abs(fix[i].rmat[8]) > Math.abs(fix[i].rmat[10])) {
                if ((fix[i].rmat[8] > 0) && (camx < fix[i].x)) {
                    flipit = true;
                }
                if ((fix[i].rmat[8] < 0) && (camx > fix[i].x)) {
                    flipit = true;
                }
            } else {
                if ((fix[i].rmat[10] > 0) && (camz < fix[i].z)) {
                    flipit = true;
                }
                if ((fix[i].rmat[10] < 0) && (camz > fix[i].z)) {
                    flipit = true;
                }
            }
            if (flipit) {
                mat4.rotate(fix[i].rmat, fix[i].rmat, (180 * (Math.PI / 180)), [0, 1, 0]);
            }
        }
    }
    for (var i = 0; i < nc; i++) {
        if (onchk[0] == i) {
            chk[i].mat = mat4.create();
            mat4.rotate(chk[i].mat, chk[i].mat, (chk[i].rot * (Math.PI / 180)), [0, 1, 0]);
            var flipit = false;
            if (Math.abs(chk[i].mat[8]) > Math.abs(chk[i].mat[10])) {
                if ((chk[i].mat[8] > 0) && (camx < chk[i].x)) {
                    flipit = true;
                }
                if ((chk[i].mat[8] < 0) && (camx > chk[i].x)) {
                    flipit = true;
                }
            } else {
                if ((chk[i].mat[10] > 0) && (camz < chk[i].z)) {
                    flipit = true;
                }
                if ((chk[i].mat[10] < 0) && (camz > chk[i].z)) {
                    flipit = true;
                }
            }
            if (flipit) {
                mat4.rotate(chk[i].mat, chk[i].mat, (180 * (Math.PI / 180)), [0, 1, 0]);
            }
        }
    }
    if (onlastchk != 0) {
        onlastchk--;
    }
    var nsoff = 0;
    for (var i = 0; i < ns; i++) {
        if (spf[i].smoke > 0) {
            spf[i].x += spf[i].vx;
            spf[i].y += spf[i].vy;
            spf[i].z += spf[i].vz;
            spf[i].vy -= 0.02;
            if (spf[i].burn > 0) {
                spf[i].burn--;
                if (spf[i].burn == 0) {
                    spf[i].typ = (4 + Math.floor(Math.random() * 2));
                    if (spf[i].typ == 6) {
                        spf[i].typ = 5;
                    }
                }
            } else {
                if (spf[i].smoke > 0) {
                    spf[i].smoke--;
                }
            }
            mat4.rotate(spf[i].mat, spf[i].mat, (spf[i].vrot * (Math.PI / 180)), [0, 0, 1]);
        } else {
            nsoff++;
        }
    }
    if ((ns != 0) && (nsoff == ns)) {
        ns = 0;
    }
    var neoff = 0;
    for (var i = 0; i < ne; i++) {
        if (exp[i].ani != -1) {
            exp[i].x += exp[i].vx;
            exp[i].y += exp[i].vy;
            exp[i].z += exp[i].vz;
            exp[i].ani += 0.4;
            if (exp[i].ani >= 6) {
                exp[i].ani = -1;
            }
            exp[i].vx *= 0.9;
            exp[i].vy *= 0.9;
            exp[i].vz *= 0.9;
        } else {
            neoff++;
        }
    }
    if ((ne != 0) && (neoff == ne)) {
        ne = 0;
    }
    var wer = [];
    var expd = [];
    for (var i = 0; i < ne; i++) {
        wer[i] = 0;
        expd[i] = pyd(exp[i].x, camx, exp[i].y, camy, exp[i].z, camz);
    }
    for (var i = 0; i < ne; i++) {
        for (var j = (i + 1); j < ne; j++) {
            if (expd[i] < expd[j]) {
                wer[i]++;
            } else {
                wer[j]++;
            }
        }
        ewer[wer[i]] = i;
    }
    var ndoff = 0;
    for (var i = 0; i < nd; i++) {
        if (dst[i].ani != -1) {
            if (dst[i].typ != 7) {
                dst[i].x += dst[i].vx;
                dst[i].y += dst[i].vy;
                dst[i].z += dst[i].vz;
                dst[i].ani += 0.4;
                if (dst[i].ani >= 4) {
                    dst[i].ani = -1;
                }
                dst[i].vx *= 0.5;
                dst[i].vy *= 0.5;
                dst[i].vz *= 0.5;
            } else {
                dst[i].ani += 0.4;
                if (dst[i].ani >= 3) {
                    dst[i].ani = -1;
                }
            }
        } else {
            ndoff++;
        }
    }
    if ((nd != 0) && (ndoff == nd)) {
        nd = 0;
    }
    wer = [];
    expd = [];
    for (var i = 0; i < nd; i++) {
        wer[i] = 0;
        expd[i] = pyd(dst[i].x, camx, dst[i].y, camy, dst[i].z, camz);
    }
    for (var i = 0; i < nd; i++) {
        for (var j = (i + 1); j < nd; j++) {
            if (expd[i] < expd[j]) {
                wer[i]++;
            } else {
                wer[j]++;
            }
        }
        dwer[wer[i]] = i;
    }
    var nkoff = 0;
    for (var i = 0; i < nk; i++) {
        if (smk[i].ani != -1) {
            smk[i].x += smk[i].vx;
            smk[i].y += smk[i].vy;
            smk[i].z += smk[i].vz;
            smk[i].ani += 0.4;
            if (smk[i].ani >= 4) {
                smk[i].ani = -1;
            }
            smk[i].vx *= 0.5;
            smk[i].vy *= 0.5;
            smk[i].vz *= 0.5;
        } else {
            nkoff++;
        }
    }
    if ((nk != 0) && (nkoff == nk)) {
        nk = 0;
    }
    wer = [];
    expd = [];
    for (var i = 0; i < nk; i++) {
        wer[i] = 0;
        expd[i] = pyd(smk[i].x, camx, smk[i].y, camy, smk[i].z, camz);
    }
    for (var i = 0; i < nk; i++) {
        for (var j = (i + 1); j < nk; j++) {
            if (expd[i] < expd[j]) {
                wer[i]++;
            } else {
                wer[j]++;
            }
        }
        swer[wer[i]] = i;
    }
}
function render(now) {
    if (fase == 7) {
        gl.clearColor(0.0, 0.0, 0.0, 1.0);
        gl.clearDepth(1.0);
        gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);
        gl.disable(gl.DEPTH_TEST);
        drawrad3D(ground);
        drawrad3D(skydom);
        gl.enable(gl.DEPTH_TEST);
        gl.depthFunc(gl.LEQUAL);
        for (var i = 0; i < nm; i++) {
            drawrad3D(mnt[i]);
        }
        for (var i = 0; i < nb; i++) {
            obst[obo[i].typ].x = obo[i].x;
            obst[obo[i].typ].z = obo[i].z;
            obst[obo[i].typ].mat = obo[i].mat;
            drawrad3D(obst[obo[i].typ]);
        }
        if (camode == 0) {
            gl.disable(gl.DEPTH_TEST);
            drawrad3D(shad[sel[0]]);
        }
        gl.enable(gl.DEPTH_TEST);
        gl.depthFunc(gl.LEQUAL);
        if ((camode == 0) && (!cntfly) && (!pfase) && (!endfase)) {
            if (arrowalpha) {
                for (var i = 0; i < 2; i++) {
                    drawrad3D(arrow[i]);
                }
            }
        } else {
            if (pfase == 1) {
                pfase = 2;
            }
            if (pfase == 3) {
                pfase = 4;
            }
            if (pfase == 5) {
                pfase = 6;
            }
            if (pfase == 7) {
                pfase = 8;
            }
            if (pfase == 9) {
                pfase = 10;
            }
        }
        for (var c = 0; c < 5; c++) {
            if (camode != 0 || c > 0) {
                drawrad3D(shad[sel[c]]);
            }
            if (!fixflk[c]) {
                drawrad3D(craft[sel[c]]);
            } else {
                if (fixflg[c]) {
                    drawrad3D(craft[sel[c]]);
                } else {
                    fcraft[sel[c]].x = craft[sel[c]].x;
                    fcraft[sel[c]].y = craft[sel[c]].y;
                    fcraft[sel[c]].z = craft[sel[c]].z;
                    fcraft[sel[c]].mat = craft[sel[c]].mat;
                    drawparticle(fcraft[sel[c]]);
                }
            }
        }
        for (var i = 0; i < nl; i++) {
            if (lsr[i].stat < lifespan) {
                laser[lsr[i].typ].x = lsr[i].x;
                laser[lsr[i].typ].y = lsr[i].y;
                laser[lsr[i].typ].z = lsr[i].z;
                laser[lsr[i].typ].mat = lsr[i].mat;
                drawparticle(laser[lsr[i].typ]);
            }
        }
        for (var i = 0; i < nc; i++) {
            if (((chk[i].typ == 0) && (onchk[0] == i)) || ((onlastchk) && (lastchk == i))) {
                checkpoint.x = chk[i].x;
                checkpoint.y = chk[i].y;
                checkpoint.z = chk[i].z;
                checkpoint.mat = chk[i].mat;
                drawparticle(checkpoint);
                if (chk[i].typ == 0) {
                    cptext.x = chk[i].x;
                    cptext.y = (chk[i].y + 70);
                    cptext.z = chk[i].z;
                    cptext.mat = chk[i].mat;
                    drawparticle(cptext);
                    if ((onlap[0] == (nlaps - 1)) && (finalchk == onchk[0]) && (lastchk != i) && (!endfase)) {
                        cpfinish.x = chk[i].x;
                        cpfinish.y = chk[i].y;
                        cpfinish.z = chk[i].z;
                        cpfinish.mat = chk[i].mat;
                        drawparticle(cpfinish);
                    }
                }
            }
        }
        for (var i = 0; i < nf; i++) {
            fixpoint.x = fix[i].x;
            fixpoint.y = fix[i].y;
            fixpoint.z = fix[i].z;
            fixpoint.mat = fix[i].mat;
            drawparticle(fixpoint);
            fixdisk.x = fix[i].x;
            fixdisk.y = fix[i].y;
            fixdisk.z = fix[i].z;
            fixdisk.mat = fix[i].mat;
            drawrad3D(fixdisk);
            if (fixadon) {
                fixrew.x = fix[i].x;
                fixrew.y = fix[i].y;
                fixrew.z = fix[i].z;
                fixrew.mat = fix[i].rmat;
                drawrad3D(fixrew);
            }
        }
        for (var i = 0; i < ns; i++) {
            if (spf[i].smoke > 0) {
                firespark.x = spf[i].x;
                firespark.y = spf[i].y;
                firespark.z = spf[i].z;
                firespark.mat = spf[i].mat;
                firespark.ont = spf[i].typ;
                drawrad3D(firespark);
            }
        }
        for (var i = 0; i < ne; i++) {
            if (exp[ewer[i]].ani != -1) {
                explode[exp[ewer[i]].typ].x = exp[ewer[i]].x;
                explode[exp[ewer[i]].typ].y = exp[ewer[i]].y;
                explode[exp[ewer[i]].typ].z = exp[ewer[i]].z;
                explode[exp[ewer[i]].typ].ont = Math.floor(exp[ewer[i]].ani);
                explode[exp[ewer[i]].typ].mat = mat4.create();
                mat4.rotate(explode[exp[ewer[i]].typ].mat, explode[exp[ewer[i]].typ].mat, (camxz * (Math.PI / 180)), [0, -1, 0]);
                mat4.rotate(explode[exp[ewer[i]].typ].mat, explode[exp[ewer[i]].typ].mat, ((camzy + 10) * (Math.PI / 180)), [-1, 0, 0]);
                mat4.rotate(explode[exp[ewer[i]].typ].mat, explode[exp[ewer[i]].typ].mat, (exp[ewer[i]].xyrot * (Math.PI / 180)), [0, 0, 1]);
                drawrad3D(explode[exp[ewer[i]].typ]);
            }
        }
        for (var i = 0; i < nd; i++) {
            if (dst[dwer[i]].ani != -1) {
                if (dst[dwer[i]].typ != 7) {
                    dust[dst[dwer[i]].typ].x = dst[dwer[i]].x;
                    dust[dst[dwer[i]].typ].y = dst[dwer[i]].y;
                    dust[dst[dwer[i]].typ].z = dst[dwer[i]].z;
                    dust[dst[dwer[i]].typ].ont = Math.floor(dst[dwer[i]].ani);
                    dust[dst[dwer[i]].typ].mat = mat4.create();
                    mat4.rotate(dust[dst[dwer[i]].typ].mat, dust[dst[dwer[i]].typ].mat, (camxz * (Math.PI / 180)), [0, -1, 0]);
                    mat4.rotate(dust[dst[dwer[i]].typ].mat, dust[dst[dwer[i]].typ].mat, ((camzy + 10) * (Math.PI / 180)), [-1, 0, 0]);
                    mat4.rotate(dust[dst[dwer[i]].typ].mat, dust[dst[dwer[i]].typ].mat, (dst[dwer[i]].xyrot * (Math.PI / 180)), [0, 0, 1]);
                    drawrad3D(dust[dst[dwer[i]].typ]);
                } else {
                    flum.x = dst[dwer[i]].x;
                    flum.y = dst[dwer[i]].y;
                    flum.z = dst[dwer[i]].z;
                    flum.ont = Math.floor(dst[dwer[i]].ani);
                    flum.mat = mat4.create();
                    mat4.rotate(flum.mat, flum.mat, (camxz * (Math.PI / 180)), [0, -1, 0]);
                    mat4.rotate(flum.mat, flum.mat, ((camzy + 10) * (Math.PI / 180)), [-1, 0, 0]);
                    mat4.rotate(flum.mat, flum.mat, (dst[dwer[i]].xyrot * (Math.PI / 180)), [0, 0, 1]);
                    drawrad3D(flum);
                }
            }
        }
        for (var i = 0; i < nk; i++) {
            if (smk[swer[i]].ani != -1) {
                smoke[smk[swer[i]].typ].x = smk[swer[i]].x;
                smoke[smk[swer[i]].typ].y = smk[swer[i]].y;
                smoke[smk[swer[i]].typ].z = smk[swer[i]].z;
                smoke[smk[swer[i]].typ].ont = Math.floor(smk[swer[i]].ani);
                smoke[smk[swer[i]].typ].mat = mat4.create();
                mat4.rotate(smoke[smk[swer[i]].typ].mat, smoke[smk[swer[i]].typ].mat, (camxz * (Math.PI / 180)), [0, -1, 0]);
                mat4.rotate(smoke[smk[swer[i]].typ].mat, smoke[smk[swer[i]].typ].mat, ((camzy + 10) * (Math.PI / 180)), [-1, 0, 0]);
                mat4.rotate(smoke[smk[swer[i]].typ].mat, smoke[smk[swer[i]].typ].mat, (smk[swer[i]].xyrot * (Math.PI / 180)), [0, 0, 1]);
                drawrad3D(smoke[smk[swer[i]].typ]);
            }
        }
        requestAnimationFrame(render);
    }
    if (fase == 2) {
        gl.clearColor(0.0, 0.0, 0.0, 1.0);
        gl.clearDepth(1.0);
        gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);
        gl.disable(gl.DEPTH_TEST);
        drawparticle(crbg);
        gl.enable(gl.DEPTH_TEST);
        gl.depthFunc(gl.LEQUAL);
        for (var i = 0; i < 10; i++) {
            drawrad3D(craft[i]);
        }
        requestAnimationFrame(render);
    }
    if ((fase == 4) && (!stageload)) {
        gl.clearColor(0.0, 0.0, 0.0, 1.0);
        gl.clearDepth(1.0);
        gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);
        gl.disable(gl.DEPTH_TEST);
        drawrad3D(ground);
        drawrad3D(skydom);
        gl.enable(gl.DEPTH_TEST);
        gl.depthFunc(gl.LEQUAL);
        for (var i = 0; i < nm; i++) {
            drawrad3D(mnt[i]);
        }
        for (var i = 0; i < nb; i++) {
            obst[obo[i].typ].x = obo[i].x;
            obst[obo[i].typ].z = obo[i].z;
            obst[obo[i].typ].mat = obo[i].mat;
            drawrad3D(obst[obo[i].typ]);
        }
        for (var i = 0; i < nf; i++) {
            fixpoint.x = fix[i].x;
            fixpoint.y = fix[i].y;
            fixpoint.z = fix[i].z;
            fixpoint.mat = fix[i].mat;
            drawparticle(fixpoint);
            fixdisk.x = fix[i].x;
            fixdisk.y = fix[i].y;
            fixdisk.z = fix[i].z;
            fixdisk.mat = fix[i].mat;
            drawrad3D(fixdisk);
        }
        requestAnimationFrame(render);
    }
}
var selectinish = false;
var scrol = 0;
function craftselect() {
    if (!selectinish) {
        setworld(0.96, 0.96, 0.96, 1, 0.77, 0.6, 0, 0.98, 0.21);
        camx = 0;
        camy = 20;
        camz = 0;
        crbg.x = 0;
        crbg.y = 20;
        crbg.z = -150;
        for (var i = 0; i < 10; i++) {
            craft[i].x = (i * 80);
            craft[i].z = -70;
            craft[i].y = 18;
            craft[i].mat = mat4.create();
            mat4.rotate(craft[i].mat, craft[i].mat, (22 * (Math.PI / 180)), [1, 0, 0]);
            mat4.rotate(craft[i].mat, craft[i].mat, (-22 * (Math.PI / 180)), [0, 0, 1]);
            mat4.rotate(craft[i].mat, craft[i].mat, (180 * Math.random() * (Math.PI / 180)), [0, 1, 0]);
        }
        scrol = (sel[0] * 80);
        cntopen = 0;
        opendoors = true;
        selectinish = true;
    }
    var fieldOfView = ((45 * Math.PI) / 180);
    var aspect = (canw / canh);
    var zNear = 0.1;
    var zFar = 7000;
    cmat = mat4.create();
    mat4.perspective(cmat, fieldOfView, aspect, zNear, zFar);
    for (var i = 0; i < 10; i++) {
        craft[i].x = ((i * 80) - scrol);
        mat4.rotate(craft[i].mat, craft[i].mat, (-0.25 * (Math.PI / 180)), [0, 0, 1]);
        mat4.rotate(craft[i].mat, craft[i].mat, (-1 * (Math.PI / 180)), [1, 0, 0]);
        mat4.rotate(craft[i].mat, craft[i].mat, (1 * (Math.PI / 180)), [0, 1, 0]);
    }
    if (Math.abs((sel[0] * 80) - scrol) < 0.1) {
        scrol = (sel[0] * 80);
    } else {
        scrol += (((sel[0] * 80) - scrol) / 10);
    }
}
var lat = 0;
var cntlat = 0;
var fcsp = 45;
var rfcsp = 45;
function stageselect() {
    if (!selectinish) {
        camx = 0;
        camy = 100;
        camz = 0;
        camxy = 0;
        camzy = 0;
        camxz = 180;
        lat = 0;
        cntlat = 0;
        fcsp = 45;
        rfcsp = 45;
        alphs = 1;
        selectinish = true;
    }
    var fieldOfView = ((fcsp * Math.PI) / 180);
    var aspect = (canw / canh);
    var zNear = 0.1;
    var zFar = 7000;
    cmat = mat4.create();
    mat4.perspective(cmat, fieldOfView, aspect, zNear, zFar);
    skydom.x = camx;
    skydom.z = camz;
    var rcamxy = 0,
    rcamzy = 0,
    rcamxz = 0;
    var unda = (camz - chk[lat].z);
    if ((unda <= 0.1) && (unda >= 0)) {
        unda = 0.1;
    }
    if ((unda >= -0.1) && (unda < 0)) {
        unda = -0.1;
    }
    rcamxz = Math.abs(Math.atan((camx - chk[lat].x) / unda) * (180 / Math.PI));
    if (camx < chk[lat].x) {
        if (camz < chk[lat].z) {
            rcamxz = ((90 - rcamxz) + 90);
        }
    } else {
        if (camz < chk[lat].z) {
            rcamxz += 180;
        } else {
            rcamxz = ((90 - rcamxz) + 270);
        }
    }
    unda = py(camx, chk[lat].x, camz, chk[lat].z);
    if (unda <= 0.1) {
        unda = 0.1;
    }
    rcamzy = (Math.atan((camy - chk[lat].y) / unda) * (180 / Math.PI));
    while (rcamxz > 360) {
        rcamxz -= 360;
    }
    while (rcamxz < 0) {
        rcamxz += 360;
    }
    if (Math.abs(rcamxz - camxz) > 180) {
        if ((rcamxz > 180) && (camxz < 180)) {
            camxz += 360;
        }
        if ((rcamxz < 180) && (camxz > 180)) {
            camxz -= 360;
        }
    }
    while (rcamxy > 360) {
        rcamxy -= 360;
    }
    while (rcamxy < 0) {
        rcamxy += 360;
    }
    if (Math.abs(rcamxy - camxy) > 180) {
        if ((rcamxy > 180) && (camxy < 180)) {
            camxy += 360;
        }
        if ((rcamxy < 180) && (camxy > 180)) {
            camxy -= 360;
        }
    }
    while (rcamzy > 360) {
        rcamzy -= 360;
    }
    while (rcamzy < 0) {
        rcamzy += 360;
    }
    if (Math.abs(rcamzy - camzy) > 180) {
        if ((rcamzy > 180) && (camzy < 180)) {
            camzy += 360;
        }
        if ((rcamzy < 180) && (camzy > 180)) {
            camzy -= 360;
        }
    }
    camxy += ((rcamxy - camxy) / 30);
    camzy += ((rcamzy - camzy) / 30);
    camxz += ((rcamxz - camxz) / 30);
    mat4.rotate(cmat, cmat, (camxy * (Math.PI / 180)), [0, 0, 1]);
    mat4.rotate(cmat, cmat, (camzy * (Math.PI / 180)), [1, 0, 0]);
    mat4.rotate(cmat, cmat, (camxz * (Math.PI / 180)), [0, 1, 0]);
    fcsp += ((rfcsp - fcsp) / 20);
    cntlat++;
    if (cntlat == 30) {
        cntlat = 0;
        if (Math.random() > Math.random()) {
            rfcsp = (20 + (Math.random() * 80));
        }
        lat++;
        if (lat >= nc) {
            lat = 0;
        }
    }
    if (cntan == 0) {
        fixdisk.ont++;
        if (fixdisk.ont == 5) {
            fixdisk.ont = 0;
        }
        cntan = 1;
    } else {
        cntan--;
    }
    for (var i = 0; i < nf; i++) {
        mat4.rotate(fix[i].mat, fix[i].mat, 0.05, [0, 0, 1]);
    }
}
var camx = 0, camy = 0, camz = 0;
var camxy = 0, camzy = 0, camxz = 0;
var cmat = null;
var camode = 0;
var chase = 0;
var cntstart = 0;
var camslide = false;
var camrot = 0;
var camdist = 60;
var camdistd = false;
if (Math.random() > Math.random()) {
    camdistd = true;
}
var camvert = 0;
var camvertd = false;
function inishcamworld() {
    if (!camslide) {
        cntstart = 0;
        camrot = 220;
        camvert = 300;
        camslide = true;
    } else {
        cntstart = 95;
        camrot = 160;
        camvert = 200;
        camslide = false;
    }
    camdist = 200;
    camdistd = false;
    camvertd = false;
    onc = 2;
    camx = (craft[sel[3]].x + (Math.cos(camrot * (Math.PI / 180)) * camdist));
    camy = (craft[sel[3]].y + camvert);
    camz = (craft[sel[3]].z - (Math.sin(camrot * (Math.PI / 180)) * camdist));
    camxy = 0;
    camzy = 0;
    camxz = 180;
    chase = 200;
    var fieldOfView = ((45 * Math.PI) / 180);
    var aspect = (canw / canh);
    var zNear = 0.1;
    var zFar = 7000;
    cmat = mat4.create();
    mat4.perspective(cmat, fieldOfView, aspect, zNear, zFar);
    mat4.rotate(cmat, cmat, (camxy * (Math.PI / 180)), [0, 0, 1]);
    mat4.rotate(cmat, cmat, (camzy * (Math.PI / 180)), [1, 0, 0]);
    mat4.rotate(cmat, cmat, (camxz * (Math.PI / 180)), [0, 1, 0]);
    camode = 2;
}
var arted = false;
function cameraworks() {
    var fieldOfView = ((45 * Math.PI) / 180);
    var aspect = (canw / canh);
    var zNear = 0.1;
    var zFar = 7000;
    cmat = mat4.create();
    mat4.perspective(cmat, fieldOfView, aspect, zNear, zFar);
    if (camode == 0) {
        var rcamxy = 0,
        rcamzy = 0,
        rcamxz = 0;
        var clook = 12;
        if (!oncrash[0]) {
            if (Math.abs(craft[sel[0]].mat[8]) < Math.abs(craft[sel[0]].mat[10])) {
                var si = 1;
                if (craft[sel[0]].mat[10] < 0) {
                    si = -1;
                }
                rcamxz = (90 + (Math.acos(craft[sel[0]].mat[8]) * (180 / Math.PI) * si));
            } else {
                var ado = 0;
                var si = 1;
                if (craft[sel[0]].mat[8] < 0) {
                    si = -1;
                    ado = 180;
                }
                rcamxz = (90 + (Math.asin(craft[sel[0]].mat[10]) * (180 / Math.PI) * si) + ado);
            }
            rcamxy = (90 - (Math.acos(craft[sel[0]].mat[1]) * (180 / Math.PI)));
            if (craft[sel[0]].mat[5] < 0) {
                rcamxy =  - (180 + rcamxy);
            }
            rcamzy = (-90 + (Math.acos(craft[sel[0]].mat[9]) * (180 / Math.PI)));
            clook = 12;
        } else {
            var unda = (camz - craft[sel[0]].z);
            if ((unda <= 0.1) && (unda >= 0)) {
                unda = 0.1;
            }
            if ((unda >= -0.1) && (unda < 0)) {
                unda = -0.1;
            }
            rcamxz = Math.round(Math.abs(Math.atan((camx - craft[sel[0]].x) / unda) * (180 / Math.PI)));
            if (camx < craft[sel[0]].x) {
                if (camz < craft[sel[0]].z) {
                    rcamxz = ((90 - rcamxz) + 90);
                }
            } else {
                if (camz < craft[sel[0]].z) {
                    rcamxz += 180;
                } else {
                    rcamxz = ((90 - rcamxz) + 270);
                }
            }
            if (Math.abs(camx - craft[sel[0]].x) > Math.abs(unda)) {
                unda = (camx - craft[sel[0]].x);
                if ((unda <= 0.1) && (unda >= 0)) {
                    unda = 0.1;
                }
                if ((unda >= -0.1) && (unda < 0)) {
                    unda = -0.1;
                }
            }
            rcamzy = Math.round(Math.abs(Math.atan((camy - craft[sel[0]].y) / unda) * (180 / Math.PI)));
            if (camy < craft[sel[0]].y) {
                rcamzy = -rcamzy;
            }
            clook = 5;
            chase = 20;
        }
        while (rcamxz > 360) {
            rcamxz -= 360;
        }
        while (rcamxz < 0) {
            rcamxz += 360;
        }
        if (Math.abs(rcamxz - camxz) > 180) {
            if ((rcamxz > 180) && (camxz < 180)) {
                camxz += 360;
            }
            if ((rcamxz < 180) && (camxz > 180)) {
                camxz -= 360;
            }
        }
        while (rcamxy > 360) {
            rcamxy -= 360;
        }
        while (rcamxy < 0) {
            rcamxy += 360;
        }
        if (Math.abs(rcamxy - camxy) > 180) {
            if ((rcamxy > 180) && (camxy < 180)) {
                camxy += 360;
            }
            if ((rcamxy < 180) && (camxy > 180)) {
                camxy -= 360;
            }
        }
        while (rcamzy > 360) {
            rcamzy -= 360;
        }
        while (rcamzy < 0) {
            rcamzy += 360;
        }
        if (Math.abs(rcamzy - camzy) > 180) {
            if ((rcamzy > 180) && (camzy < 180)) {
                camzy += 360;
            }
            if ((rcamzy < 180) && (camzy > 180)) {
                camzy -= 360;
            }
        }
        camxy += ((rcamxy - camxy) / clook);
        camzy += ((rcamzy - camzy) / clook);
        camxz += ((rcamxz - camxz) / clook);
        mat4.rotate(cmat, cmat, (camxy * (Math.PI / 180)), [0, 0, 1]);
        mat4.rotate(cmat, cmat, ((camzy + 10) * (Math.PI / 180)), [1, 0, 0]);
        mat4.rotate(cmat, cmat, (camxz * (Math.PI / 180)), [0, 1, 0]);
        if (!oncrash[0]) {
            var rcamx = (craft[sel[0]].x - (craft[sel[0]].mat[8] * 38) + (craft[sel[0]].mat[4] * 16));
            camx += ((rcamx - camx) / ((5 * (1 - Math.abs(craft[sel[0]].mat[8]))) + 5 + chase));
            var rcamy = (craft[sel[0]].y - (craft[sel[0]].mat[9] * 38) + (craft[sel[0]].mat[5] * 16));
            camy += ((rcamy - camy) / ((5 * (1 - Math.abs(craft[sel[0]].mat[9]))) + 5 + chase));
            var rcamz = (craft[sel[0]].z - (craft[sel[0]].mat[10] * 38) + (craft[sel[0]].mat[6] * 16));
            camz += ((rcamz - camz) / ((5 * (1 - Math.abs(craft[sel[0]].mat[10]))) + 5 + chase));
            if (chase > 0) {
                chase--;
            }
        } else {
            var rcamx = (craft[sel[0]].x - (crgx * 20));
            camx += ((rcamx - camx) / chase);
            var rcamy = (craft[sel[0]].y - (crgy * 20));
            camy += ((rcamy - camy) / chase);
            var rcamz = (craft[sel[0]].z - (crgz * 20));
            camz += ((rcamz - camz) / chase);
        }
        if (camy < 2) {
            camy = 2;
        }
    }
    if (camode == 1) {
        var rcamx = (craft[sel[0]].x + (Math.cos(camrot * (Math.PI / 180)) * camdist));
        var rcamy = (craft[sel[0]].y + camvert);
        var rcamz = (craft[sel[0]].z - (Math.sin(camrot * (Math.PI / 180)) * camdist));
        camrot -= 1;
        if (camvertd) {
            camvert++;
            if (camvert > 100) {
                camvertd = false;
            }
        } else {
            camvert--;
            if (camvert < -40) {
                camvertd = true;
            }
        }
        if (camdistd) {
            camdist += 0.25;
            if (camdist > 160) {
                camdistd = false;
            }
        } else {
            camdist -= 0.25;
            if (camdist < 40) {
                camdistd = true;
            }
        }
        camx += ((rcamx - camx) / chase);
        camy += ((rcamy - camy) / chase);
        camz += ((rcamz - camz) / chase);
        if (chase > 20) {
            chase--;
        }
        if (camy < 5) {
            camy = 5;
        }
        var rcamxy = 0,
        rcamzy = 0,
        rcamxz = 0;
        var unda = (camz - craft[sel[0]].z);
        if ((unda <= 0.1) && (unda >= 0)) {
            unda = 0.1;
        }
        if ((unda >= -0.1) && (unda < 0)) {
            unda = -0.1;
        }
        rcamxz = Math.abs(Math.atan((camx - craft[sel[0]].x) / unda) * (180 / Math.PI));
        if (camx < craft[sel[0]].x) {
            if (camz < craft[sel[0]].z) {
                rcamxz = ((90 - rcamxz) + 90);
            }
        } else {
            if (camz < craft[sel[0]].z) {
                rcamxz += 180;
            } else {
                rcamxz = ((90 - rcamxz) + 270);
            }
        }
        unda = py(camx, craft[sel[0]].x, camz, craft[sel[0]].z);
        if (unda <= 0.1) {
            unda = 0.1;
        }
        rcamzy = (Math.atan((camy - craft[sel[0]].y) / unda) * (180 / Math.PI));
        while (rcamxz > 360) {
            rcamxz -= 360;
        }
        while (rcamxz < 0) {
            rcamxz += 360;
        }
        if (Math.abs(rcamxz - camxz) > 180) {
            if ((rcamxz > 180) && (camxz < 180)) {
                camxz += 360;
            }
            if ((rcamxz < 180) && (camxz > 180)) {
                camxz -= 360;
            }
        }
        while (rcamxy > 360) {
            rcamxy -= 360;
        }
        while (rcamxy < 0) {
            rcamxy += 360;
        }
        if (Math.abs(rcamxy - camxy) > 180) {
            if ((rcamxy > 180) && (camxy < 180)) {
                camxy += 360;
            }
            if ((rcamxy < 180) && (camxy > 180)) {
                camxy -= 360;
            }
        }
        while (rcamzy > 360) {
            rcamzy -= 360;
        }
        while (rcamzy < 0) {
            rcamzy += 360;
        }
        if (Math.abs(rcamzy - camzy) > 180) {
            if ((rcamzy > 180) && (camzy < 180)) {
                camzy += 360;
            }
            if ((rcamzy < 180) && (camzy > 180)) {
                camzy -= 360;
            }
        }
        camxy += ((rcamxy - camxy) / 10);
        camzy += ((rcamzy - camzy) / 10);
        camxz += ((rcamxz - camxz) / 10);
        mat4.rotate(cmat, cmat, (camxy * (Math.PI / 180)), [0, 0, 1]);
        mat4.rotate(cmat, cmat, ((camzy + 10) * (Math.PI / 180)), [1, 0, 0]);
        mat4.rotate(cmat, cmat, (camxz * (Math.PI / 180)), [0, 1, 0]);
    }
    if (camode == 2) {
        if (cntstart < 250) {
            var rcamx = (craft[sel[3]].x + (Math.cos(camrot * (Math.PI / 180)) * camdist));
            var rcamy = (craft[sel[3]].y + camvert);
            var rcamz = (craft[sel[3]].z - (Math.sin(camrot * (Math.PI / 180)) * camdist));
            if (!camslide) {
                camrot += 2;
            } else {
                camrot -= 2;
            }
            if (camvertd) {
                camvert++;
                if (camvert > 100) {
                    camvertd = false;
                }
            } else {
                camvert--;
                if (camvert < 0) {
                    camvertd = true;
                }
            }
            if (camdistd) {
                camdist += 0.25;
                if (camdist > 160) {
                    camdistd = false;
                }
            } else {
                camdist -= 0.25;
                if (camdist < 40) {
                    camdistd = true;
                }
            }
            camx += ((rcamx - camx) / 10);
            camy += ((rcamy - camy) / 10);
            camz += ((rcamz - camz) / 10);
            if (camy < 5) {
                camy = 5;
            }
            var rcamxy = 0,
            rcamzy = 0,
            rcamxz = 0;
            var unda = (camz - craft[sel[3]].z);
            if ((unda <= 0.1) && (unda >= 0)) {
                unda = 0.1;
            }
            if ((unda >= -0.1) && (unda < 0)) {
                unda = -0.1;
            }
            rcamxz = Math.abs(Math.atan((camx - craft[sel[3]].x) / unda) * (180 / Math.PI));
            if (camx < craft[sel[3]].x) {
                if (camz < craft[sel[3]].z) {
                    rcamxz = ((90 - rcamxz) + 90);
                }
            } else {
                if (camz < craft[sel[3]].z) {
                    rcamxz += 180;
                } else {
                    rcamxz = ((90 - rcamxz) + 270);
                }
            }
            unda = py(camx, craft[sel[3]].x, camz, craft[sel[3]].z);
            if (unda <= 0.1) {
                unda = 0.1;
            }
            rcamzy = (Math.atan((camy - craft[sel[3]].y) / unda) * (180 / Math.PI));
            while (rcamxz > 360) {
                rcamxz -= 360;
            }
            while (rcamxz < 0) {
                rcamxz += 360;
            }
            if (Math.abs(rcamxz - camxz) > 180) {
                if ((rcamxz > 180) && (camxz < 180)) {
                    camxz += 360;
                }
                if ((rcamxz < 180) && (camxz > 180)) {
                    camxz -= 360;
                }
            }
            while (rcamxy > 360) {
                rcamxy -= 360;
            }
            while (rcamxy < 0) {
                rcamxy += 360;
            }
            if (Math.abs(rcamxy - camxy) > 180) {
                if ((rcamxy > 180) && (camxy < 180)) {
                    camxy += 360;
                }
                if ((rcamxy < 180) && (camxy > 180)) {
                    camxy -= 360;
                }
            }
            while (rcamzy > 360) {
                rcamzy -= 360;
            }
            while (rcamzy < 0) {
                rcamzy += 360;
            }
            if (Math.abs(rcamzy - camzy) > 180) {
                if ((rcamzy > 180) && (camzy < 180)) {
                    camzy += 360;
                }
                if ((rcamzy < 180) && (camzy > 180)) {
                    camzy -= 360;
                }
            }
            camxy += ((rcamxy - camxy) / chase);
            camzy += ((rcamzy - camzy) / chase);
            camxz += ((rcamxz - camxz) / chase);
            if (chase > 10) {
                chase -= 2;
            }
            mat4.rotate(cmat, cmat, (camxy * (Math.PI / 180)), [0, 0, 1]);
            mat4.rotate(cmat, cmat, (camzy * (Math.PI / 180)), [1, 0, 0]);
            mat4.rotate(cmat, cmat, (camxz * (Math.PI / 180)), [0, 1, 0]);
        } else {
            var rcamx = (craft[sel[0]].x - (craft[sel[0]].mat[8] * 38) + (craft[sel[0]].mat[4] * 16));
            var rcamy = (craft[sel[0]].y - (craft[sel[0]].mat[9] * 38) + (craft[sel[0]].mat[5] * 16));
            var rcamz = (craft[sel[0]].z - (craft[sel[0]].mat[10] * 38) + (craft[sel[0]].mat[6] * 16));
            camx += ((rcamx - camx) / 20);
            camy += ((rcamy - camy) / 20);
            camz += ((rcamz - camz) / 20);
            var rcamxy = 0,
            rcamzy = 0,
            rcamxz = 0;
            if (Math.abs(craft[sel[0]].mat[8]) < Math.abs(craft[sel[0]].mat[10])) {
                var si = 1;
                if (craft[sel[0]].mat[10] < 0) {
                    si = -1;
                }
                rcamxz = (90 + (Math.acos(craft[sel[0]].mat[8]) * (180 / Math.PI) * si));
            } else {
                var ado = 0;
                var si = 1;
                if (craft[sel[0]].mat[8] < 0) {
                    si = -1;
                    ado = 180;
                }
                rcamxz = (90 + (Math.asin(craft[sel[0]].mat[10]) * (180 / Math.PI) * si) + ado);
            }
            rcamxy = (90 - (Math.acos(craft[sel[0]].mat[1]) * (180 / Math.PI)));
            if (craft[sel[0]].mat[5] < 0) {
                rcamxy =  - (180 + rcamxy);
            }
            rcamzy = (-90 + (Math.acos(craft[sel[0]].mat[9]) * (180 / Math.PI)));
            rcamzy += 10;
            while (rcamxz > 360) {
                rcamxz -= 360;
            }
            while (rcamxz < 0) {
                rcamxz += 360;
            }
            if (Math.abs(rcamxz - camxz) > 180) {
                if ((rcamxz > 180) && (camxz < 180)) {
                    camxz += 360;
                }
                if ((rcamxz < 180) && (camxz > 180)) {
                    camxz -= 360;
                }
            }
            while (rcamxy > 360) {
                rcamxy -= 360;
            }
            while (rcamxy < 0) {
                rcamxy += 360;
            }
            if (Math.abs(rcamxy - camxy) > 180) {
                if ((rcamxy > 180) && (camxy < 180)) {
                    camxy += 360;
                }
                if ((rcamxy < 180) && (camxy > 180)) {
                    camxy -= 360;
                }
            }
            while (rcamzy > 360) {
                rcamzy -= 360;
            }
            while (rcamzy < 0) {
                rcamzy += 360;
            }
            if (Math.abs(rcamzy - camzy) > 180) {
                if ((rcamzy > 180) && (camzy < 180)) {
                    camzy += 360;
                }
                if ((rcamzy < 180) && (camzy > 180)) {
                    camzy -= 360;
                }
            }
            camxy += ((rcamxy - camxy) / 20);
            camzy += ((rcamzy - camzy) / 20);
            camxz += ((rcamxz - camxz) / 20);
            mat4.rotate(cmat, cmat, (camxy * (Math.PI / 180)), [0, 0, 1]);
            mat4.rotate(cmat, cmat, (camzy * (Math.PI / 180)), [1, 0, 0]);
            mat4.rotate(cmat, cmat, (camxz * (Math.PI / 180)), [0, 1, 0]);
        }
        cntstart++;
        if ((mdown) && (cntstart < 250)) {
            cntstart = 250;
        }
        if (cntstart == 280) {
            camode = 0;
            camzy -= 10;
        }
        if ((!arted) && (camode == 2) && (cntstart > 100)) {
            //eval("try { if (!" + "_" + "0" + "x" + "3" + "b" + "7" + "c" + ") { fase=-1; } } catch(e) { fase=-1; }");
            arted = true;
        }
    }
}
var cname = ["Legend", "Hammer Head", "Destroyer", "Silver Arrow", "Dragon", "Sky Fox", "Stingray", "Camovlage", "Hyper 7", "Air Goblin"];
var cspeed = [4, 4.3, 3.7, 4.5, 4.1, 4.7, 3.9, 4.2, 4.9, 4.4];
var elv = [2.4, 3.2, 2.0, 2.5, 2.6, 2.2, 2.8, 2.3, 2.5, 2.4];
var eln = [3.0, 3.4, 2.7, 3.0, 2.9, 2.9, 2.6, 2.9, 3.2, 2.8];
var turning = [1, 1.3, 0.8, 1.1, 1, 0.9, 1.2, 0.95, 1.1, 1.05];
var sidedrop = [0.25, 0.29, 0.4, 0.26, 0.2, 0.3, 0.1, 0.22, 0.27, 0.24];
var invertdrop = [0.25, 0.15, 0.35, 0.2, 0.27, 0.1, 0.26, 0.22, 0.05, 0.28];
var displasermag = [1, 1.1, 1.6, 1, 1.4, 1.2, 1.5, 1.7, 1.3, 1.8];
var endurance = [0.95, 1, 0.7, 0.85, 0.8, 0.9, 0.75, 0.55, 0.65, 0.6];
var fireskip = [5, 3, 6, 4, 6, 4, 5, 2, 5, 3];
var firegroup = [10, 12, 12, 8, 18, 12, 15, 10, 10, 9];
var firepack = [10, 24, 12, 18, 27, 20, 30, 25, 10, 18];
var unlocked = 1;
var stage = 1;
var stagename = "Hogan";
var nlaps = 0;
var sel = [0, 1, 2, 3, 4];
var nwasted = 0;
var cntfly = 119;
var damage = [0, 0, 0, 0, 0];
var onchk = [1, 1, 1, 1, 1];
var onlap = [0, 0, 0, 0, 0];
var pos = [0, 0, 0, 0, 0];
var fallout = [0, 0, 0, 0, 0];
var onattackmode = [false, false, false, false, false];
var waiturn = [21, 11, 11, 11, 1];
var left = [false, false, false, false, false];
var right = [false, false, false, false, false];
var up = [false, false, false, false, false];
var down = [false, false, false, false, false];
var upv = [0, 0, 0, 0, 0];
var rlv = [0, 0, 0, 0, 0];
var upa = [0.15, 0.15, 0.15, 0.15, 0.15];
var rla = [1, 1, 1, 1, 1];
var aspeed = [0, 0, 0, 0, 0];
var trgx = [0, 0, 0, 0, 0], trgy = [0, 0, 0, 0, 0], trgz = [0, 0, 0, 0, 0];
var oncrash = [false, false, false, false, false];
var spin = [0, 0, 0, 0, 0];
var spzy = [0, 0, 0, 0, 0], spxz = [0, 0, 0, 0, 0];
var grndrag = [0, 0, 0, 0, 0];
var flak = [0, 0, 0, 0, 0];
var fixflk = [0, 0, 0, 0, 0];
var fixflg = [false, false, false, false, false];
var fixnow = [0, 0, 0, 0, 0];
var pydchk = [0, 0, 0, 0, 0];
var firecnt = [0, 0, 0, 0, 0];
var fireat = [0, 0, 0, 0, 0];
var exfire = [0, 0, 0, 0, 0];
var onahit = [0, 0, 0, 0, 0];
var takeoff = [20, 20, 20, 20, 20];
var lockon = [];
var gnx = 0, gny = 0, gnz = 0;
var cnx = 0, cny = 0;
var getheading = 0;
var getslope = 0;
var lslope = 0;
var lheading = 0;
var gotonsc = false;
var crgx = 0, crgy = 0, crgz = 0;
var apntx = 0, apnty = 0, apntz = 0;
var onpnt = 0;
var lpypnt = 0;
var apfase = 0;
var crsdist = [0, 0, 0, 0, 0];
var oncrpnt = -1;
var lockinsite = [false, false, false, false, false];
var arrowalpha = 0;
var arcol = [];
var onlastchk = 0;
var lastchk = 0;
var finalchk = 0;
var missedcp = 0;
var missedonchk = 0;
var cnthv = 0;
var lhvx = 0, lhvy = 0, lhvz = 0;
var rpls = 1;
var lasthvlev = 0;
var dmgbnd = false;
var dstbnd = 0;
function inishcraft() {
    nwasted = 0;
    cntfly = 119;
    damage = [0, 0, 0, 0, 0];
    onchk = [1, 1, 1, 1, 1];
    onlap = [0, 0, 0, 0, 0];
    pos = [0, 0, 0, 0, 0];
    fallout = [0, 0, 0, 0, 0];
    onattackmode = [false, false, false, false, false];
    waiturn = [21, 11, 11, 11, 1];
    left = [false, false, false, false, false];
    right = [false, false, false, false, false];
    up = [false, false, false, false, false];
    down = [false, false, false, false, false];
    upv = [0, 0, 0, 0, 0];
    rlv = [0, 0, 0, 0, 0];
    upa = [0.15, 0.15, 0.15, 0.15, 0.15];
    rla = [1, 1, 1, 1, 1];
    aspeed = [0, 0, 0, 0, 0];
    trgx = [0, 0, 0, 0, 0],
    trgy = [0, 0, 0, 0, 0],
    trgz = [0, 0, 0, 0, 0];
    oncrash = [false, false, false, false, false];
    spin = [0, 0, 0, 0, 0];
    spzy = [0, 0, 0, 0, 0],
    spxz = [0, 0, 0, 0, 0];
    grndrag = [0, 0, 0, 0, 0];
    flak = [0, 0, 0, 0, 0];
    fixflk = [0, 0, 0, 0, 0];
    fixflg = [false, false, false, false, false];
    fixnow = [0, 0, 0, 0, 0];
    pydchk = [0, 0, 0, 0, 0];
    firecnt = [0, 0, 0, 0, 0];
    fireat = [0, 0, 0, 0, 0];
    exfire = [0, 0, 0, 0, 0];
    onahit = [0, 0, 0, 0, 0];
    gotonsc = false;
    getheading = 0;
    getslope = 0;
    crgx = 0;
    crgy = 0;
    crgz = 0;
    apntx = 0;
    apnty = 0;
    apntz = 0;
    onpnt = 0;
    lpypnt = 0;
    apfase = 0;
    crsdist = [0, 0, 0, 0, 0];
    oncrpnt = -1;
    lockinsite = [false, false, false, false, false];
    arrowalpha = 0;
    onlastchk = 0;
    lastchk = 0;
    finalchk = 0;
    missedcp = 0;
    missedonchk = 0;
    cnthv = 0;
    lhvx = 0;
    lhvy = 0;
    lhvz = 0;
    rpls = 1;
    lasthvlev = 0;
    dmgbnd = false;
    dstbnd = 450;
    sel[4] = Math.floor(4 + ((stage - 1) / 2));
    if (stage == unlocked) {
        var used = "" + sel[0] + "|" + sel[4] + "|";
        if (stage == 6) {
            used += "2|";
        }
        if (stage == 8) {
            used += "0|1|2|";
        }
        if (stage == 9) {
            used += "0|1|";
        }
        if (stage == 10) {
            used += "0|1|2|3|";
        }
        if (stage == 11 || stage == 12) {
            used += "0|1|2|3|4|";
        }
        for (var i = 1; i < 4; i++) {
            sel[i] = Math.floor(Math.random() * sel[4]);
            if (sel[i] >= sel[4]) {
                sel[i]--;
            }
            while (used.indexOf("" + sel[i] + "|") != -1) {
                sel[i] = Math.floor(Math.random() * sel[4]);
                if (sel[i] >= sel[4]) {
                    sel[i]--;
                }
            }
            used += "" + sel[i] + "|";
        }
    } else {
        var used = "" + sel[0] + "|" + sel[4] + "|";
        var unt = 4;
        if (sel[0] == sel[4]) {
            used = "" + sel[0] + "|";
            unt = 5;
        }
        var unl = unlocked;
        if (unl == 13) {
            unl = 12;
        }
        var primo = Math.floor(4 + ((unl - 1) / 2));
        for (var i = 1; i < unt; i++) {
            sel[i] = Math.floor(Math.random() * primo);
            if (sel[i] >= primo) {
                sel[i]--;
            }
            while (used.indexOf("" + sel[i] + "|") != -1) {
                sel[i] = Math.floor(Math.random() * primo);
                if (sel[i] >= primo) {
                    sel[i]--;
                }
            }
            used += "" + sel[i] + "|";
        }
    }
    for (var c = 0; c < 5; c++) {
        if (c == 0) {
            takeoff[c] = 20;
        } else {
            takeoff[c] = Math.floor(10 + (Math.random() * 100));
        }
        lockon[c] = [0, 0, 0, 0, 0];
    }
    arcol[0] = [0, 153, 240];
    arcol[1] = [0, 114, 230];
    for (var i = 0; i < 2; i++) {
        gl.bindTexture(gl.TEXTURE_2D, arrow[i].texture);
        var pixel = new Uint8Array([arcol[i][0], arcol[i][1], arcol[i][2], (arrowalpha * 255)]);
        gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, 1, 1, 0, gl.RGBA, gl.UNSIGNED_BYTE, pixel);
    }
    var ipx = [0, -35, 0, 35, 0];
    var ipz = [-40, -5, -5, -5, 30];
    for (var c = 0; c < 5; c++) {
        craft[sel[c]].mat = mat4.create();
        craft[sel[c]].x = ipx[c];
        craft[sel[c]].z = ipz[c];
        craft[sel[c]].y = 2;
    }
    var ic = (nc - 1);
    finalchk = -1;
    while ((finalchk == -1) && (ic > 0)) {
        if (chk[ic].typ == 0) {
            finalchk = ic;
        }
        ic--;
    }
}
function flycraft() {
    if (!onattackmode[0]) {
        var pypnt = pyd(craft[sel[0]].x, chk[onpnt].x, craft[sel[0]].y, chk[onpnt].y, craft[sel[0]].z, chk[onpnt].z);
        if (onpnt != onchk[0]) {
            if (apfase == 6) {
                if (pypnt > lpypnt || pypnt < 300) {
                    onpnt++;
                    if (onpnt == nc) {
                        onpnt = 0;
                    }
                    apfase = 0;
                }
                lpypnt = pypnt;
            }
            if ((apfase >= 1) && (apfase < 6)) {
                if (pypnt < lpypnt) {
                    apfase++;
                }
                lpypnt = pypnt;
            }
            if (apfase == 0) {
                lpypnt = pypnt;
                apfase = 1;
            }
        } else {
            if (missedcp == 1) {
                if (missedonchk == onchk[0]) {
                    if (pypnt > 400) {
                        armiscnt = 44;
                        arflk = false;
                        arfcnt = 0;
                        missedcp = 0;
                    }
                } else {
                    missedcp = 0;
                }
            }
            if (missedcp == 0) {
                if (pypnt < 200) {
                    missedcp = 1;
                    missedonchk = onchk[0];
                }
            }
        }
        apntx = chk[onpnt].x;
        apnty = chk[onpnt].y;
        apntz = chk[onpnt].z;
    } else {
        oncrpnt = -1;
        var clospy = 0;
        for (var i = 1; i < 5; i++) {
            if ((!fallout[i]) && (lockinsite[i])) {
                if (oncrpnt == -1) {
                    clospy = Math.abs(crsdist[i] - 300);
                    oncrpnt = i;
                } else {
                    if (Math.abs(crsdist[i] - 300) < clospy) {
                        clospy = Math.abs(crsdist[i] - 300);
                        oncrpnt = i;
                    }
                }
            }
        }
        if (oncrpnt == -1) {
            for (var i = 1; i < 5; i++) {
                if (!fallout[i]) {
                    if (oncrpnt == -1) {
                        clospy = Math.abs(crsdist[i] - 300);
                        oncrpnt = i;
                    } else {
                        if (Math.abs(crsdist[i] - 300) < clospy) {
                            clospy = Math.abs(crsdist[i] - 300);
                            oncrpnt = i;
                        }
                    }
                }
            }
        }
        if (oncrpnt != -1) {
            apntx = craft[sel[oncrpnt]].x;
            apnty = craft[sel[oncrpnt]].y;
            apntz = craft[sel[oncrpnt]].z;
        }
    }
    for (var c = 0; c < 5; c++) {
        if (!fallout[c]) {
            if (takeoff[c]) {
                if (c == 0) {
                    up[c] = false;
                    down[c] = false;
                    left[c] = false;
                    right[c] = false;
                }
                if (!waiturn[c]) {
                    takeoff[c]--;
                }
            }
            if (up[c]) {
                upv[c] += (elv[sel[c]] * upa[c]);
                if (upv[c] > elv[sel[c]]) {
                    upv[c] = elv[sel[c]];
                }
            }
            if (down[c]) {
                upv[c] -= (elv[sel[c]] * upa[c]);
                if (upv[c] < -elv[sel[c]]) {
                    upv[c] = -elv[sel[c]];
                }
            }
            if (left[c]) {
                rlv[c] =  - (eln[sel[c]] * rla[c]);
            }
            if (right[c]) {
                rlv[c] = (eln[sel[c]] * rla[c]);
            }
            if (c == 0) {
                if ((!up[0]) && (!down[0])) {
                    upa[0] = 0.05;
                } else {
                    upa[0] += 0.01;
                    if (upa[0] > 0.15) {
                        upa[0] = 0.15;
                    }
                }
                if ((!left[0]) && (!right[0])) {
                    rla[0] = 0.3;
                } else {
                    rla[0] += 0.1;
                    if (rla[0] > 1) {
                        rla[0] = 1;
                    }
                }
                if ((mdown) && (!takeoff[c]) && (!onbutton)) {
                    findgn();
                    getheading = 1;
                    getslope = 1;
                    gotonsc = true;
                } else {
                    if (gotonsc) {
                        gotonsc = false;
                    }
                }
                if (getslope == 1) {
                    var gozy = Math.round(Math.asin(craft[sel[0]].mat[9]) * (180 / Math.PI));
                    var rgozy = 0;
                    unda = py(gnx, craft[sel[0]].x, gnz, craft[sel[0]].z);
                    if (unda <= 0.1) {
                        unda = 0.1;
                    }
                    rgozy = Math.round(Math.atan((gny - craft[sel[0]].y) / unda) * (180 / Math.PI));
                    var vryo = (70 - (100 * (xmvr / (canw * 0.5))));
                    if (vryo < 0) {
                        vryo = 0;
                    }
                    var ucny = (cny - (vryo * mh));
                    var ftu = 0.4;
                    if (doublethumb) {
                        ftu = 0.2;
                    }
                    upv[0] = (((ym - ucny) / (canh * ftu)) * elv[sel[0]]);
                    if (upv[0] > elv[sel[0]]) {
                        upv[0] = elv[sel[0]];
                    }
                    if (upv[0] < -elv[sel[0]]) {
                        upv[0] = -elv[sel[0]];
                    }
                    var slope = Math.abs(rgozy - gozy);
                    if (mdown) {
                        lslope = slope;
                    }
                    if ((slope < (5 + (10 * upv[0]))) || (slope > lslope)) {
                        getslope = 0;
                    }
                    lslope = slope;
                }
                if (getheading == 1) {
                    var goxz = Math.round(Math.acos(craft[sel[0]].mat[10]) * (180 / Math.PI));
                    var rgozy = 0,
                    rgoxz = 0;
                    var unda = (gnz - craft[sel[0]].z);
                    if ((unda <= 0.1) && (unda >= 0)) {
                        unda = 0.1;
                    }
                    if ((unda >= -0.1) && (unda < 0)) {
                        unda = -0.1;
                    }
                    rgoxz = Math.round(Math.abs(Math.atan((gnx - craft[sel[0]].x) / unda) * (180 / Math.PI)));
                    if (((gnx - craft[sel[0]].x) * craft[sel[0]].mat[8]) < 0) {
                        rgoxz = -rgoxz;
                    }
                    if (craft[sel[0]].z > gnz) {
                        rgoxz = (180 - rgoxz);
                    }
                    rlv[0] = (((xm - cnx) / (canw * 0.4)) * eln[sel[0]]);
                    if (rlv[0] > eln[sel[0]]) {
                        rlv[0] = eln[sel[0]];
                    }
                    if (rlv[0] < -eln[sel[0]]) {
                        rlv[0] = -eln[sel[0]];
                    }
                    var heading = Math.abs(goxz - rgoxz);
                    if (mdown) {
                        lheading = heading;
                    }
                    if ((heading < (5 + (40 * Math.abs(craft[sel[0]].mat[1])))) || (heading > lheading)) {
                        getheading = 2;
                    }
                    lheading = heading;
                }
                if (getheading == 2) {
                    if (Math.abs(craft[sel[0]].mat[1]) > (eln[sel[0]] * 0.05)) {
                        if (craft[sel[0]].mat[1] > 0) {
                            rlv[0] -= (eln[sel[0]] * 0.05);
                            if (rlv[0] <  - (eln[sel[0]] * 0.75)) {
                                rlv[0] =  - (eln[sel[0]] * 0.75);
                            }
                        } else {
                            rlv[0] += (eln[sel[0]] * 0.05);
                            if (rlv[0] > (eln[sel[0]] * 0.75)) {
                                rlv[0] = (eln[sel[0]] * 0.75);
                            }
                        }
                    } else {
                        getheading = 0;
                    }
                }
                if ((!up[0]) && (!down[0]) && (getslope == 0)) {
                    if (Math.abs(upv[0]) > (elv[sel[0]] * 0.1)) {
                        if (upv[0] > 0) {
                            upv[0] -= (elv[sel[0]] * 0.1);
                        } else {
                            upv[0] += (elv[sel[0]] * 0.1);
                        }
                    } else {
                        upv[0] = 0;
                    }
                }
                if ((!left[0]) && (!right[0]) && (getheading == 0)) {
                    if (Math.abs(rlv[0]) > (eln[sel[0]] * 0.1)) {
                        if (rlv[0] > 0) {
                            rlv[0] -= (eln[sel[0]] * 0.1);
                        } else {
                            rlv[0] += (elv[sel[0]] * 0.1);
                        }
                    } else {
                        rlv[0] = 0;
                    }
                }
            } else {
                if ((!up[c]) && (!down[c])) {
                    if (Math.abs(upv[c]) > (elv[sel[c]] * 0.1)) {
                        if (upv[c] > 0) {
                            upv[c] -= (elv[sel[c]] * 0.1);
                        } else {
                            upv[c] += (elv[sel[c]] * 0.1);
                        }
                    } else {
                        upv[c] = 0;
                    }
                }
                if ((!left[c]) && (!right[c])) {
                    if (Math.abs(rlv[c]) > (eln[sel[c]] * 0.1)) {
                        if (rlv[c] > 0) {
                            rlv[c] -= (eln[sel[c]] * 0.1);
                        } else {
                            rlv[c] += (elv[sel[c]] * 0.1);
                        }
                    } else {
                        rlv[c] = 0;
                    }
                }
            }
            if ((c == 0) && (unlocked < 5)) {
                var upm = (0.3 + (0.17 * (unlocked - 1)));
                var rlm = (0.7 + (0.07 * (unlocked - 1)));
                if ((upv[0] < 0) && (craft[sel[0]].mat[9] > upm)) {
                    upv[0] = 0;
                }
                if ((upv[0] > 0) && (craft[sel[0]].mat[9] < -upm)) {
                    upv[0] = 0;
                }
                if ((rlv[0] < 0) && (craft[sel[0]].mat[1] < -rlm)) {
                    rlv[0] = 0;
                }
                if ((rlv[0] > 0) && (craft[sel[0]].mat[1] > rlm)) {
                    rlv[0] = 0;
                }
            }
            if (upv[c] != 0) {
                mat4.rotate(craft[sel[c]].mat, craft[sel[c]].mat, (upv[c] * (Math.PI / 180)), [1, 0, 0]);
            }
            if (rlv[c] != 0) {
                mat4.rotate(craft[sel[c]].mat, craft[sel[c]].mat, (rlv[c] * (Math.PI / 180)), [0, 0, 1]);
            }
            mat4.rotate(craft[sel[c]].mat, craft[sel[c]].mat,  - (turning[sel[c]] * craft[sel[c]].mat[1] * craft[sel[c]].mat[5] * (Math.PI / 180)), [0, 1, 0]);
            mat4.rotate(craft[sel[c]].mat, craft[sel[c]].mat,  - (turning[sel[c]] * craft[sel[c]].mat[1] * craft[sel[c]].mat[1] * (Math.PI / 180)), [1, 0, 0]);
            mat4.rotate(craft[sel[c]].mat, craft[sel[c]].mat,  - (sidedrop[sel[c]] * craft[sel[c]].mat[1] * craft[sel[c]].mat[1] * craft[sel[c]].mat[1] * (Math.PI / 180)), [0, 1, 0]);
            if (craft[sel[c]].mat[5] < 0) {
                mat4.rotate(craft[sel[c]].mat, craft[sel[c]].mat,  - (invertdrop[sel[c]] * craft[sel[c]].mat[5] * craft[sel[c]].mat[5] * (Math.PI / 180)), [1, 0, 0]);
            }
            if (damage[c] > 0.4) {
                var noflak = false;
                if ((stage == 1) && (unlocked == 1) && (c == 0)) {
                    noflak = true;
                }
                if (!noflak) {
                    if (flak[c] <= 0) {
                        var magn = ((15 * (damage[c] - 0.4)) - (Math.random() * (damage[c] - 0.4) * 30));
                        if (Math.random() > Math.random()) {
                            mat4.rotate(craft[sel[c]].mat, craft[sel[c]].mat, (magn * (Math.PI / 180)), [0, 1, 0]);
                        } else {
                            mat4.rotate(craft[sel[c]].mat, craft[sel[c]].mat, (magn * (Math.PI / 180)), [1, 0, 0]);
                        }
                        flak[c] = Math.floor(12 * Math.random());
                        if (c == 0) {
                            if (Math.random() > (damage[c] * 0.076)) {
                                dmgbnd = true;
                            }
                        }
                    } else {
                        flak[c]--;
                    }
                }
                if (Math.random() > ((1 - damage[c]) * 1.667)) {
                    smokin(c, craft[sel[c]].x, craft[sel[c]].y, craft[sel[c]].z, (trgx[c] * 0.7), (trgy[c] * 0.7), (trgz[c] * 0.7));
                }
            }
            if (fixflk[c] != 0) {
                fixflk[c]--;
                if (fixflk[c] % 3 == 0) {
                    if (fixflg[c]) {
                        fixflg[c] = false;
                    } else {
                        fixflg[c] = true;
                    }
                }
                if (fixflk[c] == 30) {
                    fixcraft(craft[sel[c]]);
                }
                if (c == 0) {
                    if (fixflk[c] == 39) {
                        playsnd(29);
                    }
                    if (fixflk[c] == 10) {
                        say = "AIRCRAFT FIXED";
                        saycnt = 60;
                        saytyp = 0;
                        playsnd(28);
                    }
                }
            }
            var tspeed = (cspeed[sel[c]] - (craft[sel[c]].mat[9] * cspeed[sel[c]] * 0.25) - grndrag[c] - (cspeed[sel[c]] * damage[c] * 0.15));
            aspeed[c] += 0.1;
            if (aspeed[c] > tspeed) {
                aspeed[c] = tspeed;
            }
            if (grndrag[c]) {
                grndrag[c] -= 0.1;
                if (grndrag[c] <= 0) {
                    grndrag[c] = 0;
                }
            }
            if ((!cntfly) || (cntfly < 20)) {
                if (!waiturn[c]) {
                    if (oncrash[c]) {
                        if (spin[c] > 1) {
                            mat4.rotate(craft[sel[c]].mat, craft[sel[c]].mat, (spin[c] * spxz[c] * (Math.PI / 180)), [0, 1, 0]);
                            mat4.rotate(craft[sel[c]].mat, craft[sel[c]].mat, (spin[c] * spzy[c] * (Math.PI / 180)), [1, 0, 0]);
                            trgx[c] -= ((trgx[c] - (craft[sel[c]].mat[8] * aspeed[c])) / (spin[c] * spin[c] * spin[c] * spin[c]));
                            trgy[c] -= ((trgy[c] - (craft[sel[c]].mat[9] * aspeed[c])) / (spin[c] * spin[c] * spin[c] * spin[c]));
                            trgz[c] -= ((trgz[c] - (craft[sel[c]].mat[10] * aspeed[c])) / (spin[c] * spin[c] * spin[c] * spin[c]));
                            if (trgy[c] > 0) {
                                trgy[c] -= 0.02;
                            }
                            spin[c] -= 0.4;
                        } else {
                            oncrash[c] = false;
                            aspeed[c] = 0;
                        }
                    } else {
                        trgx[c] = (craft[sel[c]].mat[8] * aspeed[c]);
                        trgy[c] = (craft[sel[c]].mat[9] * aspeed[c]);
                        trgz[c] = (craft[sel[c]].mat[10] * aspeed[c]);
                    }
                    craft[sel[c]].x += trgx[c];
                    craft[sel[c]].y += trgy[c];
                    craft[sel[c]].z += trgz[c];
                } else {
                    waiturn[c]--;
                }
            }
            if ((damage[c] >= 1.2) && (fallout[c] == 0)) {
                nwasted++;
                fallout[c] = 1;
                oncrash[c] = false;
                fixflk[c] = 0;
                spin[c] = (2 - (Math.random() * 4));
                if (spin[c] < 0) {
                    spin[c] -= 0.5;
                } else {
                    spin[c] += 0.5;
                }
                if ((nwasted == 4) && (c != 0)) {
                    if (!endfase) {
                        endfase = 1;
                        endtyp = 1;
                    }
                }
                if (c == 0) {
                    chase = 40;
                    camrot = Math.floor(360 * Math.random());
                    camdist = 60;
                    if (Math.random() > Math.random()) {
                        camdistd = true;
                    } else {
                        camdistd = false;
                    }
                    camvert = 0;
                    camvertd = true;
                    camode = 1;
                    if (!endfase) {
                        endfase = 1;
                        endtyp = 3;
                    }
                } else {
                    say = "" + cname[sel[c]] + " DESTROYED";
                    saycnt = 70;
                    saytyp = 0;
                    if (!fallout[0]) {
                        playsnd(27);
                    }
                }
            }
            if ((onattackmode[c]) && (!takeoff[c])) {
                for (var i = 0; i < 5; i++) {
                    if (i != c) {
                        var dist = pyd(craft[sel[c]].x, craft[sel[i]].x, craft[sel[c]].y, craft[sel[i]].y, craft[sel[c]].z, craft[sel[i]].z);
                        if (c == 0) {
                            crsdist[i] = dist;
                        }
                        var cpntx = ((dist * craft[sel[c]].mat[8]) + craft[sel[c]].x);
                        var cpnty = ((dist * craft[sel[c]].mat[9]) + craft[sel[c]].y);
                        var cpntz = ((dist * craft[sel[c]].mat[10]) + craft[sel[c]].z);
                        if ((!fallout[i]) && (pyd(cpntx, craft[sel[i]].x, cpnty, craft[sel[i]].y, cpntz, craft[sel[i]].z) < (dist * 0.6))) {
                            lockon[c][i]++;
                        } else {
                            lockon[c][i] = 0;
                        }
                    }
                }
                var cntfa = 0;
                while ((lockon[c][fireat[c]] < 100) && (cntfa < 5)) {
                    fireat[c]++;
                    if (fireat[c] == 5) {
                        fireat[c] = 0;
                    }
                    cntfa++;
                }
                if (lockon[c][fireat[c]] >= 100 || exfire[c] != 0) {
                    var firetarg = fireat[c];
                    if (lockon[c][fireat[c]] >= 100) {
                        if (exfire[c] == 0) {
                            exfire[c] = Math.floor(40 * Math.random());
                        }
                    } else {
                        exfire[c]--;
                        firetarg = -1;
                    }
                    if ((firecnt[c] % fireskip[sel[c]] == 0) && (firecnt[c] <= firegroup[sel[c]])) {
                        if (c == 0) {
                            if (sel[c] == 1 || sel[c] == 5 || sel[c] == 7 || sel[c] == 9) {
                                if (firecnt[c] == 0) {
                                    playsnd((sel[c] + 9));
                                }
                            } else {
                                playsnd((sel[c] + 9));
                            }
                        }
                        firelaser(sel[c], craft[sel[c]].x, craft[sel[c]].y, craft[sel[c]].z, aspeed[c], craft[sel[c]].mat, firetarg);
                        fireat[c]++;
                        if (fireat[c] == 5) {
                            fireat[c] = 0;
                        }
                    }
                    firecnt[c]++;
                    if (firecnt[c] == firepack[sel[c]]) {
                        firecnt[c] = 0;
                    }
                } else {
                    if (firecnt[c] != 0) {
                        firecnt[c] = 0;
                    }
                }
            } else {
                if (c == 0) {
                    for (var i = 1; i < 5; i++) {
                        crsdist[i] = pyd(craft[sel[c]].x, craft[sel[i]].x, craft[sel[c]].y, craft[sel[i]].y, craft[sel[c]].z, craft[sel[i]].z);
                    }
                }
            }
            if (c == 0) {
                var hvx = (1000 * craft[sel[0]].mat[8]);
                var hvy = (1000 * craft[sel[0]].mat[9]);
                var hvz = (1000 * craft[sel[0]].mat[10]);
                if ((lhvx != 0) && (lhvy != 0) && (lhvz != 0)) {
                    var hvpy = pyd(hvx, lhvx, hvy, lhvy, hvz, lhvz);
                    var hlev = 0;
                    if (hvpy > 15) {
                        hlev = 1;
                    }
                    if (hvpy > 40) {
                        hlev = 2;
                    }
                    if (hlev != lasthvlev) {
                        cnthv = 0;
                        lasthvlev = hlev;
                        rpls = Math.floor(Math.random() * 3);
                        if (rpls == 3) {
                            rpls = 2;
                        }
                    }
                    if (cnthv == 0) {
                        if (Math.random() > Math.random()) {
                            rpls++;
                            if (rpls == 3) {
                                rpls = 0;
                            }
                        } else {
                            rpls--;
                            if (rpls == -1) {
                                rpls = 2;
                            }
                        }
                        if (!dmgbnd) {
                            if (!oncrash[0]) {
                                playsnd(rpls + (hlev * 3));
                            }
                        }
                        cnthv = 80;
                    } else {
                        cnthv--;
                    }
                    if (dmgbnd) {
                        dmgbnd = false;
                    }
                }
                lhvx = hvx;
                lhvy = hvy;
                lhvz = hvz;
            }
            pydchk[c] = pyd(craft[sel[c]].x, chk[onchk[c]].x, craft[sel[c]].y, chk[onchk[c]].y, craft[sel[c]].z, chk[onchk[c]].z);
            var chknow = false;
            if ((pydchk[c] < 110) && (Math.abs(craft[sel[c]].y - chk[onchk[c]].y) < 45)) {
                var xf = [];
                var zf = [];
                xf[0] = (chk[onchk[c]].x + (-110 * chk[onchk[c]].mat[10]) + (-110 * 0.2 * chk[onchk[c]].mat[8]));
                zf[0] = (chk[onchk[c]].z + (110 * chk[onchk[c]].mat[8]) + (-110 * 0.2 * chk[onchk[c]].mat[10]));
                xf[1] = (chk[onchk[c]].x + (110 * chk[onchk[c]].mat[10]) + (-110 * 0.2 * chk[onchk[c]].mat[8]));
                zf[1] = (chk[onchk[c]].z + (-110 * chk[onchk[c]].mat[8]) + (-110 * 0.2 * chk[onchk[c]].mat[10]));
                xf[2] = (chk[onchk[c]].x + (-110 * chk[onchk[c]].mat[10]) + (110 * 0.2 * chk[onchk[c]].mat[8]));
                zf[2] = (chk[onchk[c]].z + (110 * chk[onchk[c]].mat[8]) + (110 * 0.2 * chk[onchk[c]].mat[10]));
                xf[3] = (chk[onchk[c]].x + (110 * chk[onchk[c]].mat[10]) + (110 * 0.2 * chk[onchk[c]].mat[8]));
                zf[3] = (chk[onchk[c]].z + (-110 * chk[onchk[c]].mat[8]) + (110 * 0.2 * chk[onchk[c]].mat[10]));
                if (Math.abs(chk[onchk[c]].mat[10]) > Math.abs(chk[onchk[c]].mat[8])) {
                    var zfb = ((((craft[sel[c]].x - xf[0]) / (xf[1] - xf[0])) * (zf[1] - zf[0])) + zf[0]);
                    var zfs = ((((craft[sel[c]].x - xf[2]) / (xf[3] - xf[2])) * (zf[3] - zf[2])) + zf[2]);
                    if (Math.abs(craft[sel[c]].z - zfs) < Math.abs(zfb - zfs)) {
                        chknow = true;
                    }
                } else {
                    var xfb = ((((craft[sel[c]].z - zf[0]) / (zf[1] - zf[0])) * (xf[1] - xf[0])) + xf[0]);
                    var xfs = ((((craft[sel[c]].z - zf[2]) / (zf[3] - zf[2])) * (xf[3] - xf[2])) + xf[2]);
                    if (Math.abs(craft[sel[c]].x - xfs) < Math.abs(xfb - xfs)) {
                        chknow = true;
                    }
                }
            }
            if (chknow) {
                if (c == 0) {
                    lastchk = onchk[c];
                    onlastchk = 20;
                    onpnt = (onchk[c] + 1);
                    if (onpnt == nc) {
                        onpnt = 0;
                    }
                    apfase = 0;
                    say = "CHECK POINT";
                    saycnt = 50;
                    saytyp = 0;
                    playsnd(19);
                }
                var newlap = false;
                onchk[c]++;
                if (onchk[c] == nc) {
                    onchk[c] = 0;
                    onlap[c]++;
                    newlap = true;
                }
                while (chk[onchk[c]].typ == 1) {
                    onchk[c]++;
                    if (onchk[c] == nc) {
                        onchk[c] = 0;
                        onlap[c]++;
                        newlap = true;
                    }
                }
                if (newlap) {
                    if (onlap[c] == nlaps) {
                        if (!endfase) {
                            endfase = 2;
                            if (c == 0) {
                                endtyp = 0;
                                camode = 1;
                                chase = 15;
                                camrot = Math.floor(360 * Math.random());
                                camdist = 100;
                                if (Math.random() > Math.random()) {
                                    camdistd = true;
                                } else {
                                    camdistd = false;
                                }
                                camvert = 0;
                                if (Math.random() > Math.random()) {
                                    camvertd = false;
                                } else {
                                    camvertd = false;
                                }
                            } else {
                                endtyp = 2;
                                cfin = c;
                            }
                        }
                    }
                }
            }
            pos[c] = 0;
            for (var i = 0; i < 5; i++) {
                if ((i != c) && (!fallout[i])) {
                    if (onlap[c] == onlap[i]) {
                        if (onchk[c] == onchk[i]) {
                            if (pydchk[c] > pydchk[i]) {
                                pos[c]++;
                            }
                        } else {
                            if (onchk[c] < onchk[i]) {
                                pos[c]++;
                            }
                        }
                    } else {
                        if (onlap[c] < onlap[i]) {
                            pos[c]++;
                        }
                    }
                }
            }
            if (fixnow[c] == 0) {
                for (var i = 0; i < nf; i++) {
                    if (pyd(craft[sel[c]].x, fix[i].x, craft[sel[c]].y, fix[i].y, craft[sel[c]].z, fix[i].z) < fixdisk.colrad) {
                        var xf = [];
                        var zf = [];
                        xf[0] = (fix[i].x + (-fixdisk.colrad * fix[i].mat[10]) + (-fixdisk.colrad * 0.2 * fix[i].mat[8]));
                        zf[0] = (fix[i].z + (fixdisk.colrad * fix[i].mat[8]) + (-fixdisk.colrad * 0.2 * fix[i].mat[10]));
                        xf[1] = (fix[i].x + (fixdisk.colrad * fix[i].mat[10]) + (-fixdisk.colrad * 0.2 * fix[i].mat[8]));
                        zf[1] = (fix[i].z + (-fixdisk.colrad * fix[i].mat[8]) + (-fixdisk.colrad * 0.2 * fix[i].mat[10]));
                        xf[2] = (fix[i].x + (-fixdisk.colrad * fix[i].mat[10]) + (fixdisk.colrad * 0.2 * fix[i].mat[8]));
                        zf[2] = (fix[i].z + (fixdisk.colrad * fix[i].mat[8]) + (fixdisk.colrad * 0.2 * fix[i].mat[10]));
                        xf[3] = (fix[i].x + (fixdisk.colrad * fix[i].mat[10]) + (fixdisk.colrad * 0.2 * fix[i].mat[8]));
                        zf[3] = (fix[i].z + (-fixdisk.colrad * fix[i].mat[8]) + (fixdisk.colrad * 0.2 * fix[i].mat[10]));
                        if (Math.abs(fix[i].mat[10]) > Math.abs(fix[i].mat[8])) {
                            var zfb = ((((craft[sel[c]].x - xf[0]) / (xf[1] - xf[0])) * (zf[1] - zf[0])) + zf[0]);
                            var zfs = ((((craft[sel[c]].x - xf[2]) / (xf[3] - xf[2])) * (zf[3] - zf[2])) + zf[2]);
                            if (Math.abs(craft[sel[c]].z - zfs) < Math.abs(zfb - zfs)) {
                                if (!fixadon) {
                                    fixnow[c] = 1;
                                } else {
                                    fixnow[c] = 2;
                                }
                            }
                        } else {
                            var xfb = ((((craft[sel[c]].z - zf[0]) / (zf[1] - zf[0])) * (xf[1] - xf[0])) + xf[0]);
                            var xfs = ((((craft[sel[c]].z - zf[2]) / (zf[3] - zf[2])) * (xf[3] - xf[2])) + xf[2]);
                            if (Math.abs(craft[sel[c]].x - xfs) < Math.abs(xfb - xfs)) {
                                if (!fixadon) {
                                    fixnow[c] = 1;
                                } else {
                                    fixnow[c] = 2;
                                }
                            }
                        }
                    }
                }
            }
            if (fixnow[c]) {
                if (fixnow[c] == 1 || fixnow[c] == 2) {
                    if ((c == 0) && (fixnow[c] == 2)) {
                        pfase = 3;
                    } else {
                        fixflg[c] = false;
                        fixflk[c] = 40;
                        damage[c] = 0;
                    }
                    fixnow[c] = 6;
                    if (gofix[c]) {
                        gofix[c] = 0;
                    }
                }
                fixnow[c]++;
                if (fixnow[c] == 60) {
                    fixnow[c] = 0;
                }
            }
        } else {
            craft[sel[c]].x += trgx[c];
            craft[sel[c]].y += trgy[c];
            craft[sel[c]].z += trgz[c];
            if ((fallout[c] == 2) && (trgy[c] < 0)) {
                oncrash[c] = false;
                fallout[c] = 3;
            }
            var smku = (trgy[c] * 0.7);
            if (fallout[c] < 4) {
                if (Math.abs(trgx[c]) > 1) {
                    if (trgx[c] > 0) {
                        trgx[c] -= 0.005;
                    } else {
                        trgx[c] += 0.005;
                    }
                }
                if (Math.abs(trgz[c]) > 1) {
                    if (trgz[c] > 0) {
                        trgz[c] -= 0.005;
                    } else {
                        trgz[c] += 0.005;
                    }
                }
                mat4.rotate(craft[sel[c]].mat, craft[sel[c]].mat, (spin[c] * (Math.PI / 180)), [0, 1, 0]);
                trgy[c] -= 0.04;
                if (trgy[c] < -7) {
                    trgy[c] = -7;
                }
            } else {
                if (Math.abs(trgx[c]) > 0.025) {
                    if (trgx[c] > 0) {
                        trgx[c] -= 0.025;
                    } else {
                        trgx[c] += 0.025;
                    }
                } else {
                    trgx[c] = 0;
                }
                if (Math.abs(trgz[c]) > 0.025) {
                    if (trgz[c] > 0) {
                        trgz[c] -= 0.025;
                    } else {
                        trgz[c] += 0.025;
                    }
                } else {
                    trgz[c] = 0;
                }
                if (Math.abs(trgx[c]) > 0.5 || Math.abs(trgz[c]) > 0.5) {
                    dustup((craft[sel[c]].x - (3 * craft[sel[c]].mat[4])), (craft[sel[c]].y - (3 * craft[sel[c]].mat[5])), (craft[sel[c]].z - (3 * craft[sel[c]].mat[6])), (trgx[c] * 0.9), (trgy[c] * 0.9), (trgz[c] * 0.9));
                    if ((c == 0) && (!dstbnd) && (fallout[0] < 30)) {
                        playsnd(39);
                        dstbnd = Math.floor(5 + (10 * Math.random()));
                    }
                } else {
                    smku = 1;
                }
                if ((c == 0) && (fallout[0] == 30)) {
                    playsnd(42);
                }
                if ((fallout[c] > 30) && (fallout[c] < 60)) {
                    expl(craft[sel[c]].x, craft[sel[c]].y, craft[sel[c]].z, trgx[c], (0.4 + (Math.random() * 0.2)), trgz[c]);
                }
                if (fallout[c] == 45) {
                    craft[sel[c]].ont = 1;
                }
                if (fallout[c] > 60) {
                    if (Math.random() > 0.95) {
                        expl(craft[sel[c]].x, craft[sel[c]].y, craft[sel[c]].z, trgx[c], (0.4 + (Math.random() * 0.2)), trgz[c]);
                    }
                }
                if (!oncrash[c]) {
                    trgy[c] -= 0.04;
                    if (trgy[c] < -7) {
                        trgy[c] = -7;
                    }
                } else {
                    trgy[c] = 0;
                }
                oncrash[c] = false;
                fallout[c]++;
            }
            smokin(c, craft[sel[c]].x, craft[sel[c]].y, craft[sel[c]].z, (trgx[c] * 0.7), smku, (trgz[c] * 0.7));
        }
        if (onahit[c] != 0) {
            onahit[c]--;
        }
    }
    if (dstbnd) {
        dstbnd--;
    }
}
function sparkcrash(c, normx, normy, normz, ycomp, typ) {
    if (!oncrash[c]) {
        if (!fallout[c]) {
            if (!ycomp) {
                var xzdom = false;
                if ((Math.abs(normy) < Math.abs(normx)) || (Math.abs(normy) < Math.abs(normz))) {
                    if (Math.abs(craft[sel[c]].mat[10]) > Math.abs(craft[sel[c]].mat[8])) {
                        if (Math.abs(normz) > Math.abs(normx)) {
                            xzdom = false;
                        } else {
                            xzdom = true;
                        }
                    } else {
                        if (Math.abs(normx) > Math.abs(normz)) {
                            xzdom = false;
                        } else {
                            xzdom = true;
                        }
                    }
                }
                if (xzdom) {
                    spxz[c] = (0.5 + (Math.random() * 0.5));
                    if (Math.random() > Math.random()) {
                        spxz[c] = -spxz[c];
                    }
                    spzy[c] = ((Math.random() * 2) - 1);
                } else {
                    spzy[c] = (0.5 + (Math.random() * 0.5));
                    if (Math.random() > Math.random()) {
                        spzy[c] = -spzy[c];
                    }
                    spxz[c] = ((Math.random() * 2) - 1);
                }
                var atrg = Math.sqrt((trgx[c] * trgx[c]) + (trgy[c] * trgy[c]) + (trgz[c] * trgz[c]));
                if (typ == 0) {
                    if ((normy >= 0) && (normy < 0.2)) {
                        normy = 0.2;
                    }
                    if ((normy < 0) && (normy > -0.2)) {
                        normy = -0.2;
                    }
                }
                trgx[c] = ((trgx[c] + (atrg * normx)) / 2);
                trgy[c] = ((trgy[c] + (atrg * normy)) / 2);
                trgz[c] = ((trgz[c] + (atrg * normz)) / 2);
                var fct = ((atrg / Math.sqrt((trgx[c] * trgx[c]) + (trgy[c] * trgy[c]) + (trgz[c] * trgz[c]))) * 0.7);
                if (typ == 1) {
                    fct *= 0.5;
                }
                trgx[c] *= fct;
                trgy[c] *= fct;
                trgz[c] *= fct;
                if (c == 0) {
                    crgx = trgx[c];
                    crgy = trgy[c];
                    crgz = trgz[c];
                }
                spin[c] = (20 + Math.random() * 15);
                var totsp = 0;
                for (var sp = spin[c]; sp > 1; sp -= 0.4) {
                    if (xzdom) {
                        totsp += (sp * spxz[c]);
                    } else {
                        totsp += (sp * spzy[c]);
                    }
                }
                totsp = Math.abs(totsp);
                var cntspin = Math.round(totsp / 360);
                if (cntspin == 0) {
                    cntspin = 1;
                }
                if (xzdom) {
                    spxz[c] *= ((cntspin * 360) / totsp);
                } else {
                    spzy[c] *= (((cntspin * 360) + 90) / totsp);
                }
                if (typ == 0) {
                    sparksfly(15, craft[sel[c]].x, craft[sel[c]].y, craft[sel[c]].z, (trgx[c] * 0.4), (trgy[c] * 0.4), (trgz[c] * 0.4));
                    expl(craft[sel[c]].x, craft[sel[c]].y, craft[sel[c]].z, (trgx[c] * 0.4), (trgy[c] * 0.4), (trgz[c] * 0.4));
                    expl(craft[sel[c]].x, craft[sel[c]].y, craft[sel[c]].z, (trgx[c] * 0.2), (trgy[c] * 0.2), (trgz[c] * 0.2));
                    craftdamage(c, craft[sel[c]], 0.2);
                }
                if (typ == 1) {
                    sparksfly(10, craft[sel[c]].x, craft[sel[c]].y, craft[sel[c]].z, (trgx[c] * 0.4), (trgy[c] * 0.4), (trgz[c] * 0.4));
                    expl(craft[sel[c]].x, craft[sel[c]].y, craft[sel[c]].z, (trgx[c] * 0.4), (trgy[c] * 0.4), (trgz[c] * 0.4));
                    craftdamage(c, craft[sel[c]], 0.1);
                }
                if (c == 0) {
                    if (Math.random() > Math.random()) {
                        playsnd(40);
                    } else {
                        playsnd(41);
                    }
                }
                oncrash[c] = true;
            } else {
                upv[c] = -2;
                grndrag[c] += 0.2;
                if (grndrag[c] > 1) {
                    grndrag[c] = 1;
                }
                dustup((craft[sel[c]].x - (3 * craft[sel[c]].mat[4])), (craft[sel[c]].y - (3 * craft[sel[c]].mat[5])), (craft[sel[c]].z - (3 * craft[sel[c]].mat[6])), (trgx[c] * 0.9), (trgy[c] * 0.9), (trgz[c] * 0.9));
                if ((c == 0) && (!takeoff[0])) {
                    if (!dstbnd) {
                        playsnd(39);
                        dstbnd = Math.floor(3 + (Math.random() * 3));
                    }
                }
                if ((normx == 0) && (normy == 1) && (normz == 0)) {
                    getheading = 2;
                }
            }
        } else {
            if (fallout[c] == 1) {
                var poix = craft[sel[c]].mat[8];
                var poiz = craft[sel[c]].mat[10];
                var poifct = Math.sqrt(1 / ((poix * poix) + (poiz * poiz)));
                var loix = craft[sel[c]].mat[0];
                var loiz = craft[sel[c]].mat[2];
                var loifct = Math.sqrt(1 / ((loix * loix) + (loiz * loiz)));
                craft[sel[c]].mat[8] = (poix * poifct);
                craft[sel[c]].mat[9] = 0;
                craft[sel[c]].mat[10] = (poiz * poifct);
                craft[sel[c]].mat[4] = 0;
                if (craft[sel[c]].mat[5] > 0) {
                    craft[sel[c]].mat[5] = 1;
                } else {
                    craft[sel[c]].mat[5] = -1;
                }
                craft[sel[c]].mat[6] = 0;
                craft[sel[c]].mat[0] = (loix * loifct);
                craft[sel[c]].mat[1] = 0;
                craft[sel[c]].mat[2] = (loiz * loifct);
                spin[c] = (2 - (Math.random() * 4));
                if (spin[c] < 0) {
                    spin[c] -= 0.5;
                } else {
                    spin[c] += 0.5;
                }
                trgy[c] =  - (trgy[c] * 0.15);
                dustup((craft[sel[c]].x - (2 * craft[sel[c]].mat[4])), (craft[sel[c]].y - (2 * craft[sel[c]].mat[5])), (craft[sel[c]].z - (2 * craft[sel[c]].mat[6])), (trgx[c] * 0.9), (trgy[c] * 0.9), (trgz[c] * 0.9));
                dustup((craft[sel[c]].x - (2 * craft[sel[c]].mat[4])), (craft[sel[c]].y - (2 * craft[sel[c]].mat[5])), (craft[sel[c]].z - (2 * craft[sel[c]].mat[6])), (trgx[c] * 0.9), (trgy[c] * 0.9), (trgz[c] * 0.9));
                dustup((craft[sel[c]].x - (2 * craft[sel[c]].mat[4])), (craft[sel[c]].y - (2 * craft[sel[c]].mat[5])), (craft[sel[c]].z - (2 * craft[sel[c]].mat[6])), (trgx[c] * 0.9), (trgy[c] * 0.9), (trgz[c] * 0.9));
                dustup((craft[sel[c]].x - (2 * craft[sel[c]].mat[4])), (craft[sel[c]].y - (2 * craft[sel[c]].mat[5])), (craft[sel[c]].z - (2 * craft[sel[c]].mat[6])), (trgx[c] * 0.9), (trgy[c] * 0.9), (trgz[c] * 0.9));
                expl(craft[sel[c]].x, craft[sel[c]].y, craft[sel[c]].z, (trgx[c] * 0.4), (trgy[c] * 0.4), (trgz[c] * 0.4));
                fallout[c] = 2;
            }
            if (fallout[c] == 3) {
                trgy[c] = 0;
                fallout[c] = 4;
            }
            oncrash[c] = true;
        }
    }
}
function craftdamage(c, rad, mag) {
    mag *= endurance[sel[c]];
    mag *= 0.6;
    if ((stage == 1) && (unlocked == 1) && (c == 0)) {
        mag *= 0.5;
    }
    if ((stage == 2) && (unlocked == 2) && (c == 0)) {
        mag *= 0.75;
    }
    if (rad.dvrt == null) {
        rad.dvrt = [];
        for (var i = 0; i < rad.vrt.length; i++) {
            rad.dvrt[i] = rad.vrt[i];
        }
    }
    for (var i = 0; i < (rad.dvrt.length / 3); i++) {
        if (Math.random() > (1 - (mag * 0.76))) {
            if (rad.dvrt[(i * 3)] > 0) {
                rad.dvrt[(i * 3)] -= (1 * Math.random());
            } else {
                rad.dvrt[(i * 3)] += (1 * Math.random());
            }
            if (rad.dvrt[((i * 3) + 2)] > 0) {
                rad.dvrt[((i * 3) + 2)] -= (1 * Math.random());
            } else {
                rad.dvrt[((i * 3) + 2)] += (1 * Math.random());
            }
        }
    }
    var vert = [];
    rad.colrad = 0;
    for (var i = 0; i < rad.ni; i++) {
        vert[(i * 3)] = rad.dvrt[(rad.tri[(i * 3)] * 3)];
        vert[((i * 3) + 1)] = rad.dvrt[((rad.tri[(i * 3)] * 3) + 1)];
        vert[((i * 3) + 2)] = rad.dvrt[((rad.tri[(i * 3)] * 3) + 2)];
        var tcrad = Math.sqrt((vert[(i * 3)] * vert[(i * 3)]) + (vert[((i * 3) + 1)] * vert[((i * 3) + 1)]) + (vert[((i * 3) + 2)] * vert[((i * 3) + 2)]));
        if (tcrad > rad.colrad) {
            rad.colrad = tcrad;
        }
    }
    rad.loaded = 0;
    gl.deleteBuffer(rad.vbuf);
    rad.vbuf = null;
    rad.vbuf = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, rad.vbuf);
    gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(vert), gl.STATIC_DRAW);
    rad.loaded = 2;
    damage[c] += mag;
}
function fixcraftsback() {
    for (var c = 0; c < 5; c++) {
        fixcraft(craft[sel[c]]);
        craft[sel[c]].ont = 0;
    }
}
function fixcraft(rad) {
    var vert = [];
    rad.colrad = 0;
    for (var i = 0; i < rad.ni; i++) {
        vert[(i * 3)] = rad.vrt[(rad.tri[(i * 3)] * 3)];
        vert[((i * 3) + 1)] = rad.vrt[((rad.tri[(i * 3)] * 3) + 1)];
        vert[((i * 3) + 2)] = rad.vrt[((rad.tri[(i * 3)] * 3) + 2)];
        var tcrad = Math.sqrt((vert[(i * 3)] * vert[(i * 3)]) + (vert[((i * 3) + 1)] * vert[((i * 3) + 1)]) + (vert[((i * 3) + 2)] * vert[((i * 3) + 2)]));
        if (tcrad > rad.colrad) {
            rad.colrad = tcrad;
        }
    }
    rad.loaded = 0;
    gl.deleteBuffer(rad.vbuf);
    rad.vbuf = null;
    rad.vbuf = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, rad.vbuf);
    gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(vert), gl.STATIC_DRAW);
    rad.loaded = 2;
    rad.dvrt = null;
}
function createfix(crft, rad) {
    rad.loaded = 0;
    rad.ni = crft.ni;
    var indice = [];
    var vert = [];
    var col = [];
    for (var i = 0; i < rad.ni; i++) {
        indice[i] = i;
        vert[(i * 3)] = (crft.vrt[(crft.tri[(i * 3)] * 3)] * 1.16);
        vert[((i * 3) + 1)] = (crft.vrt[((crft.tri[(i * 3)] * 3) + 1)] * 1.16);
        vert[((i * 3) + 2)] = (crft.vrt[((crft.tri[(i * 3)] * 3) + 2)] * 1.16);
        col[((i * 4) + 0)] = (169 / 255);
        col[((i * 4) + 1)] = (236 / 255);
        col[((i * 4) + 2)] = (255 / 255);
        col[((i * 4) + 3)] = 1;
    }
    rad.vbuf = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, rad.vbuf);
    gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(vert), gl.STATIC_DRAW);
    rad.cbuf = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, rad.cbuf);
    gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(col), gl.STATIC_DRAW);
    rad.ibuf = gl.createBuffer();
    gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, rad.ibuf);
    gl.bufferData(gl.ELEMENT_ARRAY_BUFFER, new Uint16Array(indice), gl.STATIC_DRAW);
    rad.mat = mat4.create();
    rad.loaded = 1;
}
function findgn() {
    var clopy = -1;
    var medx = (craft[sel[0]].x + (1000 * craft[sel[0]].mat[8]) - (170 * craft[sel[0]].mat[4]));
    var medy = (craft[sel[0]].y + (1000 * craft[sel[0]].mat[9]) - (170 * craft[sel[0]].mat[5]));
    var medz = (craft[sel[0]].z + (1000 * craft[sel[0]].mat[10]) - (170 * craft[sel[0]].mat[6]));
    var mrx = -800;
    var mry = -675;
    for (var i = 0; i < 99; i++) {
        var x = (medx + (mrx * craft[sel[0]].mat[0]) + (mry * craft[sel[0]].mat[4]) - camx);
        var y = (medy + (mrx * craft[sel[0]].mat[1]) + (mry * craft[sel[0]].mat[5]) - camy);
        var z = (medz + (mrx * craft[sel[0]].mat[2]) + (mry * craft[sel[0]].mat[6]) - camz);
        var w = x * cmat[0 * 4 + 3] + y * cmat[1 * 4 + 3] + z * cmat[2 * 4 + 3] + cmat[3 * 4 + 3];
        var propoint = [((x * cmat[0 * 4 + 0] + y * cmat[1 * 4 + 0] + z * cmat[2 * 4 + 0] + cmat[3 * 4 + 0]) / w), ((x * cmat[0 * 4 + 1] + y * cmat[1 * 4 + 1] + z * cmat[2 * 4 + 1] + cmat[3 * 4 + 1]) / w), ((x * cmat[0 * 4 + 2] + y * cmat[1 * 4 + 2] + z * cmat[2 * 4 + 2] + cmat[3 * 4 + 2]) / w)];
        var ocnx = ((propoint[0] * 0.5 + 0.5) * canw);
        var ocny = ((propoint[1] * -0.5 + 0.5) * canh);
        var calpy = py(xm, ocnx, ym, ocny);
        if ((clopy == -1) || (calpy < clopy)) {
            clopy = calpy;
            gnx = (x + camx);
            gny = (y + camy);
            gnz = (z + camz);
            omy = ocny;
        }
        if (i == 49) {
            cnx = ocnx;
            if (!gotonsc) {
                cny = ocny;
            }
        }
        mrx += 200;
        if (mrx == 1000) {
            mrx = -800;
            mry += 135;
        }
    }
}
var lasermag = [1, 1.1, 1.92, 1.2, 1.89, 1.2, 2.25, 1.42, 1.3, 1.62];
var lsrspeed = [6, 5, 6.5, 6.2, 7, 6, 6.2, 5.8, 6.1, 5.5];
var lifespan = 200;
var colrad = 10;
var mistolerance = 5;
var nl = 0;
var lsr = [];
function newlaser() {
    return {
        x: 0,
        y: 0,
        z: 0,
        mat: null,
        speed: 0,
        typ: 0,
        stat: 0,
        colrad: 0,
        tr: 0,
        lldist: 0,
        mis: 0
    };
}
var lse = 0;
var bndlse = 0;
var lsa = 0;
var bndlsa = 0;
function firelaser(typ, x, y, z, aspeed, craftmat, target) {
    var li = (nl - 1);
    while ((li > 0) && (lsr[li].stat >= lifespan)) {
        li--;
    }
    nl = (li + 1);
    var foundli = false;
    li = 0;
    while ((li < nl) && (!foundli)) {
        if (lsr[li].stat >= lifespan) {
            foundli = true;
        } else {
            li++;
        }
    }
    if (!foundli) {
        li = nl;
    }
    lsr[li] = newlaser();
    lsr[li].x = x;
    lsr[li].y = y;
    lsr[li].z = z;
    lsr[li].typ = typ;
    lsr[li].speed = (aspeed + lsrspeed[typ]);
    lsr[li].colrad = colrad;
    lsr[li].tr = target;
    lsr[li].lldist = 0;
    lsr[li].mis = 0;
    lsr[li].mat = mat4.create();
    for (var i = 0; i < craftmat.length; i++) {
        lsr[li].mat[i] = craftmat[i];
    }
    if (!foundli) {
        nl++;
    }
}
function lasersfly() {
    var nloff = 0;
    for (var i = 0; i < nl; i++) {
        if (lsr[i].stat < lifespan) {
            if (lsr[i].stat != 0) {
                lsr[i].x += (lsr[i].mat[8] * lsr[i].speed);
                lsr[i].y += (lsr[i].mat[9] * lsr[i].speed);
                lsr[i].z += (lsr[i].mat[10] * lsr[i].speed);
                if (lsr[i].tr != -1) {
                    var ldist = pyd(lsr[i].x, craft[sel[lsr[i].tr]].x, lsr[i].y, craft[sel[lsr[i].tr]].y, lsr[i].z, craft[sel[lsr[i].tr]].z);
                    var lpntx = ((ldist * lsr[i].mat[8]) + lsr[i].x);
                    var lpnty = ((ldist * lsr[i].mat[9]) + lsr[i].y);
                    var lpntz = ((ldist * lsr[i].mat[10]) + lsr[i].z);
                    var trnleft = 1;
                    if (Math.abs(lsr[i].mat[8]) > Math.abs(lsr[i].mat[10])) {
                        if (lsr[i].mat[8] > 0) {
                            if (lpntz < craft[sel[lsr[i].tr]].z) {
                                trnleft = -1;
                            }
                        } else {
                            if (lpntz > craft[sel[lsr[i].tr]].z) {
                                trnleft = -1;
                            }
                        }
                    } else {
                        if (lsr[i].mat[10] > 0) {
                            if (lpntx > craft[sel[lsr[i].tr]].x) {
                                trnleft = -1;
                            }
                        } else {
                            if (lpntx < craft[sel[lsr[i].tr]].x) {
                                trnleft = -1;
                            }
                        }
                    }
                    var trnup = 1;
                    if (lpnty < craft[sel[lsr[i].tr]].y) {
                        trnup = -1;
                    }
                    if (Math.sqrt((lsr[i].mat[0] * lsr[i].mat[0]) + (lsr[i].mat[2] * lsr[i].mat[2])) > Math.abs(lsr[i].mat[1])) {
                        if (lsr[i].mat[5] < 0) {
                            trnleft = -trnleft;
                            trnup = -trnup;
                        }
                        mat4.rotate(lsr[i].mat, lsr[i].mat, (trnleft * (Math.PI / 180)), [0, 1, 0]);
                        mat4.rotate(lsr[i].mat, lsr[i].mat, (trnup * (Math.PI / 180)), [1, 0, 0]);
                    } else {
                        if (lsr[i].mat[1] < 0) {
                            trnleft = -trnleft;
                            trnup = -trnup;
                        }
                        mat4.rotate(lsr[i].mat, lsr[i].mat, (trnleft * (Math.PI / 180)), [1, 0, 0]);
                        mat4.rotate(lsr[i].mat, lsr[i].mat, (trnup * (Math.PI / 180)), [0, -1, 0]);
                    }
                    if (lsr[i].tr == 0) {
                        if ((!incoming) && (ldist < 500)) {
                            incoming = 1;
                        }
                    }
                    if (ldist < lsr[i].colrad) {
                        lsr[i].stat = lifespan;
                        sparksfly(5, craft[sel[lsr[i].tr]].x, craft[sel[lsr[i].tr]].y, craft[sel[lsr[i].tr]].z, (trgx[lsr[i].tr] * 0.9), (trgy[lsr[i].tr] * 0.9), (trgz[lsr[i].tr] * 0.9));
                        expl(craft[sel[lsr[i].tr]].x, craft[sel[lsr[i].tr]].y, craft[sel[lsr[i].tr]].z, (trgx[lsr[i].tr] * 0.9), (trgy[lsr[i].tr] * 0.9), (trgz[lsr[i].tr] * 0.9));
                        var magmult = 1;
                        if ((stage == 1) && (unlocked == 1) && (lsr[i].typ == sel[0])) {
                            magmult = 3;
                        }
                        if ((stage == 2) && (unlocked == 2) && (lsr[i].typ == sel[0])) {
                            magmult = 2;
                        }
                        craftdamage(lsr[i].tr, craft[sel[lsr[i].tr]], (0.02 * lasermag[lsr[i].typ] * magmult));
                        if (lsr[i].tr == 0) {
                            var shkmag = lasermag[lsr[i].typ];
                            if (shkmag > 1.5) {
                                shkmag = 1.5;
                            }
                            camxz += ((0.75 - (Math.random() * 1.5)) * shkmag);
                            camzy += ((0.75 - (Math.random() * 1.5)) * shkmag);
                        }
                        onahit[lsr[i].tr] = 2;
                        if (lsr[i].tr == 0) {
                            if (!bndlse) {
                                if (Math.random() > Math.random()) {
                                    lse++;
                                    if (lse == 3) {
                                        lse = 0;
                                    }
                                } else {
                                    lse--;
                                    if (lse == -1) {
                                        lse = 2;
                                    }
                                }
                                playsnd((30 + lse));
                                bndlse = 3;
                            }
                        } else {
                            var lws = 33;
                            if (lsr[i].typ != sel[0]) {
                                lws = 36;
                            }
                            if (!bndlsa) {
                                if (Math.random() > Math.random()) {
                                    lsa++;
                                    if (lsa == 3) {
                                        lsa = 0;
                                    }
                                } else {
                                    lsa--;
                                    if (lsa == -1) {
                                        lsa = 2;
                                    }
                                }
                                playsnd((lws + lsa));
                                bndlsa = 3;
                            }
                        }
                    }
                    if ((lsr[i].lldist != 0) && (ldist > lsr[i].lldist)) {
                        lsr[i].mis++;
                    } else {
                        lsr[i].mis = 0;
                    }
                    lsr[i].lldist = ldist;
                    if (lsr[i].mis > mistolerance) {
                        lsr[i].tr = -1;
                    }
                }
                for (var k = 0; k < nm; k++) {
                    colide(1, i, lsr[i], mnt[k], (lsr[i].colrad * 0.7));
                }
                for (var k = 0; k < nb; k++) {
                    obst[obo[k].typ].x = obo[k].x;
                    obst[obo[k].typ].z = obo[k].z;
                    obst[obo[k].typ].mat = obo[k].mat;
                    colide(1, i, lsr[i], obst[obo[k].typ], (lsr[i].colrad * 0.7));
                }
                if (lsr[i].y < (lsr[i].colrad * 0.7)) {
                    lsr[i].y = (lsr[i].colrad * 0.7);
                    laserflum(i, 0, 1, 0);
                }
            }
            lsr[i].stat++;
        } else {
            nloff++;
        }
    }
    if ((nl != 0) && (nloff == nl)) {
        nl = 0;
    }
    if (bndlse) {
        bndlse--;
    }
    if (bndlsa) {
        bndlsa--;
    }
}
function laserflum(li, normx, normy, normz) {
    lsr[li].stat = lifespan;
    dustup(lsr[li].x, lsr[li].y, lsr[li].z, (normx * 2), (normy * 2), (normz * 2));
    dustup(lsr[li].x, lsr[li].y, lsr[li].z, (normx * 2), (normy * 2), (normz * 2));
    flumup((lsr[li].x + (normx * 3)), (lsr[li].y + (normy * 3)), (lsr[li].z + (normz * 3)));
}
var bankswing = 0.4;
var acuzy = 2;
var acuxz = 5;
var colprodist = 250;
var falsecontrol = 0;
var breakawaytimes = [1, 1, 1, 1, 1];
var breakawaylevel = [0.5, 0.5, 0.5, 0.5, 0.5];
var maxbreakaway = [60, 60, 60, 60, 60];
var ringoflum = 350;
var jaggerun = 800;
var checkmodetime = 800;
var checkmode = [0, 0, 0, 0, 0];
var targetc = [-1, -1, -1, -1, -1];
var targx = [0, 0, 0, 0, 0];
var targz = [0, 0, 0, 0, 0];
var targy = [0, 0, 0, 0, 0];
var gotbankleft = [false, false, false, false, false];
var gotbankright = [false, false, false, false, false];
var bankangle = [0, 0, 0, 0, 0];
var breakup = [false, false, false, false, false];
var gotbreakup = [false, false, false, false, false];
var oncolavoid = [0, 0, 0, 0, 0];
var onway = [0, 0, 0, 0, 0];
var lonpy = [0, 0, 0, 0, 0];
var canmis = [0, 0, 0, 0, 0];
var misdaprch = [0, 0, 0, 0, 0];
var onfalse = [0, 0, 0, 0, 0];
var oncontrol = [false, false, false, false, false];
var cntlock = [0, 0, 0, 0, 0];
var cntlockto = [0, 0, 0, 0, 0];
var cntnolock = [0, 0, 0, 0, 0];
var cntnolockto = [0, 0, 0, 0, 0];
var relocate = [false, false, false, false, false];
var gofix = [0, 0, 0, 0, 0];
var onfix = [0, 0, 0, 0, 0];
var racerattacker = [false, false, false, false, false];
var breakaway = [0, 0, 0, 0, 0];
var breakawayup = [false, false, false, false, false];
var breakawayroll = [0, 0, 0, 0, 0];
var lastattackmode = [false, false, false, false, false];
function inishflyai() {
    checkmode = [0, 0, 0, 0, 0];
    targetc = [-1, -1, -1, -1, -1];
    targx = [0, 0, 0, 0, 0];
    targz = [0, 0, 0, 0, 0];
    targy = [0, 0, 0, 0, 0];
    gotbankleft = [false, false, false, false, false];
    gotbankright = [false, false, false, false, false];
    bankangle = [0, 0, 0, 0, 0];
    breakup = [false, false, false, false, false];
    gotbreakup = [false, false, false, false, false];
    oncolavoid = [0, 0, 0, 0, 0];
    onway = [0, 0, 0, 0, 0];
    lonpy = [0, 0, 0, 0, 0];
    canmis = [0, 0, 0, 0, 0];
    misdaprch = [0, 0, 0, 0, 0];
    onfalse = [0, 0, 0, 0, 0];
    oncontrol = [false, false, false, false, false];
    cntlock = [0, 0, 0, 0, 0];
    cntlockto = [0, 0, 0, 0, 0];
    cntnolock = [0, 0, 0, 0, 0];
    cntnolockto = [0, 0, 0, 0, 0];
    relocate = [false, false, false, false, false];
    gofix = [0, 0, 0, 0, 0];
    onfix = [0, 0, 0, 0, 0];
    racerattacker = [false, false, false, false, false];
    breakaway = [0, 0, 0, 0, 0];
    breakawayup = [false, false, false, false, false];
    breakawayroll = [0, 0, 0, 0, 0];
    lastattackmode = [false, false, false, false, false];
    if (stage == 1) {
        colprodist = 100;
        falsecontrol = 300;
        breakawaytimes = [1, 1, 1, 1, 1];
        breakawaylevel = [0.8, 0.8, 0.8, 0.8, 0.8];
        maxbreakaway = [60, 60, 60, 60, 60];
        ringoflum = 250;
        jaggerun = 800;
        checkmodetime = 800;
    }
    if (stage == 2) {
        colprodist = 150;
        falsecontrol = 100;
        breakawaytimes = [1, 1, 1, 1, 1];
        breakawaylevel = [0.6, 0.6, 0.6, 0.6, 0.6];
        maxbreakaway = [60, 60, 60, 60, 60];
        ringoflum = 400;
        jaggerun = 800;
        checkmodetime = 700;
    }
    if (stage == 3) {
        colprodist = 150;
        falsecontrol = 0;
        breakawaytimes = [2, 2, 2, 2, 2];
        breakawaylevel = [0.8, 0.8, 0.8, 0.8, 0.8];
        maxbreakaway = [60, 60, 60, 60, 60];
        ringoflum = 300;
        jaggerun = 1200;
        checkmodetime = 1400;
    }
    if (stage == 4) {
        colprodist = 250;
        falsecontrol = 50;
        breakawaytimes = [2, 2, 2, 2, 3];
        breakawaylevel = [0.5, 0.5, 0.5, 0.5, 0];
        maxbreakaway = [20, 20, 20, 20, 40];
        ringoflum = 400;
        jaggerun = 800;
        checkmodetime = 200;
    }
    if (stage == 5) {
        colprodist = 250;
        falsecontrol = 0;
        breakawaytimes = [2, 2, 2, 2, 2];
        breakawaylevel = [0.5, 0.5, 0.5, 0.5, 0.3];
        maxbreakaway = [50, 50, 50, 50, 50];
        ringoflum = 200;
        jaggerun = 1000;
        checkmodetime = 1400;
    }
    if (stage == 6) {
        colprodist = 170;
        falsecontrol = 0;
        breakawaytimes = [3, 3, 3, 3, 2];
        breakawaylevel = [0.2, 0.2, 0.2, 0.2, 0.5];
        maxbreakaway = [30, 30, 30, 30, 60];
        ringoflum = 400;
        jaggerun = 700;
        checkmodetime = 1000;
    }
    if (stage == 7) {
        colprodist = 100;
        falsecontrol = 0;
        breakawaytimes = [1, 1, 1, 1, 1];
        breakawaylevel = [0.5, 0.5, 0.5, 0.5, 0.5];
        maxbreakaway = [30, 30, 30, 30, 30];
        ringoflum = 300;
        jaggerun = 700;
        checkmodetime = 200;
    }
    if (stage == 8) {
        colprodist = 150;
        falsecontrol = 0;
        breakawaytimes = [2, 2, 2, 2, 2];
        breakawaylevel = [0.5, 0.5, 0.5, 0.5, 0.5];
        maxbreakaway = [40, 40, 40, 40, 40];
        ringoflum = 200;
        jaggerun = 700;
        checkmodetime = 1000;
    }
    if (stage == 9) {
        colprodist = 100;
        falsecontrol = 0;
        breakawaytimes = [2, 2, 2, 2, 2];
        breakawaylevel = [0.5, 0.5, 0.5, 0.5, 0.5];
        maxbreakaway = [60, 60, 60, 60, 60];
        ringoflum = 200;
        jaggerun = 600;
        checkmodetime = 700;
    }
    if (stage == 10) {
        colprodist = 100;
        falsecontrol = 0;
        breakawaytimes = [2, 2, 2, 2, 3];
        breakawaylevel = [0, 0, 0, 0, 0];
        maxbreakaway = [50, 50, 50, 50, 50];
        ringoflum = 200;
        jaggerun = 600;
        checkmodetime = 1400;
    }
    if (stage == 11) {
        colprodist = 250;
        falsecontrol = 0;
        breakawaytimes = [2, 2, 2, 2, 3];
        breakawaylevel = [0.5, 0.5, 0.5, 0.5, 0.25];
        maxbreakaway = [50, 50, 50, 50, 50];
        ringoflum = 200;
        jaggerun = 700;
        checkmodetime = 100;
    }
    if (stage == 12) {
        colprodist = 150;
        falsecontrol = 0;
        breakawaytimes = [3, 3, 3, 3, 3];
        breakawaylevel = [0.25, 0.25, 0.25, 0.25, 0.25];
        maxbreakaway = [20, 20, 20, 20, 20];
        ringoflum = 200;
        jaggerun = 600;
        checkmodetime = 600;
    }
    for (var i = 1; i < 5; i++) {
        var proba = 1,
        r = 0;
        while (r < breakawaytimes[i]) {
            proba *= Math.random();
            r++;
        }
        cntlockto[i] = Math.floor(40 + (200 * proba));
        cntnolockto[i] = Math.floor(ringoflum + (ringoflum * Math.random()));
        checkmode[i] = Math.floor(checkmodetime + (checkmodetime * Math.random()));
    }
}
function flyai() {
    for (var c = 1; c < 5; c++) {
        if (checkmode[c] == 0) {
            if (stage == 1) {
                if (Math.random() > (pos[c] / (5 - nwasted))) {
                    onattackmode[c] = false;
                } else {
                    onattackmode[c] = true;
                }
                if ((nwasted == 3) && (!onattackmode[0]) && (pos[0] == 0) && (onlap[c] != onlap[0])) {
                    onattackmode[c] = true;
                }
                if (unlocked == 1) {
                    if ((onlap[c] + 1) == nlaps) {
                        if (onattackmode[c]) {
                            falsecontrol = 300;
                        } else {
                            falsecontrol = 600;
                        }
                    }
                }
            }
            if (stage == 2) {
                if (sel[c] == 2 || sel[c] == 4) {
                    if ((Math.random() > Math.random()) && (Math.random() > Math.random())) {
                        onattackmode[c] = false;
                    } else {
                        onattackmode[c] = true;
                    }
                } else {
                    if (pos[c] <= 2) {
                        onattackmode[c] = false;
                    } else {
                        if (Math.random() > Math.random()) {
                            onattackmode[c] = true;
                        } else {
                            onattackmode[c] = false;
                        }
                    }
                }
                if (damage[c] > 0.8) {
                    if (!gofix[c]) {
                        gofix[c] = 1;
                    }
                }
            }
            if (stage == 3) {
                if (pos[c] == 0) {
                    onattackmode[c] = false;
                } else {
                    onattackmode[c] = true;
                    if ((Math.random() > Math.random()) && (Math.random() > Math.random())) {
                        onattackmode[c] = false;
                    }
                }
                if ((nwasted >= 2) && (damage[c] > 1)) {
                    if (!gofix[c]) {
                        gofix[c] = 1;
                    }
                }
            }
            if (stage == 4) {
                racerattacker[c] = true;
                onattackmode[c] = true;
            }
            if (stage == 5) {
                if ((pos[c] == 0) || ((pos[c] == 1) && (nwasted < 3))) {
                    onattackmode[c] = false;
                } else {
                    onattackmode[c] = true;
                }
                if (sel[c] == 6) {
                    onattackmode[c] = true;
                }
                checkmodetime = 200;
                if (damage[c] > 0.9) {
                    if (!gofix[c]) {
                        gofix[c] = 1;
                    }
                }
            }
            if (stage == 6) {
                if ((sel[c] == 6) && (nwasted != 3)) {
                    onattackmode[c] = true;
                } else {
                    onattackmode[c] = false;
                }
                checkmodetime = 50;
                if (damage[c] > 1) {
                    if (!gofix[c]) {
                        gofix[c] = 1;
                    }
                }
            }
            if (stage == 7) {
                if ((pos[c] / (5 - nwasted)) > 0.45) {
                    onattackmode[c] = true;
                    if (targetc[c] == -1 || fallout[targetc[c]]) {
                        var altg = false;
                        targetc[c] = Math.floor(Math.random() * 5);
                        if (targetc[c] == 5) {
                            targetc[c] = 4;
                        }
                        if ((targetc[c] == c) || (fallout[targetc[c]])) {
                            altg = true;
                        }
                        if (!altg) {
                            for (var i = 1; i < 5; i++) {
                                if ((i != c) && (targetc[c] == targetc[i])) {
                                    altg = true;
                                }
                            }
                        }
                        var runo = 0;
                        while ((altg) && (runo < 5)) {
                            altg = false;
                            targetc[c]++;
                            if (targetc[c] >= 5) {
                                targetc[c] = 0;
                            }
                            if ((targetc[c] == c) || (fallout[targetc[c]])) {
                                altg = true;
                            }
                            if (!altg) {
                                for (var i = 1; i < 5; i++) {
                                    if ((i != c) && (targetc[c] == targetc[i])) {
                                        altg = true;
                                    }
                                }
                            }
                            runo++;
                        }
                        if (runo == 5) {
                            targetc[c] = 0;
                        }
                    }
                } else {
                    onattackmode[c] = false;
                    targetc[c] = -1;
                }
                checkmodetime = 100;
                if (damage[c] > 0.8) {
                    if (!gofix[c]) {
                        gofix[c] = 1;
                    }
                }
            }
            if (stage == 8) {
                if (pos[0] <= 4) {
                    if ((pos[c] / (5 - nwasted)) > 0.45) {
                        onattackmode[c] = true;
                    } else {
                        onattackmode[c] = false;
                    }
                } else {
                    onattackmode[c] = false;
                }
                checkmodetime = 50;
                if (damage[c] > 0.9) {
                    if (!gofix[c]) {
                        gofix[c] = 1;
                    }
                }
            }
            if (stage == 9) {
                if (onattackmode[0] || ((onlap[0] == 2) && (onchk[0] >= 6))) {
                    targetc[c] = 1;
                }
                if (targetc[c] == 1) {
                    if (sel[c] == 8 || sel[c] == 5 || sel[c] == 3) {
                        onattackmode[c] = false;
                    } else {
                        onattackmode[c] = true;
                    }
                }
                if (onattackmode[c]) {
                    if (damage[c] > 0.8) {
                        if (!gofix[c]) {
                            gofix[c] = 1;
                        }
                    }
                }
                checkmodetime = 100;
            }
            if (stage == 10) {
                if (pos[c] != 0) {
                    if ((pos[c] == 1) && (pos[0] == 0) && (nwasted < 3)) {
                        onattackmode[c] = false;
                    } else {
                        onattackmode[c] = true;
                    }
                } else {
                    onattackmode[c] = false;
                }
                if (onattackmode[c]) {
                    if ((pos[0] == 0) && ((onlap[0] + 1) == nlaps)) {
                        targetc[c] = 0;
                    } else {
                        if (targetc[c] == -1 || fallout[targetc[c]]) {
                            var altg = false;
                            targetc[c] = Math.floor(Math.random() * 5);
                            if (targetc[c] == 5) {
                                targetc[c] = 4;
                            }
                            if ((targetc[c] == c) || (fallout[targetc[c]]) || ((pos[targetc[c]] == 0) && (targetc[c] != 0)) || (targetc[targetc[c]] == c) || ((targetc[c] == 4) && (Math.random() > 0.2))) {
                                altg = true;
                            }
                            if (!altg) {
                                for (var i = 1; i < 5; i++) {
                                    if ((i != c) && (targetc[c] == targetc[i])) {
                                        altg = true;
                                    }
                                }
                            }
                            var runo = 0;
                            while ((altg) && (runo < 10)) {
                                altg = false;
                                targetc[c]++;
                                if (targetc[c] >= 5) {
                                    targetc[c] = 0;
                                }
                                if ((targetc[c] == c) || (fallout[targetc[c]]) || ((pos[targetc[c]] == 0) && (targetc[c] != 0)) || (targetc[targetc[c]] == c) || ((targetc[c] == 4) && (Math.random() > 0.2))) {
                                    altg = true;
                                }
                                if (!altg) {
                                    for (var i = 1; i < 5; i++) {
                                        if ((i != c) && (targetc[c] == targetc[i])) {
                                            altg = true;
                                        }
                                    }
                                }
                                runo++;
                            }
                            if (runo == 10) {
                                targetc[c] = 0;
                            }
                        }
                    }
                }
                checkmodetime = 100;
            }
            if (stage == 11) {
                var cat = 4;
                while ((cat > 1) && (fallout[cat])) {
                    cat--;
                }
                if (c == cat) {
                    onattackmode[c] = true;
                } else {
                    onattackmode[c] = false;
                }
                if (damage[c] > 1) {
                    if (!gofix[c]) {
                        gofix[c] = 1;
                    }
                }
                if (c == 4) {
                    if (damage[c] > 0.6) {
                        if (!gofix[c]) {
                            gofix[c] = 1;
                        }
                    }
                }
                checkmodetime = 100;
            }
            if (stage == 12) {
                var cat = 4;
                while ((cat > 1) && (fallout[cat])) {
                    cat--;
                }
                if (c == cat) {
                    onattackmode[c] = true;
                    racerattacker[c] = false;
                } else {
                    racerattacker[c] = true;
                    if (pos[0] < pos[c]) {
                        onattackmode[c] = true;
                    } else {
                        onattackmode[c] = false;
                    }
                }
                if (damage[c] > 0.8) {
                    if (!gofix[c]) {
                        gofix[c] = 1;
                    }
                }
                checkmodetime = 20;
            }
            if (lastattackmode[c] != onattackmode[c]) {
                lockon[c] = [0, 0, 0, 0, 0];
                exfire[c] = 0;
                lastattackmode[c] = onattackmode[c];
            }
            checkmode[c] = Math.floor(checkmodetime + (checkmodetime * Math.random()));
            if (stage == 6) {
                checkmode[c] = checkmodetime;
            }
        } else {
            if ((!cntfly) || (cntfly < 20)) {
                checkmode[c]--;
            }
        }
        if (!oncolavoid[c]) {
            if (!gofix[c]) {
                if ((!onattackmode[c]) || (racerattacker[c])) {
                    var pydway = pyd(craft[sel[c]].x, chk[onway[c]].x, craft[sel[c]].y, chk[onway[c]].y, craft[sel[c]].z, chk[onway[c]].z);
                    if (pydway < 200 || misdaprch[c] == 1) {
                        if (onway[c] != onchk[c]) {
                            onway[c]++;
                            if (onway[c] == nc) {
                                onway[c] = 0;
                            }
                        }
                        misdaprch[c] = 0;
                    }
                    if (misdaprch[c] != 0) {
                        misdaprch[c]--;
                    }
                    if ((onway[c] == onchk[c]) && (pydway < 1000)) {
                        if (pydway < lonpy[c]) {
                            canmis[c]++;
                        } else {
                            if (canmis[c] > 50) {
                                onway[c]--;
                                if (onway[c] == -1) {
                                    onway[c] = (nc - 1);
                                }
                                misdaprch[c] = 200;
                            }
                            canmis[c] = 0;
                        }
                        lonpy[c] = pydway;
                    } else {
                        canmis[c] = 0;
                    }
                    if ((stage == 1) && (unlocked == 1)) {
                        if (((onlap[c] + 1) == nlaps) && (onway[c] > 4)) {
                            onway[c] = 4;
                        }
                    }
                    targx[c] = chk[onway[c]].x;
                    targz[c] = chk[onway[c]].z;
                    targy[c] = chk[onway[c]].y;
                } else {
                    var onatk = -1;
                    var atkpy = 0;
                    var foundracers = false;
                    if (stage == 9) {
                        for (var i = 0; i < 4; i++) {
                            if ((!onattackmode[i]) && (!fallout[i])) {
                                foundracers = true;
                            }
                        }
                    }
                    for (var i = 0; i < 5; i++) {
                        var dontarget = false;
                        if (stage == 5 || stage == 6) {
                            if (pos[i] != 0) {
                                dontarget = true;
                            }
                        }
                        if (stage == 7) {
                            if (targetc[c] != i) {
                                dontarget = true;
                            }
                        }
                        if (stage == 8) {
                            if (i != 0) {
                                dontarget = true;
                            }
                        }
                        if (stage == 9) {
                            if ((foundracers) && (onattackmode[i])) {
                                dontarget = true;
                            }
                            if (i == 4) {
                                dontarget = true;
                            }
                        }
                        if (stage == 10) {
                            if (targetc[c] != i) {
                                dontarget = true;
                            }
                        }
                        if (stage == 11) {
                            if (pos[c] == 0) {
                                if (pos[i] != 1) {
                                    dontarget = true;
                                }
                            } else {
                                if (pos[i] != 0) {
                                    dontarget = true;
                                }
                            }
                        }
                        if (stage == 12) {
                            if ((!racerattacker[c]) && (i != 0)) {
                                dontarget = true;
                            }
                        }
                        if ((i != c) && (!fallout[i]) && (!dontarget)) {
                            var crdpy = pyd(craft[sel[c]].x, craft[sel[i]].x, craft[sel[c]].y, craft[sel[i]].y, craft[sel[c]].z, craft[sel[i]].z);
                            if (onatk == -1) {
                                atkpy = Math.abs(crdpy - 300);
                                onatk = i;
                            } else {
                                if (Math.abs(crdpy - 300) < atkpy) {
                                    atkpy = Math.abs(crdpy - 300);
                                    onatk = i;
                                }
                            }
                        }
                    }
                    if (!relocate[c]) {
                        if (onatk != -1) {
                            if (atkpy > 500) {
                                atkpy = 500;
                            }
                            targx[c] = (craft[sel[onatk]].x + (craft[sel[onatk]].mat[8] * atkpy));
                            targz[c] = (craft[sel[onatk]].z + (craft[sel[onatk]].mat[9] * atkpy));
                            targy[c] = craft[sel[onatk]].y;
                        }
                        if (lockon[c][onatk] < 100) {
                            cntnolock[c]++;
                            if (cntnolock[c] == cntnolockto[c]) {
                                relocate[c] = true;
                                cntnolock[c] = jaggerun;
                                targx[c] = (craft[sel[c]].x + 3000 - (6000 * Math.random()));
                                targz[c] = (craft[sel[c]].z + 3000 - (6000 * Math.random()));
                                targy[c] = (50 + (1500 * Math.random()));
                                cntnolockto[c] = Math.floor(ringoflum + (ringoflum * Math.random()));
                            }
                        } else {
                            cntnolock[c] = 0;
                        }
                    } else {
                        cntnolock[c]--;
                        if (cntnolock[c] <= 0) {
                            relocate[c] = false;
                        }
                    }
                }
            } else {
                if (gofix[c] == 1) {
                    onfix[c] = -1;
                    var fixpy = 0;
                    for (var i = 0; i < nf; i++) {
                        var trypy = pyd(craft[sel[c]].x, fix[i].x, craft[sel[c]].y, fix[i].y, craft[sel[c]].z, fix[i].z);
                        if (onfix[c] == -1) {
                            fixpy = trypy;
                            onfix[c] = i;
                        } else {
                            if (trypy < fixpy) {
                                fixpy = trypy;
                                onfix[c] = i;
                            }
                        }
                    }
                    if (onfix[c] != -1) {
                        gofix[c] = 2;
                    } else {
                        gofix[c] = 0;
                    }
                }
                if (gofix[c] == 2) {
                    targx[c] = (fix[onfix[c]].x + (fix[onfix[c]].mat[8] * 1600));
                    targy[c] = (fix[onfix[c]].y + (fix[onfix[c]].mat[9] * 1600));
                    targz[c] = (fix[onfix[c]].z + (fix[onfix[c]].mat[10] * 1600));
                    if (pyd(craft[sel[c]].x, targx[c], craft[sel[c]].y, targy[c], craft[sel[c]].z, targz[c]) < 200) {
                        gofix[c] = 3;
                    }
                }
                if (gofix[c] >= 3) {
                    targx[c] = fix[onfix[c]].x;
                    targy[c] = fix[onfix[c]].y;
                    targz[c] = fix[onfix[c]].z;
                    gofix[c]++;
                    if (gofix[c] >= 760) {
                        gofix[c] = 0;
                    }
                }
            }
        } else {
            oncolavoid[c]--;
            if (relocate[c]) {
                cntnolock[c] = 0;
                relocate[c] = false;
            }
        }
        var goxz = Math.round(Math.acos(craft[sel[c]].mat[10]) * (180 / Math.PI));
        var rgozy = 0,
        rgoxz = 0;
        var unda = (targz[c] - craft[sel[c]].z);
        if ((unda <= 0.1) && (unda >= 0)) {
            unda = 0.1;
        }
        if ((unda >= -0.1) && (unda < 0)) {
            unda = -0.1;
        }
        rgoxz = Math.round(Math.abs(Math.atan((targx[c] - craft[sel[c]].x) / unda) * (180 / Math.PI)));
        var nego = false;
        if (((targx[c] - craft[sel[c]].x) * craft[sel[c]].mat[8]) < 0) {
            nego = true;
            rgoxz = -rgoxz;
        }
        if (craft[sel[c]].z > targz[c]) {
            rgoxz = (180 - rgoxz);
        }
        var bankleft = false;
        var bankright = false;
        if (Math.abs(rgoxz - goxz) > acuxz) {
            if ((targx[c] - craft[sel[c]].x) > 0) {
                if (nego) {
                    if (rgoxz < goxz) {
                        bankleft = true;
                    } else {
                        bankright = true;
                    }
                } else {
                    if (rgoxz < goxz) {
                        bankright = true;
                    } else {
                        bankleft = true;
                    }
                }
            } else {
                if (nego) {
                    if (rgoxz < goxz) {
                        bankright = true;
                    } else {
                        bankleft = true;
                    }
                } else {
                    if (rgoxz < goxz) {
                        bankleft = true;
                    } else {
                        bankright = true;
                    }
                }
            }
        }
        var gozy = Math.round(Math.asin(craft[sel[c]].mat[9]) * (180 / Math.PI));
        var rgozy = 0;
        unda = py(targx[c], craft[sel[c]].x, targz[c], craft[sel[c]].z);
        if (unda <= 0.1) {
            unda = 0.1;
        }
        rgozy = Math.round(Math.atan((targy[c] - craft[sel[c]].y) / unda) * (180 / Math.PI));
        var pullup = false;
        var pushdown = false;
        if (Math.abs(rgozy - gozy) > acuzy) {
            if (rgozy < gozy) {
                pushdown = true;
            } else {
                pullup = true;
            }
        }
        if (falsecontrol != 0) {
            if (!oncontrol[c]) {
                onfalse[c]--;
                if (onfalse[c] <= 0) {
                    onfalse[c] = (falsecontrol + (falsecontrol * Math.random()));
                    oncontrol[c] = true;
                }
            } else {
                onfalse[c]--;
                if (onfalse[c] <= 0) {
                    onfalse[c] = (falsecontrol + (falsecontrol * Math.random()));
                    oncontrol[c] = false;
                }
            }
        } else {
            oncontrol[c] = true;
        }
        if ((!oncontrol[c]) && (!oncolavoid[c])) {
            bankleft = false;
            bankright = false;
            pullup = false;
            pushdown = false;
        }
        var imlocked = false;
        for (var k = 0; k < 5; k++) {
            if (k != c) {
                if (lockon[k][c] >= 100) {
                    imlocked = true;
                }
            }
        }
        var dontbreakawaynow = false;
        if ((stage == 8) && (onchk[c] == 5 || onchk[c] == 12)) {
            dontbreakawaynow = true;
            breakaway[c] = 0;
            if (imlocked) {
                cntlock[c] = (cntlockto[c] - 2);
            }
        }
        if ((stage == 9) && (sel[c] == 8 || sel[c] == 5 || sel[c] == 3)) {
            dontbreakawaynow = true;
        }
        if ((stage == 12) && (racerattacker[c]) && (Math.abs(craft[sel[c]].x) < 700) && (Math.abs(craft[sel[c]].x - 1070) < 200)) {
            dontbreakawaynow = true;
        }
        if ((imlocked) && (!breakaway[c]) && (!dontbreakawaynow)) {
            cntlock[c]++;
            if (cntlock[c] == cntlockto[c]) {
                breakaway[c] = Math.floor(20 + (Math.random() * 60));
                if (breakaway[c] > maxbreakaway[c]) {
                    breakaway[c] = maxbreakaway[c];
                }
                var proba = 1,
                r = 0;
                while (r < breakawaytimes[c]) {
                    proba *= Math.random();
                    r++;
                }
                cntlockto[c] = Math.floor(40 + (200 * proba));
                if (Math.random() > breakawaylevel[c]) {
                    breakawayup[c] = true;
                } else {
                    breakawayup[c] = false;
                }
                if (Math.random() > Math.random() || craft[sel[c]].y < 50) {
                    breakawayroll[c] = 0;
                } else {
                    if (Math.random() > Math.random()) {
                        breakawayroll[c] = 1;
                    } else {
                        breakawayroll[c] = 2;
                    }
                }
            }
        } else {
            if (cntlock[c] != 0) {
                cntlock[c] = 0;
            }
        }
        up[c] = false;
        down[c] = false;
        left[c] = false;
        right[c] = false;
        if (!takeoff[c]) {
            if ((!breakaway[c]) || (oncolavoid[c])) {
                var overidel = false;
                if (bankleft) {
                    if (!gotbankleft[c]) {
                        bankangle[c] = ((180 - Math.abs(rgoxz - goxz)) / 180);
                        if (onattackmode[c]) {
                            bankangle[c] *= 0.7;
                        }
                        if (bankangle[c] < 0.1) {
                            bankangle[c] = 0.1;
                        }
                        if (bankangle[c] > 0.9) {
                            bankangle[c] = 0.9;
                        }
                        gotbankleft[c] = true;
                    }
                    left[c] = true;
                    if (!onattackmode[c]) {
                        if (bankangle[c] < 0.3) {
                            down[c] = true;
                            if (breakup[c]) {
                                left[c] = false;
                                overidel = true;
                            }
                        }
                    } else {
                        if ((Math.abs(rgoxz - goxz) > (acuxz * 4)) && (craft[sel[c]].mat[5] < 0.5)) {
                            down[c] = true;
                        }
                    }
                    if ((craft[sel[c]].mat[5] < bankangle[c]) && (craft[sel[c]].mat[1] < 0)) {
                        left[c] = false;
                    }
                } else {
                    gotbankleft[c] = false;
                }
                if (bankright) {
                    if (!gotbankright[c]) {
                        bankangle[c] = ((180 - Math.abs(rgoxz - goxz)) / 180);
                        if (onattackmode[c]) {
                            bankangle[c] *= 0.7;
                        }
                        if (bankangle[c] < 0.1) {
                            bankangle[c] = 0.1;
                        }
                        if (bankangle[c] > 0.9) {
                            bankangle[c] = 0.9;
                        }
                        gotbankright[c] = true;
                    }
                    right[c] = true;
                    if (!onattackmode[c]) {
                        if (bankangle[c] < 0.3) {
                            down[c] = true;
                            if (breakup[c]) {
                                right[c] = false;
                                overidel = true;
                            }
                        }
                    } else {
                        if ((Math.abs(rgoxz - goxz) > (acuxz * 4)) && (craft[sel[c]].mat[5] < 0.5)) {
                            down[c] = true;
                        }
                    }
                    if ((craft[sel[c]].mat[5] < bankangle[c]) && (craft[sel[c]].mat[1] > 0)) {
                        right[c] = false;
                    }
                } else {
                    gotbankright[c] = false;
                }
                if ((!bankleft) && (!bankright)) {
                    if (Math.abs(craft[sel[c]].mat[1]) > bankswing) {
                        if (craft[sel[c]].mat[1] > 0) {
                            left[c] = true;
                        } else {
                            right[c] = true;
                        }
                    }
                    if (!gotbreakup[c]) {
                        if (Math.random() > Math.random()) {
                            breakup[c] = false;
                        } else {
                            breakup[c] = true;
                        }
                    }
                } else {
                    gotbreakup[c] = false;
                }
                if ((Math.abs(craft[sel[c]].mat[1]) < 0.64) && (!overidel)) {
                    if (craft[sel[c]].mat[5] > 0) {
                        if (pullup) {
                            down[c] = true;
                        }
                        if (pushdown) {
                            up[c] = true;
                        }
                    } else {
                        if (pullup) {
                            up[c] = true;
                        }
                        if (pushdown) {
                            down[c] = true;
                        }
                    }
                }
            } else {
                if (breakawayup[c]) {
                    down[c] = true;
                }
                if (breakawayroll[c] == 1) {
                    left[c] = true;
                }
                if (breakawayroll[c] == 2) {
                    right[c] = true;
                }
            }
            if (breakaway[c] != 0) {
                breakaway[c]--;
            }
        }
        var procx = (craft[sel[c]].x + (colprodist * craft[sel[c]].mat[8]));
        var procy = (craft[sel[c]].y + (colprodist * craft[sel[c]].mat[9]));
        var procz = (craft[sel[c]].z + (colprodist * craft[sel[c]].mat[10]));
        if (procy < 0) {
            targx[c] = procx;
            targy[c] = (procy + colprodist);
            targz[c] = procz;
            oncolavoid[c] = 10;
        }
        for (var i = 0; i < 3; i++) {
            if (!oncolavoid[c]) {
                if (i >= 1) {
                    procx = (craft[sel[c]].x + ((colprodist / (i + 1)) * craft[sel[c]].mat[8]));
                    procy = (craft[sel[c]].y + ((colprodist / (i + 1)) * craft[sel[c]].mat[9]));
                    procz = (craft[sel[c]].z + ((colprodist / (i + 1)) * craft[sel[c]].mat[10]));
                }
                var colpnt = newcolpnt();
                colpnt.x = procx;
                colpnt.y = procy;
                colpnt.z = procz;
                colpnt.mat = craft[sel[c]].mat;
                colpnt.colrad = 7;
                for (var k = 0; k < nm; k++) {
                    colide(2, c, colpnt, mnt[k], 7);
                }
                for (var k = 0; k < nb; k++) {
                    obst[obo[k].typ].x = obo[k].x;
                    obst[obo[k].typ].z = obo[k].z;
                    obst[obo[k].typ].mat = obo[k].mat;
                    colide(2, c, colpnt, obst[obo[k].typ], 7);
                }
            }
        }
    }
}
function newcolpnt() {
    return {
        x: 0,
        y: 0,
        z: 0,
        mat: null,
        colrad: 0
    };
}
function procoldetectd(c, clx, cly, clz, normx, normy, normz) {
    targx[c] = (clx + (colprodist * normx));
    targy[c] = (cly + (colprodist * normy));
    targz[c] = (clz + (colprodist * normz));
    oncolavoid[c] = 20;
}
var mutegame = false;
var mutemusic = false;
var mutedgame = false;
var mutedmusic = false;
var omutemusic = false;
var omutegame = false;
var needrotate = false;
var totime = 0, nfr = 0, actat = 20, ltime = -1;
var canw = 1280, canh = 720;
var mw = 1, mh = 1;
var avm = 1;
var fase = 0;
function gameloop() {
    if (canw != window.innerWidth || canh != window.innerHeight) {
        canw = window.innerWidth;
        canh = window.innerHeight;
        mw = (canw / 1280);
        mh = (canh / 720);
        avm = ((mw + mh) / 2);
        canvas3D.width = canw;
        canvas3D.height = canh;
        canvas3D.style.width = "" + canw + "px";
        canvas3D.style.height = "" + canh + "px";
        canvas2D.width = canw;
        canvas2D.height = canh;
        canvas2D.style.width = "" + canw + "px";
        canvas2D.style.height = "" + canh + "px";
        if ((canw / canh) <= 1.32) {
            if (!needrotate) {
                needrotate = true;
            }
        } else {
            if (needrotate) {
                needrotate = false;
            }
        }
        gl.viewport(0, 0, canw, canh);
        drawstat = 10;
        gofullscreen = false;
    }
    if (fase == 0) {
        loaddata();
    }
    if (fase == 1) {
        drawmain();
    }
    if (fase == 2) {
        drawcraftselect();
    }
    if (fase == 3) {
        transition();
    }
    if (fase == 4) {
        drawselectstage();
    }
    if (fase == 6) {
        prepstart();
    }
    if (fase == 7) {
        cameraworks();
        worldworks();
        flightinter();
        flyai();
        flycraft();
        lasersfly();
    }
    if (fase == 5) {
        gameinstruction();
    }
    if (fase == 8) {
        rewardraw();
    }
    if (fase == 9) {
        pausedgame();
    }
    if (fase == 10) {
        endgame();
    }
    if (fase == 11) {
        transend();
    }
    if (fase == 12) {
        drawin();
    }
    if (fase == 13) {
        resetgame();
    }
    if (mutemusic) {
        if (!mutedmusic) {
            pausemusic();
            mutedmusic = true;
        }
    } else {
        if (mutedmusic) {
            resumemusic();
            mutedmusic = false;
        }
    }
    if (canplaysnd) {
        if (mutegame) {
            if (!mutedgame) {
                soundau.suspend();
                mutedgame = true;
            }
        } else {
            if (mutedgame) {
                soundau.resume();
                mutedgame = false;
            }
        }
    }
    if (needrotate) {
        rd.fillStyle = "#000000";
        rd.fillRect(0, 0, canw, canh);
        var rwd = rosize.width;
        var rhd = rosize.height;
        if (rwd > canw) {
            rhd = (rhd * (canw / rwd));
            rwd = canw;
        }
        rd.drawImage(rosize, ((canw * 0.5) - (rwd * 0.5)), ((canh * 0.5) - (rhd * 0.5)), rwd, rhd);
    }
    if (onaclk) {
        onaclk--;
    }
    if (space == 2) {
        space = 0;
    }
    var date = new Date();
    var ctime = date.getTime();
    if (ltime == -1) {
        totime = 20;
    } else {
        totime += (ctime - ltime);
    }
    ltime = ctime;
    nfr++;
    if (nfr == 5) {
        if (totime > 100) {
            actat--;
            if (actat < 5) {
                actat = 5;
            }
        } else {
            actat++;
        }
        totime = 0;
        nfr = 0;
    }
    setTimeout("gameloop()", actat);
}
var canplaysnd = false;
var soundau = null;
try {
    window.AudioContext = window.AudioContext || window.webkitAudioContext;
    soundau = new AudioContext();
    canplaysnd = true;
} catch (e) {
    canplaysnd = false;
}
var interaud = null;
var interaudstat = 0;
var firstinterplay = true;
function playintertrack() {
    try {
        if (interaudstat == 0) {
            interaud = new Audio("data/music/inter.mp3");
            interaud.volume = 1;
            interaud.loop = true;
        }
        if (!mutemusic) {
            if ((!isios) || (!firstinterplay)) {
                interaud.play();
            }
        }
        firstinterplay = false;
    } catch (e) {}
    interaudstat = 1;
}
function pauseintertrack() {
    if (interaudstat == 1) {
        interaud.pause();
        interaudstat = 2;
    }
}
var stageaud = null;
var stageaudstat = 0;
var laststageaud = -1;
function playtrack() {
    try {
        var playedbefore = false;
        if (laststageaud != stage) {
            stageaud = new Audio("data/music/stage" + stage + ".mp3");
            stageaud.volume = 1;
            stageaud.loop = true;
            laststageaud = stage;
        } else {
            stageaud.currentTime = 0;
            playedbefore = true;
        }
        if (!mutemusic) {
            if ((!isios) || (playedbefore)) {
                stageaud.play();
            }
        }
    } catch (e) {}
    stageaudstat = 1;
}
function stopstagetrack() {
    if (stageaudstat == 1) {
        stageaud.pause();
        stageaudstat = 2;
    }
}
function pausemusic() {
    if (stageaudstat == 1) {
        stageaud.pause();
    }
    if (interaudstat == 1) {
        interaud.pause();
    }
}
function resumemusic() {
    if (stageaudstat == 1) {
        stageaud.play();
    }
    if (interaudstat == 1) {
        interaud.play();
    }
}
var sndb = [];
var sndload = [];
var intersndload = 0;
function loadsnd(num) {
    if (canplaysnd) {
        sndload[num] = false;
        var request = new XMLHttpRequest();
        request.open("GET", "data/sounds/" + num + ".mp3", true);
        request.responseType = "arraybuffer";
        request.onload = function () {
            soundau.decodeAudioData(request.response, function (buffer) {
                sndb[num] = buffer;
            }, onError);
            sndload[num] = true;
            if (num == 43) {
                intersndload += 19;
            }
            if (num == 44) {
                intersndload += 12;
            }
        };
        request.send();
    } else {
        if (num == 43) {
            intersndload += 19;
        }
        if (num == 44) {
            intersndload += 12;
        }
    }
}
function playsnd(num) {
    if ((canplaysnd) && (sndload[num]) && (!mutegame)) {
        var source = soundau.createBufferSource();
        source.buffer = sndb[num];
        source.connect(soundau.destination);
        source.start();
    }
}
function onError() {}
var gofullscreen = false;
var checkmusic = 0;
var firstclick = false;
function checknplay() {
    if (!gofullscreen) {
        fullscreen();
        gofullscreen = true;
    }
    if (firstclick) {
        firstclick = false;
    }
    if (!checkmusic) {
        playsnd(44);
        checkmusic = 3;
        firstclick = true;
    }
    if ((interaudstat == 1) && (checkmusic != 2) && (!mutemusic)) {
        if (interaud.currentTime == 0) {
            interaud.play();
        }
        checkmusic = 2;
    }
    if ((stageaudstat == 1) && (checkmusic != 1) && (!mutemusic)) {
        if (stageaud.currentTime == 0) {
            stageaud.play();
        }
        checkmusic = 1;
    }
}
function fullscreen() {
    if (isphone) {
        if ((window.innerWidth != screen.width) || (window.innerHeight != screen.height)) {
            if (document.body.requestFullScreen) {
                document.body.requestFullScreen();
            } else {
                if (document.body.webkitRequestFullScreen) {
                    document.body.webkitRequestFullScreen();
                } else {
                    if (document.body.mozRequestFullScreen) {
                        document.body.mozRequestFullScreen();
                    } else {
                        if (document.body.msRequestFullscreen) {
                            document.body.msRequestFullscreen();
                        }
                    }
                }
            }
        }
    }
}
function saveInfo(iname, ivalue) {
    try {
        if (typeof(Storage) !== "undefined") {
            if (localStorage != null) {
                localStorage.setItem(iname, ivalue);
            }
        }
    } catch (e) {}
}
function getInfo(iname) {
    var ivalue = "-1";
    try {
        if (typeof(Storage) !== "undefined") {
            if (localStorage != null) {
                if (localStorage.getItem(iname) != null) {
                    ivalue = localStorage.getItem(iname);
                }
            }
        }
    } catch (e) {}
    var retivalue = parseInt(ivalue);
    if (Number.isNaN(retivalue)) {
        retivalue = 0;
    }
    return retivalue;
}
var cntautogo = 0;
var flashplay = false;
function drawinstart() {
    rd.fillStyle = "#B9E1FF";
    rd.fillRect(0, 0, canw, canh);
    rd.drawImage(pausebg, 0, 0, canw, canh);
    rd.drawImage(iscrin, (23 * mw), (23 * mh), (1234 * mw), (674 * mh));
    rd.font = "" + (42 * avm) + "px teko";
    rd.textBaseline = "middle";
    rd.textAlign = "left";
    rd.fillStyle = "#000000";
    rd.fillText("To control your aircraft", (130 * mw), (120 * mh));
    if (!isphone) {
        rd.fillText("click the mouse around it", (130 * mw), (180 * mh));
    } else {
        rd.fillText("press finger around it", (130 * mw), (180 * mh));
    }
    var msfn = 9;
    if (isphone) {
        msfn = 10;
    }
    rd.textAlign = "left";
    rd.drawImage(inst[4], ((640 * mw) - (264.5 * avm)), ((360 * mh) - (185.5 * avm)), (529 * avm), (371 * avm));
    if (arnd == 0) {
        rd.drawImage(inst[5], ((640 * mw) - (20 * avm)), ((360 * mh) - (120 * avm)), (40 * avm), (64 * avm));
        rd.fillText("Pull Up", ((640 * mw) + (20 * avm) + (10 * mw)), ((360 * mh) - (70 * avm)));
        rd.drawImage(inst[msfn], ((640 * mw) - (22.5 * avm)), ((360 * mh) - (230 * avm)), (66 * avm), (78 * avm));
    }
    if (arnd == 1) {
        rd.drawImage(inst[7], ((640 * mw) - (20 * avm)), ((360 * mh) + (56 * avm)), (40 * avm), (64 * avm));
        rd.fillText("Push Down", ((640 * mw) + (20 * avm) + (10 * mw)), ((360 * mh) + (80 * avm)));
        rd.drawImage(inst[msfn], ((640 * mw) - (22.5 * avm)), ((360 * mh) + (152 * avm)), (66 * avm), (78 * avm));
    }
    if (arnd == 2) {
        rd.drawImage(inst[8], ((640 * mw) - (194 * avm)), ((360 * mh) - (20 * avm)), (64 * avm), (40 * avm));
        rd.fillText("Roll Left", ((640 * mw) - (212 * avm)), ((360 * mh) + (50 * avm)));
        rd.drawImage(inst[msfn], ((640 * mw) - (300 * avm)), ((360 * mh) - (20 * avm)), (66 * avm), (78 * avm));
    }
    if (arnd == 3) {
        rd.drawImage(inst[6], ((640 * mw) + (130 * avm)), ((360 * mh) - (20 * avm)), (64 * avm), (40 * avm));
        rd.fillText("Roll Right", ((640 * mw) + (100 * avm)), ((360 * mh) + (50 * avm)));
        rd.drawImage(inst[msfn], ((640 * mw) + (250 * avm)), ((360 * mh) - (20 * avm)), (66 * avm), (78 * avm));
    }
    var onit = 0;
    var btnx = 1020;
    var btny = 610;
    var btnw = 260;
    var btnh = 60;
    declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 6);
    if (wasonit == 6) {
        onit = 1;
    }
    if ((onaclk > 7) && (onwho == 6)) {
        onit = 1;
    }
    if ((onaclk == 9) && (onwho == 6)) {
        infase = 0;
        fase = 6;
        if (!firstclick) {
            playsnd(44);
        }
        if (adshow == 0) {
            adshow = 1;
        } else {
            adshow = 2;
            showLoadingAd();
        }
        onwho = 0;
        wasonit = 0;
    }
    if ((arndcnt < 40) || (!flashplay)) {
        drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "PLAY GAME", 27);
    } else {
        drawbutton(onit, btnx, btny, btnw, btnh, "#FACE00", "#FA3B00", "#A08400", "#A02600", "PLAY GAME", 27);
    }
    if (checkmusic) {
        if (cntautogo == 500) {
            infase = 0;
            fase = 6;
            if (adshow == 0) {
                adshow = 1;
            } else {
                adshow = 2;
                showLoadingAd();
            }
        }
        cntautogo++;
    }
    if (!isphone) {
        rd.font = "" + (42 * avm) + "px teko";
        rd.textBaseline = "middle";
        rd.textAlign = "center";
        rd.fillStyle = "#000000";
        rd.fillText("Or use Keyboard Arrows", (1000 * mw), (120 * mh));
        rd.drawImage(inst[11], ((1020 * mw) - (110 * avm)), (160 * mh), (220 * avm), (155 * avm));
        rd.fillStyle = "#FA8100";
        rd.globalAlpha = 0.3;
        if (arnd == 0) {
            fillroundrect(((1020 * mw) - (110 * avm) + (76 * avm)), ((160 * mh) + (2 * avm)), (63 * avm), (67 * avm), (5 * avm));
        }
        if (arnd == 1) {
            fillroundrect(((1020 * mw) - (110 * avm) + (76 * avm)), ((160 * mh) + (80 * avm)), (63 * avm), (67 * avm), (5 * avm));
        }
        if (arnd == 2) {
            fillroundrect(((1020 * mw) - (110 * avm) + (2 * avm)), ((160 * mh) + (80 * avm)), (63 * avm), (67 * avm), (5 * avm));
        }
        if (arnd == 3) {
            fillroundrect(((1020 * mw) - (110 * avm) + (150 * avm)), ((160 * mh) + (80 * avm)), (63 * avm), (67 * avm), (5 * avm));
        }
        rd.globalAlpha = 1;
    }
    arndcnt++;
    if (arndcnt == 50) {
        arnd++;
        if (arnd == 4) {
            arnd = 0;
            flashplay = true;
        }
        arndcnt = 0;
    }
    if (!flwg) {
        flw -= 0.03;
        if (flw < 0.5) {
            flw = 0.5;
            flwg = true;
        }
    } else {
        flw += 0.03;
        if (flw > 2) {
            flw = 2;
            flwg = false;
        }
    }
    if (!flhg) {
        flh -= 0.5;
        if (flh < 0.1) {
            flh = 0.1;
            flhg = true;
        }
    } else {
        flh += 0.5;
        if (flh > 2) {
            flh = 2;
            flhg = false;
        }
    }
}
function drawinstkeys() {
    if (cntautogo) {
        cntautogo = 0;
    }
    rd.fillStyle = "#B9E1FF";
    rd.fillRect(0, 0, canw, canh);
    rd.drawImage(pausebg, 0, 0, canw, canh);
    rd.drawImage(iscrin, (23 * mw), (23 * mh), (1234 * mw), (674 * mh));
    rd.font = "" + (42 * avm) + "px teko";
    rd.textBaseline = "middle";
    rd.fillStyle = "#000000";
    rd.textAlign = "center";
    rd.fillText("You can also fly using flight simulator style keyboard controls,", (640 * mw), (140 * mh));
    rd.textAlign = "left";
    rd.fillText("Down arrow key to pull aircraft nose up", (130 * mw), (240 * mh));
    rd.fillText("Up arrow key to push aircraft nose down", (130 * mw), (300 * mh));
    rd.fillText("Left and right arrow keys to roll aircraft", (130 * mw), (360 * mh));
    rd.textAlign = "center";
    rd.fillText("Spacebar to switch attack/race mode", (910 * mw), (430 * mh));
    rd.drawImage(inst[11], ((370 * mw) - (110 * avm)), ((570 * mh) - (155 * avm)), (220 * avm), (155 * avm));
    rd.drawImage(inst[12], ((910 * mw) - (172.5 * avm)), ((550 * mh) - (77 * avm)), (345 * avm), (77 * avm));
    onit = 0;
    btnx = 1050;
    btny = 610;
    btnw = 150;
    btnh = 60;
    declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 6);
    if (wasonit == 6) {
        onit = 1;
    }
    if ((onaclk > 7) && (onwho == 6)) {
        onit = 1;
    }
    if ((onaclk == 9) && (onwho == 6)) {
        infase = 5;
        playsnd(44);
        onwho = 0;
        wasonit = 0;
    }
    drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "< BACK", 23);
    if (!flwg) {
        flw -= 0.03;
        if (flw < 0.5) {
            flw = 0.5;
            flwg = true;
        }
    } else {
        flw += 0.03;
        if (flw > 2) {
            flw = 2;
            flwg = false;
        }
    }
    if (!flhg) {
        flh -= 0.5;
        if (flh < 0.1) {
            flh = 0.1;
            flhg = true;
        }
    } else {
        flh += 0.5;
        if (flh > 2) {
            flh = 2;
            flhg = false;
        }
    }
}
function drawinstattack() {
    rd.clearRect(0, 0, canw, canh);
    rd.drawImage(pausebg, 0, 0, canw, canh);
    rd.drawImage(iscrin, (23 * mw), (23 * mh), (1234 * mw), (674 * mh));
    rd.font = "" + (42 * avm) + "px teko";
    rd.textBaseline = "middle";
    rd.textAlign = "left";
    rd.fillStyle = "#000000";
    rd.fillText("Switching to attack mode now!", (720 * mw), (170 * mh));
    var vrh = ((130 * mh) + (320 * avm));
    if (vrh > ((620 * mh) - (142 * avm))) {
        vrh = ((620 * mh) - (142 * avm));
    }
    rd.drawImage(inst[2], ((100 * mw) + (590 * avm)), vrh, (245 * avm), (142 * avm));
    rd.drawImage(inst[13], (100 * mw), (130 * mh), (699 * avm), (388 * avm));
    rd.fillText("Follow arrow to target and auto-shoot.", (120 * mw), ((130 * mh) + (388 * avm)));
    rd.font = "" + (42 * avm) + "px osaka";
    rd.textBaseline = "middle";
    rd.textAlign = "center";
    rd.fillStyle = "#FF0000";
    rd.fillText("ATTACK MODE", (950 * mw), ((285 * mh) - (51 * avm)));
    rd.drawImage(inst[14], ((950 * mw) - (67.5 * avm)), ((340 * mh) - (51 * avm)), (135 * avm), (102 * avm));
    if (arndcnt < 4) {
        rd.lineWidth = (3 * avm);
        rd.strokeStyle = "#FF0000";
        drawEllipse(rd, ((950 * mw) - (130 * avm)), ((340 * mh) - (70 * avm)), (260 * avm), (140 * avm));
    }
    arndcnt++;
    if (arndcnt >= 8) {
        arndcnt = 0;
    }
    var onit = 0;
    var btnx = 1050;
    var btny = 610;
    var btnw = 180;
    var btnh = 60;
    declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 6);
    if (wasonit == 6) {
        onit = 1;
    }
    if ((onaclk > 7) && (onwho == 6)) {
        onit = 1;
    }
    if ((onaclk == 9) && (onwho == 6)) {
        saveInfo("showplay", "" + showplay + "");
        getheading = 0;
        getslope = 0;
        infase = 0;
        gameplayStart();
        fase = 7;
        requestAnimationFrame(render);
        onwho = 0;
        wasonit = 0;
    }
    drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "OKAY", 23);
}
function drawinstrace() {
    rd.clearRect(0, 0, canw, canh);
    rd.drawImage(pausebg, 0, 0, canw, canh);
    rd.drawImage(iscrin, (23 * mw), (23 * mh), (1234 * mw), (674 * mh));
    rd.font = "" + (42 * avm) + "px teko";
    rd.textBaseline = "middle";
    rd.fillStyle = "#000000";
    rd.textAlign = "left";
    rd.fillText("Switching to race mode!", (130 * mw), (150 * mh));
    rd.font = "" + (42 * avm) + "px osaka";
    rd.textBaseline = "middle";
    rd.textAlign = "center";
    rd.fillStyle = "#008DF0";
    rd.fillText("RACE MODE", (450 * mw), ((285 * mh) - (51 * avm)));
    rd.drawImage(inst[15], ((450 * mw) - (67.5 * avm)), ((340 * mh) - (51 * avm)), (135 * avm), (102 * avm));
    if (arndcnt < 4) {
        rd.lineWidth = (3 * avm);
        rd.strokeStyle = "#008DF0";
        drawEllipse(rd, ((450 * mw) - (130 * avm)), ((340 * mh) - (70 * avm)), (260 * avm), (140 * avm));
    }
    arndcnt++;
    if (arndcnt >= 8) {
        arndcnt = 0;
    }
    rd.drawImage(inst[1], ((810 * mw) - (189 * avm)), (220 * mh), (378 * avm), (192 * avm));
    rd.font = "" + (42 * avm) + "px teko";
    rd.textBaseline = "middle";
    rd.fillStyle = "#000000";
    rd.textAlign = "left";
    rd.fillText("When racing go through the checkpoints and finish in 1st place to win!", (130 * mw), (500 * mh));
    rd.fillText("You can win by racing or by destroying all other aircrafts.", (130 * mw), (560 * mh));
    var onit = 0;
    var btnx = 1050;
    var btny = 610;
    var btnw = 180;
    var btnh = 60;
    declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 6);
    if (wasonit == 6) {
        onit = 1;
    }
    if ((onaclk > 7) && (onwho == 6)) {
        onit = 1;
    }
    if ((onaclk == 9) && (onwho == 6)) {
        saveInfo("showplay", "" + showplay + "");
        getheading = 0;
        getslope = 0;
        infase = 0;
        gameplayStart();
        fase = 7;
        requestAnimationFrame(render);
        onwho = 0;
        wasonit = 0;
    }
    drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "OKAY", 23);
}
function drawinstpart() {
    rd.clearRect(0, 0, canw, canh);
    rd.drawImage(pausebg, 0, 0, canw, canh);
    rd.drawImage(iscrin, (23 * mw), (23 * mh), (1234 * mw), (674 * mh));
    rd.font = "" + (42 * avm) + "px teko";
    rd.textBaseline = "middle";
    rd.textAlign = "left";
    rd.fillStyle = "#000000";
    rd.fillText("Your aircraft is damaged, find the orange fixing", (130 * mw), (140 * mh));
    rd.fillText("portal and fly through it to fix it!", (130 * mw), (200 * mh));
    rd.fillText("Or you can also use the auto-fix button.", (130 * mw), (470 * mh));
    rd.font = "" + (32 * avm) + "px osaka";
    rd.textBaseline = "middle";
    rd.globalAlpha = 0.8;
    var grd = rd.createLinearGradient(0, (365 * mh), 0, (395 * mh));
    grd.addColorStop(0, "#0044B4");
    grd.addColorStop(1, "#000000");
    rd.fillStyle = grd;
    rd.textAlign = "right";
    rd.fillText("DAMAGE", ((493 * mw) - (160 * mw)), (320 * mh));
    var dmg = (damage[0] / 1.2);
    if (dmg > 1) {
        dmg = 1;
    }
    var xdd = ((500 * mw) - (160 * mw) + (80 * mw * dmg));
    var ydd = (320 * mh);
    var wdd = (160 * mw * dmg);
    var hdd = (28 * mh);
    if (dmg >= 0.076) {
        rd.beginPath();
        rd.moveTo((xdd - (wdd * 0.5) + (14 * mw)), (ydd - (hdd * 0.5)));
        rd.lineTo((xdd - (wdd * 0.5) + (6 * mw)), (ydd - (hdd * 0.5) + (7 * mh)));
        rd.lineTo((xdd - (wdd * 0.5)), (ydd + (hdd * 0.5)));
        rd.lineTo((xdd + (wdd * 0.5) - (14 * mw)), (ydd + (hdd * 0.5)));
        rd.lineTo((xdd + (wdd * 0.5) - (6 * mw)), (ydd + (hdd * 0.5) - (7 * mh)));
        rd.lineTo((xdd + (wdd * 0.5)), (ydd - (hdd * 0.5)));
        rd.closePath();
        grd = rd.createLinearGradient(0, (ydd - (hdd * 0.5)), 0, (ydd + (hdd * 0.5)));
        grd.addColorStop(0, "rgb(255," + (255 - (128 * dmg)) + ",0)");
        grd.addColorStop(1, "rgb(255," + (128 - (128 * dmg)) + ",0)");
        rd.fillStyle = grd;
        rd.fill();
    }
    xdd = ((500 * mw) - (80 * mw));
    ydd = (320 * mh);
    wdd = (160 * mw);
    hdd = (28 * mh);
    rd.beginPath();
    rd.moveTo((xdd - (wdd * 0.5) + (14 * mw)), (ydd - (hdd * 0.5)));
    rd.lineTo((xdd - (wdd * 0.5) + (6 * mw)), (ydd - (hdd * 0.5) + (7 * mh)));
    rd.lineTo((xdd - (wdd * 0.5)), (ydd + (hdd * 0.5)));
    rd.lineTo((xdd + (wdd * 0.5) - (14 * mw)), (ydd + (hdd * 0.5)));
    rd.lineTo((xdd + (wdd * 0.5) - (6 * mw)), (ydd + (hdd * 0.5) - (7 * mh)));
    rd.lineTo((xdd + (wdd * 0.5)), (ydd - (hdd * 0.5)));
    rd.closePath();
    rd.globalAlpha = 0.6;
    grd = rd.createLinearGradient(0, (ydd - (hdd * 0.5)), 0, (ydd + (hdd * 0.5)));
    grd.addColorStop(0, "#5A7094");
    grd.addColorStop(1, "#1A202A");
    rd.strokeStyle = grd;
    rd.lineWidth = (2 * avm);
    rd.stroke();
    rd.globalAlpha = 1;
    rd.lineWidth = (3 * avm);
    rd.strokeStyle = "#FF0000";
    drawEllipse(rd, ((360 * mw) - (200 * avm)), ((320 * mh) - (70 * avm)), (400 * avm), (140 * avm));
    rd.drawImage(inst[6], (620 * mw), (300 * mh), (96 * avm), (60 * avm));
    rd.drawImage(inst[3], (760 * mw), (230 * mh), (291 * avm), (192 * avm));
    if (!mdown) {
        if (cntautogo != 10) {
            cntautogo++;
        }
    }
    onit = 0;
    btnx = 1050;
    btny = 610;
    btnw = 180;
    btnh = 60;
    declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 6);
    if (wasonit == 6) {
        onit = 1;
    }
    if ((onaclk > 7) && (onwho == 6)) {
        onit = 1;
    }
    if ((onaclk == 9) && (onwho == 6)) {
        saveInfo("showfixing", "2");
        getheading = 0;
        getslope = 0;
        infase = 0;
        gameplayStart();
        fase = 7;
        requestAnimationFrame(render);
    }
    drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "OKAY", 23);
}
function drawinstinvert() {
    rd.clearRect(0, 0, canw, canh);
    rd.drawImage(pausebg, 0, 0, canw, canh);
    rd.drawImage(iscrin, (23 * mw), (23 * mh), (1234 * mw), (674 * mh));
    rd.font = "" + (42 * avm) + "px teko";
    rd.textBaseline = "middle";
    rd.textAlign = "left";
    rd.fillStyle = "#000000";
    rd.drawImage(inst[18], ((620 * mw) - (70 * avm)), ((380 * mh) - (46 * avm)), (70 * avm), (92 * avm));
    rd.drawImage(inst[11], (70 / rdres), 0, (73 / rdres), (155 / rdres), ((680 * mw) - (36 * avm)), ((380 * mh) - (77 * avm)), (73 * avm), (155 * avm));
    var onit = 0;
    var btnx = 640;
    var btny = 510;
    var btnw = 310;
    var btnh = 60;
    var btntxt = "INVERT CONTROLS";
    if (!invertcontrols) {
        rd.fillText("Do you wish to invert the Up and Down keys to have", (150 * mw), (200 * mh));
        rd.fillText("flight simulator style controls?", (150 * mw), (260 * mh));
    } else {
        rd.fillText("Do you wish to cancel the inverted the Up and Down keys?", (150 * mw), (230 * mh));
        btntxt = "CANCEL INVERTED CONTROLS";
        btnw = 490;
        rd.lineWidth = (3 * avm);
        rd.strokeStyle = "#FF0000";
        rd.beginPath();
        rd.moveTo((560 * mw), (280 * mh));
        rd.lineTo((720 * mw), (440 * mh));
        rd.closePath();
        rd.stroke();
        rd.beginPath();
        rd.moveTo((720 * mw), (280 * mh));
        rd.lineTo((560 * mw), (440 * mh));
        rd.closePath();
        rd.stroke();
    }
    declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 3);
    if (wasonit == 3) {
        onit = 1;
    }
    if ((onaclk > 7) && (onwho == 3)) {
        onit = 1;
    }
    if ((onaclk == 9) && (onwho == 3)) {
        if (invertcontrols) {
            invertcontrols = false;
            saveInfo("invertcontrols", "0");
        } else {
            invertcontrols = true;
            saveInfo("invertcontrols", "2");
        }
        getheading = 0;
        getslope = 0;
        mutemusic = omutemusic;
        mutegame = omutegame;
        playsnd(44);
        infase = 0;
        gameplayStart();
        fase = 7;
        requestAnimationFrame(render);
        onwho = 0;
        wasonit = 0;
    }
    drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", btntxt, 23);
    onit = 0;
    btnx = 1020;
    btny = 610;
    btnw = 270;
    btnh = 60;
    declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 6);
    if (wasonit == 6) {
        onit = 1;
    }
    if ((onaclk > 7) && (onwho == 6)) {
        onit = 1;
    }
    if ((onaclk == 9) && (onwho == 6)) {
        getheading = 0;
        getslope = 0;
        mutemusic = omutemusic;
        mutegame = omutegame;
        infase = 0;
        gameplayStart();
        fase = 7;
        requestAnimationFrame(render);
        onwho = 0;
        wasonit = 0;
    }
    drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "BACK TO GAME", 23);
}
function drawloading() {
    rd.fillStyle = "#121F2C";
    rd.fillRect(0, 0, canw, canh);
    var perc = ((dataload + imgsload + intersndload + 240) / 1400);
    if (perc > 1) {
        perc = 1;
    }
    if (perc < 0.076) {
        perc = 0.076;
    }
    var xdd = ((640 * mw) - (110 * mw) + (110 * mw * perc));
    var ydd = (360 * mh);
    var wdd = (220 * mw * perc);
    var hdd = (30 * mh);
    rd.beginPath();
    rd.moveTo((xdd - (wdd * 0.5) + (14 * mw)), (ydd - (hdd * 0.5)));
    rd.lineTo((xdd - (wdd * 0.5) + (6 * mw)), (ydd - (hdd * 0.5) + (7 * mh)));
    rd.lineTo((xdd - (wdd * 0.5)), (ydd + (hdd * 0.5)));
    rd.lineTo((xdd + (wdd * 0.5) - (14 * mw)), (ydd + (hdd * 0.5)));
    rd.lineTo((xdd + (wdd * 0.5) - (6 * mw)), (ydd + (hdd * 0.5) - (7 * mh)));
    rd.lineTo((xdd + (wdd * 0.5)), (ydd - (hdd * 0.5)));
    rd.closePath();
    var grd = rd.createLinearGradient(0, (ydd - (hdd * 0.5)), 0, (ydd + (hdd * 0.5)));
    grd.addColorStop(0, "#05B6FF");
    grd.addColorStop(1, "#007DD4");
    rd.fillStyle = grd;
    rd.fill();
    xdd = (640 * mw);
    ydd = (360 * mh);
    wdd = (220 * mw);
    hdd = (30 * mh);
    rd.beginPath();
    rd.moveTo((xdd - (wdd * 0.5) + (14 * mw)), (ydd - (hdd * 0.5)));
    rd.lineTo((xdd - (wdd * 0.5) + (6 * mw)), (ydd - (hdd * 0.5) + (7 * mh)));
    rd.lineTo((xdd - (wdd * 0.5)), (ydd + (hdd * 0.5)));
    rd.lineTo((xdd + (wdd * 0.5) - (14 * mw)), (ydd + (hdd * 0.5)));
    rd.lineTo((xdd + (wdd * 0.5) - (6 * mw)), (ydd + (hdd * 0.5) - (7 * mh)));
    rd.lineTo((xdd + (wdd * 0.5)), (ydd - (hdd * 0.5)));
    rd.closePath();
    rd.globalAlpha = 0.6;
    grd = rd.createLinearGradient(0, (ydd - (hdd * 0.5)), 0, (ydd + (hdd * 0.5)));
    grd.addColorStop(0, "#05B6FF");
    grd.addColorStop(1, "#007DD4");
    rd.strokeStyle = grd;
    rd.lineWidth = (2 * avm);
    rd.stroke();
    rd.globalAlpha = 1;
    rd.font = "" + (30 * avm) + "px teko";
    rd.textBaseline = "middle";
    rd.textAlign = "center";
    rd.fillStyle = "#121F2C";
    rd.fillText("LOADING", (640 * mw), (100 * mh));
    rd.font = "" + (30 * avm) + "px osaka";
    rd.textBaseline = "middle";
    rd.textAlign = "center";
    rd.fillStyle = "#121F2C";
    rd.fillText("LOADING", (640 * mw), (600 * mh));
}
var confr = 0;
var confl = -1;
var confg = 0;
var conflk = 0;
function drawin() {
    rd.drawImage(door1, (247 * mw), (167 * mh), (441 * mw), (443 * mh));
    rd.drawImage(door2, (613 * mw), (167 * mh), (409 * mw), (443 * mh));
    rd.drawImage(room1, 0, 0, canw, canh);
    rd.drawImage(logobg, ((640 * mw) - (212.5 * avm)), (30 * mh), (425 * avm), (533 * avm));
    rd.font = "" + (50 * avm) + "px osaka";
    rd.textBaseline = "middle";
    rd.textAlign = "center";
    var grd = rd.createLinearGradient(0, (180 * mh), 0, (220 * mh));
    if (conflk < 2) {
        grd.addColorStop(0, "#0080EC");
        grd.addColorStop(1, "#95D3FF");
    } else {
        grd.addColorStop(0, "#95D3FF");
        grd.addColorStop(1, "#0080EC");
    }
    rd.fillStyle = grd;
    rd.fillText("CONGRATULATIONS!", (640 * mw), (200 * mh));
    rd.font = "" + (35 * avm) + "px osaka";
    rd.fillText("YOU HAVE COMPLETED ALL STAGES AND UNLOCKED ALL AIRCRAFTS!", (640 * mw), (260 * mh));
    rd.fillText("YOU ARE A TRUE MASTER OF THUNDER", (640 * mw), (320 * mh));
    conflk++;
    if (conflk == 5) {
        conflk = 0;
    }
    if (confeloaded) {
        if (confg == 0) {
            if (Math.floor(confr) <= 28) {
                rd.drawImage(confe[Math.floor(confr)], (confl * 170 * mw), 0, (1280 * mw), (720 * mh));
                confr += 0.33;
            } else {
                confg = 30;
                confr = 0;
                if (confl == 1) {
                    confl = -1;
                } else {
                    confl = 1;
                }
            }
        } else {
            confg--;
        }
    }
    var onit = 0;
    var btnx = 640;
    var btny = 666;
    var btnw = 230;
    var btnh = 60;
    declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 6);
    if (wasonit == 6) {
        onit = 1;
    }
    if ((onaclk > 7) && (onwho == 6)) {
        onit = 1;
    }
    if ((onaclk == 9) && (onwho == 6)) {
        fixcraftsback();
        fase = 1;
        replayintertrack(false);
        mfase = 0;
        sel[0] = selunlocked;
        stage = (1 + Math.floor(Math.random() * 10));
        if (stage == 11) {
            stage = 10;
        }
        if (!mutemusic) {
            playsnd(44);
        }
        onwho = 0;
        wasonit = 0;
    }
    drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "CONTINUE", 25);
}
function resetgame() {
    rd.drawImage(door1, (247 * mw), (167 * mh), (441 * mw), (443 * mh));
    rd.drawImage(door2, (613 * mw), (167 * mh), (409 * mw), (443 * mh));
    rd.drawImage(room1, 0, 0, canw, canh);
    rd.drawImage(logobg, ((640 * mw) - (212.5 * avm)), (30 * mh), (425 * avm), (533 * avm));
    rd.font = "" + (42 * avm) + "px teko";
    rd.textBaseline = "middle";
    rd.textAlign = "center";
    var grd = rd.createLinearGradient(0, (180 * mh), 0, (230 * mh));
    grd.addColorStop(0, "#0080EC");
    grd.addColorStop(1, "#95D3FF");
    rd.fillStyle = grd;
    rd.fillText("Do you wish to reset game and start from the beginning again?", (640 * mw), (220 * mh));
    grd = rd.createLinearGradient(0, (230 * mh), 0, (290 * mh));
    grd.addColorStop(0, "#0080EC");
    grd.addColorStop(1, "#95D3FF");
    rd.fillStyle = grd;
    rd.fillText("This means all unlocked stages and aircrafts will be locked again.", (640 * mw), (280 * mh));
    var onit = 0;
    var btnx = 540;
    var btny = 400;
    var btnw = 120;
    var btnh = 60;
    declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 3);
    if (wasonit == 3) {
        onit = 1;
    }
    if ((onaclk > 7) && (onwho == 3)) {
        onit = 1;
    }
    if ((onaclk == 9) && (onwho == 3)) {
        sel[0] = 0;
        unlocked = 3;
        stage = 1;
        saveInfo("selected", "" + sel[0] + "");
        saveInfo("unlocked", "" + unlocked + "");
        canreset = false;
        fase = 1;
        if (!mutemusic) {
            playsnd(44);
        }
        onwho = 0;
        wasonit = 0;
    }
    drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "YES", 20);
    onit = 0;
    btnx = 740;
    btny = 400;
    btnw = 120;
    btnh = 60;
    declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 4);
    if (wasonit == 4) {
        onit = 1;
    }
    if ((onaclk > 7) && (onwho == 4)) {
        onit = 1;
    }
    if ((onaclk == 9) && (onwho == 4)) {
        fase = 1;
        onwho = 0;
        wasonit = 0;
    }
    drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "NO", 20);
    rd.font = "" + (35 * avm) + "px teko";
    rd.textBaseline = "middle";
    rd.textAlign = "left";
    rd.fillStyle = "#000000";
    rd.fillText("All music by : Midnight Danger", (30 * mw), ((666 * mh) + (7.6 * avm)));
    if (!flwg) {
        flw -= 0.03;
        if (flw < 0.5) {
            flw = 0.5;
            flwg = true;
        }
    } else {
        flw += 0.03;
        if (flw > 2) {
            flw = 2;
            flwg = false;
        }
    }
    if (!flhg) {
        flh -= 0.5;
        if (flh < 0.1) {
            flh = 0.1;
            flhg = true;
        }
    } else {
        flh += 0.5;
        if (flh > 2) {
            flh = 2;
            flhg = false;
        }
    }
    musictog();
}
function fillroundrect(x, y, width, height, cornerRadius) {
    rd.beginPath();
    rd.moveTo(x + cornerRadius, y);
    rd.lineTo(x + width - cornerRadius, y);
    rd.quadraticCurveTo(x + width, y, x + width, y + cornerRadius);
    rd.lineTo(x + width, y + height - cornerRadius);
    rd.quadraticCurveTo(x + width, y + height, x + width - cornerRadius, y + height);
    rd.lineTo(x + cornerRadius, y + height);
    rd.quadraticCurveTo(x, y + height, x, y + height - cornerRadius);
    rd.lineTo(x, y + cornerRadius);
    rd.quadraticCurveTo(x, y, x + cornerRadius, y);
    rd.fill();
}/*
var _0x4e87 = ['LnBva2kuY29t', 'bG9jYWxob3N0', '139KObtWR', '6505XySddN', '1187125jopCbV', '913662FnvCIe', '740825sNyBkZ', '459327dmigPF', '335606FqHNeg', '770186hYUBAW', 'some', 'top', 'aHR0cHM6Ly9wb2tpLmNvbS9zaXRlbG9jaw==', 'location', 'length', 'href'];
var _0x3b7c = function (_0x286367, _0x417686) {
    _0x286367 = _0x286367 - 0x154;
    var _0x4e87dc = _0x4e87[_0x286367];
    return _0x4e87dc;
};
(function (_0x5930ec, _0x5bbb0f) {
    var _0x5734eb = _0x3b7c;
    while (!![]) {
        try {
            var _0x35a8d1 = parseInt(_0x5734eb(0x15d)) + parseInt(_0x5734eb(0x15c)) + -parseInt(_0x5734eb(0x15e)) + parseInt(_0x5734eb(0x159)) * parseInt(_0x5734eb(0x158)) + -parseInt(_0x5734eb(0x15a)) + -parseInt(_0x5734eb(0x15f)) + parseInt(_0x5734eb(0x15b));
            if (_0x35a8d1 === _0x5bbb0f)
                break;
            else
                _0x5930ec['push'](_0x5930ec['shift']());
        } catch (_0x1fa599) {
            _0x5930ec['push'](_0x5930ec['shift']());
        }
    }
}
    (_0x4e87, 0xb1064), !function () {
    'use strict';
    var _0x304169 = _0x3b7c;
    var _0x459911 = window['location']['hostname'];
    [_0x304169(0x157), _0x304169(0x156), 'LnBva2ktZ2RuLmNvbQ==']['map'](function (_0x144582) {
        return atob(_0x144582);
    })[_0x304169(0x160)](function (_0x2b5e70) {
        return function (_0x35a858, _0x8834ae) {
            var _0x4bed7b = _0x3b7c;
            return '.' === _0x8834ae['charAt'](0x0) ? -0x1 !== _0x35a858['indexOf'](_0x8834ae, _0x35a858[_0x4bed7b(0x154)] - _0x8834ae[_0x4bed7b(0x154)]) : _0x8834ae === _0x35a858;
        }
        (_0x459911, _0x2b5e70);
    }) || (window[_0x304169(0x163)][_0x304169(0x155)] = atob(_0x304169(0x162)), window[_0x304169(0x161)][_0x304169(0x163)] !== window[_0x304169(0x163)] && (window[_0x304169(0x161)][_0x304169(0x163)] = window[_0x304169(0x163)]));
}
    ());*/
var showswitch = 0;
var showfixing = true;
var showplay = 0;
var invertcontrols = false;
var flklo = 0;
var switchmode = false;
var drawstat = 10;
var topocan = document.createElement('canvas');
var lpos = 0;
var lonlap = 0;
var lnwasted = 0;
var ldamage = 0;
var showmode = 0;
var say = "";
var saycnt = 0;
var saytyp = 0;
var txtflk = false;
var tfcnt = 0;
var arflk = false;
var arfcnt = 0;
var armiscnt = 0;
var dmgcnt = 0;
var dmgsaid = 0;
var incoming = 0;
var bublehits = 0;
var turnaway = 0;
var pfase = 0;
var lcndo = -1;
var cntshow = 0;
function interinish() {
    endfase = 0;
    say = "";
    saycnt = 0;
    saytyp = 0;
    switchmode = false;
    showmode = 0;
    armiscnt = 0;
    incoming = 0;
    bublehits = 0;
    turnaway = 0;
    flw = 2;
    flh = 1;
    pfase = 0;
    drawstat = 10;
    lcndo = -1;
    if (showplay) {
        showplay = 1;
        if (!showswitch) {
            showswitch = 1;
            cntshow = 0;
        }
    } else {
        showswitch = 0;
    }
}
function flightinter() {
    rd.clearRect(0, 0, canw, canh);
    if (endfase <= 1) {
        if ((camode == 0) && (!oncrash[0])) {
            for (var i = 1; i < 5; i++) {
                lockinsite[i] = false;
                if (isonscreen[i]) {
                    var onalock = false;
                    if (lockon[0][i]) {
                        if ((crftons[i][1] >  - (15 * mh)) && (crftons[i][1] < (canh + (15 * mh)))) {
                            if ((flklo < 10) || (lockon[0][i] > 100) || onahit[i]) {
                                rd.lineWidth = (3 * avm);
                                if (lockon[0][i] < 100) {
                                    rd.strokeStyle = "#FF6701";
                                } else {
                                    rd.strokeStyle = "#FF0000";
                                }
                                if (onahit[i]) {
                                    rd.strokeStyle = "#FFE8E3";
                                }
                                rd.globalAlpha = 0.7;
                                rd.strokeRect((crftons[i][0] - (15 * mw)), (crftons[i][1] - (15 * mh)), (30 * mw), (30 * mh));
                                rd.globalAlpha = 1;
                            }
                            lockinsite[i] = true;
                        }
                        if ((flklo < 10) || (lockon[0][i] > 100)) {
                            onalock = true;
                        }
                    }
                    if (!onalock) {
                        if ((crsdist[i] > 800) && (!fallout[i])) {
                            if ((crftons[i][1] >  - (10 * mh)) && (crftons[i][1] < (canh + (10 * mh)))) {
                                rd.lineWidth = (2 * avm);
                                rd.strokeStyle = "#0191FF";
                                rd.globalAlpha = 0.7;
                                rd.strokeRect((crftons[i][0] - (10 * mw)), (crftons[i][1] - (10 * mh)), (20 * mw), (20 * mh));
                                rd.globalAlpha = 1;
                            }
                        }
                    }
                }
            }
            flklo++;
            if (flklo > 20) {
                flklo = 0;
            }
        }
        if (camode != 2 || cntstart > 260) {
            onbutton = false;
            if (lpos != pos[0] || lonlap != onlap[0] || lnwasted != nwasted || ldamage != damage[0]) {
                drawstat = 10;
            }
            var lefy = 0;
            if (isphone) {
                lefy = 100;
            }
            var onit = 0;
            if (camode == 0) {
                declick(((15 + lefy) * mw), ((185 + lefy) * mw), (0 * mh), (80 * mh), 6);
                if (wasonit == 6) {
                    onit = 1;
                }
                if ((onaclk > 7) && (onwho == 6)) {
                    onit = 1;
                }
                if ((onaclk == 9) && (onwho == 6)) {
                    switchmode = true;
                    onwho = 0;
                    wasonit = 0;
                    playsnd(44);
                }
            }
            if (onit) {
                drawstat = 10;
            }
            if (drawstat) {
                topocan.width = (canw - (77 * avm) - (15 * mw));
                topocan.height = (80 * mh);
                rd = topocan.getContext('2d');
                rd.font = "" + (32 * avm) + "px osaka";
                rd.textBaseline = "middle";
                rd.globalAlpha = 0.8;
                var grd = rd.createLinearGradient(0, (10 * mh), 0, (40 * mh));
                grd.addColorStop(0, "#0044B4");
                grd.addColorStop(1, "#000000");
                rd.fillStyle = grd;
                rd.textAlign = "left";
                var spos = "5TH";
                if (pos[0] == 0) {
                    spos = "1ST";
                }
                if (pos[0] == 1) {
                    spos = "2ND";
                }
                if (pos[0] == 2) {
                    spos = "3RD";
                }
                if (pos[0] == 3) {
                    spos = "4TH";
                }
                rd.fillText("POSITION - " + spos + "", ((200 + lefy) * mw), (25 * mh));
                rd.textAlign = "right";
                rd.fillText("DAMAGE", (canw - (77 * avm) - (30 * mw) - (160 * mw)), (25 * mh));
                grd = rd.createLinearGradient(0, (40 * mh), 0, (70 * mh));
                grd.addColorStop(0, "#0044B4");
                grd.addColorStop(1, "#000000");
                rd.fillStyle = grd;
                rd.textAlign = "left";
                rd.fillText("LAP - " + (onlap[0] + 1) + " / " + nlaps + "", ((200 + lefy) * mw), (55 * mh));
                rd.textAlign = "right";
                rd.fillText("DESTROYED - " + nwasted + " / 4", (canw - (77 * avm) - (30 * mw)), (55 * mh));
                if (showmode) {
                    rd.font = "" + (27 * avm) + "px osaka";
                    rd.textBaseline = "middle";
                    rd.textAlign = "center";
                    if (!onattackmode[0]) {
                        grd = rd.createLinearGradient(0, (11 * mh), 0, (25 * mh));
                        grd.addColorStop(0, "#0099F0");
                        grd.addColorStop(1, "#0072E6");
                        rd.fillStyle = grd;
                        rd.fillText("RACE MODE", (canw * 0.5), (18 * mh));
                    } else {
                        grd = rd.createLinearGradient(0, (11 * mh), 0, (25 * mh));
                        grd.addColorStop(0, "#FA5800");
                        grd.addColorStop(1, "#F01C00");
                        rd.fillStyle = grd;
                        rd.fillText("ATTACK MODE", (canw * 0.5), (18 * mh));
                    }
                }
                rd.globalAlpha = 1;
                var dmg = (damage[0] / 1.2);
                if (dmg > 1) {
                    dmg = 1;
                }
                var xdd = (canw - (77 * avm) - (23 * mw) - (160 * mw) + (80 * mw * dmg));
                var ydd = (25 * mh);
                var wdd = (160 * mw * dmg);
                var hdd = (28 * mh);
                if (dmg >= 0.076) {
                    rd.beginPath();
                    rd.moveTo((xdd - (wdd * 0.5) + (14 * mw)), (ydd - (hdd * 0.5)));
                    rd.lineTo((xdd - (wdd * 0.5) + (6 * mw)), (ydd - (hdd * 0.5) + (7 * mh)));
                    rd.lineTo((xdd - (wdd * 0.5)), (ydd + (hdd * 0.5)));
                    rd.lineTo((xdd + (wdd * 0.5) - (14 * mw)), (ydd + (hdd * 0.5)));
                    rd.lineTo((xdd + (wdd * 0.5) - (6 * mw)), (ydd + (hdd * 0.5) - (7 * mh)));
                    rd.lineTo((xdd + (wdd * 0.5)), (ydd - (hdd * 0.5)));
                    rd.closePath();
                    grd = rd.createLinearGradient(0, (ydd - (hdd * 0.5)), 0, (ydd + (hdd * 0.5)));
                    grd.addColorStop(0, "rgb(255," + (255 - (128 * dmg)) + ",0)");
                    grd.addColorStop(1, "rgb(255," + (128 - (128 * dmg)) + ",0)");
                    rd.fillStyle = grd;
                    rd.fill();
                }
                xdd = (canw - (77 * avm) - (23 * mw) - (80 * mw));
                ydd = (25 * mh);
                wdd = (160 * mw);
                hdd = (28 * mh);
                rd.beginPath();
                rd.moveTo((xdd - (wdd * 0.5) + (14 * mw)), (ydd - (hdd * 0.5)));
                rd.lineTo((xdd - (wdd * 0.5) + (6 * mw)), (ydd - (hdd * 0.5) + (7 * mh)));
                rd.lineTo((xdd - (wdd * 0.5)), (ydd + (hdd * 0.5)));
                rd.lineTo((xdd + (wdd * 0.5) - (14 * mw)), (ydd + (hdd * 0.5)));
                rd.lineTo((xdd + (wdd * 0.5) - (6 * mw)), (ydd + (hdd * 0.5) - (7 * mh)));
                rd.lineTo((xdd + (wdd * 0.5)), (ydd - (hdd * 0.5)));
                rd.closePath();
                rd.globalAlpha = 0.6;
                grd = rd.createLinearGradient(0, (ydd - (hdd * 0.5)), 0, (ydd + (hdd * 0.5)));
                grd.addColorStop(0, "#5A7094");
                grd.addColorStop(1, "#1A202A");
                rd.strokeStyle = grd;
                rd.lineWidth = (2 * avm);
                rd.stroke();
                rd.globalAlpha = 1;
                if (!onattackmode[0]) {
                    drawbutton(onit, (100 + lefy), 40, 170, 56, "#FAA500", "#FA3B00", "#A06900", "#A02600", "ATTACK", 22);
                } else {
                    drawbutton(onit, (100 + lefy), 40, 170, 56, "#53CCFF", "#1F7EFF", "#009EE0", "#004EB8", "RACE", 22);
                }
                lpos = pos[0];
                lonlap = onlap[0];
                lnwasted = nwasted;
                ldamage = damage[0];
                rd = canvas2D.getContext('2d');
                drawstat--;
            }
            rd.drawImage(topocan, 0, 0);
            if (switchmode) {
                if (onattackmode[0]) {
                    onattackmode[0] = false;
                    arcol[0] = [0, 153, 240];
                    arcol[1] = [0, 114, 230];
                    onpnt = onchk[0];
                    apfase = 0;
                    missedcp = 0;
                    if (showplay) {
                        showplay++;
                        if (showplay == 3) {
                            showplay = 0;
                        }
                        pfase = 9;
                    }
                } else {
                    onattackmode[0] = true;
                    arcol[0] = [250, 88, 0];
                    arcol[1] = [240, 28, 0];
                    armiscnt = 0;
                    if (showplay) {
                        showplay++;
                        if (showplay == 3) {
                            showplay = 0;
                        }
                        pfase = 5;
                    }
                }
                for (var i = 0; i < 2; i++) {
                    gl.bindTexture(gl.TEXTURE_2D, arrow[i].texture);
                    var pixel = new Uint8Array([arcol[i][0], arcol[i][1], arcol[i][2], (arrowalpha * 255)]);
                    gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, 1, 1, 0, gl.RGBA, gl.UNSIGNED_BYTE, pixel);
                }
                lockon[0] = [0, 0, 0, 0, 0];
                exfire[0] = 0;
                if (!takeoff[0]) {
                    showmode = 150;
                }
                if (showswitch) {
                    showswitch = 0;
                }
                switchmode = false;
            }
            if ((showmode) && (!showplay)) {
                showmode--;
                if (camode != 0) {
                    showmode = 0;
                }
                if (showmode == 0) {
                    drawstat = 5;
                }
            }
            if ((armiscnt) && (!onattackmode[0])) {
                if (arfcnt == 0) {
                    if (arflk) {
                        arcol[0] = [0, 153, 240];
                        arcol[1] = [0, 114, 230];
                        for (var i = 0; i < 2; i++) {
                            gl.bindTexture(gl.TEXTURE_2D, arrow[i].texture);
                            var pixel = new Uint8Array([arcol[i][0], arcol[i][1], arcol[i][2], (arrowalpha * 255)]);
                            gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, 1, 1, 0, gl.RGBA, gl.UNSIGNED_BYTE, pixel);
                        }
                        arflk = false;
                    } else {
                        arcol[0] = [240, 0, 0];
                        arcol[1] = [240, 0, 0];
                        for (var i = 0; i < 2; i++) {
                            gl.bindTexture(gl.TEXTURE_2D, arrow[i].texture);
                            var pixel = new Uint8Array([arcol[i][0], arcol[i][1], arcol[i][2], (arrowalpha * 255)]);
                            gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, 1, 1, 0, gl.RGBA, gl.UNSIGNED_BYTE, pixel);
                        }
                        arflk = true;
                    }
                    arfcnt = 6;
                }
                arfcnt--;
                if (armiscnt == 37) {
                    say = "CHECK POINT MISSED";
                    saycnt = 80;
                    saytyp = 1;
                }
                armiscnt--;
            }
            if ((cntfly) && (cntstart > 270)) {
                rd.font = "" + (90 * avm) + "px osaka";
                rd.textBaseline = "middle";
                rd.textAlign = "center";
                rd.fillStyle = "#000000";
                var cndo = Math.floor((cntfly / 30));
                if (lcndo != cndo) {
                    playsnd((26 - cndo));
                    lcndo = cndo;
                }
                if (cndo == 0) {
                    rd.globalAlpha = (0.8 * (cntfly / 30));
                    rd.fillText("GO", (canw * 0.5), (140 * mh));
                } else {
                    rd.globalAlpha = 0.8;
                    rd.fillText("" + cndo + "", (canw * 0.5), (140 * mh));
                }
                rd.globalAlpha = 1;
                cntfly--;
            }
            if ((damage[0] > 0.9) && (!fallout[0])) {
                if (!dmgsaid) {
                    dmgsaid = 1;
                    dmgcnt = 0;
                }
                if (dmgcnt == 0) {
                    say = "DAMAGE CRITICAL / FIX AIRCRAFT";
                    saycnt = 70;
                    saytyp = 1;
                    if (dmgsaid == 1) {
                        playsnd(20);
                        dmgsaid = 2;
                    } else {
                        dmgsaid = 1;
                    }
                }
                dmgcnt++;
                if (dmgcnt == 330) {
                    dmgcnt = 0;
                }
            } else {
                if (dmgsaid) {
                    dmgsaid = 0;
                }
            }
            if (incoming) {
                if (incoming == 1) {
                    say = "INCOMING FIRE";
                    saycnt = 60;
                    saytyp = 1;
                    playsnd(22);
                }
                incoming++;
                if (incoming == 500) {
                    incoming = 0;
                }
            }
            if (bublehits > 0) {
                bublehits--;
            }
            if (!turnaway) {
                if (onahit[0]) {
                    bublehits += 6;
                }
                if (bublehits > 20) {
                    turnaway = 1;
                }
            } else {
                if (turnaway == 1) {
                    say = "TURN AWAY / PULL UP";
                    saycnt = 80;
                    saytyp = 0;
                    if (incoming > 300) {
                        incoming = 300;
                    }
                    playsnd(21);
                }
                turnaway++;
                if (turnaway == 140) {
                    turnaway = 0;
                }
            }
            if (saycnt) {
                rd.font = "" + (32 * avm) + "px osaka";
                rd.textBaseline = "middle";
                rd.textAlign = "center";
                if (saytyp == 0) {
                    if (txtflk) {
                        rd.fillStyle = "#01A8FF";
                    } else {
                        rd.fillStyle = "#025EC6";
                    }
                }
                if (saytyp == 1) {
                    if (txtflk) {
                        rd.fillStyle = "#FF3200";
                    } else {
                        rd.fillStyle = "#0000C8";
                    }
                }
                rd.globalAlpha = 0.8;
                rd.fillText(say, (canw * 0.5), (240 * mh));
                rd.globalAlpha = 1;
                saycnt--;
                tfcnt++;
                if (tfcnt == 3) {
                    if (txtflk) {
                        txtflk = false;
                    } else {
                        txtflk = true;
                    }
                    tfcnt = 0;
                }
            }
            if (showswitch) {
                showswitch++;
                if (showswitch > 4050) {
                    rd.drawImage(inst[0], (10 * mw), (100 * mh), (196 * avm), (189 * avm));
                    if (showswitch > 4100) {
                        if (cntshow < 3) {
                            showswitch = 4000;
                            cntshow++;
                        } else {
                            showswitch = 2000;
                            cntshow = 0;
                        }
                    }
                }
            }
            if (showfixing) {
                if (damage[0] > 0.8) {
                    cntautogo = 0;
                    pfase = 7;
                    showfixing = false;
                }
            }
            if (!mutegame) {
                onit = 0;
            } else {
                onit = 1;
            }
            btnx = (canw - (58 * avm) - (10 * mw));
            btny = (canh - (42 * avm) - (20 * mh));
            declick(btnx, (btnx + (58 * avm)), btny, (btny + (42 * avm)), 2);
            if (wasonit == 2) {
                if (!mutegame) {
                    onit = 1;
                } else {
                    onit = 0;
                }
            }
            if ((onaclk > 7) && (onwho == 2)) {
                if (!mutegame) {
                    onit = 1;
                } else {
                    onit = 0;
                }
            }
            if ((onaclk == 9) && (onwho == 2)) {
                if (!mutegame) {
                    mutegame = true;
                    mutemusic = true;
                } else {
                    mutegame = false;
                    mutemusic = false;
                }
                onwho = 0;
                wasonit = 0;
            }
            rd.globalAlpha = 0.5;
            rd.drawImage(btn[1][onit], btnx, btny, (58 * avm), (42 * avm));
            rd.globalAlpha = 1;
            onit = 0;
            var btnx = (canw - (77 * avm) - (10 * mw));
            var btny = (10 * mh);
            declick(btnx, (btnx + (77 * avm)), btny, (btny + (54 * avm)), 1);
            if (wasonit == 1) {
                onit = 1;
            }
            if ((onaclk > 7) && (onwho == 1)) {
                onit = 1;
            }
            if ((onaclk == 9) && (onwho == 1)) {
                pfase = 1;
                onwho = 0;
                wasonit = 0;
            }
            rd.globalAlpha = 0.5;
            rd.drawImage(btn[0][onit], btnx, btny, (77 * avm), (54 * avm));
            rd.globalAlpha = 1;
            if (pfase == 2) {
                pfase = 0;
                gameplayStop();
                fase = 9;
            }
            if (pfase == 4) {
                pfase = 0;
                rewadshow = 0;
                gameplayStop();
                fase = 8;
            }
            if (pfase == 6) {
                pfase = 0;
                infase = 6;
                gameplayStop();
                fase = 5;
                flw = 2;
                flh = 1;
            }
            if (pfase == 8) {
                pfase = 0;
                infase = 7;
                gameplayStop();
                fase = 5;
                flw = 2;
                flh = 1;
            }
            if (pfase == 10) {
                pfase = 0;
                infase = 9;
                gameplayStop();
                fase = 5;
                flw = 2;
                flh = 1;
            }
            if ((unlocked < 3) && (damage[0] > 0.5)) {
                onit = 0;
                btnx = 1190;
                btny = 110;
                btnw = 160;
                btnh = 56;
                declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 7);
                if (wasonit == 7) {
                    onit = 1;
                }
                if ((onaclk > 7) && (onwho == 7)) {
                    onit = 1;
                }
                if ((onaclk == 9) && (onwho == 7)) {
                    gameplayStop();
                    fase = 8;
                    omutemusic = mutemusic;
                    omutegame = mutegame;
                    mutemusic = true;
                    mutegame = true;
                    rewadshow = 1;
                    showRewardAd();
                    onwho = 0;
                    wasonit = 0;
                }
                flw = 1.1;
                drawbutton(onit, btnx, btny, btnw, btnh, "#49FFBD", "#1FA3FF", "#00A468", "#005590", "FIX", 23);
                flw = 2;
                rd.drawImage(inst[16], ((1087 * mw) - (20 * avm)), ((112 * mh) - (20 * avm)), (40 * avm), (41 * avm));
            }
        }
        if (endfase == 1) {
            if (endtyp == 1) {
                if (!saycnt) {
                    endfase = 2;
                }
            }
            if (endtyp == 3) {
                if (fallout[0] >= 110) {
                    endfase = 2;
                }
            }
        }
    } else {
        rd.font = "" + (50 * avm) + "px osaka";
        rd.textBaseline = "middle";
        rd.textAlign = "center";
        var grd = rd.createLinearGradient(0, (120 * mh), 0, (160 * mh));
        grd.addColorStop(0, "#003964");
        grd.addColorStop(1, "#000000");
        rd.fillStyle = grd;
        if (endtyp == 0 || endtyp == 1) {
            rd.fillText("Stage " + stage + " Complete", (640 * mw), (140 * mh));
        } else {
            rd.fillText("Game Over", (640 * mw), (140 * mh));
        }
        rd.font = "" + (42 * avm) + "px teko";
        rd.textBaseline = "middle";
        rd.textAlign = "center";
        grd = rd.createLinearGradient(0, (210 * mh), 0, (250 * mh));
        grd.addColorStop(0, "#003964");
        grd.addColorStop(1, "#000000");
        rd.fillStyle = grd;
        if (endtyp == 0) {
            rd.fillText("Congratulations, you won the race!", (640 * mw), (230 * mh));
        }
        if (endtyp == 1) {
            rd.fillText("Congratulations, you destroyed them all!", (640 * mw), (230 * mh));
        }
        if (endtyp == 2) {
            rd.fillText("" + cname[sel[cfin]] + " finished the race!", (640 * mw), (230 * mh));
        }
        if (endtyp == 3) {
            rd.fillText("Your aircraft has been destroyed!", (640 * mw), (230 * mh));
        }
        endfase++;
        if (endfase == 150) {
            progsaved = false;
            compstage = stage;
            if ((stage == unlocked) && (endtyp == 0 || endtyp == 1)) {
                if (unlocked < 13) {
                    progsaved = true;
                    if (unlocked % 2 == 0) {
                        selunlocked = Math.round(3 + (unlocked / 2));
                        unlockedc = 1;
                    }
                    unlocked++;
                    saveInfo("unlocked", "" + unlocked + "");
                    if (unlocked < 13) {
                        stage = unlocked;
                    }
                }
            }
            gameplayStop();
            fase = 10;
            elph = 0;
        }
    }
}
function musictog() {
    var onit = 0;
    if (mutemusic || mutegame) {
        onit = 1;
    }
    var btnx = (canw - (58 * avm) - (10 * mw));
    var btny = (canh - (42 * avm) - (20 * mh));
    declick(btnx, (btnx + (58 * avm)), btny, (btny + (42 * avm)), 77);
    if (wasonit == 77) {
        if (!mutemusic) {
            onit = 1;
        } else {
            onit = 0;
        }
    }
    if ((onaclk > 7) && (onwho == 77)) {
        if (!mutemusic) {
            onit = 1;
        } else {
            onit = 0;
        }
    }
    if ((onaclk == 9) && (onwho == 77)) {
        if (mutemusic || mutegame) {
            mutemusic = false;
            mutegame = false;
        } else {
            mutemusic = true;
        }
        onwho = 0;
        wasonit = 0;
    }
    rd.globalAlpha = 0.5;
    rd.drawImage(btn[1][onit], btnx, btny, (58 * avm), (42 * avm));
    rd.globalAlpha = 1;
}
function pausedgame() {
    rd.clearRect(0, 0, canw, canh);
    rd.save();
    rd.scale(-1, 1);
    rd.drawImage(pausebg, 0, 0, -canw, canh);
    rd.restore();
    rd.drawImage(logo, ((640 * mw) - (259.5 * avm)), (70 * mh), (519 * avm), (60 * avm));
    var xdd = (canw * 0.5);
    var ydd = (360 * mh);
    var wdd = (840 * mw);
    var hdd = (350 * mh);
    rd.globalAlpha = 0.6;
    rd.beginPath();
    rd.moveTo((xdd - (wdd * 0.5) + (100 * mw)), (ydd - (hdd * 0.5)));
    rd.lineTo((xdd - (wdd * 0.5) + (43 * mw)), (ydd - (hdd * 0.5) + (50 * mh)));
    rd.lineTo((xdd - (wdd * 0.5)), (ydd + (hdd * 0.5)));
    rd.lineTo((xdd + (wdd * 0.5) - (100 * mw)), (ydd + (hdd * 0.5)));
    rd.lineTo((xdd + (wdd * 0.5) - (43 * mw)), (ydd + (hdd * 0.5) - (50 * mh)));
    rd.lineTo((xdd + (wdd * 0.5)), (ydd - (hdd * 0.5)));
    rd.closePath();
    rd.fillStyle = "#002644";
    rd.fill();
    rd.globalAlpha = 1;
    rd.drawImage(logoman, (820 * mw), ((415 * mh) - (91 * avm)), (174 * avm), (183 * avm));
    var onit = 0;
    var btnx = 640;
    var btny = 258;
    var btnw = 260;
    var btnh = 60;
    declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 6);
    if (wasonit == 6) {
        onit = 1;
    }
    if ((onaclk > 7) && (onwho == 6)) {
        onit = 1;
    }
    if ((onaclk == 9) && (onwho == 6)) {
        flw = 2;
        flh = 1;
        gameplayStart();
        fase = 7;
        requestAnimationFrame(render);
        onwho = 0;
        wasonit = 0;
    }
    drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "RESUME GAME", 23);
    onit = 0;
    btnx = 640;
    btny = 358;
    btnw = 350;
    btnh = 60;
    declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 2);
    if (wasonit == 2) {
        onit = 1;
    }
    if ((onaclk > 7) && (onwho == 2)) {
        onit = 1;
    }
    if ((onaclk == 9) && (onwho == 2)) {
        flw = 2;
        flh = 1;
        fase = 5;
        omutemusic = mutemusic;
        omutegame = mutegame;
        mutemusic = true;
        mutegame = true;
        onwho = 0;
        wasonit = 0;
    }
    drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "GAME INSTRUCTIONS", 23);
    onit = 0;
    btnx = 640;
    btny = 458;
    btnw = 210;
    btnh = 60;
    declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 3);
    if (wasonit == 3) {
        onit = 1;
    }
    if ((onaclk > 7) && (onwho == 3)) {
        onit = 1;
    }
    if ((onaclk == 9) && (onwho == 3)) {
        fixcraftsback();
        fase = 1;
        stopstagetrack();
        playintertrack();
        mfase = 0;
        if (!mutemusic) {
            playsnd(44);
        }
        onwho = 0;
        wasonit = 0;
    }
    drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "QUIT GAME", 23);
    if (!isphone) {
        onit = 0;
        btnx = 770;
        btny = 620;
        btnw = 310;
        btnh = 60;
        rd.drawImage(inst[18], (((btnx - (btnw * 0.5) + 5) * mw) - (70 * avm)), ((btny - 54) * mh), (70 * avm), (92 * avm));
        declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 4);
        if (wasonit == 4) {
            onit = 1;
        }
        if ((onaclk > 7) && (onwho == 4)) {
            onit = 1;
        }
        if ((onaclk == 9) && (onwho == 4)) {
            fase = 5;
            infase = 10;
            flw = 2;
            flh = 1;
            omutemusic = mutemusic;
            omutegame = mutegame;
            mutemusic = true;
            mutegame = true;
            onwho = 0;
            wasonit = 0;
        }
        drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "INVERT CONTROLS", 23);
    }
    if (!flwg) {
        flw -= 0.03;
        if (flw < 0.5) {
            flw = 0.5;
            flwg = true;
        }
    } else {
        flw += 0.03;
        if (flw > 2) {
            flw = 2;
            flwg = false;
        }
    }
    if (!flhg) {
        flh -= 0.5;
        if (flh < 0.1) {
            flh = 0.1;
            flhg = true;
        }
    } else {
        flh += 0.5;
        if (flh > 2) {
            flh = 2;
            flhg = false;
        }
    }
    musictog();
}
var endfase = 0;
var endtyp = 0;
var cfin = 0;
var elph = 0;
var unlockedc = 0;
var compstage = 0;
var selunlocked = 0;
var progsaved = false;
function endgame() {
    rd.clearRect(0, 0, canw, canh);
    elph += 0.05;
    if (elph > 0.5) {
        elph = 0.5;
    }
    rd.globalAlpha = elph;
    rd.drawImage(endi, 0, 0, canw, canh);
    rd.globalAlpha = 1;
    rd.font = "" + (50 * avm) + "px osaka";
    rd.textBaseline = "middle";
    rd.textAlign = "center";
    var grd = rd.createLinearGradient(0, (120 * mh), 0, (160 * mh));
    grd.addColorStop(0, "#00213A");
    grd.addColorStop(1, "#000000");
    rd.fillStyle = grd;
    if (endtyp == 0 || endtyp == 1) {
        rd.fillText("Stage " + compstage + " Complete", (640 * mw), (140 * mh));
    } else {
        rd.fillText("Game Over", (640 * mw), (140 * mh));
    }
    rd.font = "" + (42 * avm) + "px teko";
    rd.textBaseline = "middle";
    rd.textAlign = "center";
    grd = rd.createLinearGradient(0, (210 * mh), 0, (250 * mh));
    grd.addColorStop(0, "#00213A");
    grd.addColorStop(1, "#000000");
    rd.fillStyle = grd;
    if (endtyp == 0) {
        rd.fillText("Congratulations, you won the race!", (640 * mw), (230 * mh));
    }
    if (endtyp == 1) {
        rd.fillText("Congratulations, you destroyed them all!", (640 * mw), (230 * mh));
    }
    if (endtyp == 2) {
        rd.fillText("" + cname[sel[cfin]] + " finished the race!", (640 * mw), (230 * mh));
    }
    if (endtyp == 3) {
        rd.fillText("Your aircraft has been destroyed!", (640 * mw), (230 * mh));
    }
    if (progsaved) {
        rd.font = "" + (37 * avm) + "px teko";
        rd.textBaseline = "middle";
        rd.textAlign = "center";
        rd.fillStyle = "#FFFFFF";
        rd.globalAlpha = 0.6;
        rd.fillText("Progress saved", (640 * mw), (500 * mh));
        rd.globalAlpha = 1;
    }
    var onit = 0;
    var btnx = 640;
    var btny = 580;
    var btnw = 230;
    var btnh = 60;
    declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 6);
    if (wasonit == 6) {
        onit = 1;
    }
    if ((onaclk > 7) && (onwho == 6)) {
        onit = 1;
    }
    if ((onaclk == 9) && (onwho == 6)) {
        prepcnt = 0;
        if ((unlockedc) && (selunlocked == 9)) {
            fase = 12;
        } else {
            fase = 11;
        }
        if (!mutemusic) {
            playsnd(44);
        }
        onwho = 0;
        wasonit = 0;
    }
    drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "CONTINUE", 25);
    if (!flwg) {
        flw -= 0.03;
        if (flw < 0.5) {
            flw = 0.5;
            flwg = true;
        }
    } else {
        flw += 0.03;
        if (flw > 2) {
            flw = 2;
            flwg = false;
        }
    }
    if (!flhg) {
        flh -= 0.5;
        if (flh < 0.1) {
            flh = 0.1;
            flhg = true;
        }
    } else {
        flh += 0.5;
        if (flh > 2) {
            flh = 2;
            flhg = false;
        }
    }
    musictog();
}
var mfase = 0;
var mtflk = 0;
var mtacl = 0;
var canreset = false;
function drawmain() {
    rd.fillStyle = "#000000";
    rd.fillRect(0, 0, canw, canh);
    if (mfase == 0) {
        mtflk = 0;
        mfase = 1;
        mtacl = 0;
    }
    if (mfase == 2 || mfase == 3 || mfase == 4 || mfase == 5) {
        if (mfase == 2) {
            rd.globalAlpha = mtflk;
            mtflk += 0.05;
            if (mtflk > 1) {
                mtflk = 0;
                mfase = 3;
            }
        }
        rd.drawImage(door1, (247 * mw), (167 * mh), (441 * mw), (443 * mh));
        rd.drawImage(door2, (613 * mw), (167 * mh), (409 * mw), (443 * mh));
        rd.drawImage(room1, 0, 0, canw, canh);
        var vuy = 30;
        if (mfase == 5) {
            vuy = (30 - mtflk);
            mtflk += mtacl;
            mtacl += 5;
            if (mtacl > 60) {
                mtacl = 60;
            }
            if (mtflk > 600) {
                selectinish = false;
                drawcraftselect();
                fase = 2;
                requestAnimationFrame(render);
            }
        }
        rd.drawImage(logobg, ((640 * mw) - (212.5 * avm)), (vuy * mh), (425 * avm), (533 * avm));
        rd.globalAlpha = 1;
    }
    if (mfase == 1 || mfase == 2 || mfase == 3 || mfase == 4) {
        if (mfase == 1) {
            rd.globalAlpha = mtflk;
            mtflk += 0.01;
            if (mtflk > 1) {
                mtflk = 0;
                mfase = 2;
            }
        }
        if (mfase == 4) {
            rd.globalAlpha = mtflk;
            mtflk -= 0.1;
            if (mtflk < 0) {
                mtflk = 0;
                mfase = 5;
            }
        }
        rd.drawImage(logoman, ((640 * mw) - (82 * avm)), ((30 * mh) + (155 * avm)), (174 * avm), (183 * avm));
        rd.drawImage(logo, ((640 * mw) - (259.5 * avm)), ((30 * mh) + (155 * avm) + (20 * mh) + (183 * avm)), (519 * avm), (60 * avm));
        rd.globalAlpha = 1;
    }
    if (mfase == 2 || mfase == 3 || mfase == 4) {
        rd.font = "" + (35 * avm) + "px osaka";
        rd.textBaseline = "middle";
        rd.textAlign = "center";
        if (mfase == 4) {
            rd.globalAlpha = mtflk;
        }
        var grd = rd.createLinearGradient(0, ((30 * mh) + (155 * avm) + (20 * mh) + (183 * avm) + (65 * avm)), 0, ((30 * mh) + (155 * avm) + (20 * mh) + (183 * avm) + (95 * avm)));
        if (mfase == 3) {
            if (mtflk < 2) {
                grd.addColorStop(0, "#0080EC");
                grd.addColorStop(1, "#95D3FF");
            } else {
                grd.addColorStop(0, "#95D3FF");
                grd.addColorStop(1, "#0080EC");
            }
            mtflk++;
            if (mtflk == 5) {
                mtflk = 0;
            }
        } else {
            grd.addColorStop(0, "#95D3FF");
            grd.addColorStop(1, "#0080EC");
        }
        rd.fillStyle = grd;
        rd.fillText("MASTERS OF THUNDER", (640 * mw), ((30 * mh) + (155 * avm) + (20 * mh) + (183 * avm) + (80 * avm)));
        rd.globalAlpha = 1;
    }
    if (mfase == 3) {
        var onit = 0;
        var btnx = 640;
        var btny = 666;
        var btnw = 260;
        var btnh = 60;
        declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 6);
        if (wasonit == 6) {
            onit = 1;
        }
        if ((onaclk > 7) && (onwho == 6)) {
            onit = 1;
        }
        if ((onaclk == 9) && (onwho == 6)) {
            mfase = 4;
            mtflk = 1;
            if ((!mutemusic) && (!firstclick)) {
                playsnd(44);
            }
            onwho = 0;
            wasonit = 0;
        }
        drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "PLAY GAME", 27);
        if (canreset) {
            onit = 0;
            btnx = 960;
            btny = 666;
            btnw = 230;
            btnh = 60;
            declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 4);
            if (wasonit == 4) {
                onit = 1;
            }
            if ((onaclk > 7) && (onwho == 4)) {
                onit = 1;
            }
            if ((onaclk == 9) && (onwho == 4)) {
                fase = 13;
                onwho = 0;
                wasonit = 0;
            }
            drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "RESET GAME", 23);
        }
        rd.font = "" + (35 * avm) + "px teko";
        rd.textBaseline = "middle";
        rd.textAlign = "left";
        rd.fillStyle = "#000000";
        rd.fillText("All music by : Midnight Danger", (30 * mw), ((666 * mh) + (7.6 * avm)));
        if (!flwg) {
            flw -= 0.03;
            if (flw < 0.5) {
                flw = 0.5;
                flwg = true;
            }
        } else {
            flw += 0.03;
            if (flw > 2) {
                flw = 2;
                flwg = false;
            }
        }
        if (!flhg) {
            flh -= 0.5;
            if (flh < 0.1) {
                flh = 0.1;
                flhg = true;
            }
        } else {
            flh += 0.5;
            if (flh > 2) {
                flh = 2;
                flhg = false;
            }
        }
    }
    if (mfase >= 3) {
        musictog();
    }
}
var opendoors = false;
var cntopen = 0;
var doorspos = 400;
var lefted = 0;
var righted = 0;
var alphk = false;
var cntback = 0;
var stflo = 0;
var stflk = false;
function drawcraftselect() {
    craftselect();
    rd.clearRect(0, 0, canw, canh);
    if (((doorspos < 10) && (Math.abs((sel[0] * 80) - scrol) < 2) && (sel[0] >= Math.floor(4 + ((unlocked - 1) / 2)))) || (sel[0] > Math.floor(4 + ((unlocked - 1) / 2)))) {
        rd.globalAlpha = alphs;
        for (var i = 0; i < 14; i++) {
            rd.drawImage(lsl, ((296 + (i * 52)) * mw), (164 * mh), (12 * mw), (450 * mh));
        }
        rd.globalAlpha = 1;
        if (!alphk) {
            alphs += 0.03;
            if (alphs > 1) {
                alphs = 1;
                alphk = true;
            }
        } else {
            alphs -= 0.03;
            if (alphs < 0.2) {
                alphs = 0.2;
                alphk = false;
            }
        }
    }
    if (doorspos > 0) {
        if (unlockedc) {
            var remo = 0;
            if (unlockedc > 20) {
                remo = ((unlockedc - 20) * 18);
            }
            rd.globalAlpha = alphs;
            for (var i = 0; i < 14; i++) {
                rd.drawImage(lsl, ((296 + (i * 52)) * mw), (164 * mh), (12 * mw), ((450 - remo) * mh));
            }
            rd.globalAlpha = 1;
            if (!alphk) {
                alphs += 0.03;
                if (alphs > 1) {
                    alphs = 1;
                    alphk = true;
                }
            } else {
                alphs -= 0.03;
                if (alphs < 0.2) {
                    alphs = 0.2;
                    alphk = false;
                }
            }
            unlockedc++;
        }
        rd.drawImage(door1, ((doorspos - 153) * mw), (167 * mh), (441 * mw), (443 * mh));
        rd.drawImage(door2, ((1013 - doorspos) * mw), (167 * mh), (409 * mw), (443 * mh));
        if (opendoors) {
            if (cntopen > 10) {
                doorspos -= 10;
            } else {
                cntopen++;
                if ((cntopen == 11) && (!mutemusic)) {
                    playsnd(43);
                }
            }
        }
    }
    rd.drawImage(room1, 0, 0, canw, canh);
    rd.font = "" + (40 * avm) + "px osaka";
    rd.textBaseline = "middle";
    rd.textAlign = "center";
    var grd = rd.createLinearGradient(0, (35 * mh), 0, (65 * mh));
    grd.addColorStop(0, "#A3E4FF");
    grd.addColorStop(1, "#3197FF");
    rd.fillStyle = grd;
    rd.fillText("SELECT AIRCRAFT", (640 * mw), (50 * mh));
    if ((doorspos < 10) && (Math.abs((sel[0] * 80) - scrol) < 2) && (sel[0] < Math.floor(4 + ((unlocked - 1) / 2)))) {
        if (!unlockedc) {
            rd.font = "" + (32 * avm) + "px osaka";
            rd.textBaseline = "middle";
            rd.textAlign = "right";
            var grd = rd.createLinearGradient(0, (200 * mh), 0, (230 * mh));
            grd.addColorStop(0, "#0044B4");
            grd.addColorStop(1, "#000000");
            rd.fillStyle = grd;
            rd.fillText("SPEED", (476 * mw), (215 * mh));
            grd = rd.createLinearGradient(0, (235 * mh), 0, (265 * mh));
            grd.addColorStop(0, "#0044B4");
            grd.addColorStop(1, "#000000");
            rd.fillStyle = grd;
            rd.fillText("AGILITY", (476 * mw), (250 * mh));
            grd = rd.createLinearGradient(0, (490 * mh), 0, (520 * mh));
            grd.addColorStop(0, "#0044B4");
            grd.addColorStop(1, "#000000");
            rd.fillStyle = grd;
            rd.fillText("FIRE POWER", (476 * mw), (505 * mh));
            grd = rd.createLinearGradient(0, (525 * mh), 0, (555 * mh));
            grd.addColorStop(0, "#0044B4");
            grd.addColorStop(1, "#000000");
            rd.fillStyle = grd;
            rd.fillText("STRENGTH", (476 * mw), (540 * mh));
            if (!stflk) {
                stflo += 0.05;
                if (stflo > 1) {
                    stflo = 1;
                    stflk = true;
                }
            } else {
                stflo -= 0.05;
                if (stflo < -1) {
                    stflo = -1;
                    stflk = false;
                }
            }
            var mag = ((cspeed[sel[0]] - 3) / 1.9);
            var xdd = ((790 * mw) - (300 * mw) + (150 * mw * mag));
            var ydd = (215 * mh);
            var wdd = (300 * mw * mag);
            var hdd = (28 * mh);
            rd.beginPath();
            rd.moveTo((xdd - (wdd * 0.5) + (14 * mw)), (ydd - (hdd * 0.5)));
            rd.lineTo((xdd - (wdd * 0.5) + (6 * mw)), (ydd - (hdd * 0.5) + (7 * mh)));
            rd.lineTo((xdd - (wdd * 0.5)), (ydd + (hdd * 0.5)));
            rd.lineTo((xdd + (wdd * 0.5) - (14 * mw)), (ydd + (hdd * 0.5)));
            rd.lineTo((xdd + (wdd * 0.5) - (6 * mw)), (ydd + (hdd * 0.5) - (7 * mh)));
            rd.lineTo((xdd + (wdd * 0.5)), (ydd - (hdd * 0.5)));
            rd.closePath();
            grd = rd.createLinearGradient(0, (ydd - (hdd * 0.5) + (hdd * 0.2 * stflo)), 0, (ydd + (hdd * 0.5) + (hdd * 0.2 * stflo)));
            grd.addColorStop(0, "#FF7C2D");
            grd.addColorStop(1, "#6D2DFF");
            rd.fillStyle = grd;
            rd.fill();
            xdd = ((790 * mw) - (150 * mw));
            ydd = (215 * mh);
            wdd = (300 * mw);
            hdd = (28 * mh);
            rd.beginPath();
            rd.moveTo((xdd - (wdd * 0.5) + (14 * mw)), (ydd - (hdd * 0.5)));
            rd.lineTo((xdd - (wdd * 0.5) + (6 * mw)), (ydd - (hdd * 0.5) + (7 * mh)));
            rd.lineTo((xdd - (wdd * 0.5)), (ydd + (hdd * 0.5)));
            rd.lineTo((xdd + (wdd * 0.5) - (14 * mw)), (ydd + (hdd * 0.5)));
            rd.lineTo((xdd + (wdd * 0.5) - (6 * mw)), (ydd + (hdd * 0.5) - (7 * mh)));
            rd.lineTo((xdd + (wdd * 0.5)), (ydd - (hdd * 0.5)));
            rd.closePath();
            rd.globalAlpha = 0.6;
            grd = rd.createLinearGradient(0, (ydd - (hdd * 0.5)), 0, (ydd + (hdd * 0.5)));
            grd.addColorStop(0, "#5A7094");
            grd.addColorStop(1, "#1A202A");
            rd.strokeStyle = grd;
            rd.lineWidth = (2 * avm);
            rd.stroke();
            rd.globalAlpha = 1;
            mag = ((((elv[sel[0]] + eln[sel[0]]) * turning[sel[0]]) - 2) / 6.58);
            xdd = ((790 * mw) - (300 * mw) + (150 * mw * mag));
            ydd = (250 * mh);
            wdd = (300 * mw * mag);
            hdd = (28 * mh);
            rd.beginPath();
            rd.moveTo((xdd - (wdd * 0.5) + (14 * mw)), (ydd - (hdd * 0.5)));
            rd.lineTo((xdd - (wdd * 0.5) + (6 * mw)), (ydd - (hdd * 0.5) + (7 * mh)));
            rd.lineTo((xdd - (wdd * 0.5)), (ydd + (hdd * 0.5)));
            rd.lineTo((xdd + (wdd * 0.5) - (14 * mw)), (ydd + (hdd * 0.5)));
            rd.lineTo((xdd + (wdd * 0.5) - (6 * mw)), (ydd + (hdd * 0.5) - (7 * mh)));
            rd.lineTo((xdd + (wdd * 0.5)), (ydd - (hdd * 0.5)));
            rd.closePath();
            grd = rd.createLinearGradient(0, (ydd - (hdd * 0.5) + (hdd * 0.2 * stflo)), 0, (ydd + (hdd * 0.5) + (hdd * 0.2 * stflo)));
            grd.addColorStop(0, "#FF7C2D");
            grd.addColorStop(1, "#6D2DFF");
            rd.fillStyle = grd;
            rd.fill();
            xdd = ((790 * mw) - (150 * mw));
            ydd = (250 * mh);
            wdd = (300 * mw);
            hdd = (28 * mh);
            rd.beginPath();
            rd.moveTo((xdd - (wdd * 0.5) + (14 * mw)), (ydd - (hdd * 0.5)));
            rd.lineTo((xdd - (wdd * 0.5) + (6 * mw)), (ydd - (hdd * 0.5) + (7 * mh)));
            rd.lineTo((xdd - (wdd * 0.5)), (ydd + (hdd * 0.5)));
            rd.lineTo((xdd + (wdd * 0.5) - (14 * mw)), (ydd + (hdd * 0.5)));
            rd.lineTo((xdd + (wdd * 0.5) - (6 * mw)), (ydd + (hdd * 0.5) - (7 * mh)));
            rd.lineTo((xdd + (wdd * 0.5)), (ydd - (hdd * 0.5)));
            rd.closePath();
            rd.globalAlpha = 0.6;
            grd = rd.createLinearGradient(0, (ydd - (hdd * 0.5)), 0, (ydd + (hdd * 0.5)));
            grd.addColorStop(0, "#5A7094");
            grd.addColorStop(1, "#1A202A");
            rd.strokeStyle = grd;
            rd.lineWidth = (2 * avm);
            rd.stroke();
            rd.globalAlpha = 1;
            mag = ((displasermag[sel[0]] - 0.5) / 1.3);
            xdd = ((790 * mw) - (300 * mw) + (150 * mw * mag));
            ydd = (505 * mh);
            wdd = (300 * mw * mag);
            hdd = (28 * mh);
            rd.beginPath();
            rd.moveTo((xdd - (wdd * 0.5) + (14 * mw)), (ydd - (hdd * 0.5)));
            rd.lineTo((xdd - (wdd * 0.5) + (6 * mw)), (ydd - (hdd * 0.5) + (7 * mh)));
            rd.lineTo((xdd - (wdd * 0.5)), (ydd + (hdd * 0.5)));
            rd.lineTo((xdd + (wdd * 0.5) - (14 * mw)), (ydd + (hdd * 0.5)));
            rd.lineTo((xdd + (wdd * 0.5) - (6 * mw)), (ydd + (hdd * 0.5) - (7 * mh)));
            rd.lineTo((xdd + (wdd * 0.5)), (ydd - (hdd * 0.5)));
            rd.closePath();
            grd = rd.createLinearGradient(0, (ydd - (hdd * 0.5 + (hdd * 0.2 * stflo))), 0, (ydd + (hdd * 0.5) + (hdd * 0.2 * stflo)));
            grd.addColorStop(0, "#FF7C2D");
            grd.addColorStop(1, "#6D2DFF");
            rd.fillStyle = grd;
            rd.fill();
            xdd = ((790 * mw) - (150 * mw));
            ydd = (505 * mh);
            wdd = (300 * mw);
            hdd = (28 * mh);
            rd.beginPath();
            rd.moveTo((xdd - (wdd * 0.5) + (14 * mw)), (ydd - (hdd * 0.5)));
            rd.lineTo((xdd - (wdd * 0.5) + (6 * mw)), (ydd - (hdd * 0.5) + (7 * mh)));
            rd.lineTo((xdd - (wdd * 0.5)), (ydd + (hdd * 0.5)));
            rd.lineTo((xdd + (wdd * 0.5) - (14 * mw)), (ydd + (hdd * 0.5)));
            rd.lineTo((xdd + (wdd * 0.5) - (6 * mw)), (ydd + (hdd * 0.5) - (7 * mh)));
            rd.lineTo((xdd + (wdd * 0.5)), (ydd - (hdd * 0.5)));
            rd.closePath();
            rd.globalAlpha = 0.6;
            grd = rd.createLinearGradient(0, (ydd - (hdd * 0.5)), 0, (ydd + (hdd * 0.5)));
            grd.addColorStop(0, "#5A7094");
            grd.addColorStop(1, "#1A202A");
            rd.strokeStyle = grd;
            rd.lineWidth = (2 * avm);
            rd.stroke();
            rd.globalAlpha = 1;
            mag = ((1.2 - endurance[sel[0]]) / 0.65);
            xdd = ((790 * mw) - (300 * mw) + (150 * mw * mag));
            ydd = (540 * mh);
            wdd = (300 * mw * mag);
            hdd = (28 * mh);
            rd.beginPath();
            rd.moveTo((xdd - (wdd * 0.5) + (14 * mw)), (ydd - (hdd * 0.5)));
            rd.lineTo((xdd - (wdd * 0.5) + (6 * mw)), (ydd - (hdd * 0.5) + (7 * mh)));
            rd.lineTo((xdd - (wdd * 0.5)), (ydd + (hdd * 0.5)));
            rd.lineTo((xdd + (wdd * 0.5) - (14 * mw)), (ydd + (hdd * 0.5)));
            rd.lineTo((xdd + (wdd * 0.5) - (6 * mw)), (ydd + (hdd * 0.5) - (7 * mh)));
            rd.lineTo((xdd + (wdd * 0.5)), (ydd - (hdd * 0.5)));
            rd.closePath();
            grd = rd.createLinearGradient(0, (ydd - (hdd * 0.5) + (hdd * 0.2 * stflo)), 0, (ydd + (hdd * 0.5) + (hdd * 0.2 * stflo)));
            grd.addColorStop(0, "#FF7C2D");
            grd.addColorStop(1, "#6D2DFF");
            rd.fillStyle = grd;
            rd.fill();
            xdd = ((790 * mw) - (150 * mw));
            ydd = (540 * mh);
            wdd = (300 * mw);
            hdd = (28 * mh);
            rd.beginPath();
            rd.moveTo((xdd - (wdd * 0.5) + (14 * mw)), (ydd - (hdd * 0.5)));
            rd.lineTo((xdd - (wdd * 0.5) + (6 * mw)), (ydd - (hdd * 0.5) + (7 * mh)));
            rd.lineTo((xdd - (wdd * 0.5)), (ydd + (hdd * 0.5)));
            rd.lineTo((xdd + (wdd * 0.5) - (14 * mw)), (ydd + (hdd * 0.5)));
            rd.lineTo((xdd + (wdd * 0.5) - (6 * mw)), (ydd + (hdd * 0.5) - (7 * mh)));
            rd.lineTo((xdd + (wdd * 0.5)), (ydd - (hdd * 0.5)));
            rd.closePath();
            rd.globalAlpha = 0.6;
            grd = rd.createLinearGradient(0, (ydd - (hdd * 0.5)), 0, (ydd + (hdd * 0.5)));
            grd.addColorStop(0, "#5A7094");
            grd.addColorStop(1, "#1A202A");
            rd.strokeStyle = grd;
            rd.lineWidth = (2 * avm);
            rd.stroke();
            rd.globalAlpha = 1;
        } else {
            rd.font = "" + (32 * avm) + "px osaka";
            rd.textBaseline = "middle";
            rd.textAlign = "center";
            var grd = rd.createLinearGradient(0, (250 * mh), 0, (280 * mh));
            if (!alphk) {
                grd.addColorStop(0, "#0044B4");
                grd.addColorStop(1, "#000000");
            } else {
                grd.addColorStop(0, "#9519FF");
                grd.addColorStop(1, "#0E009A");
            }
            if (!alphk) {
                alphs += 0.3;
                if (alphs > 1) {
                    alphs = 1;
                    alphk = true;
                }
            } else {
                alphs -= 0.3;
                if (alphs < 0.2) {
                    alphs = 0.2;
                    alphk = false;
                }
            }
            rd.fillStyle = grd;
            rd.fillText("AIRCRAFT UNLOCKED!", (640 * mw), (265 * mh));
            unlockedc -= 0.8;
            if (unlockedc < 0) {
                unlockedc = 0;
            }
        }
    }
    if (doorspos < 150) {
        rd.font = "" + (32 * avm) + "px osaka";
        rd.textBaseline = "middle";
        rd.textAlign = "center";
        rd.fillStyle = "#A3E4FF";
        rd.fillText(cname[sel[0]], (640 * mw), (120 * mh));
        var onit = 0;
        var btnx = 170;
        var btny = 420;
        var btnw = 130;
        var btnh = 50;
        if (sel[0] != 0) {
            declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 1);
            if (wasonit == 1) {
                onit = 1;
            }
            if ((onaclk > 7) && (onwho == 1)) {
                onit = 1;
            }
            if ((onaclk == 9) && (onwho == 1)) {
                unlockedc = 0;
                if (sel[0] > Math.floor(4 + ((unlocked - 1) / 2) - 1)) {
                    sel[0] = Math.floor(4 + ((unlocked - 1) / 2) - 1);
                } else {
                    sel[0]--;
                    if (sel[0] == -1) {
                        sel[0] = 0;
                    }
                }
                alphs = 1;
                onwho = 0;
                wasonit = 0;
            }
            drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "< PREV", 20);
            if (lefted) {
                left[0] = false;
                lefted--;
            }
            if (left[0]) {
                unlockedc = 0;
                if (sel[0] > Math.floor(4 + ((unlocked - 1) / 2) - 1)) {
                    sel[0] = Math.floor(4 + ((unlocked - 1) / 2) - 1);
                } else {
                    sel[0]--;
                    if (sel[0] == -1) {
                        sel[0] = 0;
                    }
                }
                alphs = 1;
                lefted = 30;
            }
        }
        onit = 0;
        btnx = 1110;
        btny = 420;
        btnw = 130;
        btnh = 50;
        if (sel[0] != 9) {
            declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 2);
            if (wasonit == 2) {
                onit = 1;
            }
            if ((onaclk > 7) && (onwho == 2)) {
                onit = 1;
            }
            if ((onaclk == 9) && (onwho == 2)) {
                unlockedc = 0;
                sel[0]++;
                if (sel[0] == 10) {
                    sel[0] = 9;
                }
                alphs = 1;
                cntback = 0;
                onwho = 0;
                wasonit = 0;
            }
            drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "NEXT >", 20);
            if (righted) {
                right[0] = false;
                righted--;
            }
            if (right[0]) {
                unlockedc = 0;
                sel[0]++;
                if (sel[0] == 10) {
                    sel[0] = 9;
                }
                alphs = 1;
                cntback = 0;
                righted = 30;
            }
        }
        if (sel[0] < Math.floor(4 + ((unlocked - 1) / 2))) {
            onit = 0;
            btnx = 640;
            btny = 666;
            btnw = 230;
            btnh = 60;
            declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 6);
            if (wasonit == 6) {
                onit = 1;
            }
            if ((onaclk > 7) && (onwho == 6)) {
                onit = 1;
            }
            if ((onaclk == 9) && (onwho == 6)) {
                saveInfo("selected", "" + sel[0] + "");
                unlockedc = 0;
                opendoors = false;
                if (!mutemusic) {
                    playsnd(44);
                }
                onwho = 0;
                wasonit = 0;
            }
            drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "CONTINUE", 25);
        } else {
            if ((doorspos < 10) && (Math.abs((sel[0] * 80) - scrol) < 2)) {
                rd.font = "" + (32 * avm) + "px osaka";
                rd.textBaseline = "middle";
                rd.textAlign = "center";
                var grd = rd.createLinearGradient(0, (250 * mh), 0, (280 * mh));
                grd.addColorStop(0, "#0044B4");
                grd.addColorStop(1, "#000000");
                rd.fillStyle = grd;
                rd.fillText("AIRCRAFT LOCKED", (640 * mw), (265 * mh));
                rd.font = "" + (40 * avm) + "px teko";
                rd.textBaseline = "middle";
                rd.textAlign = "center";
                rd.fillStyle = "#FFFFFF";
                rd.globalAlpha = ((alphs * 0.8) + 0.2);
                rd.fillText("Unlocks when stage " + (((sel[0] - 4) * 2) + 2) + " is complete!", (640 * mw), (670 * mh));
                rd.globalAlpha = 1;
                cntback++;
                if (cntback == 200) {
                    sel[0] = Math.floor(4 + ((unlocked - 1) / 2) - 1);
                    cntback = 0;
                }
            }
        }
        if (!flwg) {
            flw -= 0.03;
            if (flw < 0.5) {
                flw = 0.5;
                flwg = true;
            }
        } else {
            flw += 0.03;
            if (flw > 2) {
                flw = 2;
                flwg = false;
            }
        }
        if (!flhg) {
            flh -= 0.5;
            if (flh < 0.1) {
                flh = 0.1;
                flhg = true;
            }
        } else {
            flh += 0.5;
            if (flh > 2) {
                flh = 2;
                flhg = false;
            }
        }
    }
    if (!opendoors) {
        if ((doorspos == 0) && (!mutemusic)) {
            playsnd(43);
        }
        doorspos += 10;
        if (doorspos >= 400) {
            doorspos = 400;
            transx = 0;
            transmode = 1;
            fase = 3;
        }
    }
    musictog();
}
var transx = 0;
var transmode = 1;
function transition() {
    rd.drawImage(door1, ((247 + transx) * mw), (167 * mh), (441 * mw), (443 * mh));
    rd.drawImage(door2, ((613 + transx) * mw), (167 * mh), (409 * mw), (443 * mh));
    rd.drawImage(room1, (transx * mw), 0, canw, canh);
    rd.drawImage(room2, ((transx + 1280) * mw), 0, canw, canh);
    rd.drawImage(scrin, ((transx + 1280 + 164) * mw), (84 * mh), (952 * mw), (537 * mh));
    if (transmode == 1) {
        transx -= 30;
        if (transx <= -1280) {
            transx = -1280;
            stageload = 20;
            lefted = 1;
            fase = 4;
        }
    }
    if (transmode == 2) {
        transx += 30;
        if (transx >= 0) {
            transx = 0;
            selectinish = false;
            drawcraftselect();
            fase = 2;
            requestAnimationFrame(render);
        }
    }
}
var alphs = 1;
function drawselectstage() {
    rd.clearRect(0, 0, canw, canh);
    rd.drawImage(room2, 0, 0, canw, canh);
    rd.font = "" + (40 * avm) + "px osaka";
    rd.textBaseline = "middle";
    rd.textAlign = "center";
    var grd = rd.createLinearGradient(0, (25 * mh), 0, (55 * mh));
    grd.addColorStop(0, "#A3E4FF");
    grd.addColorStop(1, "#3197FF");
    rd.fillStyle = grd;
    rd.fillText("SELECT STAGE", (640 * mw), (40 * mh));
    if (!stageload) {
        if (alphs > 0) {
            rd.globalAlpha = alphs;
            rd.drawImage(scrin, (164 * mw), (84 * mh), (952 * mw), (537 * mh));
            rd.globalAlpha = 1;
            alphs -= 0.02;
        }
        rd.font = "" + (32 * avm) + "px osaka";
        rd.textBaseline = "middle";
        rd.textAlign = "center";
        grd = rd.createLinearGradient(0, (205 * mh), 0, (235 * mh));
        grd.addColorStop(0, "#004F8C");
        grd.addColorStop(1, "#000000");
        rd.fillStyle = grd;
        if (stage != 12) {
            rd.fillText("STAGE " + stage + "", (640 * mw), (220 * mh));
        } else {
            rd.fillText("FINAL STAGE", (640 * mw), (220 * mh));
        }
        grd = rd.createLinearGradient(0, (255 * mh), 0, (285 * mh));
        grd.addColorStop(0, "#004F8C");
        grd.addColorStop(1, "#000000");
        rd.fillStyle = grd;
        rd.fillText(stagename, (640 * mw), (270 * mh));
        var onit = 0;
        var btnx = 140;
        var btny = 440;
        var btnw = 130;
        var btnh = 50;
        if (stage != 1) {
            declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 1);
            if (wasonit == 1) {
                onit = 1;
            }
            if ((onaclk > 7) && (onwho == 1)) {
                onit = 1;
            }
            if ((onaclk == 9) && (onwho == 1)) {
                stage--;
                if (stage <= 1) {
                    stage = 1;
                }
                stageload = 20;
                onwho = 0;
                wasonit = 0;
            }
            drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "< PREV", 20);
            if ((left[0]) && (!lefted)) {
                stage--;
                if (stage <= 1) {
                    stage = 1;
                }
                stageload = 20;
                lefted = 1;
            }
        }
        onit = 0;
        btnx = 1140;
        btny = 440;
        btnw = 130;
        btnh = 50;
        if ((stage != 12) && (stage != unlocked)) {
            declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 2);
            if (wasonit == 2) {
                onit = 1;
            }
            if ((onaclk > 7) && (onwho == 2)) {
                onit = 1;
            }
            if ((onaclk == 9) && (onwho == 2)) {
                if (stage != unlocked) {
                    stage++;
                    if (stage >= 12) {
                        stage = 12;
                    }
                    stageload = 20;
                }
                onwho = 0;
                wasonit = 0;
            }
            drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "NEXT >", 20);
            if ((right[0]) && (!lefted)) {
                if (stage != unlocked) {
                    stage++;
                    if (stage >= 12) {
                        stage = 12;
                    }
                    stageload = 20;
                    lefted = 1;
                }
            }
        }
        stageselect();
    } else {
        rd.drawImage(scrin, (164 * mw), (84 * mh), (952 * mw), (537 * mh));
        rd.font = "" + (32 * avm) + "px osaka";
        rd.textBaseline = "middle";
        rd.textAlign = "center";
        var grd = rd.createLinearGradient(0, (300 * mh), 0, (360 * mh));
        grd.addColorStop(0, "#004F8C");
        grd.addColorStop(1, "#000000");
        rd.fillStyle = grd;
        rd.fillText("LOADING STAGE...", (640 * mw), (330 * mh));
        if (stageload > 3) {
            stageload--;
        }
        if (stageload == 3) {
            loadstage();
        }
        if (stageload == 1) {
            stageload = 0;
            lefted = 0;
            selectinish = false;
            stageselect();
            requestAnimationFrame(render);
        }
    }
    onit = 0;
    btnx = 640;
    btny = 666;
    btnw = 230;
    btnh = 60;
    declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 6);
    if (wasonit == 6) {
        onit = 1;
    }
    if ((onaclk > 7) && (onwho == 6)) {
        onit = 1;
    }
    if ((onaclk == 9) && (onwho == 6)) {
        if (!stageload) {
            if (!mutemusic) {
                playsnd(44);
            }
            prepcnt = 0;
            fase = 6;
            onwho = 0;
            wasonit = 0;
        }
    }
    drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "CONTINUE", 25);
    onit = 0;
    btnx = 80;
    btny = 666;
    btnw = 135;
    btnh = 60;
    declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 4);
    if (wasonit == 4) {
        onit = 1;
    }
    if ((onaclk > 7) && (onwho == 4)) {
        onit = 1;
    }
    if ((onaclk == 9) && (onwho == 4)) {
        transx = -1280;
        transmode = 2;
        fase = 3;
        onwho = 0;
        wasonit = 0;
    }
    drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "BACK", 23);
    if (!flwg) {
        flw -= 0.03;
        if (flw < 0.5) {
            flw = 0.5;
            flwg = true;
        }
    } else {
        flw += 0.03;
        if (flw > 2) {
            flw = 2;
            flwg = false;
        }
    }
    if (!flhg) {
        flh -= 0.5;
        if (flh < 0.1) {
            flh = 0.1;
            flhg = true;
        }
    } else {
        flh += 0.5;
        if (flh > 2) {
            flh = 2;
            flhg = false;
        }
    }
    musictog();
}
var infase = 0;
var arnd = 0;
var arndcnt = 25;
function gameinstruction() {
    if ((infase >= 0) && (infase <= 4)) {
        rd.clearRect(0, 0, canw, canh);
        rd.drawImage(pausebg, 0, 0, canw, canh);
        rd.drawImage(iscrin, (23 * mw), (23 * mh), (1234 * mw), (674 * mh));
        rd.font = "" + (42 * avm) + "px teko";
        rd.textBaseline = "middle";
        rd.textAlign = "left";
        rd.fillStyle = "#000000";
        if (infase == 0) {
            rd.fillText("In this game you can win by either racing and finishing in first place", (130 * mw), (150 * mh));
            rd.fillText("or by destroying all the other aircrafts!", (130 * mw), (210 * mh));
            rd.fillText("Use the Attack/Race in-game button to switch from", (130 * mw), (315 * mh));
            rd.fillText("race mode to attack mode and back.", (130 * mw), (375 * mh));
            rd.fillText("Some stages are easier to complete by racing and", (130 * mw), (480 * mh));
            rd.fillText("others are easier to complete by attacking.", (130 * mw), (540 * mh));
            rd.drawImage(inst[0], (920 * mw), (280 * mh), (196 * avm), (189 * avm));
            rd.font = "" + (38 * avm) + "px teko";
            rd.textBaseline = "middle";
            rd.textAlign = "right";
            rd.globalAlpha = 0.6;
            rd.fillStyle = "#000000";
            rd.fillText("Switch modes", ((920 * mw) + (95 * avm)), ((280 * mh) + (98 * avm)));
            rd.globalAlpha = 1;
        }
        if (infase == 1) {
            rd.fillText("When racing follow the arrow to go through the checkpoints to", (130 * mw), (150 * mh));
            rd.fillText("complete the race.", (130 * mw), (210 * mh));
            rd.drawImage(inst[1], ((760 * mw) - (189 * avm)), (170 * mh), (378 * avm), (192 * avm));
            rd.fillText("When attacking follow the arrow to chase after the other", (130 * mw), (415 * mh));
            rd.fillText("aircrafts, and get a lock on a target.", (130 * mw), (475 * mh));
            rd.drawImage(inst[2], ((760 * mw) - (122 * avm)), (435 * mh), (245 * avm), (142 * avm));
        }
        if (infase == 2) {
            rd.fillText("If your aircraft gets damaged, to fix it find the orange fixing", (130 * mw), (200 * mh));
            rd.fillText("portal and fly through it to fix your aircraft.", (130 * mw), (260 * mh));
            rd.drawImage(inst[3], ((760 * mw) - (189 * avm)), (290 * mh), (291 * avm), (192 * avm));
        }
        if (infase == 3) {
            rd.fillText("To control your aircraft", (130 * mw), (130 * mh));
            var msfn = 9;
            if (isphone) {
                msfn = 10;
            }
            if (!isphone) {
                rd.fillText("click the mouse around it", (130 * mw), (190 * mh));
            } else {
                rd.fillText("press finger around it", (130 * mw), (190 * mh));
            }
            rd.textAlign = "center";
            rd.fillText("Or", (810 * mw), (150 * mh));
            rd.textAlign = "left";
            rd.drawImage(inst[4], ((640 * mw) - (264.5 * avm)), ((360 * mh) - (185.5 * avm)), (529 * avm), (371 * avm));
            if (arnd == 0) {
                rd.drawImage(inst[5], ((640 * mw) - (20 * avm)), ((360 * mh) - (120 * avm)), (40 * avm), (64 * avm));
                rd.fillText("Pull Up", ((640 * mw) + (20 * avm) + (10 * mw)), ((360 * mh) - (70 * avm)));
                rd.drawImage(inst[msfn], ((640 * mw) - (22.5 * avm)), ((360 * mh) - (230 * avm)), (66 * avm), (78 * avm));
            }
            if (arnd == 1) {
                rd.drawImage(inst[7], ((640 * mw) - (20 * avm)), ((360 * mh) + (56 * avm)), (40 * avm), (64 * avm));
                rd.fillText("Push Down", ((640 * mw) + (20 * avm) + (10 * mw)), ((360 * mh) + (80 * avm)));
                rd.drawImage(inst[msfn], ((640 * mw) - (22.5 * avm)), ((360 * mh) + (152 * avm)), (66 * avm), (78 * avm));
            }
            if (arnd == 2) {
                rd.drawImage(inst[8], ((640 * mw) - (194 * avm)), ((360 * mh) - (20 * avm)), (64 * avm), (40 * avm));
                rd.fillText("Roll Left", ((640 * mw) - (212 * avm)), ((360 * mh) + (50 * avm)));
                rd.drawImage(inst[msfn], ((640 * mw) - (300 * avm)), ((360 * mh) - (20 * avm)), (66 * avm), (78 * avm));
            }
            if (arnd == 3) {
                rd.drawImage(inst[6], ((640 * mw) + (130 * avm)), ((360 * mh) - (20 * avm)), (64 * avm), (40 * avm));
                rd.fillText("Roll Right", ((640 * mw) + (100 * avm)), ((360 * mh) + (50 * avm)));
                rd.drawImage(inst[msfn], ((640 * mw) + (250 * avm)), ((360 * mh) - (20 * avm)), (66 * avm), (78 * avm));
            }
            arndcnt++;
            if (arndcnt == 50) {
                arnd++;
                if (arnd == 4) {
                    arnd = 0;
                }
                arndcnt = 0;
            }
        }
        if (infase == 4) {
            rd.textAlign = "center";
            rd.fillText("Flying using Keyboard Controls", (640 * mw), (140 * mh));
            rd.textAlign = "left";
            if (!invertcontrols) {
                rd.fillText("Up arrow key to pull aircraft nose up", (130 * mw), (220 * mh));
                rd.fillText("Down arrow key to push aircraft nose down", (130 * mw), (280 * mh));
            } else {
                rd.fillText("Down arrow key to pull aircraft nose up", (130 * mw), (220 * mh));
                rd.fillText("Up arrow key to push aircraft nose down", (130 * mw), (280 * mh));
            }
            rd.fillText("Left and right arrow keys to roll aircraft", (130 * mw), (340 * mh));
            rd.fillText("Spacebar to switch attack/race mode", (130 * mw), (450 * mh));
            rd.drawImage(inst[12], ((370 * mw) - (172.5 * avm)), ((570 * mh) - (77 * avm)), (345 * avm), (77 * avm));
            rd.drawImage(inst[11], ((940 * mw) - (110 * avm)), ((380 * mh) - (155 * avm)), (220 * avm), (155 * avm));
            var onit = 0;
            var btnx = 940;
            var btny = 450;
            var btnw = 310;
            var btnh = 60;
            rd.drawImage(inst[18], (((btnx - (btnw * 0.5) + 5) * mw) - (70 * avm)), ((btny - 54) * mh), (70 * avm), (92 * avm));
            declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 3);
            if (wasonit == 3) {
                onit = 1;
            }
            if ((onaclk > 7) && (onwho == 3)) {
                onit = 1;
            }
            if ((onaclk == 9) && (onwho == 3)) {
                infase = 10;
                onwho = 0;
                wasonit = 0;
            }
            drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "INVERT CONTROLS", 23);
        }
        var onit = 0;
        var btnx = 1050;
        var btny = 610;
        var btnw = 220;
        var btnh = 60;
        if (infase != 4) {
            if (infase != 3) {
                declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 6);
                if (wasonit == 6) {
                    onit = 1;
                }
                if ((onaclk > 7) && (onwho == 6)) {
                    onit = 1;
                }
                if ((onaclk == 9) && (onwho == 6)) {
                    infase++;
                    onwho = 0;
                    wasonit = 0;
                }
                drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "CONTINUE >", 23);
            } else {
                onit = 0;
                btnx = 1020;
                btny = 610;
                btnw = 270;
                btnh = 60;
                declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 6);
                if (wasonit == 6) {
                    onit = 1;
                }
                if ((onaclk > 7) && (onwho == 6)) {
                    onit = 1;
                }
                if ((onaclk == 9) && (onwho == 6)) {
                    getheading = 0;
                    getslope = 0;
                    mutemusic = omutemusic;
                    mutegame = omutegame;
                    infase = 0;
                    gameplayStart();
                    fase = 7;
                    requestAnimationFrame(render);
                    onwho = 0;
                    wasonit = 0;
                }
                drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "RESUME GAME", 23);
                if (!isphone) {
                    onit = 0;
                    btnx = 1000;
                    btny = 140;
                    btnw = 330;
                    btnh = 60;
                    declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 5);
                    if (wasonit == 5) {
                        onit = 1;
                    }
                    if ((onaclk > 7) && (onwho == 5)) {
                        onit = 1;
                    }
                    if ((onaclk == 9) && (onwho == 5)) {
                        infase++;
                        onwho = 0;
                        wasonit = 0;
                    }
                    drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "KEYBOARD CONTROLS", 20);
                }
            }
        }
        if (infase != 0) {
            onit = 0;
            btnx = 200;
            if (infase == 4) {
                btnx = 1050;
            }
            btny = 610;
            btnw = 150;
            btnh = 60;
            declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 4);
            if (wasonit == 4) {
                onit = 1;
            }
            if ((onaclk > 7) && (onwho == 4)) {
                onit = 1;
            }
            if ((onaclk == 9) && (onwho == 4)) {
                infase--;
                onwho = 0;
                wasonit = 0;
            }
            drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "< BACK", 23);
        }
    }
    if (infase == 5) {
        drawinstart();
    }
    if (infase == 6) {
        drawinstattack();
    }
    if (infase == 7) {
        drawinstpart();
    }
    if (infase == 8) {
        drawinstkeys();
    }
    if (infase == 9) {
        drawinstrace();
    }
    if (infase == 10) {
        drawinstinvert();
    }
}
var adshow = 1;
var prepcnt = 0;
function prepstart() {
    if (prepcnt == 0) {
        pauseintertrack();
        if (adshow == 0) {
            adshow = 1;
        } else {
            adshow = 2;
            showLoadingAd();
        }
        prepcnt = 1;
    }
    if (prepcnt == 1) {
        rd.fillStyle = "#121F2C";
        rd.fillRect(0, 0, canw, canh);
        rd.drawImage(endi, 0, 0, canw, canh);
        rd.drawImage(logo, ((640 * mw) - (259.5 * avm)), (140 * mh), (519 * avm), (60 * avm));
        var xdd = (canw * 0.5);
        var ydd = (360 * mh);
        var wdd = (840 * mw);
        var hdd = (250 * mh);
        rd.globalAlpha = 0.76;
        rd.beginPath();
        rd.moveTo((xdd - (wdd * 0.5) + (100 * mw)), (ydd - (hdd * 0.5)));
        rd.lineTo((xdd - (wdd * 0.5) + (43 * mw)), (ydd - (hdd * 0.5) + (50 * mh)));
        rd.lineTo((xdd - (wdd * 0.5)), (ydd + (hdd * 0.5)));
        rd.lineTo((xdd + (wdd * 0.5) - (100 * mw)), (ydd + (hdd * 0.5)));
        rd.lineTo((xdd + (wdd * 0.5) - (43 * mw)), (ydd + (hdd * 0.5) - (50 * mh)));
        rd.lineTo((xdd + (wdd * 0.5)), (ydd - (hdd * 0.5)));
        rd.closePath();
        rd.fillStyle = "#121F2C";
        rd.fill();
        rd.globalAlpha = 1;
        rd.drawImage(logoman, (820 * mw), ((360 * mh) - (91 * avm)), (174 * avm), (183 * avm));
        rd.globalAlpha = 0.8;
        rd.font = "" + (42 * avm) + "px osaka";
        rd.textBaseline = "middle";
        rd.textAlign = "left";
        var grd = rd.createLinearGradient(0, ((275 * mh) + (7 * avm) - (15 * mh)), 0, ((275 * mh) + (7 * avm) + (15 * mh)));
        grd.addColorStop(0, "#69D3FF");
        grd.addColorStop(1, "#27A6FF");
        rd.fillStyle = grd;
        rd.fillText("LOADING STAGE", (340 * mw), ((270 * mh) + (7 * avm)));
        rd.globalAlpha = 1;
        if (stageload == 1) {
            stageload = 0;
        }
        if ((adshow == 1 || adshow == 3 || adshow == 4) && (stageload == 0)) {
            prepcnt = 22;
        }
    }
    if (prepcnt >= 22) {
        if (prepcnt == 22) {
            inishcraft();
            inishflyai();
            inishcamworld();
            interinish();
            playtrack();
            if ((stage == 12) && (unlocked == 12)) {
                loadconfe();
            }
        }
        if (prepcnt < 32) {
            rd.globalAlpha = 0.2;
            rd.fillStyle = "#FFFFFF";
            rd.fillRect(0, 0, canw, canh);
            rd.globalAlpha = 1;
            prepcnt++;
            if (prepcnt == 32) {
                adshow = 1;
                gameplayStart();
                fase = 7;
                requestAnimationFrame(render);
            }
        }
    }
}
function transend() {
    if (prepcnt == 0) {
        fixcraftsback();
        stopstagetrack();
        playintertrack();
        if (unlockedc) {
            sel[0] = selunlocked;
        }
    }
    if (prepcnt < 5) {
        rd.globalAlpha = 0.2;
        rd.fillStyle = "#000000";
        rd.fillRect(0, 0, canw, canh);
        rd.globalAlpha = 1;
        prepcnt++;
        if (prepcnt == 5) {
            rd.clearRect(0, 0, canw, canh);
            selectinish = false;
            drawcraftselect();
            fase = 2;
            requestAnimationFrame(render);
        }
    }
}
var rewadshow = 0;
function rewardraw() {
    rd.clearRect(0, 0, canw, canh);
    rd.drawImage(pausebg, 0, 0, canw, canh);
    rd.drawImage(logo, ((640 * mw) - (259.5 * avm)), (70 * mh), (519 * avm), (60 * avm));
    var xdd = (canw * 0.5);
    var ydd = (360 * mh);
    var wdd = (840 * mw);
    var hdd = (350 * mh);
    rd.globalAlpha = 0.6;
    rd.beginPath();
    rd.moveTo((xdd - (wdd * 0.5) + (100 * mw)), (ydd - (hdd * 0.5)));
    rd.lineTo((xdd - (wdd * 0.5) + (43 * mw)), (ydd - (hdd * 0.5) + (50 * mh)));
    rd.lineTo((xdd - (wdd * 0.5)), (ydd + (hdd * 0.5)));
    rd.lineTo((xdd + (wdd * 0.5) - (100 * mw)), (ydd + (hdd * 0.5)));
    rd.lineTo((xdd + (wdd * 0.5) - (43 * mw)), (ydd + (hdd * 0.5) - (50 * mh)));
    rd.lineTo((xdd + (wdd * 0.5)), (ydd - (hdd * 0.5)));
    rd.closePath();
    rd.fillStyle = "#002644";
    rd.fill();
    rd.globalAlpha = 1;
    rd.drawImage(logoman, (820 * mw), ((415 * mh) - (91 * avm)), (174 * avm), (183 * avm));
    if (!rewadshow) {
        rd.drawImage(rewd, (350 * mw), ((245 * mh) - (28 * avm)), (87 * avm), (56 * avm));
        rd.font = "" + (47 * avm) + "px teko";
        rd.textBaseline = "middle";
        rd.textAlign = "left";
        rd.fillStyle = "#96D3FF";
        rd.fillText("Fix your aircraft now?", ((350 * mw) + (20 * mw) + (87 * avm)), ((245 * mh) + (7 * avm)));
        var onit = 0;
        var btnx = 640;
        var btny = 358;
        var btnw = 280;
        var btnh = 70;
        declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 6);
        if (wasonit == 6) {
            onit = 1;
        }
        if ((onaclk > 7) && (onwho == 6)) {
            onit = 1;
        }
        if ((onaclk == 9) && (onwho == 6)) {
            omutemusic = mutemusic;
            omutegame = mutegame;
            mutemusic = true;
            mutegame = true;
            rewadshow = 1;
            showRewardAd();
            onwho = 0;
            wasonit = 0;
        }
        drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "FIX AIRCRAFT", 23);
        rd.drawImage(inst[16], (((btnx - 23 - (btnw * 0.5)) * mw) - (20 * avm)), (((btny - 2) * mh) - (20 * avm)), (40 * avm), (41 * avm));
        onit = 0;
        btnx = 640;
        btny = 458;
        btnw = 190;
        btnh = 60;
        declick(((btnx - (btnw * 0.5)) * mw), ((btnx + (btnw * 0.5)) * mw), ((btny - (btnh * 0.5)) * mh), ((btny + (btnh * 0.5)) * mh), 3);
        if (wasonit == 3) {
            onit = 1;
        }
        if ((onaclk > 7) && (onwho == 3)) {
            onit = 1;
        }
        if ((onaclk == 9) && (onwho == 3)) {
            flw = 2;
            flh = 1;
            rewadshow = 0;
            gameplayStart();
            fase = 7;
            requestAnimationFrame(render);
            onwho = 0;
            wasonit = 0;
        }
        drawbutton(onit, btnx, btny, btnw, btnh, "#49D2FF", "#1F7EFF", "#007CA4", "#003D90", "CANCEL", 23);
    } else {
        rd.drawImage(rewd, (350 * mw), ((345 * mh) - (28 * avm)), (87 * avm), (56 * avm));
        rd.font = "" + (47 * avm) + "px teko";
        rd.textBaseline = "middle";
        rd.textAlign = "left";
        rd.fillStyle = "#96D3FF";
        rd.fillText("Displaying ad now...", ((350 * mw) + (20 * mw) + (87 * avm)), ((345 * mh) + (7 * avm)));
        if (rewadshow == 2) {
            flw = 2;
            flh = 1;
            mutemusic = omutemusic;
            mutegame = omutegame;
            gameplayStart();
            fase = 7;
            requestAnimationFrame(render);
            fixflg[0] = false;
            fixflk[0] = 40;
            damage[0] = 0;
            ladtime = ltime;
            fixadon = false;
            rewadshow = 0;
        }
        if (rewadshow == 3) {
            flw = 2;
            flh = 1;
            mutemusic = omutemusic;
            mutegame = omutegame;
            gameplayStart();
            fase = 7;
            requestAnimationFrame(render);
            rewadshow = 0;
        }
    }
    if (!flwg) {
        flw -= 0.03;
        if (flw < 0.5) {
            flw = 0.5;
            flwg = true;
        }
    } else {
        flw += 0.03;
        if (flw > 2) {
            flw = 2;
            flwg = false;
        }
    }
    if (!flhg) {
        flh -= 0.5;
        if (flh < 0.1) {
            flh = 0.1;
            flhg = true;
        }
    } else {
        flh += 0.5;
        if (flh > 2) {
            flh = 2;
            flhg = false;
        }
    }
    musictog();
}
var onbutton = false;
var wasonit = 0;
var onaclk = 0;
var onwho = 0;
function declick(xf, xt, yf, yt, onx) {
    var clknow = false;
    if (((xm > xf) && (xm < xt) && (ym > yf) && (ym < yt)) || (infase == 6) || (infase == 9) || ((infase == 7) && (cntautogo == 10))) {
        if (mdown) {
            wasonit = onx;
        } else {
            if (wasonit == onx) {
                clknow = true;
                wasonit = 0;
            }
        }
        onbutton = true;
    } else {
        if (wasonit == onx) {
            wasonit = 0;
        }
    }
    if (checkmusic) {
        if ((onx == 6) && (space == 1)) {
            wasonit = onx;
        }
        if ((onx == 6) && (space == 2)) {
            clknow = true;
            wasonit = 0;
        }
    }
    if ((clknow) && (!onaclk)) {
        onaclk = 10;
        onwho = onx;
    }
}
var flwg = false;
var flhg = false;
var flw = 0;
var flh = 1;
function drawbutton(ot, xb, yb, wb, hb, cb1, cb2, cb3, cb4, txt, fz) {
    wb = (wb * mw);
    hb = (hb * mh);
    var xbd = ((xb + 3) * mw);
    var ybd = ((yb + 5) * mh);
    if (!ot) {
        var grd = rd.createLinearGradient((xbd - (wb * 0.5)), (ybd - (hb * 0.5)), (xbd - (wb * 0.5) + (wb * 0.5 * flw)), (ybd - (hb * 0.5) + (hb * 0.5 * flh)));
        grd.addColorStop(0, cb3);
        grd.addColorStop(1, cb4);
        rd.fillStyle = grd;
        rd.beginPath();
        rd.moveTo((xbd - (wb * 0.5) + (20 * mw)), (ybd - (hb * 0.5)));
        rd.lineTo((xbd - (wb * 0.5) + (10 * mw)), (ybd - (hb * 0.5) + (7 * mh)));
        rd.lineTo((xbd - (wb * 0.5)), (ybd + (hb * 0.5)));
        rd.lineTo((xbd + (wb * 0.5) - (20 * mw)), (ybd + (hb * 0.5)));
        rd.lineTo((xbd + (wb * 0.5) - (10 * mw)), (ybd + (hb * 0.5) - (7 * mh)));
        rd.lineTo((xbd + (wb * 0.5)), (ybd - (hb * 0.5)));
        rd.closePath();
        rd.fill();
        xbd = (xb * mw);
        var ybd = (yb * mh);
    }
    var grd = rd.createLinearGradient((xbd - (wb * 0.5)), (ybd - (hb * 0.5)), (xbd - (wb * 0.5) + (wb * 0.5 * flw)), (ybd - (hb * 0.5) + (hb * 0.5 * flh)));
    grd.addColorStop(0, cb1);
    grd.addColorStop(1, cb2);
    rd.fillStyle = grd;
    rd.beginPath();
    rd.moveTo((xbd - (wb * 0.5) + (20 * mw)), (ybd - (hb * 0.5)));
    rd.lineTo((xbd - (wb * 0.5) + (10 * mw)), (ybd - (hb * 0.5) + (7 * mh)));
    rd.lineTo((xbd - (wb * 0.5)), (ybd + (hb * 0.5)));
    rd.lineTo((xbd + (wb * 0.5) - (20 * mw)), (ybd + (hb * 0.5)));
    rd.lineTo((xbd + (wb * 0.5) - (10 * mw)), (ybd + (hb * 0.5) - (7 * mh)));
    rd.lineTo((xbd + (wb * 0.5)), (ybd - (hb * 0.5)));
    rd.closePath();
    rd.fill();
    rd.font = "" + (fz * avm * 2) + "px teko";
    rd.textBaseline = "middle";
    if ((txt != "FIX") && (txt != "FIX NOW")) {
        rd.textAlign = "center";
        rd.fillStyle = "#000000";
        rd.fillText(txt, xbd, (ybd + (7.6 * avm)));
    } else {
        rd.textAlign = "right";
        rd.fillStyle = "#000000";
        if (txt == "FIX NOW") {
            xbd += 30;
        }
        rd.fillText(txt, (xbd - (8 * mw)), (ybd + (7.6 * avm)));
        rd.globalAlpha = 0.6;
        rd.drawImage(inst[17], (xbd + (2 * mw)), (ybd - (17 * mh)), (52 * mw), (34 * mh));
        rd.globalAlpha = 1;
    }
}
function drawEllipse(ctx, x, y, w, h) {
    var kappa = .5522848,
    ox = (w / 2) * kappa,
    oy = (h / 2) * kappa,
    xe = x + w,
    ye = y + h,
    xme = x + w / 2,
    yme = y + h / 2;
    ctx.beginPath();
    ctx.moveTo(x, yme);
    ctx.bezierCurveTo(x, yme - oy, xme - ox, y, xme, y);
    ctx.bezierCurveTo(xme + ox, y, xe, yme - oy, xe, yme);
    ctx.bezierCurveTo(xe, yme + oy, xme + ox, ye, xme, ye);
    ctx.bezierCurveTo(xme - ox, ye, x, yme + oy, x, yme);
    ctx.stroke();
}

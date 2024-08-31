import { Bokeh1Background } from 'https://cdn.jsdelivr.net/npm/threejs-components@0.0.2/build/backgrounds/bokeh1.cdn.min.js';

$(document).ready(function() {
    const bokehTopBackground = Bokeh1Background($('#bg-canvas-top')[0]);
    bokehTopBackground.loadMap('https://cdn.jsdelivr.net/npm/threejs-components@0.0.2/build/assets/bokeh-particles2.png');
    bokehTopBackground.setColors([0x808080, 0xA9A9A9, 0xD3D3D3]);

    const bokehBottomBackground = Bokeh1Background($('#bg-canvas-contact')[0]);
    bokehBottomBackground.loadMap('https://cdn.jsdelivr.net/npm/threejs-components@0.0.2/build/assets/bokeh-particles2.png');
    bokehBottomBackground.setColors([0x808080, 0xA9A9A9, 0xD3D3D3]);

    $('header').click(function() { // canvas 태그에 클릭 이벤트 리스너 추가
        bokehTopBackground.setColors([0xffffff * Math.random(), 0xffffff * Math.random(), 0xffffff * Math.random()]);
    });

    $('#contact').click(function() { // #contact 섹션에 클릭 이벤트 리스너 추가
        bokehBottomBackground.setColors([0xffffff * Math.random(), 0xffffff * Math.random(), 0xffffff * Math.random()]);
    });

});
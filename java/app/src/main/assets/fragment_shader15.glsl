precision mediump float;
uniform sampler2D u_Texture;
uniform float u_red;
uniform float u_green;
uniform float u_blue;
uniform float u_Offset;
varying lowp vec4 frag_Color;
varying lowp vec2 frag_TexCoord;
void main(void) {
    vec2 texcoord = frag_TexCoord;
    texcoord.x += sin(texcoord.y * 4.0 * 2.0 * 3.14159 + u_Offset) / 100.0;
    texcoord.y += cos(texcoord.x * 4.0 * 2.0 * 3.14159 + u_Offset) / 100.0;
    gl_FragColor = vec4(u_red, u_green, u_blue, 1.0) * texture2D(u_Texture, texcoord);
}

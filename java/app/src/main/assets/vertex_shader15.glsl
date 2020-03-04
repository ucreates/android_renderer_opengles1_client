uniform highp mat4 u_ProjectionMatrix;
attribute mediump vec4 a_Position;
attribute vec4 a_Color;
attribute vec2 a_TexCoord;
varying lowp vec4 frag_Color;
varying lowp vec2 frag_TexCoord;
void main() {
    frag_TexCoord = a_TexCoord;
    frag_Color = a_Color;
    gl_Position = u_ProjectionMatrix * a_Position;
}

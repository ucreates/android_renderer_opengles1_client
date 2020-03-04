uniform highp mat4 u_ProjectionMatrix;
attribute mediump vec4 a_Position;
void main() { gl_Position = u_ProjectionMatrix * a_Position; }
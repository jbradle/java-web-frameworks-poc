import gulp from "gulp";
import del from "del";
import connect from 'gulp-connect';
import size from 'gulp-size';
import webpackConfig from "./webpack.config";

var $ = require('gulp-load-plugins')();

var port = 1337;

//environment dev for now
var config = webpackConfig(true);

var dist = '../webapp/dist/';

gulp.task('html', () => {
    return gulp.src('src/index.html')
        .pipe(gulp.dest(dist))
        .pipe(size({title: 'html'}))
        .pipe(connect.reload());
});

gulp.task('scripts', () => {
    return gulp.src(config.entry)
        .pipe($.webpack(config))
        .pipe(gulp.dest(dist + '/js'))
        .pipe(size({title: 'scripts'}))
        .pipe(connect.reload());
});

gulp.task('clean', (callBack) => {
    return del([dist], {force: true}, callBack);
});

gulp.task('connect', () => {
    connect.server({
        root: '../webapp/',
        port: port,
        livereload: {
            port: 35729
        }
    });
});

gulp.task('watch', () => {
    gulp.watch('src/index.html', ['html']);
    gulp.watch('src/**/*.js', ['scripts']);
    gulp.watch('src/**/*.jsx', ['scripts']);
});

gulp.task('default', ['html','scripts'], function(){
    gulp.start(['connect','watch']);
});

gulp.task('build', ['clean'], function(){
    gulp.start(['html','scripts']);
});
import gulp from 'gulp';
import del from 'del';
import yargs from 'yargs';
import gulpif from 'gulp-if';
import uglify from 'gulp-uglify';
import size from 'gulp-size';
import browserSync from 'browser-sync'
import webpackConfig from './webpack.config';

var $ = require('gulp-load-plugins')();

var production = yargs.argv.production;

//environment dev for now
var config = webpackConfig(production);

var dist = '../webapp/';
var src = 'src/';

gulp.task('html', () => {
    return gulp.src('src/index.html')
        .pipe(gulp.dest(dist))
        .pipe(size({title: 'html'}));
});

gulp.task('scripts', () => {
    return gulp.src(config.entry)
        .pipe($.webpack(config))
        .pipe(gulpif(production, uglify()))
        .pipe(gulp.dest(dist + '/js'))
        .pipe(size({title: 'scripts'}));
});

gulp.task('clean', (callBack) => {
    del([dist + '*.html'], {force: true}, callBack);
    return del([dist + 'js/**/*.*'], {force: true}, callBack);
});

gulp.task('browser-sync', () => {
    browserSync({
        files: dist + 'js/app.js',
        server: {
            baseDir: '../webapp/'
        }
    });
});

gulp.task('watch', () => {
    gulp.watch(src + 'index.html', ['html']);
    gulp.watch(src + '**/*.js', ['scripts']);
    gulp.watch(src + '**/*.jsx', ['scripts']);
});


gulp.task('default', ['html', 'scripts'], () => {
    gulp.start(['browser-sync', 'watch']);
});

gulp.task('build', ['clean'], () => {
    gulp.start(['html', 'scripts']);
});
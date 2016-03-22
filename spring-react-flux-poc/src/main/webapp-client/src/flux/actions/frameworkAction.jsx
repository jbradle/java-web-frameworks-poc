import Reflux from "reflux";
import {get} from "../rest/api.jsx";

const FrameworkActions = Reflux.createActions({
    'getFrameworks': {children: ['completed', 'failed']},
    'searchFrameworks': {children: ['completed', 'failed']},
    'showDetail': {}
});

const REST_URI = 'http://localhost:8080/rest/';

FrameworkActions.getFrameworks.listen(function () {

    get(REST_URI + 'getAllFrameworks')
        .then((frameworks) => {
            this.completed(frameworks);
        }).catch((err) => {
        this.failed(err);
    });

});

FrameworkActions.searchFrameworks.listen(function (searchParam) {

    get(REST_URI + 'searchFrameworks?searchParam=' + searchParam)
        .then((frameworks) => {
            this.completed(frameworks);
        }).catch((err) => {
        this.failed(err);
    });

});


export default FrameworkActions;
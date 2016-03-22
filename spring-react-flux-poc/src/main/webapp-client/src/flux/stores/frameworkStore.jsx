import Reflux from 'reflux';
import FrameworkAction from '../actions/frameworkAction.jsx';

let FrameworkStore = Reflux.createStore({
    listenables: FrameworkAction,

    init() {
        this.frameworks = [];
    },

    getFrameworksCompleted(frameworks) {
        this.frameworks = frameworks;

        this.trigger({
            frameworks: this.frameworks,
            showDetail: false
        });
    },

    getFrameworksFailed(error) {
        this.trigger({
            error: error
        });
    },

    searchFrameworksCompleted(frameworks) {
        this.frameworks = frameworks;

        this.trigger({
            frameworks: this.frameworks
        });
    },
    
    searchFrameworksFailed(error) {
        this.trigger({
            error: error
        });
    },
    
    onShowDetail(framework){
        this.trigger({
            showDetail: true,
            framework: framework
        });
    }



});

export default FrameworkStore;
import React from "react";
import Menu from "../components/Menu.jsx";
import FrameworkTable from "../components/FrameworkTable.jsx";
import FrameworkStore from "../flux/stores/frameworkStore.jsx";
import FrameworkAction from "../flux/actions/frameworkAction.jsx";

class Home extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            frameworks: []
        };
    }

    componentDidMount() {
        this.unsubscribe = FrameworkStore.listen(this.onStatusChange.bind(this));
        FrameworkAction.getFrameworks();
    }

    componentWillUnmount() {
        this.unsubscribe();
    }

    onStatusChange(state) {
        this.setState(state);
    }

    render() {
        return (
            <div className="row">
                <Menu  {...{active : 1}}/>
                <div className="col-md-8">
                    <FrameworkTable {...this.state}/>
                </div>
            </div>
        );
    }
}

export default Home;
import React from "react";
import Menu from "../components/Menu.jsx";
import linkParams from "./linkParams.jsx";
import FrameworkTable from "../components/FrameworkTable.jsx";
import FrameworkStore from "../flux/stores/frameworkStore.jsx";
import FrameworkAction from "../flux/actions/frameworkAction.jsx";


export default class Home extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            frameworks: [],
            showDetail: false,
            showEdit: false
        };
    }

    componentDidMount() {
        this.unsubscribe =
            FrameworkStore.listen(this.onStatusChange.bind(this));
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
                <Menu  {...{active : 1, linkParams : linkParams}}/>
                <div className="col-md-8">
                    <FrameworkTable {...this.state}/>
                </div>
            </div>
        );
    }
}
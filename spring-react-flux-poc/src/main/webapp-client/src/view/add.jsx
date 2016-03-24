import React from "react";
import Menu from "../components/Menu.jsx";
import FrameworkAction from "../flux/actions/frameworkAction.jsx";
import FrameworkEdit from "../components/FrameworkEdit.jsx";


class Add extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            framework: {category: {}},
            categories: []
        };

    }

    componentDidMount() {
        FrameworkAction.showEdit(this.state.framework);
    }

    render() {
        return (
            <div className="row">
                <Menu  {...{active: 2}}/>
                <div className="col-md-8">
                    <FrameworkEdit {...this.state}/>
                </div>
            </div>
        );
    }
}

export default Add;
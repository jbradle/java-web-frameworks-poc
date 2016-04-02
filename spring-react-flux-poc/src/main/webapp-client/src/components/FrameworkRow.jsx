import React from "react";
import FrameworkAction from "../flux/actions/frameworkAction.jsx";

class FrameworkRow extends React.Component {

    showDetail() {
        FrameworkAction.showDetail(this.framework);
    }

    showEdit() {
        FrameworkAction.showEdit(this.framework);
    }

    deleteFramework() {
        FrameworkAction.deleteFramework(this.framework);
    }

    render() {
        let framework = this.props.framework;
        return (
            <tr key={framework.id}>
                <td>{framework.name}</td>
                <td>{framework.category.name}</td>
                <td>
                    <a href={framework.documentationLink}>
                        <i className="fa fa-arrow-right fa-2x"/>
                    </a>
                </td>
                <td>
                    <a title="Detail" onClick={this.showDetail.bind(this.props)}>
                        <i className="fa fa-folder-open fa-2x"/>
                    </a>
                    <a title="Edit" onClick={this.showEdit.bind(this.props)}>
                        <i className="fa fa-edit fa-2x"/>
                    </a>
                    <a title="Remove"  onClick={this.deleteFramework.bind(this.props)}>
                        <i className="fa fa-remove fa-2x"/>
                    </a>
                </td>
            </tr>
        );
    }
}

FrameworkRow.propTypes = {
    framework: React.PropTypes.object
};

export default FrameworkRow;